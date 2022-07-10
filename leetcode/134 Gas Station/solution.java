class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0; // ���ۣ������x�������ˡ�y+1������ô�ӡ�x������y������һ������������ܵ��y+1��������
        while (i < n) {
            int gasSum = 0, costSum = 0;
            int count = 0; // ���ȼ���0������վ������ͼ�ж��ܷ���һ�ܣ�������ܣ��ʹӡ���һ���޷�����ļ���վ����ʼ������飡����
            while (count < n) {
                int j = (i + count) % n; // ϸ�ڣ�����ѭ����Ҫȡ�࣡����
                gasSum += gas[j];
                costSum += cost[j];
                if (costSum > gasSum) {
                    break;
                }
                count++;
            }
            if (count == n) {
                return i;
            } else {
                i = i + count + 1;
            }
        }
        return -1;
    }
}