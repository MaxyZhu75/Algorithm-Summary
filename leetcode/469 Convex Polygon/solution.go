func isConvex(points [][]int) bool { // ����ѧ�����⣡����
    n := len(points)
    x1, x2, y1, y2 := 0, 0, 0, 0 // ������A(x1, y1)������B(x2, y2)������
    previous, current := 0, 0

    for i:=0; i<n; i++ { // ��ȡ��ŷ�ֹ��������nʱ���������
        x1 = points[(i+1)%n][0] - points[i][0]
        y1 = points[(i+1)%n][1] - points[i][1]
        x2 = points[(i+2)%n][0] - points[(i+1)%n][0]
        y2 = points[(i+2)%n][1] - points[(i+1)%n][1]
        current = x1 * y2 - x2 * y1 // �����ʽ���������0ʱ����ʱ�뷽��С��0ʱ��˳ʱ�뷽�򣡣���

        if current != 0 {
            if current * previous < 0 { // С��0˵����ǰһ�η���������ͬһ���򣡣���
                return false
            }
            previous = current
        }
    }

    return true
}