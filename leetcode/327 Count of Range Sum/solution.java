class Solution { // 题目等价于要求：preSum[j]?preSum[i]属于范围[lower,upper]！！！
    public int countRangeSum(int[] nums, int lower, int upper) { // 对「前缀和数组」调用「归并排序」！！！
		int n = nums.length;
		long[] pSum = new long[n+1]; // 计算前缀和！！！
		for (int i=0; i<n; i++) {
			pSum[i+1] = pSum[i] + nums[i];
		}
		return mergeSortCounter(pSum, 0, pSum.length-1, lower, upper);
    }

	private int mergeSortCounter(long[] pSum, int left, int right, int lower, int upper) {
        if (left == right) {
            return 0;
        }
		int mid = (right-left)/2 + left;
		int count = mergeSortCounter(pSum, left, mid, lower, upper) + mergeSortCounter(pSum, mid+1, right, lower, upper);
		
		int i2 = mid+1, j2 = mid+1; // 统计符合要求的边界；[i2,j2)中所有index满足pSum[index]?pSum[i1]属于[lower,upper]！！！
		for (int i1=left; i1<=mid; i1++) { // 在「1st」以left为起点移动i1遍历！！！
			while (i2 <= right && pSum[i2] - pSum[i1] < lower) {
				i2++; // 在「2nd」以mid为起点移动i2直到pSum[i2]-pSum[i1]>=lower为止！！！
			}
			while (j2 <= right && pSum[j2] - pSum[i1] <= upper) {
				j2++; // 在「2nd」以mid为起点移动j2直到pSum[j2]-pSum[i1]>upper为止！！！	
			}
			count += (j2-i2);
		}

        long[] merge = new long[right-left+1]; // 双指针合并操作；合并后仍保持有序！！！
		int p1 = left, p2 = mid+1;
        int i = 0;
        while (p1 <= mid && p2 <= right) {
            if (pSum[p1] <= pSum[p2]) {
                merge[i++] = pSum[p1++];
            } else {
                merge[i++] = pSum[p2++];
            }
        }
        while (p1 <= mid) { // 其中一个指针走完时，用循环将另一个也走完！！！
            merge[i++] = pSum[p1++];
        }
        while (p2 <= right) {
            merge[i++] = pSum[p2++];
        }

        for (int k=0; k <= right-left; k++) { // 将合并且排序后的[left,right]填回原数组！！！
            pSum[left+k] = merge[k];
        }

		return count;
	}
}