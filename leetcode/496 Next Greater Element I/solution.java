class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) { //「单调栈」解决「子集下一个更大元素问题」！！！
        Map<Integer, Integer> hashRecord = new HashMap<>(); // 记录形式：<nums2[i], 右边下一个更大的元素值>！！！
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=nums2.length-1; i>=0; i--) { //「反向」：为左边新来的元素找到右侧第一个更小的元素！！！
            while (!stack.isEmpty() && nums2[i] >= stack.peekFirst()) {
                stack.removeFirst();
            }
            hashRecord.put(nums2[i], stack.isEmpty() ? -1 : stack.peekFirst()); // 注意默认为-1！！！
            stack.addFirst(nums2[i]); // 每次需要入栈操作！！！
        }

        int[] result = new int[nums1.length]; // 添加结果！！！
        for (int i=0; i<nums1.length; i++) {
            result[i] = hashRecord.get(nums1[i]);
        }
        return result;
    }
}
