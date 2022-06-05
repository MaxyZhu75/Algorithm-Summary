class Solution {
    public boolean canCross(int[] stones) { // �����Ż������Ķ�̬�滮������
        int n = stones.length;
        boolean[][] d = new boolean[n][n]; // �ܷ�ͨ������Ծ����distance���ӡ�ǰһ�����Ϊj��ʯ�ӡ��ﵽ����ǰ���Ϊi��ʯ�ӡ�������
        d[0][0] = true;
        
		for (int i=1; i<n; i++) { // ÿ����Ծ֮����Ծ������������1��������i-1��ʯ��ʱ��֮ǰ��������i-1�Σ���һ�������� i �ľ��룡����
            if (stones[i] - stones[i-1] > i) {
                return false; // �Ż�����һ�������i��ʯ������i?1��ʯ�Ӿ��볬��iʱ�����ܱض��޷������յ㣬ֱ��return������
            }
        }
		
		int distance = 0;
        for (int i=1; i<n; i++) {
            for (int j=i-1; j>=0; j--) {
                distance = stones[i] - stones[j];
                if (distance > j+1) { // �Ż����۶���ͬ��������j��ʯ��ʱ����һ��������j+1�ľ��룡����
                    break; // ���ڵ������j�������ֵ�ǰ��Ϊ��Ծ���벻�����޷������ֱ��break�˳�ѭ��������
                }
                d[i][distance] = d[j][distance-1] || d[j][distance] || d[j][distance+1]; // ת�Ʒ��̣�����
                if (i == n-1 && d[n-1][distance]) { // �����յ㣡����
                    return true;
                }
            }
        }
        return false;
    }
}