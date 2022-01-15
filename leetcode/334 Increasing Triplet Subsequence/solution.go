func increasingTriplet(nums []int) bool {
    var n int = len(nums)
    low := nums[0]  // ÿһ����̰�ĸ���ֵ��С��low��ֵ�ڶ�Сmid������
    mid := math.MaxInt32 // Go����math�������MaxInt32�˴���ʼ����������ʹ�ã�����
    for i:=1; i<n; i++ {
        if nums[i] > mid { // case1���������г��֣�ֱ��return������
            return true
        } else if nums[i] > low { // case2������mid������
            mid = nums[i]
        } else {
            low = nums[i] // case3������low������
        }
    }
    return false
}