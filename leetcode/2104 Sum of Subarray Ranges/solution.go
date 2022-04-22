func subArrayRanges(nums []int) int64 { // ���׽ⷨΪ����ջ������
    n := len(nums)
    result := int64(0) // int64���͵ĳ�ʼ��������
    for i:=0; i<n; i++ { // ����ÿ������Ϊ�����еĿ�ͷ������
        min, max := nums[i], nums[i]
        for j:=i+1; j<n; j++ { // ��̬���µ�ǰ���������ֵ��Сֵ����������������
            max = maxTwo(max, nums[j])
            min = minTwo(min, nums[j])        
            result += int64(max-min)
        }
    }
    return result
}

func maxTwo(a int, b int) int {
    if a > b {
        return a
    } else {
        return b
    }
}

func minTwo(a int, b int) int {
    if a < b {
        return a
    } else {
        return b
    }
}