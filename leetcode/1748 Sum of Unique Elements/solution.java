class Solution {
    public int sumOfUnique(int[] nums) { // ������Ҫʵ��һ�α�������Ҫά������״̬������
        int[] record = new int[101]; // ��¼0, 1, 2����״̬�������Ǽ�¼����������
        int result = 0;

        for (int num : nums) {
            if (record[num] == 0) { // ״̬0��֮ǰδ���ֹ��������result����ת��Ϊ״̬1������
                result += num;
                record[num] = 1;
            } else if (record[num] == 1) { // ״̬1��֮ǰ���ֹ�һ�Σ����result�п۳�֮ǰ������ģ���ת��Ϊ״̬2������
                result -= num;
                record[num] = 2;
            } else { // ״̬2��֮ǰ���ֹ���Σ�����ʱ����Լ�¼����ı���result���κβ���������
                continue;
            }
        }

        return result;
    }
}