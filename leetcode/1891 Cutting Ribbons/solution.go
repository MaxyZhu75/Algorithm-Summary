func maxLength(ribbons []int, k int) int { // ���ֲ��ң�����
    low, high, result := 1, 1, 0
    for _, ribbon := range ribbons {
        high = max(ribbon, high)
    }
    for low <= high { // ��ѭ���ڲ���Ԫ�أ���result��¼��ǰ���������Ľ��������
        mid := (high-low)/2 + low
        if check(ribbons, k , mid) {
            result = mid
            low = mid+1
        } else {
            high = mid-1
        }
    }
    return result
}

func check(ribbons []int, k int, length int) bool { // �ж��Ƿ��ܹ��г�k�������ϳ���Ϊlength�����ӣ�����
    count := 0
    for _, ribbon := range ribbons {
        count += ribbon/length
    }
    return count >= k
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}