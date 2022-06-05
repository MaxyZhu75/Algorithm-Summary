class Solution {
    public int splitArray(int[] nums, int m) { // ���ֲ��� + ̰�ģ���ʹ�������ֵ������С���Ƕ��ֲ��ҳ������ʷ�������
        int maxNum = 0, sum = 0;
		for (int i=0; i<nums.length; i++) { // ���ֵ��Ͻ�Ϊ����������Ԫ�صĺͣ��½�Ϊ����������Ԫ�ص����ֵ������
            sum += nums[i];
            if (maxNum < nums[i]) {
                maxNum = nums[i];
            }
        }

        int low = maxNum, high = sum; // ���ֲ��ң�����
        while (low < high) {
            int mid = low + (high-low)/2;
            if (check(nums, mid, m)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean check(int[] nums, int upperBound, int m) { // ��֤�Ƿ����һ�ַָ�Ϊm��ķ��������������ָ�������ĺͲ�����upperBound������
        int subsetSum = 0;
        int count = 1;
        for (int i=0; i<nums.length; i++) {
            if (subsetSum + nums[i] > upperBound) { // case1���������Խ�磬�˴���Ҫ�����µ��飡����
                count++;
                subsetSum = nums[i];
            } else {
                subsetSum += nums[i]; // case2����Ӳ���Խ�磬��������ǰ���Ԫ�أ�����
            }
        }
        return count <= m; // ����mһ������nums.length�����ֻҪ����Ϊcount<m��ķ������ڣ�����Ϊm��ķ���Ҳ��Ȼ���ڣ�����
    }
}