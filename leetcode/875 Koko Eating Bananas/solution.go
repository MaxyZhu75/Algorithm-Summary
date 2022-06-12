func minEatingSpeed(piles []int, h int) int { // �����ֲ��ҡ��ж����⣻��LeetCode��1011��1231�����ƣ�����
    max := 0
    for _, pile := range piles {
        if pile > max {
            max = pile
        }
    }
    low, high := 1, max
    for low < high {
        mid := (high-low)/2 + low // ��midΪÿСʱθ�����ޣ�period��ʾ���ٳ���ȫ���㽶��ʱ�䣡����
        period := 0
        for _, pile := range piles { // ע��ÿСʱֻ��һ�ѣ�ĳһ�ѳ���θ��ʱ��Ҫ�Զ��Сʱ������
            if pile > mid {
                period += (pile+mid-1)/mid // �Ż�ʱ��д�����˴��ȼ��ڵ��� Math.ceil(pile*1.0 / mid)������
            } else {
                period++
            }
        }
        if (period <= h) {
            high = mid
        } else {
            low = mid+1
        }
    }
    return low
}