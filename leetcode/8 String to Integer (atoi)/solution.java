class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        char[] letters = s.toCharArray();
        boolean negative = false;
        int result = 0;
        int pointer = 0;

        while (pointer < n && letters[pointer] == ' ') { // ����һ���������õ�ǰ���ո񣡣���
            pointer++;
        }

        if (pointer == n) return result; // ����������ָ���Ƿ�ﵽĩβ�������Զ�ȡ�����ţ�����
        if (letters[pointer] == '-') {
            negative = true;
            pointer++;
        } else if (letters[pointer] == '+') {
            pointer++;
        }

        int currentDigit = 0;
        while (pointer < n && Character.isDigit(letters[pointer])) { // �������������ֲ��ֽ��д�������
            currentDigit = letters[pointer] - '0';    
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && currentDigit > Integer.MAX_VALUE % 10)) { // �ж����д��������
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result*10 + currentDigit; // resultʹ��int�Ļ������Ƚ������㣬��Ҫ���ж����������
            pointer++; 
        }
        return negative ? (-1*result) : result;
    }
}