class Solution {
    public int strStr(String haystack, String needle) { // KMP算法，利用前缀函数解决字符串匹配问题！！！
        int n = haystack.length();
		int m = needle.length();
        if (m == 0) return 0;
		
        int[] pi = new int[m];
        for (int i=1, j=0; i<m; i++) { // 求needle的前缀函数！！！
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) { // 通过迭代j=π(π(π(…)?1)?1)找到最大的j满足s[0:j?1]=s[i?j:i?1]！！！
                j = pi[j-1];
            }
            if (needle.charAt(i) == needle.charAt(j)) { // case1：若s[i]=s[j]，那么π(i)=j+1！！！
                j++;
            }
            pi[i] = j; // case2：若找不到s[i]=s[j]，则j=0，那么π(i)=0！！！
        }
        
		for (int i=0, j=0; i<n; i++) { // 同理求haystack的前缀函数；i初始值为0是由于被 # 占用！！！
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) { // 当且仅当前缀函数值等于m时，说明找到了一次字符串needle在haystack中的出现！！！
                return i - m + 1; // 由 str = needle + # + haystack 与 s[0:j?1]=s[i?j:i?1]可知，真后缀起始索引为i-m+1（#占用1位要补上）！！！
            }
        }
        
		return -1;
    }
}