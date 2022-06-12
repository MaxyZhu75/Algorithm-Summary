class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) { //「单调栈」解决「子集下一个更大元素问题」！！！
        Map<Integer, Integer> hashRecord = new HashMap<>(); // 记录形式：<nums2[i], 右边下一个更大的元素值>！！！
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=nums2.length-1; i>=0; i--) { // 倒序遍历nums2！！！
            while (!stack.isEmpty() && stack.peekFirst() <= nums2[i]) { // 出栈条件：栈顶元素小于等于当前元素（维护单调栈）！！！
                stack.removeFirst();
            }
            hashRecord.put(nums2[i], stack.isEmpty() ? -1 : stack.peekFirst()); // 栈为空说明右侧没有比当前元素更大的！！！
            stack.addFirst(nums2[i]); // 每次需要入栈操作！！！
        }
        int[] result = new int[nums1.length];
        for (int i=0; i<nums1.length; i++) {
            result[i] = hashRecord.get(nums1[i]);
        }
        return result;
    }
}