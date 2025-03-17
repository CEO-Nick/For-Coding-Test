import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        // 최소 x 최대 의 합이 최소인가..
        Arrays.sort(A);
        Arrays.sort(B);
        int n = A.length;
        for (int i = 0; i < n; i++) {
            answer += (A[i] * B[n-1-i]);
        }
        // System.out.println(Arrays.toString(A));
        return answer;
    }
}