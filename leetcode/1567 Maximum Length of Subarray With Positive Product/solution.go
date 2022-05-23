func getMaxLen(nums []int) int { // ���ද̬�滮������
    n := len(nums)
    positive, negative, result := 0, 0, 0
    if nums[0] > 0 {
        positive, result = 1, 1
    } else if nums[0] < 0 {
        negative = 1
    }

    for i:=1; i<n; i++ {
        if nums[i] > 0 { // case1��nums[i]Ϊ��������
            positive++
            if negative > 0 {
                negative++
            } else {
                negative = 0
            }
        } else if nums[i] < 0 { // case2��nums[i]Ϊ��������
            newNegative := positive + 1 // Ҫ�㣺�˴���Ҫ��ʱ�����������ֵ������
            newPositive := 0
            if negative > 0 {
                newPositive = negative + 1
            } else {
                newPositive = 0
            }
            positive = newPositive
            negative = newNegative
        } else { // case3��nums[i]Ϊ0������
            negative, positive = 0, 0
        }
        result = max(result, positive)
    }
    return result
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}