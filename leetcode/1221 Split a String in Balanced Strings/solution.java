class Solution {
    public int balancedStringSplit(String s) { // 贪心；正确性证明见官方题解！！！
        int count = 0, balance = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'L') { // L则balance++！！！
                balance++;
            } else {
                balance--; // R则balance--！！！
            }
            if (balance == 0) { // 贪心地添加每次平衡状态；此时剩余部分必然仍是平衡字符串！！！
                count++;
            }
        }
        return count;
    }
}