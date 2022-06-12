class Solution {
    public String reorganizeString(String s) { // 贪心交叉填数解决；正确性证明见官方解答！！！
        int n = s.length();
		if (n <= 1) return s;
        
		int[] record = new int[26]; // 统计各个字符出现次数及，单个字符最大出现次数！！！
        int maxCount = 0;
        for (int i=0; i<n; i++) {
            record[s.charAt(i) - 'a']++;
            maxCount = Math.max(maxCount, record[s.charAt(i) - 'a']);
        }

        if (maxCount > (n+1)/2) { // 当n是偶数，单个字母的出现次数都不能超过n/2次；当n是奇数，单个字母的出现次数都不能超过(n+1)/2次！！！
            return ""; // 对于偶数，n/2与(n+1)/2相等，故简化判断条件！！！
        }
        char[] reorganized = new char[n]; // 奇偶下标交叉填数，故使用字符数组！！！
        int even = 0, odd = 1;
        for (int i=0; i<26; i++) {
            char letter = (char) ('a' + i);
            while (record[i] > 0 && record[i] <= n/2 && odd < n) { // 要点：当n是奇数且maxCount=(n+1)/2时，出现最多的字母必须全部放置在偶数下标；其余情况任意！！！
                reorganized[odd] = letter;
                record[i]--;
                odd += 2;
            }
            while (record[i] > 0) { // 将record剩余字符拿出填完即可！！！
                reorganized[even] = letter;
                record[i]--;
                even += 2;
            }
        }
        return new String(reorganized);
    }
}