func maximizeSweetness(sweetness []int, k int) int { // �����ֲ��ҡ��ж����⣻��LeetCode��1011��875�����ƣ�����
    min, sum := math.MaxInt32, 0
    for _, sweet := range sweetness {
        sum += sweet
        if sweet < min {
            min = sweet
        }
    }
    low, high, result := min, sum/(k+1), 0 // �Լ����Ե������С��һ�ݣ�����Լ������ֵܷ������С��һ�飬�����ֵܷ�ƽ��ֵ������
    for low <= high {
        mid := (high-low)/2 + low
        people, currentSweetness := 0, 0 // ��midΪ������ޣ�people��ʾ����������currentSweetness��¼��ǰ���ѷֵ�����ȣ�����
        for _, sweet := range sweetness {
            currentSweetness += sweet
            if currentSweetness >= mid {
                people++
                currentSweetness = 0
            }
        }
        if people >= k+1 { // �������ҵ������������ޣ�����
            result = mid
            low = mid+1
        } else {
            high = mid-1
        }
    }
    return result
}