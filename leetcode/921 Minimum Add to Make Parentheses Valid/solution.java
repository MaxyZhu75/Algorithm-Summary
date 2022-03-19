class Solution {
    public int minAddToMakeValid(String s) { // 方法一：使用Deque接口实现栈！！！
        int left = 0;
        Deque<Character> myStack = new ArrayDeque<>(); // import java.util.Deque; import java.util.ArrayDeque！！！

        for (char letter : s.toCharArray()) {
            if (letter == '(') {
                myStack.push(letter);
            } else {
                if (!myStack.isEmpty()) {
                    myStack.pop();
                } else {
                    left++;
                }
            }
        }
        return left + myStack.size(); // 需要添加的左括号数量 + 需要添加的右括号数量
    }
}