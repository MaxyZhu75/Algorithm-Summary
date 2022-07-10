func maxSubarraySumCircular(nums []int) int { // ��̬�滮�ռ��Ż��汾������
    total := 0
    curMax, curMin, maxSum, minSum := 0, 0, math.MinInt32, math.MaxInt32
    for _, num := range nums {
        curMax = max(curMax+num, num) // ���ڡ������м䡹�����ǡ��������͡�������
        curMin = min(curMin+num, num) // ���ڡ��������ߡ������ǡ�total-��С������͡�������
        maxSum = max(maxSum, curMax)
        minSum = min(minSum, curMin)
        total += num
    }
    if maxSum > 0 { // ϸ��:���������͡�С��0���򷵻�maxSum������
        return max(maxSum, total-minSum)
    } else {
        return maxSum
    }
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}