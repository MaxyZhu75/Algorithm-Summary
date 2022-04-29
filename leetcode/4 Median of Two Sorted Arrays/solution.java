class Solution {
    int[] nums1;
	int[] nums2;
	int n1;
	int n2;
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) { // 具体二分查找规则见LeetCode官方解答！！！
        this.nums1 = nums1;
		this.nums2 = nums2;
		this.n1 = nums1.length;
		this.n2 = nums2.length;
        int totalLength = n1 + n2;
        if (totalLength % 2 == 1) { // 总长度为奇数时，直接找中间位置元素！！！
            int midIndex = totalLength/2;
            double median = getKthElement(midIndex + 1); // 令k=midIndex，此时将问题转化为获取第k小的数！！！
            return median;
        } else {
            int midIndex1 = totalLength/2 - 1; // 总长度为偶数时，求中间两个元素的均值！！！
			int midIndex2 = totalLength/2;
            double median = (getKthElement(midIndex1+1) + getKthElement(midIndex2+1)) / 2.0; // 分别令k1=midIndex1，k2=midIndex2，此时将问题转化为求第k1及k2小的元素！！！
            return median;
        }
    }

    public int getKthElement(int k) {
        int left1 = 0, left2 = 0;
        while (true) {
            if (left1 == n1) { // 边界1: nums1遍历结束，剩余的k个在nums2中找即可！！！
                return nums2[left2 + k - 1];
            }
            if (left2 == n2) { // 边界2: nums2遍历结束，剩余的k个在nums1中找即可！！！
                return nums1[left1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[left1], nums2[left2]); // 边界3：查找结束，返回较小值！！！
            }

            int index1 = Math.min(left1 + k/2, n1) - 1; // 每次去比较nums1[k/2-1]与nums2[k/2-1]来排除元素；若k/2-1越界，则选择数组最后一个元素比较！！！
            int index2 = Math.min(left2 + k/2, n2) - 1;
            if (nums1[index1] <= nums2[index2]){ // 更新k及数组的left指针！！！
                k -= (index1 - left1 + 1);
                left1 = index1+1;
            } else {
                k -= (index2 - left2 + 1);
                left2 = index2+1;
            }
        }
    }
}