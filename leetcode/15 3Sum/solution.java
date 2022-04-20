class Solution {
    public List<List<Integer>> threeSum(int[] nums) { // 类似题目为四数之和！！！
        List<List<Integer>> result = new ArrayList<>(); // p1，left，right指向的值可以相同，但不能重复往result添加已存在的答案组合！！！
        if (nums == null || nums.length < 3) return result;
        int n = nums.length;

        Arrays.sort(nums); // 先排序！！！

        for (int p1=0; p1<n-2; p1++) {
            if (p1 > 0 && nums[p1] == nums[p1-1]) continue; // 记住三个剪枝操作，加强代码效率！！！
			if ((long) nums[p1] + nums[p1+1] + nums[p1+2] > 0) break;
            if ((long) nums[p1] + nums[n-1] + nums[n-2] < 0) continue; // long可防止加法溢出问题；此处亦可直接换成减法避免溢出！！！
            
            int left = p1 + 1; // 当前p1固定，对left和right写while循环的双指针！！！
            int right = n-1;
            while (left < right) {
                int sum = nums[p1] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[p1], nums[left], nums[right])); // Arrays.asList(a, b, c)！！！
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]); // 此处循环旨在提前移动指针使下一个答案不重复！！！
                } else if (sum < 0) {
                    while (left < right && nums[left] == nums[++left]);
                } else {
                    while (left < right && nums[right] == nums[--right]);
                }
            }
        }

        return result;
    }
}
