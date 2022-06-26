public class Solution {
    public int[] nextGreaterElements(int[] nums) { // 把循环数组「拉直」：对下标取模，相当于将数组复制拼接在尾部！！！
        int n = nums.length;
		int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 2*n - 1; i >= 0; i--) { //「反向」：为左边新来的元素找到右侧第一个更小的元素！！！
            while (!stack.isEmpty() && nums[i%n] >= nums[stack.peekFirst()]) {
                stack.removeFirst();
            }
            result[i%n] = stack.isEmpty() ? -1 : nums[stack.peekFirst()]; // 注意默认为-1！！！
            stack.addFirst(i%n);
        }
        return result;
    }
}