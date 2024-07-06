
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] array = br.readLine().toCharArray();

        List<Character> characters = new LinkedList<>();
        for (char c : array) {
            characters.add(c);
        }

        int M = Integer.parseInt(br.readLine());

        ListIterator<Character> it = characters.listIterator(characters.size());
        while (M-- > 0) {
            char[] commands = br.readLine().toCharArray();
            char command = commands[0];
            switch (command) {
                case 'L':
                    if (it.hasPrevious())
                        it.previous();
                    break;
                case 'D':
                    if (it.hasNext())
                        it.next();
                    break;
                case 'B':
                    if (it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                    break;
                case 'P':
                    // ListIterator의 add()는 현재 커서의 앞에 추가함
                    it.add(commands[2]);
                    break;
            }
        }

        for (char command : characters) {
            bw.write(String.valueOf(command));
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
