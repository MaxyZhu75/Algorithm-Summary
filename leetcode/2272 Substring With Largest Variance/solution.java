class Solution {
    public int largestVariance(String s) { // LeetCode第53题最大子数组变形题；时间优化可考虑DP！！！
        int result = 0;
        for (char c1 = 'a'; c1 <= 'z'; c1++) // 假设出现次数最多的字符为c1，出现次数最少的字符为c2！！！
            for (char c2 = 'a'; c2 <= 'z'; c2++) {
                if (c1 == c2) continue;
                int count = 0; // 维护c1和c2的出现次数之差！！！
                int difference = Integer.MIN_VALUE; // c1和c2必须都出现在子串中，若c2未出现，则difference会始终为无穷小！！！
                for (int i=0; i<s.length(); i++) {
                    if (s.charAt(i) == c1) { // 两种情况需要做处理，注意包含许多细节！！！
                        count++;
                        difference++; // 此处difference对c1的统计仅当已确认c2出现在子串中时（difference不为无穷小）才有效！！！
                    } else if (s.charAt(i) == c2) {
                        count--;
						difference = count;
                        count = Math.max(count, 0); // c1出现次数不大于c2时会摈弃之前的统计，重置count为0，且此时difference也必然为0或-1（不需要重置为无穷小，因为已经此时已确认c2出现在新子串当中，新子串为c1c2或c2）！！！
                    }

                    result = Math.max(result, difference);
                }
            }
        return result;
    }
}