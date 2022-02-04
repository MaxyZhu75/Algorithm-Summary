class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length(); // 已知两个字符串长度相等！！！
        int[] record1 = new int[256]; // 记录每个字符上次出现的索引！！！
        int[] record2 = new int[256]; // 已知字符串由任意ASCII字符组成，大小定为128时会溢出！！！

        for (int i=0; i<n; i++) {
            char letter1 = s.charAt(i);
            char letter2 = t.charAt(i);
            if (record1[letter1] != record2[letter2]) { // 遍历两个字符串时，若各自当前字母上次出现的索引相同则同构！！！
                return false;
            }
            record1[letter1] = i+1; // 数组元素初始值为0，我们把0视作该字母未出现；因此在记录出现过的字母索引时要+1以作区分（防止把第一个出现的字母索引也记录为0而出错）！！！
            record2[letter2] = i+1;
        }

        return true;
    }
}