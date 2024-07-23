
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int[] ans = new int[N];
        int[] stack = new int[N];
        int topIndex = -1;
        for (int i = N-1; i >= 0; i--) {
            while (topIndex >= 0 && stack[topIndex] <= arr[i]) {
                topIndex--;
            }
            ans[i] = topIndex >= 0 ? stack[topIndex] : -1;
            stack[++topIndex] = arr[i];
        }

        System.out.println(Arrays.stream(ans)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" ")));

        br.close();
    }

}
