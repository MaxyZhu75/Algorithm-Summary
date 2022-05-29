class Solution {
    public boolean isRobotBounded(String instructions) { // ��ִ��һ��ָ����жϣ���û�ص�ԭ�㲢�����򱱷����Ȼ�޷��ص�ԭ�㣬�����Ȼ�ܻص�ԭ�㣡����
        int[][] directionsR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] directionsL = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int offset = 0, x = 0, y = 0;
        for (int i=0; i<instructions.length(); i++) {
            if (instructions.charAt(i) == 'R') { // case1������ת�򣡣���
                offset++;
            } else if (instructions.charAt(i) == 'L') { // case2������ת�򣡣���
                offset--;
            } else { // case3��ǰ��������
                if (offset >= 0) {
                    x += directionsR[offset%4][0];
                    y += directionsR[offset%4][1];
                } else {
                    int temp = -1 * offset; // ���ﲻ�ܸı�ԭoffset��������Ӱ��������㣡����
                    x += directionsL[temp%4][0];
                    y += directionsL[temp%4][1];                 
                }
            }
        }
        return (x == 0 && y == 0) || (offset % 4 != 0);
    }
}