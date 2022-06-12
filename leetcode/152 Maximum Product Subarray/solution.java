class Solution {
	public int maxProduct(int[] nums) { //�����������ϡ�������
		int n = nums.length;
		if (n == 1) return nums[0]; // ���ۣ����������������������������û��0�Ļ�����ôӵ�����˻���������һ����nums[0]��ʼ��ǰ׺���飩������nums[n-1]��β����׺���飩������
		int[] left = new int[n];
		int[] right = new int[n];
		left[0] = nums[0];
		right[n-1] = nums[n-1];
		for (int i=1; i<n; i++) { // ��������ͳ�Ƹ�Ԫ��ǰ��׺���飡����
			left[i] = (left[i-1] == 0 ? 1 : left[i-1]) * nums[i]; // ������Ԫ��Ϊ0����ǰ׺����׺������˻�Ϊ0�������´ӵ�ǰԪ�ؿ�ʼ����ǰ׺�˻����ɣ�����
			right[n-i-1] = (right[n-i] == 0 ? 1 : right[n-i]) * nums[n-1-i];
		}
		int result = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			result = Math.max(result, Math.max(left[i], right[n-1-i]));
		}
		return result;
	}
}