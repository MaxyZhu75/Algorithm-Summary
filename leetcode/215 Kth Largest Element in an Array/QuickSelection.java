class Solution {
    public int findKthLargest(int[] nums, int k) { // �����еĺ���partition()�ǳ�ʵ�ã�����
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int index = partition(nums, left, right); // ����ֵΪ��ǰѭ����ѡpivot����partition()�����ڵ�����λ��index���京���൱�������ں���index����pivotֵС��Ԫ�أ����Ѿ������õ�pivot����ߣ�����
            if (nums.length - index > k) {
                left = index + 1; // case1���ȵ�ǰѭ����ѡpivot���Ԫ�ض���k-1��������partition()�Ѿ�������Ԫ�ط�����pivot�ұߣ���k���Ԫ�ش�ʱ�϶���pivot�ұߣ�������߽磡����
            } else if (nums.length - index < k) {
                right = index - 1; // case2���ȵ�ǰѭ����ѡpivot���Ԫ������k-1��������partition()�Ѿ�����СԪ�ط�����pivot��ߣ���k���Ԫ�ش�ʱ�϶���pivot��ߣ������ұ߽磡����
            } else {
                return nums[index]; // case3���ȵ�ǰѭ����ѡpivot���Ԫ�ص���k-1������ǰpivot��Ϊ��k���ֵ������
            }
        }
    }

    private static Random random = new Random(System.currentTimeMillis()); // java.util.Random �Լ� java.util.Date�����������������pivot��������ʱ�䣡����

    private int partition(int[] nums, int left, int right) {
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right-left); // random.nextInt(right-left)�����ɽ���[0, right-left]�������������
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