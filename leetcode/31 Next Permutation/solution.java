class Solution {
    public void nextPermutation(int[] nums) { // Ҫ��ԭ�ز������ⷨ��ȷ��֤����LeetCode�ٷ���𣡣���
        int lastMini = nums.length-2;
        while (lastMini >= 0 && nums[lastMini] >= nums[lastMini+1]) { // ����һ��Ѱ�����ļ�Сֵ������ζ�Ŵ�ʱ�ü�Сֵ��Ԫ�ر�Ȼ�������У�����
            lastMini--;
        }
        if (lastMini >= 0) {
            int nextHigher = nums.length-1;
            while (nextHigher >= lastMini+1 && nums[lastMini] >= nums[nextHigher]) { // ���������[lastMini+1, n)����������ҵ�һ������lastMini���������ڸ����併�򣬸����������lastMini����������ӽ�lastMini����������
                nextHigher--;
            }
            swap(nums, lastMini, nextHigher); // ����������������������[lastMini+1, n)��Ϊ���򣡣���
        }
        reverse(nums, lastMini+1, nums.length-1); // �����ģ�������[lastMini+1, n)��ת��Ϊ���򼴿ɣ�����
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}