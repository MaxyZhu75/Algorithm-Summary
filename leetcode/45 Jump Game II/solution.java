class Solution {
    public int jump(int[] nums) { // �ӽ�̰��˼�룡����
        int n = nums.length;
        int actualBoundary = 0; // ÿһ���������ʵ�ʱ߽磡����
        int currentFurthest = 0;  // ���㵱ǰ��������Զ���룬Ϊ��һ��׼��������
        int hop = 0;
        for (int i=0; i<n-1; i++) { // ��������Ҫ����λ�ã�n-1���ѵ����յ㣬���ñ���������
            currentFurthest = Math.max(currentFurthest, i+nums[i]); 
            if (i == actualBoundary) { // Ҫ�㣺����������ʵ�ʱ߽�ʱ������һ��������
                actualBoundary = currentFurthest;
                hop++;
            }
        }
        return hop;
    }
}