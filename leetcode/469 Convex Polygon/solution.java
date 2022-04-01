class Solution {
    public boolean isConvex(List<List<Integer>> points) { // ����ѧ�����⣡����
        int n = points.size();
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0; // ������A(x1, y1)������B(x2, y2)������
        int previous = 0, current = 0;
        
        for (int i=0; i<n; i++) { // ��ȡ��ŷ�ֹ��������nʱ���������
            x1 = points.get((i+1)%n).get(0) - points.get(i).get(0);
            y1 = points.get((i+1)%n).get(1) - points.get(i).get(1);
            x2 = points.get((i+2)%n).get(0) - points.get((i+1)%n).get(0);
            y2 = points.get((i+2)%n).get(1) - points.get((i+1)%n).get(1);
            current = x1 * y2 - x2 * y1; // �����ʽ���������0ʱ����ʱ�뷽��С��0ʱ��˳ʱ�뷽�򣡣���

            if (current != 0) {
                if ((long) previous*current < 0) return false; // ǿ��ת��Ϊlong��С��0˵����ǰһ�η���������ͬһ���򣡣���
                previous = current;
            }
        }

        return true;
    }
}