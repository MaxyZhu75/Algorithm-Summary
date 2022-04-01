class Solution {
    public int calculate(String s) { // 利用Stack来完成；记住该题套路！！！
        int n = s.length();
        int digit = 0; // 待处理数字！！！
        char preOperand = '+'; // 注意存储的是前一个操作符，不是当前的！！！
        Deque<Integer> myStack = new LinkedList<>(); // java.util.Deque！！！
        
        for (int i=0; i<n; i++) {
            char letter = s.charAt(i);
            if (Character.isDigit(letter)) { // case1：当前字符为数字；记住该统计数字的操作（套路）！！！
                digit = digit * 10 + letter - '0';
            }
            if (!Character.isDigit(letter) && letter != ' ' || i == n-1) { // case2：当前字符为操作符或最后一位字符！！！
                switch (preOperand) { // 注意此处是在对前一个操作符及数字进行运算！！！
                    case '+':
                        myStack.push(digit);
                        break;
                    case '-':
                        myStack.push(-digit);
                        break;
                    case '*':
                        myStack.push(myStack.pop() * digit);
                        break;
                    default:
                        myStack.push(myStack.pop() / digit);
                }
                preOperand = letter; // 当前操作符记为前一个操作符，等待处理！！！
                digit = 0; // 待处理数字归零！！！
            }
        }

        int result = 0;
        while (!myStack.isEmpty()) {
            result += myStack.pop();
        }
        return result;
    }
}