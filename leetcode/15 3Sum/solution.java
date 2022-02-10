class Solution {
    public List<List<Integer>> threeSum(int[] nums) { // Java答案与Go答案的变量定义有区别，因为定义一样时LeetCode上会发现另一种有内存或时间溢出问题；但两种解法都基于排序+双指针！！！
        int n = nums.length; // 要点一：left代表左边界指针，对于一组相同的数会指在最左边；mid和right为中间指针和右边界指针！！！
        List<List<Integer>> result = new ArrayList<>(); // left，mid，right指向的值可以相同，但不能重复往result添加已存在的答案组合！！！

        Arrays.sort(nums);

        for (int left=0; left<n-2; left++) {
            if (nums[left] > 0) { // 要点二：左边界右边元素都不小于左边界元素值，直接退出！！！
                break;
            }
           
            if (left > 0 && nums[left] == nums[left-1]) { // 要点三：分别确定left，mid，right位置（对于一组相同的数left会指在最左边）！！！
                continue;
            }
            int mid = left+1;
            int right = n-1;
            
            while (mid < right) { // 要点四：当前left固定（left在外层循环移），对mid和right写while循环的双指针！！！
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[left], nums[mid], nums[right])); // Arrays.asList(a, b, c)！！！
                    while (mid < right && nums[mid] == nums[++mid]);
                    while (mid < right && nums[right] == nums[--right]); // 要点五：注意该移动指针的写法与Go答案区分！！！
                } else if (sum < 0) {
                    while (mid < right && nums[mid] == nums[++mid]); // 此处循环是为了使下一个答案不重复！！！
                } else {
                    while (mid < right && nums[right] == nums[--right]);
                }
            }
        }

        return result;
    }
}