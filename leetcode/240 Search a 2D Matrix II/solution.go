func searchMatrix(matrix [][]int, target int) bool { // �ɶ�ÿһ���ö��ֲ��ң����˴�ʹ�ø���Ч��Z���Ͳ��ҷ�������
    m, n := len(matrix), len(matrix[0])
    
    row, colum := 0, n-1 // Ҫ�㣺���Ҫ�ھ������Ͻǣ���ʱ��Ԫ��ȫ��С�ڣ��·�Ԫ��ȫ�����ڣ�target�������·�������
    for (row <= m-1 && colum >=0) { // ÿ��ѭ��ִֻ��һ�����������ƻ����ƣ�����
        if matrix[row][colum] == target {
            return true
        } else if matrix[row][colum] > target {
            colum-- // ���ƣ�����
        } else {
            row++ // ���ƣ�����
        }
    }
	
    return false
}