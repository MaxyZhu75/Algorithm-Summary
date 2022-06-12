class Solution {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}; // 由大到小存储所有可用的基本数字及对应字符！！！
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}; // 注意两数组索引与内容要对应！！！

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<values.length; i++) { // 贪心地从大到小遍历可用的数字！！！
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
            if (num == 0) { // 组合完成，出口！！！
                break;
            }
        }
        return sb.toString();
    }
}