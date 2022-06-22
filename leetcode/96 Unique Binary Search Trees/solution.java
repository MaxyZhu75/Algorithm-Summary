class Solution {
    public int numTrees(int n) { // ��̬�滮�Ƶ�����ȷ�Լ��ٷ���⣡����
        int[] G = new int[n+1]; // ����Ϊn�������ܹ��ɵĲ�ͬ�����������ĸ���������
        G[0] = 1;
        G[1] = 1;
        for (int i=2; i<=n; i++) {
            for (int j=1; j<=i; j++) { // F(i,j) = G[j-1]*G[i-j] �ɱ�ʾ��jΪ������iΪ���г��ȵĲ�ͬ��������������������
                G[i] += G[j-1] * G[i-j]; // ת�Ʒ��̣�G[i] = sum{G[j-1]*G[i-j]} ����sum��ʾj��1��i�ۼӣ�����
            }
        }
        return G[n];
    }
}