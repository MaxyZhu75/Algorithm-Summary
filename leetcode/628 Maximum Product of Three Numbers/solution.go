func maximumProduct(nums []int) int { // ˼·Ϊ�����һ�α���ɨ�裡����
    max1, max2, max3 := math.MinInt32, math.MinInt32, math.MinInt32// case1��������ȫ�ǷǸ�����ȫ�Ƿ�����������ӦΪ������������ˣ�����
    min1, min2 := math.MaxInt32, math.MaxInt32 // case2���������������и����������˻��ȿ�����������������ĳ˻���Ҳ������������С��������������ĳ˻�������

    for _, num := range nums { // ע�������ʼ���Լ�����ʱ���±�����if-elseд��������
        if num > max1 {
            max3 = max2
            max2 = max1
            max1 = num
        } else if num > max2 {
            max3 = max2
            max2 = num
        } else if num > max3 {
            max3 = num
        }

        if num < min1 {
            min2 = min1
            min1 = num
        } else if num < min2 {
            min2 = num
        }
    }

    return max(max1*max2*max3, min1*min2*max1) // ������һ�α������ҳ���������������С�����������ɣ�����max1*max2*max3��min1*min2*max1���ֽ����ʽȡ���ֵ������
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}