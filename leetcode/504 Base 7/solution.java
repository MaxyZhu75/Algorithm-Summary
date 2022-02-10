class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        
        boolean isNegative = false; // 先化为正数处理！！！
        if (num < 0) {
            num = -num;
            isNegative = true;
        }

        StringBuilder sb = new StringBuilder();
        while (num != 0) { // 注意高低位顺序问题！！！
            int oneBit = num % 7;
            sb.append(oneBit);
            num /= 7;
        }

        String result = sb.reverse().toString();
        
        return isNegative ? "-" + result : result; // 判断是否补上负号！！！
    }
}