class Solution {
    public int findUnsortedSubarray(int[] nums) { //���������������⡹������
        int n = nums.length; // ����������numsA��numsB��numsC����numsB���������������齫����˵��numsA��numsC������δ�ı䣡����
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int right = -1, left = -1;
        for (int i=0; i<n; i++) { // ���򣡣���
            if (nums[i] < max) {
                right = i; // ���������ұ�������Ԫ�ر�Ȼ�ı�max����¼�¡����һ�Ρ�����ı�max��λ��ΪnumsB���ұ߽磡����
            } else {
                max = nums[i];
            }
        }
		for (int i=n-1; i>=0; i--){ // ���򣡣���
            if (nums[i] > min) {
                left = i; // �����������������Ԫ�ر�Ȼ�ı�min����¼�¡����һ�Ρ�����ı�min��λ��ΪnumsB����߽磡����
            } else {
                min = nums[i];
            }
		}
        return (right == -1) ? 0 : right-left+1;
    }
}