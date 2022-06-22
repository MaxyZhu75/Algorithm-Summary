class Solution {
    public int[] intersect(int[] nums1, int[] nums2) { // 方法一：哈希表！！！
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1); // hashRecord存储较短的数组；若nums2较短则重新调用！！！
        }
		
        Map<Integer, Integer> hashRecord = new HashMap<>();
        for (int num : nums1) {
            hashRecord.put(num, hashRecord.getOrDefault(num, 0)+1); // nums1数组计数！！！
        }
		
        int[] result = new int[nums1.length]; // 定长结果数组，滑动index，最后复制有效部分！！！
        int index = 0;
        for (int num : nums2) {
            int count = hashRecord.getOrDefault(num, 0);
            if (count > 0) {
                count--;
                result[index++] = num;
                if (count > 0) {
                    hashRecord.put(num, count);
                } else {
                    hashRecord.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }
}