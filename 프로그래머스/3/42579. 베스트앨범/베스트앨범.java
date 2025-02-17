import java.util.*;
import java.util.Map.Entry;


class Solution {
    
    static class MusicInfo implements Comparable<MusicInfo> {
        int num;
        int play;
        
        MusicInfo(int num, int play) {
            this.num = num;
            this.play = play;
        }
        
        // 재생 많은 순 -> 고유 번호 낮은 순
        @Override
        public int compareTo(MusicInfo m) {
            if (this.play == m.play) {
                return this.num - m.num;
            } 
            return m.play - this.play;
        }
    }
    
    /*
        재생 많은 장르 순 -> 같은 장르 내에서는 재생 많은 순 -> 같은 장르 & 같은 재생 수에서는 고유 번호 낮은 순
    */
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 재생 횟수 저장 ex) key = "pop", value = 3100
        HashMap<String, Integer> genreToPlay = new HashMap<>();
        
        // 장르별 음악 리스트 ex) key = "pop", value = {num: 4 play: 2500}, {num: 1 play: 600}
        HashMap<String, List<MusicInfo>> genreToList = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            // 장르별 재생 수 계산
            if (genreToPlay.containsKey(genres[i])) {
                genreToPlay.put(genres[i], genreToPlay.get(genres[i]) + plays[i]);
            } else {
                genreToPlay.put(genres[i], plays[i]);
            }
            
            // 장르별 음악 리스트 저장
            if (genreToList.containsKey(genres[i])) {
                genreToList.get(genres[i]).add(new MusicInfo(i, plays[i]));
            } else {
                List<MusicInfo> list = new ArrayList<>();
                list.add(new MusicInfo(i, plays[i]));
                genreToList.put(genres[i], list);
            }
        }
        
        // 장르별 음악 리스트 정렬 (재생 많은 순 -> 고유 번호 작은 순)
        for (List<MusicInfo> list : genreToList.values()) {
            Collections.sort(list);
        }
        
        // 재생된 횟수에 따른 장르 ("모든 장르는 재싱된 횟수가 다릅니다." -> 재생 횟수를 key로 해도 된다)
        // ex) key = 3100, value = "pop"
        TreeMap<Integer, String> playToGenre = new TreeMap<>();
        for (Entry<String, Integer> entry : genreToPlay.entrySet()) {
            playToGenre.put(entry.getValue(), entry.getKey());
        }
        
        // 역순으로 순회하면서 각 장르별 음악 최대 2개씩 ans 리스트에 저장
        ArrayList<Integer> ans = new ArrayList<>();
        for (Integer key : playToGenre.descendingKeySet()) {
            String genre = playToGenre.get(key);
            
            List<MusicInfo> genreList = genreToList.get(genre);
            // 장르 당 최대 2곡
            int count = genreList.size() >= 2 ? 2 : genreList.size();
            for (int i = 0; i < count; i++) {
                ans.add(genreList.get(i).num);
            }
        }
        
        // ArrayList -> int[]로 변환
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}