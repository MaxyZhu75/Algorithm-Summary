class Solution {
    public int[] sortArray(int[] nums) { // ���á��������򡹣�����
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int index = partition(nums, left, right); // ����ֵΪ��ǰѭ����ѡpivot����partition()�����ڵ�����λ��index���京���൱�������ں���index����pivotֵС��Ԫ�أ����Ѿ������õ�pivot����ߣ�����
            quickSort(nums, left, index-1);
            quickSort(nums, index+1, right);
        }
    }

    private int partition(int[] nums, int left, int right) { // ����partition()�̶�д��������
		Random random = new Random(System.currentTimeMillis());
        if (left < right) {
            int randomIndex = left + 1 + random.nextInt(right-left); // random.nextInt(right-left)�����ɽ���[0, right-left)�������������
            swap(nums, left, randomIndex); // �����ѡȡ��pivot�ƶ�����ǰ�棡����
        }
        int pivot = nums[left];
        int j = left; // ��¼pivot�ĺ�������λ�ã�����ѭ���ڲ�δ��������pivot������
        for (int i = left+1; i<=right; i++) {
            if (nums[i] < pivot) {
                j++; // ��¼pivot�ĺ�������λ�ã���ͳ�Ƶ�ǰ��pivotС��Ԫ�ظ���������
                swap(nums, j, i);
            }
        }
        swap(nums, left, j); // ѭ�������󣬴˴��ٽ�pivot��������ȷλ�ã�����
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}