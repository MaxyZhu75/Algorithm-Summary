class Solution {
    public int longestConsecutive(int[] nums) { // 线性时间完成；哈希表！！！
        Set<Integer> hashRecord = new HashSet<>();
        for (int num : nums) {
            hashRecord.add(num); // 存储索引元素且去重！！！
        }

        int result = 0;
        for (int num : hashRecord) {
            if (!hashRecord.contains(num-1)) { // 结论：若发现原数组存在num-1，则无需枚举以num为开头的连续序列结果（此时num必然已经被访问过）！！！
                int current = num;
                int count = 1;
                while (hashRecord.contains(current+1)) { // 统计当前最长序列长度！！！
                    current++;
                    count++;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}