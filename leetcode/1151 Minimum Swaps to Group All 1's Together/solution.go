func minSwaps(data []int) int { // �������ڣ�����
    n := len(data)
    windowsize := 0
    for i:=0; i<n; i++ {
        windowsize += data[i] // �������ڴ�С = ������1������������
    }

    countOne := 0
    for i:=0; i<windowsize; i++ {
        countOne += data[i] // ͳ�ƻ��������ڳ�ʼλ�ã�������1������������
    }

    maxOne := countOne // �������ڽ����һ��������¼�¼������1���������������
    for i:=windowsize; i<n; i++ {
        countOne += data[i] // �룡����
        countOne -= data[i-windowsize] // ��������
        if maxOne < countOne {
            maxOne = countOne
        }
    }

    return windowsize - maxOne // ��Ҫ��������С������������0����С����������
}