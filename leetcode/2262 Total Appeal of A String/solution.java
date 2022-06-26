class Solution {
    public long appealSum(String s) { // 相当于LeetCode第828题统计方法中，前一次出现的位置在本题中均为-1！！！
        int d[] = new int[26];
        long result = 0;
        for (int i=0; i<s.length(); i++) {
            int charIndex = s.charAt(i)-'a';
			d[charIndex] = i+1;
            for (int j=0; j<26; j++) {
				result += d[j];
			}
        }
        return result;
    }
}