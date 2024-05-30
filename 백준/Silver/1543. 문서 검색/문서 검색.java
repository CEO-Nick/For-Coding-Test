import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();
        String word = sc.nextLine();

        int i = 0;
        int count = 0;
        int len = word.length();

        // 내가 짠 코드
//        while (i <= (doc.length() - len)) {
//            String substring = doc.substring(i, i + len);
//            if (word.equals(substring)) {
//                count++;
//                i += len;
//            } else
//                i++;
//        }

        while(true) {
            int findIdx = doc.indexOf(word, i);
            if (findIdx < 0) break;
            i = findIdx + len;
            count++;
        }

        System.out.println(count);
    }

}
