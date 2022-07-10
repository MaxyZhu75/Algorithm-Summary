class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> leftStack = new LinkedList<>(); //「*」也需要一个栈，需要先将「*」看成「左括号」！！！
        Deque<Integer> starStack = new LinkedList<>();
        int n = s.length();
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == '(') {
                leftStack.push(i);
            } else if (s.charAt(i) == '*') {
                starStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }
        while (!leftStack.isEmpty() && !starStack.isEmpty()) { // 需要将「*」看成「右括号」，且每个「左括号」必须出现在其匹配的「*」之前！！！
            int leftIndex = leftStack.pop();
            int starIndex = starStack.pop();
            if (leftIndex > starIndex) {
                return false;
            }
        }
        return leftStack.isEmpty(); // 最终判断「左括号栈」是否为空！！！
    }
}