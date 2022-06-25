class Solution {
    public int calculate(String s) {
        int n = s.length();
        int num = 0; // 待处理数字！！！
        char preOperand = '+';
        Deque<Integer> myStack = new LinkedList<>();
        
        for (int i=0; i<n; i++) {
            char letter = s.charAt(i);
            if (Character.isDigit(letter)) { // 当前字符为数字；记住该统计数字的操作（套路）！！！
                num = num * 10 + letter - '0';
            }
            if (!Character.isDigit(letter) && letter != ' ' || i == n-1) { // 当前字符为「操作符」或「最后一位」！！！
                switch (preOperand) { // 注意此处是在对「前一个操作符」进行运算！！！
                    case '+':
                        myStack.push(num);
                        break;
                    case '-':
                        myStack.push(-num);
                        break;
                    case '*':
                        myStack.push(myStack.pop() * num);
                        break;
                    default:
                        myStack.push(myStack.pop() / num);
                }
                preOperand = letter;
                num = 0; // 待处理数字「归零」！！！
            }
        }

        int result = 0;
        while (!myStack.isEmpty()) { // 最后循环累加栈内结果！！！
            result += myStack.pop();
        }
        return result;
    }
}
