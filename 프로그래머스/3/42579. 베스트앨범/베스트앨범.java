import java.util.*;

class Solution {
    static class Music implements Comparable {
        int idx;
        int plays;
        
        Music(int idx, int plays) {
            this.idx = idx;
            this.plays = plays;
        }
        
        public int compareTo(Object obj) {
            Music m = (Music) obj;
            if (this.plays == m.plays) {
                return this.idx - m.idx;
            }
            return m.plays - this.plays;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 재생 횟수
        HashMap<String, Integer> genrePlay = new HashMap<>();
        // 장르별 음악 목록
        HashMap<String, ArrayList<Music>> genrePlayList = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            genrePlay.put(genres[i], genrePlay.getOrDefault(genres[i], 0) + plays[i]);
            
            ArrayList<Music> playList = genrePlayList.getOrDefault(genres[i], new ArrayList<>());
            playList.add(new Music(i, plays[i]));
            genrePlayList.put(genres[i], playList);
        }
        
        // 모든 장르 재생 횟수 다름 -> key로 써도 된다
        // 재생 횟수 별 장르 (재생 횟수 많은 순으로 정렬하기 위해 tree map 사용)
        TreeMap<Integer, String> playGenre = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> entry : genrePlay.entrySet()) {
            playGenre.put(entry.getValue(), entry.getKey());
        }
        
        // 장르별 재생 목록을 재생횟수 많은 순으로 정렬
        for (Map.Entry<String, ArrayList<Music>> entry : genrePlayList.entrySet()) {
            Collections.sort(entry.getValue());
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : playGenre.entrySet()) {
            String genre = entry.getValue();
            ArrayList<Music> playList = genrePlayList.get(genre);
            
            if (playList.size() == 1) answer.add(playList.get(0).idx);
            else {
                answer.add(playList.get(0).idx);
                answer.add(playList.get(1).idx);
            }
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}