func isRobotBounded(instructions string) bool { // ��ִ��һ��ָ����жϣ���û�ص�ԭ�㲢�����򱱷����Ȼ�޷��ص�ԭ�㣬�����Ȼ�ܻص�ԭ�㣡����
    var directionsR = [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}
    var directionsL = [][]int{{0, 1}, {-1, 0}, {0, -1}, {1, 0}}
    offset, x, y := 0, 0, 0
    for i:=0; i<len(instructions); i++ {
        if instructions[i] == 'R' { // case1������ת�򣡣���
            offset++
        } else if instructions[i] == 'L' { // case2������ת�򣡣���
            offset--
        } else { // case3��ǰ��������
            if offset >= 0 {
                x += directionsR[offset%4][1]  
                y += directionsR[offset%4][0]
            } else {
                temp := -1 * offset // ���ﲻ�ܸı�ԭoffset��������Ӱ��������㣡����
                x += directionsL[temp%4][1]  
                y += directionsL[temp%4][0]
            }
        }
    }
    return (x == 0 && y == 0) || (offset % 4 != 0)
}