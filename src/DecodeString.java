import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<String> string = new Stack<>();
        Stack<Integer> num = new Stack<>();
        StringBuilder current = new StringBuilder();
        int currentNum = 0;

        for (int i = 0; i < s.length(); i++) {
             // Access each character by index
                char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                // Build the current number
                currentNum = currentNum * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push current number and current string to the stacks
                num.push(currentNum);
                string.push(current.toString());
                current.setLength(0); // Reset current string
                currentNum = 0; // Reset current number
            } else if (ch == ']') {
                // Pop the number and previous string from the stacks
                int repeatTimes = num.pop();
                StringBuilder prevString = new StringBuilder(string.pop());
                // Repeat the current string and append it to the previous one
                for (int j = 0; j < repeatTimes; j++) {
                    prevString.append(current);
                }
                current = prevString;
            } else {
                // add to the current string if its a letter
                current.append(ch);
            }
        }
        return current.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}
