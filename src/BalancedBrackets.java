import java.util.Deque;
import java.util.LinkedList;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.add(ch); // Push opening bracket onto stack
            } else {
                if (stack.isEmpty()) {
                    return "NO"; // Unmatched closing bracket
                }
                char top = stack.peek();
                if ((ch == '}' && top == '{') ||
                        (ch == ')' && top == '(') ||
                        (ch == ']' && top == '[')) {
                    stack.remove(); // Pop the matching opening bracket
                } else {
                    return "NO"; // Mismatched closing bracket
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO"; // Stack should be empty if balanced
    }

    public static void main(String[] args) {
        String[] testCases = {"{[()]}", "{[(])}", "{{[[(())]]}}"};

        for (String s : testCases) {
            System.out.println(isBalanced(s));
        }
    }
}
