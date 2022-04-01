class Solution {
    public int calculate(String s) { // 使用栈解决！！！
        int n = s.length();
        Deque<Integer> myStack = new ArrayDeque<>(); // 栈顶元素记录了当前位置所处的每个括号所「共同形成」的符号！！！
        myStack.addFirst(1);
        int sign = 1; // 记录当前符号！！！
        int result = 0;
        
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') { // case1：空字符跳过！！！
                i++;
            } else if (s.charAt(i) == '+') { // case2：加号，正确获取当前计算符号！！！
                sign = myStack.peekFirst();
                i++;
            } else if (s.charAt(i) == '-') { // case3：减号，正确获取当前计算符号！！！
                sign = -myStack.peekFirst();
                i++;
            } else if (s.charAt(i) == '(') { // case4：左括号，将该括号总的运算符号压入栈顶！！！
                myStack.addFirst(sign);
                i++;
            } else if (s.charAt(i) == ')') { // case5：右括号，结束数值计算，将该括号总的运算符号弹出栈顶！！！
                myStack.removeFirst();
                i++;
            } else { // case6：数字计算！！！
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) { // 字符串转数字处理！！！
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                result += sign * num;
            }
        }
        return result;
    }
}