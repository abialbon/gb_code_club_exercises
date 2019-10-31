public class BracketMatcher {
    public static boolean checkBrackets(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
            if (chars[i] == '(') stack.push('(');
        }
        if (stack.isEmpty()) return true;
        return false;
    }

    public static void main(String[] args) {
        String test = "(this is)()(())(did not)";
        System.out.println(checkBrackets(test));
    }
}
