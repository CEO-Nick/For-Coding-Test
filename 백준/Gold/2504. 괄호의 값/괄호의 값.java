
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static class Element {
        int value;
        char bracket;

        Element(int value) {
            this.value = value;
        }

        Element(char bracket) {
            this.bracket = bracket;
        }

        public String toString() {
            return "value : " + value + "\t" + "bracket : " + bracket;
        }
    }

    public static boolean isRight(char[] array) {
        Stack<Character> stack = new Stack<>();

        for (char ch : array) {
            if (stack.isEmpty()) {
                stack.add(ch);
                continue;
            }
            if (stack.peek() == '(' && ch == ')') {
                stack.pop();
            } else if (stack.peek() == '[' && ch == ']') {
                stack.pop();
            } else {
                stack.add(ch);
            }
        }

        if (stack.isEmpty()) return true;
        else return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] array = sc.next().toCharArray();

        if (!isRight(array)) {
            System.out.println(0);
            return;
        }

        Stack<Element> stack = new Stack<>();

        int ans = 0;
        for (char ch : array) {
            if (stack.isEmpty()) {
                stack.add(new Element(ch));
                continue;
            }
            if (stack.peek().bracket == '(' && ch == ')') {
                stack.pop();
                stack.add(new Element(2));
            } else if (stack.peek().bracket == '[' && ch == ']') {
                stack.pop();
                stack.add(new Element(3));
            } else if (ch == '(' || ch == '[') {
                stack.add(new Element(ch));
            } else if (ch == ')') {
                int temp = 0;
                while (true) {
                    if (stack.isEmpty()) {
                        System.out.println(0);
                        return;
                    }
                    Element element = stack.pop();
                    if (element.bracket == '(') {
                        int calc = 2 * temp;
                        if (stack.isEmpty()) ans += calc;
                        else stack.add(new Element(calc));
                        break;
                    }
                    temp += element.value;
                }
            } else if (ch == ']') {
                int temp = 0;
                while (true) {
                    if (stack.isEmpty()) {
                        System.out.println(0);
                        return;
                    }
                    Element element = stack.pop();
                    if (element.bracket == '[') {
                        int calc = 3 * temp;
                        if (stack.isEmpty()) ans += calc;
                        else stack.add(new Element(calc));
                        break;
                    }
                    temp += element.value;
                }
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            ans += stack.elementAt(i).value;
        }
        System.out.println(ans);
    }
}
