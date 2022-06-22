class Solution {
    public int findUnsortedSubarray(int[] nums) { //「正向逆向结合问题」！！！
        int n = nums.length; // 将数组视作numsA，numsB，numsC；对numsB进行排序整个数组将有序，说明numsA和numsC有序且未改变！！！
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int right = -1, left = -1;
        for (int i=0; i<n; i++) { // 正向！！！
            if (nums[i] < max) {
                right = i; // 若有序则右边新来的元素必然改变max，记录下「最后一次」无需改变max的位置为numsB的右边界！！！
            } else {
                max = nums[i];
            }
        }
		for (int i=n-1; i>=0; i--){ // 逆向！！！
            if (nums[i] > min) {
                left = i; // 若有序则左边新来的元素必然改变min，记录下「最后一次」无需改变min的位置为numsB的左边界！！！
            } else {
                min = nums[i];
            }
		}
        return (right == -1) ? 0 : right-left+1;
    }
}