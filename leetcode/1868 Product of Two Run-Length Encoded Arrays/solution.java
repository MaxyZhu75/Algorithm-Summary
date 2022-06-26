class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) { //��˫ָ�롹������
        List<List<Integer>> result = new ArrayList<>();
        int p1 = 1, p2 = 1; // ϸ�ڣ�ָ����һ��������Ԫ�ء�������
        int num1 = encoded1[0][0], left1 = encoded1[0][1], num2 = encoded2[0][0], left2 = encoded2[0][1]; // ��ǰ�����������ʣ�����������
        int num = -1, count = -1, curNum = 0, curCount = 0; // ����ӽ�����ĺϲ����ּ��������µõ������ּ�����������
        while (p1 < encoded1.length || p2 < encoded2.length) {
            if (left1 == 0) {
                left1 = encoded1[p1][1];
                num1 = encoded1[p1][0];
                p1++;
            }
            if (left2 == 0) {
                left2 = encoded2[p2][1];
                num2 = encoded2[p2][0];
                p2++;
            }
            curNum = num1 * num2;
            curCount = Math.min(left1, left2);
            left1 -= curCount;
            left2 -= curCount;
            if (curNum == num) {
                count += curCount;
            } else {
                if (num != -1) { // ϸ�ڣ���ʼ�������ӣ�����
                    result.add(Arrays.asList(num, count));
                }
                num = curNum;
                count = curCount;
            }
        }

        if (num != -1) { // ϸ�ڣ��������һ����������
            result.add(Arrays.asList(num, count));
        }
        return result;
    }
}