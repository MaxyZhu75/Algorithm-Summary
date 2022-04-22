class Solution {
    public int uniqueLetterString(String s) { // 题目不是求唯一字符的子串个数，也不是求唯一字符的子串长度；而是求所有子串中，每一个子串其唯一字符的个数总和！！！
        if (s.length() == 0) {
            return 0;
        }

        int[][] d = new int[26][2]; // 26个字母；d[char][0]表示该字母前一次出现的索引位置；d[char][1]表示该字母当前最晚出现的索引位置！！！
        
        for (int i=0; i<26; i++) {
            Arrays.fill(d[i], -1);  // 手动初始化填充-1！！！
        }

        int result = 0;
        for (int i=0; i<s.length(); i++) { // 遍历字符串，每个字母关注前一次出现的索引位置！！！
            int charIndex = s.charAt(i) - 'A';
            d[charIndex][0] = d[charIndex][1]; // 更新当前末尾字母dp表，其余字母唯一性不变！！！
            d[charIndex][1] = i;

            int count = 0;
            for (int j=0; j<26; j++) {               
                count += (d[j][1] - d[j][0]); // 加入结果；正确性证明见官方解答！！！
            }
            result += count;         
        }
        return result % 1000000007;
    }    
}
