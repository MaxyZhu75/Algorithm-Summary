class Solution {
    int[] merge;

    public int[] sortArray(int[] nums) { // ���á��鲢���򡹣�����
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
        mergeSort(nums, low, mid); // ǰ�벿�֣���[low,mid]���ֽ������򣡣���
        mergeSort(nums, mid+1, high); // ��벿�֣���[mid+1,high]���ֽ������򣡣���
        
		int p1 = low, p2 = mid+1; // ˫ָ��ϲ��������ϲ����Ա������򣡣���
        int i = 0;
        while (p1 <= mid && p2 <= high) {
            if (nums[p1] <= nums[p2]) {
                merge[i++] = nums[p1++];
            } else {
                merge[i++] = nums[p2++];
            }
        }
        while (p1 <= mid) { // ����һ��ָ������ʱ����ѭ������һ��Ҳ���꣡����
            merge[i++] = nums[p1++];
        }
        while (p2 <= high) {
            merge[i++] = nums[p2++];
        }

        for (int k=0; k <= high-low; k++) { // ���ϲ���������[low,high]���ԭ���飡����
            nums[low+k] = merge[k];
        }
    }
}