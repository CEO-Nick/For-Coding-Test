
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Egg {
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }

        public void fight(Egg other) {
            this.durability -= other.weight;
            other.durability -= this.weight;
        }

        public void restore(Egg other) {
            this.durability += other.weight;
            other.durability += this.weight;
        }

    }
    public  static int n;
    public static Egg[] eggs;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        eggs= new Egg[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        hit(0);
        System.out.println(max);
        br.close();
    }

    public static void hit(int current) {
        if (current == n) {
            int count = 0;
            for (int i = 0; i < n; i++) if (eggs[i].durability <= 0) count++;
            max = Math.max(max, count);
            return;
        }


        if (eggs[current].durability > 0) {
            boolean targetExists = false;   // 대상 계란이 있는지
            for (int target = 0; target < n; target++) {
                if (current == target) continue;
                if (eggs[target].durability > 0) {
                    targetExists = true; // 깨뜨릴 계란 있음!
                    eggs[current].fight(eggs[target]);
                    hit(current+1);
                    eggs[current].restore(eggs[target]);
                }
                // 충돌 시킬 계란이 없는 경우(모두 깨진 경우) -> 오른쪽 계란 집기
                if (!targetExists) hit(current+1);
            }
        } else {    // 손에 집은 계란이 이미 깨진 경우
            hit(current + 1);
        }
    }

}
