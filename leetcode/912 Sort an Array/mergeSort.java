class Solution {
    int[] merge;

    public int[] sortArray(int[] nums) { // 调用「归并排序」！！！
        int n = nums.length;
		this.merge = new int[n];
        mergeSort(nums, 0, n-1);
        return nums;
    }

    public void mergeSort(int[] nums, int low, int high) {
        if (low == high) {
            return;
        }

        int mid = (high-low)/2 + low;
        mergeSort(nums, low, mid); // 前半部分：对[low,mid]部分进行排序！！！
        mergeSort(nums, mid+1, high); // 后半部分：对[mid+1,high]部分进行排序！！！
        
		int p1 = low, p2 = mid+1; // 双指针合并操作；合并后仍保持有序！！！
        int i = 0;
        while (p1 <= mid && p2 <= high) {
            if (nums[p1] <= nums[p2]) {
                merge[i++] = nums[p1++];
            } else {
                merge[i++] = nums[p2++];
            }
        }
        while (p1 <= mid) { // 其中一个指针走完时，用循环将另一个也走完！！！
            merge[i++] = nums[p1++];
        }
        while (p2 <= high) {
            merge[i++] = nums[p2++];
        }

        for (int k=0; k <= high-low; k++) { // 将合并且排序后的[low,high]填回原数组！！！
            nums[low+k] = merge[k];
        }
    }
}