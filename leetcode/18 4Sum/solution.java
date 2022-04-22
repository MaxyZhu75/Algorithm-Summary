class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) { // 类似题目为三数之和，此题仅多一个指针！！！
        List<List<Integer>> result = new ArrayList<>(); // p1，p2，left，right指向的值可以相同，但不能重复往result添加已存在的答案组合！！！
        int n = nums.length;
        if (n < 4) return result;

        Arrays.sort(nums); // 先排序！！！

        for (int p1=0; p1<n-3; p1++) {
            if (p1 > 0 && nums[p1] == nums[p1-1]) continue; // 记住三个剪枝操作，加强代码效率！！！
			if ((long) nums[p1] + nums[p1+1] + nums[p1+2] + nums[p1+3] > target) break;
            if ((long) nums[p1] + nums[n-1] + nums[n-2] + nums[n-3] < target) continue; // long可防止加法溢出问题；此处亦可直接换成减法避免溢出！！！

			for (int p2=p1+1; p2<n-2; p2++) {
                if (p2 > p1+1 && nums[p2] == nums[p2-1]) continue; // 记住三个剪枝操作，加强代码效率！！！
                if ((long) nums[p1] + nums[p2] + nums[p2+1] + nums[p2+2] > target) break;
                if ((long) nums[p1] + nums[p2] + nums[n-1] + nums[n-2] < target) continue;

                int left = p2 + 1; // 当前p1，p2固定，对left和right写while循环的双指针！！
                int right = n-1;
                while (left < right) {
                    int sum = nums[p1] + nums[p2] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[p1], nums[p2], nums[left], nums[right])); // Arrays.asList(a, b, c，d)！！！
                        while (left < right && nums[left] == nums[++left]);
                        while (left < right && nums[right] == nums[--right]); // 此处循环旨在提前移动指针使下一个答案不重复！！！
                    } else if (sum < target) {
                        while (left < right && nums[left] == nums[++left]);
                    } else {
                        while (left < right && nums[right] == nums[--right]);
                    }
                }
            }
        }
        return result;
    }
}