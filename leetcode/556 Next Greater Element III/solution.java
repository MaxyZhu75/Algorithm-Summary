class Solution {
    public int nextGreaterElement(int n) { // 找到「下一个更大的排列」！！！
        char[] nums = Integer.toString(n).toCharArray();
        int i = nums.length-2;
        while (i >= 0 && nums[i] >= nums[i+1]) { // 步骤一：寻找最靠右的「nums[i]<nums[i+1]」满足「其右侧为降序排列」！！！
            i--;
        }

        if (i < 0) return -1;

        int j = nums.length-1;
        while (j >= i+1 && nums[i] >= nums[j]) { // 步骤二：在「降序排列中」寻找最靠右的「nums[i]<nums[j]」；即nums[i]右侧最接近nums[i]的数！！！
            j--;
        }
        swap(nums, i, j); // 步骤三：交换两数，此时的nums[i]右侧必然「仍为降序」！！！
        reverse(nums, i+1, nums.length-1); // 步骤四：将nums[i]右侧反转「变为升序」！！！
        
        long result = Long.parseLong(new String(nums));
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }

    public void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(char[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}