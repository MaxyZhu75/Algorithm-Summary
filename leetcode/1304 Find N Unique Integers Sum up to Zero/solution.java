class Solution {
    public int[] sumZero(int n) { // [0], [-1,1], [-1,1,0], [-2,-1,1,2], [-2,-1,-1,2,0]......������
        int[] A = new int[n]; // ϸ�ڣ�nΪ����ʱ����ĩβΪ��ʼ��Ԫ��0������
        int index = 0;
        for (int i=1; i<=n/2; i++) { // ϸ�ڣ�ע��ѭ����1��n/2������
            A[index++] = -i;
            A[index++] = i;
        }
        return A;
    }
}