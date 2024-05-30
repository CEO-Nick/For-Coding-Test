import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] array = str.toCharArray();
        int len = array.length;

        for(int i = 0; i < len; i++) {
            if (array[i] >= 65 && array[i] <= 90) {
                array[i] += 32;
            } else {
                array[i] -= 32;
            }
        }
        str = new String(array);
        System.out.println(str);
    }
}
