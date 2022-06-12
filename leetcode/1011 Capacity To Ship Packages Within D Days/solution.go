func shipWithinDays(weights []int, days int) int { // ת��Ϊ�ж�����ġ����ֲ��ҡ�����LeetCode��875��1231�����ƣ�����������
    max, sum := 0, 0
    for _, weight := range weights {
        sum += weight
        if weight > max {
            max = weight
        }
    }

    low, high := max, sum // ��ʼ��߽�Ϊ�������������������ʼ�ұ߽�Ϊ��������֮�ͣ�����
    for low < high {
        mid := (high-low)/2 + low
        period, currentLoad := 1, 0 // ��midΪװ�����ޣ�period��ʾ��������������currentLoad��¼��������������������
        for _, weight := range weights {
            if currentLoad + weight > mid {
                period++
                currentLoad = 0
            }
            currentLoad += weight
        }
        if period <= days { // �ų���Ч��װ�����ޣ��ҳ���С����Чװ�����ޣ�����
            high = mid 
        } else {
            low = mid+1
        }
    }
    return low
}