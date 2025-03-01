import java.util.Stack;

public class InfixToPostfix {
    // check if a character is an operand (a-z)
    public static boolean isOperand(char ch) {
        return Character.isLetterOrDigit(ch);
    }
    // return precedence of operators
    public static int order(char op) {
        if (op == '^') {
            return 3;
        } else if (op == '*' || op == '/') {
            return 2;
        } else if (op == '+' || op == '-') {
            return 1;
        }
        return -1;
    }
    public static String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isOperand(ch)) {
                result.append(ch); // Directly add operands (a-z) to result
            } else if (ch == '(') {
                stack.push(ch); // Push '(' onto stack
            } else if (ch == ')') {
                // Pop until '(' is found
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Discard the '('
            } else {
                // Operator case
                while (!stack.isEmpty() && order(ch) <= order(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch); // Push current operator onto stack
            }
        }
        // Pop remaining operators from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(infix));
    }
}
