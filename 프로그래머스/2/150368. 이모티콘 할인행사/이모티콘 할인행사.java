import java.util.*;

class Solution {
    
    static class Result implements Comparable{
        int newSubs;
        int total;
        
        Result(int n, int t) {
            newSubs = n;
            total = t;
        }
        
        public int compareTo(Object o) {
            Result result = (Result) o;
            if (this.newSubs == result.newSubs) {
                return result.total - this.total;
            }
            return result.newSubs - this.newSubs;
        }
        
        public String toString() {
            return "(" + newSubs + ", " + total + ")";
        }
    }
    
    // 할인율 배열
    static int[] discountRate;
    static ArrayList<Result> answerList;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        discountRate = new int[] {10, 20, 30, 40};
        chosenDiscountRate = new ArrayList<>();
        answerList = new ArrayList<>();
        
        choose(users, emoticons);
    
        Collections.sort(answerList);
                
        answer[0] = answerList.get(0).newSubs;
        answer[1] = answerList.get(0).total;
        return answer;
    }
    
    // 각 이모티콘에 적용될 할인율 list
    static ArrayList<Integer> chosenDiscountRate;
    
    public static void choose(int[][] users, int[] emoticons) {
        if (chosenDiscountRate.size() == emoticons.length) {
            calc(users, emoticons);
            return;
        }
        
        for (int i = 0; i < discountRate.length; i++) {
            chosenDiscountRate.add(discountRate[i]);
            choose(users, emoticons);
            chosenDiscountRate.remove(chosenDiscountRate.size() - 1);
        }
    }
    
    // 각 이모티콘에 적용될 할인율 선택된 후 유저가 구매할지, 가입할지 계산
    public static void calc(int[][] users, int[] emoticons) {
        int totalSub = 0;
        int totalSum = 0;
        
        for (int i = 0; i < users.length; i++) {
            int minRate = users[i][0];  // 이 할인율 이상인 임티만 구매
            int minSub = users[i][1];   // 이 금액 이상이어야 서비스 구독
            
            int sum = 0;
            for (int j = 0; j < emoticons.length; j++) {
                int rate = chosenDiscountRate.get(j);
                if (rate >= minRate) {
                    sum += (emoticons[j] - (emoticons[j] * rate / 100));
                }
            }
            
            // 임티 구매 비용이 유저의 기준을 넘어가면
            if (sum >= minSub) {
                // 서비스 가입만 진행
                totalSub++;
            } else {
                // 안넘어가면 가입안하고 그대로 모두 구매
                totalSum += sum;
            }
        }
        
        answerList.add(new Result(totalSub, totalSum));
    }
    
}