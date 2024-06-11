
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String[] titles = new String[N];

        for (int i = 0; i < N; i++) {
            String bookName = sc.next();
            titles[i] = bookName;
        }

        Arrays.sort(titles);
        int count = 1;
        int maxCount = 0;
        String maxBookName = "";
        for (int i = 0; i < N - 1; i++) {
            if (titles[i].equals(titles[i+1])) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    maxBookName = titles[i];
                }
                count = 1;
            }
        }
        if (count > maxCount) {
            maxCount = count;
            maxBookName = titles[N-1];
        }

        System.out.println(maxBookName);
    }


}
