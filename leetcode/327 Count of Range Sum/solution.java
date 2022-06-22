class Solution { // ��Ŀ�ȼ���Ҫ��preSum[j]?preSum[i]���ڷ�Χ[lower,upper]������
    public int countRangeSum(int[] nums, int lower, int upper) { // �ԡ�ǰ׺�����项���á��鲢���򡹣�����
		int n = nums.length;
		long[] pSum = new long[n+1]; // ����ǰ׺�ͣ�����
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
		
		int i2 = mid+1, j2 = mid+1; // ͳ�Ʒ���Ҫ��ı߽磻[i2,j2)������index����pSum[index]?pSum[i1]����[lower,upper]������
		for (int i1=left; i1<=mid; i1++) { // �ڡ�1st����leftΪ����ƶ�i1����������
			while (i2 <= right && pSum[i2] - pSum[i1] < lower) {
				i2++; // �ڡ�2nd����midΪ����ƶ�i2ֱ��pSum[i2]-pSum[i1]>=lowerΪֹ������
			}
			while (j2 <= right && pSum[j2] - pSum[i1] <= upper) {
				j2++; // �ڡ�2nd����midΪ����ƶ�j2ֱ��pSum[j2]-pSum[i1]>upperΪֹ������	
			}
			count += (j2-i2);
		}

        long[] merge = new long[right-left+1]; // ˫ָ��ϲ��������ϲ����Ա������򣡣���
		int p1 = left, p2 = mid+1;
        int i = 0;
        while (p1 <= mid && p2 <= right) {
            if (pSum[p1] <= pSum[p2]) {
                merge[i++] = pSum[p1++];
            } else {
                merge[i++] = pSum[p2++];
            }
        }
        while (p1 <= mid) { // ����һ��ָ������ʱ����ѭ������һ��Ҳ���꣡����
            merge[i++] = pSum[p1++];
        }
        while (p2 <= right) {
            merge[i++] = pSum[p2++];
        }

        for (int k=0; k <= right-left; k++) { // ���ϲ���������[left,right]���ԭ���飡����
            pSum[left+k] = merge[k];
        }

		return count;
	}
}