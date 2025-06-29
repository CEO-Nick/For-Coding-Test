import java.util.*;
import java.util.stream.*;

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
        
        ArrayList<Integer> answer = new ArrayList<>();
        // 총 재생 횟수가 많은 장르 순으로 내림차순 정렬
        Stream<Map.Entry<String, Integer>> sortedGenre = genrePlay.entrySet().stream()
            .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        
        // 각 장르 내 노래를 재생 횟수 순으로 정렬해 최대 2곡 선택
        sortedGenre.forEach(entry -> {
            Stream<Music> sortedSongs = genrePlayList.get(entry.getKey()).stream()
                .sorted((m1, m2) -> Integer.compare(m2.plays, m1.plays))
                .limit(2);
            
            sortedSongs.forEach(music -> answer.add(music.idx));
        });
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}