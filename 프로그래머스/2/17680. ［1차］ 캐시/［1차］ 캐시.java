import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        HashSet<String> inCache = new HashSet<>();
        ArrayDeque<String> cache = new ArrayDeque<>();
        
        if (cacheSize == 0) return cities.length * 5;
        
        for (String city : cities) {
            city = city.toLowerCase();
            if (inCache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                answer++;
            } else {
                // 캐시에 도시 없는 경우
                // 여유로운 경우 -> cache, inCache에 모두 추가
                if (cache.size() < cacheSize) {
                    cache.add(city);
                    inCache.add(city);
                } else {
                    // 맨 앞 삭제하고 추가
                    String first = cache.removeFirst();
                    inCache.remove(first);
                    cache.add(city);
                    inCache.add(city);
                }
                answer += 5;
            }
        }
        return answer;
    }
}