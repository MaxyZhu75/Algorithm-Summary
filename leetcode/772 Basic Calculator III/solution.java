class Solution {
    public int calculate(String s) { // �õݹ����ȴ��������ڵ����ݣ�����
        int[] result = calculator(s, 0);
        return result[0];
    }

    public int[] calculator(String s, int start) { // �������飺[���, �����±�]������
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
            if (letter == '(') { // ϸ�ڣ�������������ݹ飡����
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
                if (letter == ')') { // ϸ�ڣ���¼�ݹ�����±꣬��break������
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