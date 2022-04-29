func getModifiedArray(length int, updates [][]int) []int { // ���������⣨Range Caching��������
    array := make([]int, length)
    start, end, inc := 0, 0, 0
    for _, operation := range updates { // ֻ�ڲ�������ı߽��ϴ洢�仯��ֵ���������������䶼���и��£�������
        start, end , inc = operation[0], operation[1], operation[2]
        array[start] += inc // array[start] = array[start] + inc������
        if end < length-1 {
            array[end+1] -= inc // array[end+1] = array[end+1] - inc������
        }
    }
    for i:=1; i<length; i++ {
        array[i] = array[i] + array[i-1] // array[i] = array[i] + array[i-1]������
    }
    return array
}