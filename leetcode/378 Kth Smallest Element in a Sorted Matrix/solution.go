func kthSmallest(matrix [][]int, k int) int { // ������LeetCode240��ͬ����Z���Ͳ��ң�����ͬʱ���ö��ֲ���˼�룡����
    n := len(matrix)
    low, high := matrix[0][0], matrix[n-1][n-1]
    notLargerThan := 0
    for (low < high) {
        mid := low + (high-low)/2
        notLargerThan = zigZagSearch(matrix, mid);
        if notLargerThan < k { // case1����ΪnotLargerThan��¼��������Ԫ��ֵС�ڵ���mid��Ԫ�ظ�������������ֵΪmid��Ԫ�أ����ʵ��ü�¼С��k��ʱ����kС��ֵ��Ȼ����mid������
           low = mid + 1 
        } else {
            high = mid // case2��mid�����ǵ�kС������
        }
    }
    return low
}

func zigZagSearch(matrix [][]int, mid int) int {
    row, colum := len(matrix)-1, 0 // Z���Ͳ���ʱ���½�Ϊ��㣡����
    count := 0
    for (row >=0 && colum <= len(matrix)-1) { // Խ����˳���������ֵΪmid��Ԫ�ؿ����ж����Ҫȫ��ɨ�裡����
        if matrix[row][colum] <= mid { // ����ʱ����ǰԪ�ؼ����������Ϸ�Ԫ�ر�ȻС�ڵ���mid������
            colum++
            count += row+1 // ע�⣺��¼����С�ڵ���mid�ĸ������������ϸ�С��mid������
        } else {
            row--
        }
    }
    return count;
}