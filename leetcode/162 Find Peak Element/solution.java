class Solution {
    public int findPeakElement(int[] nums) { // �����󼫴�ֵ���������ֵ�����ֲ�����ȷ��֤�����ٷ���𣻴���չʾ�˶����Զ����ǵ����ԣ�����
        int n = nums.length;
        int low = 0, high = n-1;
        while (low < high) { // ��������ԣ�����nums[mid]��[mid��1]�Ĵ�С��ϵ������ȷ������һ�����㡸��Ȼ�н⡹������
            int mid = (high-low)/2 + low;
            if (nums[mid] < nums[mid+1]) { // ����أ�ѡ����ڱ߽�һ�˽��ж��֣�����ȷ��ѡ�������һ�����ڷ�ֵ������
				low = mid + 1;
			} else {
				high = mid;
			}
        }
        return low;
    }
}