class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        char[] letters = s.toCharArray();
        boolean negative = false;
        int result = 0;
        int pointer = 0;

        while (pointer < n && letters[pointer] == ' ') { // 步骤一：丢弃无用的前导空格！！！
            pointer++;
        }

        if (pointer == n) return result; // 步骤二：检查指针是否达到末尾，并尝试读取正负号！！！
        if (letters[pointer] == '-') {
            negative = true;
            pointer++;
        } else if (letters[pointer] == '+') {
            pointer++;
        }

        int currentDigit = 0;
        while (pointer < n && Character.isDigit(letters[pointer])) { // 步骤三：对数字部分进行处理！！！
            currentDigit = letters[pointer] - '0';    
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && currentDigit > Integer.MAX_VALUE % 10)) { // 判断溢出写法！！！
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result*10 + currentDigit; // result使用int的话不能先进行运算，需要先判断溢出！！！
            pointer++; 
        }
        return negative ? (-1*result) : result;
    }
}