package LeetcodeProblems;

import java.util.Stack;

public class RemoveDigits {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) return "0";
        StringBuilder sb = new StringBuilder(num);
        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        stack.add(sb.charAt(0) - '0');
        for (int i = 1; i < num.length(); i++) {
            int digit = sb.charAt(i) - '0';
            if (digit < stack.peek() && k > 0) {
                stack.pop(); k--;
            }
            stack.add(digit);
        }
        while (k-- > 0) stack.pop();
        while (!stack.isEmpty()) answer.append(stack.pop());
        return answer.reverse().toString();
    }

    public static void main(String[] args) {
        new RemoveDigits().removeKdigits("1432219", 3);
    }
}
