class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0; // ����ά��������
        int count = 0;

        for (int[] rectangle : rectangles) {
            int currentLen = Math.min(rectangle[0], rectangle[1]); // ��Ȼ�ǰ����ζ̱߳����������Σ�����
            if (currentLen == maxLen) {
                count++;
            }
            if (currentLen > maxLen) {
                maxLen = currentLen;
                count = 1;
            }
        }

        return count;
    }
}