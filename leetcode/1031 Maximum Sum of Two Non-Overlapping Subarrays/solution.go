func maxSumTwoNoOverlap(nums []int, firstLen int, secondLen int) int { //��ǰ׺�͡�+����������������
    L, M := firstLen, secondLen
    preSum := make([]int, len(nums)+1)
    for i:=1; i<=len(nums); i++ {
        preSum[i] = preSum[i-1] + nums[i-1] // �洢ǰ׺�ͣ�����
    }
    max1 := findMax(nums, L, M, preSum) // case1������Ϊ L �����������������, ����Ϊ M ���������������ұߣ�����
    max2 := findMax(nums, M, L, preSum) // case2������Ϊ M �����������������, ����Ϊ L ���������������ұߣ�����
    return maxTwo(max1, max2)
}

func findMax(nums []int, l int,  r int, preSum []int) int { //��l���͡�r���ֱ������ߺ��ұ�����������ĳ��ȣ�����
    lMax, rMax := preSum[l], preSum[l+r]-preSum[l]
    max := lMax + rMax
    for i:=l+1; i+r <= len(nums); i++ {
        lMax = maxTwo(lMax, preSum[i]-preSum[i-l])
        rMax = preSum[i+r] - preSum[i] // ϸ�ڣ���ߵ���������ÿ����Ҫ���£��ұߵ�����֮�Ͳ��ܹ��ص���ÿ����Ϊ�����������Ƽ��ɣ�����
        max = maxTwo(max, lMax + rMax) // ����������ÿ�μ����¼��ɣ�����
    }
    return max
}

func maxTwo(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}