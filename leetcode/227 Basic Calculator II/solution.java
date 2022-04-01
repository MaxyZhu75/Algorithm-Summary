class Solution {
    public int calculate(String s) { // ����Stack����ɣ���ס������·������
        int n = s.length();
        int digit = 0; // ���������֣�����
        char preOperand = '+'; // ע��洢����ǰһ�������������ǵ�ǰ�ģ�����
        Deque<Integer> myStack = new LinkedList<>(); // java.util.Deque������
        
        for (int i=0; i<n; i++) {
            char letter = s.charAt(i);
            if (Character.isDigit(letter)) { // case1����ǰ�ַ�Ϊ���֣���ס��ͳ�����ֵĲ�������·��������
                digit = digit * 10 + letter - '0';
            }
            if (!Character.isDigit(letter) && letter != ' ' || i == n-1) { // case2����ǰ�ַ�Ϊ�����������һλ�ַ�������
                switch (preOperand) { // ע��˴����ڶ�ǰһ�������������ֽ������㣡����
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
                preOperand = letter; // ��ǰ��������Ϊǰһ�����������ȴ���������
                digit = 0; // ���������ֹ��㣡����
            }
        }

        int result = 0;
        while (!myStack.isEmpty()) {
            result += myStack.pop();
        }
        return result;
    }
}