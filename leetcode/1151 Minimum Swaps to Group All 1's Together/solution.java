class Solution {
    public int minSwaps(int[] data) { // �������ڣ�����
        int n = data.length;
        int windowSize = 0;
        for (int i=0; i<n; i++) {
            if (data[i] == 1) windowSize++; // �������ڴ�С = ������1������������
        }

        int countOne = 0;
        for (int i=0; i<windowSize; i++) {
            if (data[i] == 1) countOne++; // ͳ�ƻ��������ڳ�ʼλ�ã�������1������������
        }
        
        int maxOne = countOne; // �������ڽ����һ��������¼�¼������1���������������
        for (int i=windowSize; i<n; i++) {
            countOne += data[i]; // �룡����
            countOne -= data[i-windowSize]; // ��������
            maxOne = Math.max(maxOne, countOne);
        }
        
        return windowSize-maxOne; // ��Ҫ��������С������������0����С����������
    }
}