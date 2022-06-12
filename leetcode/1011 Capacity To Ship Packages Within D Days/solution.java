class Solution {
    public int shipWithinDays(int[] weights, int days) { // ת��Ϊ�ж�����ġ����ֲ��ҡ�����LeetCode��875��1231�����ƣ�����
        int max = 0, sum = 0;
        for (int weight : weights) {
			sum += weight;
            max = Math.max(max, weight);
		}
        int low = max, high = sum; // ��ʼ��߽�Ϊ�������������������ʼ�ұ߽�Ϊ��������֮�ͣ�����
        while (low < high) {
            int mid = (high-low)/2 + low;
            int period = 1, currentLoad = 0; // ��midΪװ�����ޣ�period��ʾ��������������currentLoad��¼��������������������
            for (int weight : weights) {
                if (currentLoad + weight > mid) {
                    period++;
                    currentLoad = 0;
                }
                currentLoad += weight;
            }
            if (period <= days) { // �ų���Ч��װ�����ޣ��ҳ���С����Чװ�����ޣ�����
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}