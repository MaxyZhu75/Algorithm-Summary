func findDiagonalOrder(mat [][]int) []int { // ������Ŀ�ҹ��ɣ�����
    m, n := len(mat), len(mat[0])
    result := []int{}
    direction, up, down, upMax, downMax := 0, 0, 0, 0, 0 // ���ַ����棻ĳһ�Խ����ɿ�ʼ��������������������һ��һ�����Ҹ�Ԫ�صĺ�������֮����ͬ������
    for indexSum:=0; indexSum <= m+n-2; indexSum++ { // ������ͬ�Խ��߼���С���������ͬ����֮�ͣ�����
        if direction == 0 { // ȷ��������������ݼ������ı߽磡����
            downMax, upMax = m, n
        } else {
            downMax, upMax = n, m
        }
        if indexSum < downMax { // ȷ��������������ݼ������ĳ�ʼֵ������
            down = indexSum
        } else {
            down = downMax-1
        }
        up = indexSum - down

        for down >= 0 && up < upMax { // �жϵ�ǰ���򣬱�����ǰ�Խ����ϵ�Ԫ�أ�����
            if direction == 0 {
                result = append(result, mat[down][up]) // ע����������������ÿ�ֻᷴת��Ӧ���ݶԽ��ߵķ���ȷ��i��j�ֱ��ǵ������ǵݼ�������
            } else {
                result = append(result, mat[up][down])
            }
            down--
            up++
        }
        
        direction = 1 - direction // �Խ��߷���ת������
    }
    return result
}