class Solution {
    public int reversePairs(int[] nums) { // 统计符合要求的对数；调用「归并排序」！！！
        return mergeCount(nums, 0, nums.length-1);
    }

    public int mergeCount(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
		int mid = (right-left)/2 + left;
		int count = mergeCount(nums, left, mid) + mergeCount(nums, mid+1, right);

		int j = mid+1; // 统计符合要求的边界；[mid+1,j2)中所有index满足「nums[i]>2*nums[index]」！！！
		for (int i=left; i<=mid; i++) {
			while (j <= right && (long)nums[i] > 2*(long)nums[j]) {
				j++;
			}
			count += (j-mid-1);
		}

        int[] merge = new int[right-left+1]; // 双指针合并操作；合并后仍保持有序！！！
		int p1 = left, p2 = mid+1;
        int i = 0;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                merge[i++] = nums[p1++];
            } else {
                merge[i++] = nums[p2++];
            }
        }
        while (p1 <= mid) { // 其中一个指针走完时，用循环将另一个也走完！！！
            merge[i++] = nums[p1++];
        }
        while (p2 <= right) {
            merge[i++] = nums[p2++];
        }

        for (int k=0; k <= right-left; k++) { // 将合并且排序后的[left,right]填回原数组！！！
            nums[left+k] = merge[k];
        }

		return count;
    }
}