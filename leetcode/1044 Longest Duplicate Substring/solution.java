class Solution { //「字符串哈希」+「二分」！！！
    long[] h;
    long[] p;

    public String longestDupSubstring(String s) {
        int P = 1313131; // 需要较大的质数！！！
	int n = s.length();
        this.h = new long[n+10]; // 哈希数组h[]！！！
	this.p = new long[n+10]; // 次方数组p[]！！！
        p[0] = 1;
        for (int i=0; i<n; i++) { // 按公式填充数组！！！
            p[i+1] = p[i] * P;
            h[i+1] = h[i] * P + s.charAt(i);
        }

        String result = "";
        int low = 0, high = n; // 以「最大长度」为分割点的数轴具有「二段性」！！！
        while (low < high) {
            int mid = high + low + 1 >> 1; // 此处写成除法时间会超出限制！！！
            String current = check(s, mid);
            if (current.length() != 0) {
	        low = mid;
	    } else {
	        high = mid - 1;	
	    }
            result = (current.length() > result.length()) ? current : result;
        }
        return result;
    }
	
    public String check(String s, int len) { // O(n)时间检查某个长度「len」作为最大长度，是否存在合法方案！！！
        int n = s.length();
        Set<Long> hashRecord = new HashSet<>();
        for (int i = 1; i+len-1 <= n; i++) {
            int j = i+len-1;
            long hash = h[j] - h[i-1] * p[j-i+1]; // 利用前缀和思想，使得能够O(1)时间获取「子串s[i...j]的哈希值」！！！
            if (hashRecord.contains(hash)) {
	        return s.substring(i-1, j);
	    } else {
	        hashRecord.add(hash);	
	    }
        }
        return "";
    }
}
