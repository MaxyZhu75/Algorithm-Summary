class Solution {
    public int reversePairs(int[] nums) { // ͳ�Ʒ���Ҫ��Ķ��������á��鲢���򡹣�����
        return mergeCount(nums, 0, nums.length-1);
    }

    public int mergeCount(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
		int mid = (right-left)/2 + left;
		int count = mergeCount(nums, left, mid) + mergeCount(nums, mid+1, right);

		int j = mid+1; // ͳ�Ʒ���Ҫ��ı߽磻[mid+1,j2)������index���㡸nums[i]>2*nums[index]��������
		for (int i=left; i<=mid; i++) {
			while (j <= right && (long)nums[i] > 2*(long)nums[j]) {
				j++;
			}
			count += (j-mid-1);
		}

        int[] merge = new int[right-left+1]; // ˫ָ��ϲ��������ϲ����Ա������򣡣���
		int p1 = left, p2 = mid+1;
        int i = 0;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                merge[i++] = nums[p1++];
            } else {
                merge[i++] = nums[p2++];
            }
        }
        while (p1 <= mid) { // ����һ��ָ������ʱ����ѭ������һ��Ҳ���꣡����
            merge[i++] = nums[p1++];
        }
        while (p2 <= right) {
            merge[i++] = nums[p2++];
        }

        for (int k=0; k <= right-left; k++) { // ���ϲ���������[left,right]���ԭ���飡����
            nums[left+k] = merge[k];
        }

		return count;
    }
}