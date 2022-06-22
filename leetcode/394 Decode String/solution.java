class Solution {
    String decodeString(String s) { // ������ջ��+���ַ�ջ��������
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (char letter : s.toCharArray()) {
            if (Character.isDigit(letter)) { // case1��ͳ�����ִ�С������
                k = k * 10 + letter - '0';
            } else if (letter == '[') { // case2�������������š�����ջ������Ҫ����sb��k�����ݣ�sb��ջ��������ַ�������Ի�ı䣩������
                countStack.addFirst(k);
                stringStack.addFirst(sb);
                sb = new StringBuilder();
                k = 0;
            } else if (letter == ']') { // case3�������������š���ջ��sb�������ظ�k�β�����sb������
                StringBuilder current = stringStack.removeFirst();
                for (int i=countStack.removeFirst(); i>0; i--) {
                    current.append(sb);
                }
                sb = current;
            } else { // case4����ͨ��ĸֱ��׷�ӵ�sb���ɣ�����
                sb.append(letter);
            }
        }
        return sb.toString();
    }
}