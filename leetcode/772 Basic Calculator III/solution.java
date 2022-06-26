class Solution {
    public int calculate(String s) { // 用递归优先处理括号内的内容！！！
        int[] result = calculator(s, 0);
        return result[0];
    }

    public int[] calculator(String s, int start) { // 返回数组：[结果, 结束下标]！！！
        int n = s.length();
		int[] result = new int[2];
        char preOprand = '+';
        int num = 0;
        Deque<Integer> stack = new LinkedList<>();

        for (int i=start; i<n; i++) {
            char letter = s.charAt(i);
            if (Character.isDigit(letter)) {
                num = num * 10 + letter - '0';
            }
            if (letter == '(') { // 细节：遇见左括号则递归！！！
                int[] numNext = calculator(s, i+1);
                num = numNext[0];
                i = numNext[1];
            }
            if (i == n-1 || !Character.isDigit(letter) && letter != '(') {
                switch (preOprand) {
                    case '+': 
					    stack.addFirst(num);
						break;
                    case '-':
					    stack.addFirst(-num);
						break;
                    case '*':
					    stack.addFirst(stack.removeFirst()*num);
						break;
                    default:
					    stack.addFirst(stack.removeFirst()/num);
						break;
                }
                if (letter == ')') { // 细节：记录递归结束下标，且break！！！
                    result[1] = i;
                    break;
                }
                preOprand = letter;
                num = 0;
            }

        }
        while (!stack.isEmpty()) {
            result[0] += stack.removeFirst();
        }
        return result;
    }
}