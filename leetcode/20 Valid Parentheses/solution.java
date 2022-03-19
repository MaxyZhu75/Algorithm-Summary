class Solution {
    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>(); // 括号匹配使用Stack！！！
        for (char letter : s.toCharArray()) {
            if (letter == '(' || letter == '{' || letter == '[') { // case1：左括号入栈！！！
                myStack.push(letter);
            } else { // case2：右括号进行出栈操作及判断！！！
                if (myStack.isEmpty()) {
                    return false;
                }
                char previousLeft = myStack.pop();
                boolean check1 = (previousLeft == '(' && letter != ')');
                boolean check2 = (previousLeft == '{' && letter != '}');
                boolean check3 = (previousLeft == '[' && letter != ']');
                if (check1 || check2 || check3) {
                    return false;
                }
            }
        }
        return myStack.isEmpty();
    }
}