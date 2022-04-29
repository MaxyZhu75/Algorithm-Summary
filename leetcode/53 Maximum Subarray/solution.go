func maxSubArray(nums []int) int { // ��̬�滮�ռ��Ż��棻����ٷ�����з��νⷨ������
    current, max := 0, nums[0]
    for _, num := range nums { // �˴��߼�Ϊ����current+numС��num��˵����ǰ����Ӵ�֮��currentΪ��������ֱ������num֮ǰ����ʹcurrent����num������
        current = maxInt(current+num, num) // d[i] = max(d[i?1]+nums[i], nums[i])������
        max = maxInt(max, current)
    }
    return max
}

func maxInt(a int, b int) int {
    if a > b {
        return a
    } else {
        return b
    }
}