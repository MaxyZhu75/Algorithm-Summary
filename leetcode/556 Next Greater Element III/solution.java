class Solution {
    public int nextGreaterElement(int n) { // �ҵ�����һ����������С�������
        char[] nums = Integer.toString(n).toCharArray();
        int i = nums.length-2;
        while (i >= 0 && nums[i] >= nums[i+1]) { // ����һ��Ѱ����ҵġ�nums[i]<nums[i+1]�����㡸���Ҳ�Ϊ�������С�������
            i--;
        }

        if (i < 0) return -1;

        int j = nums.length-1;
        while (j >= i+1 && nums[i] >= nums[j]) { // ��������ڡ����������С�Ѱ����ҵġ�nums[i]<nums[j]������nums[i]�Ҳ���ӽ�nums[i]����������
            j--;
        }
        swap(nums, i, j); // ��������������������ʱ��nums[i]�Ҳ��Ȼ����Ϊ���򡹣�����
        reverse(nums, i+1, nums.length-1); // �����ģ���nums[i]�Ҳ෴ת����Ϊ���򡹣�����
        
        long result = Long.parseLong(new String(nums));
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }

    public void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(char[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}