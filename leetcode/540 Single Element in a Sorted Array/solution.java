class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int result = 0;
        while (low < high) {
            int mid = low + (high-low)/2;
            int remainder = mid % 2; 
            if (remainder == 1) { // �ؼ�������֪���������Ϊ������Ԫ�أ�������mid������Ϊż�������ʹ���ֵ�ǰ�������ֽԺ���ż����Ԫ�أ�����
                mid--; // �˴�����ʹmid��һ������
            }
			
            if (nums[mid] == nums[mid+1]) { // ����nums[mid]ƥ�䵽�˺�һ��Ԫ�أ���ζ�ź�벿��Ԫ�ظ�����Ϊ����������Ȼ�����䵥��һ��Ԫ�أ�����
                low = mid+2; // case1�����ڴ�ʱ�𰸱�Ȼ����[mid+2, high]��resultÿ�θ��µ�ǰ����Ľ�����ɣ�����
                result = low; 
            } else { // ����nums[mid]���һ��Ԫ�ز�ƥ�䣬���ʱ�䵥��Ԫ�����������������
                high = mid; // case2��nums[mid]��Ϊ�䵥��Ԫ�أ�case3���𰸽���[low, mid-2]�����ڷ�дΪ3��caseʱLeetCode�ϻᳬʱ���˴�else���հ����������������д����д������
                result = high;
            }
        }
        return nums[result];
    }
}