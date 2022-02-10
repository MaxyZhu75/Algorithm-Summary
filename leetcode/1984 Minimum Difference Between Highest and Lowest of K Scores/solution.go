func minimumDifference(nums []int, k int) int { // ��������������йص�һ��Ӧ�ǻ��ݣ����Ǵ�������+�������ڼ��ɣ�����
    n := len(nums)
    sort.Ints(nums) // import ��sort�� ������
    
    result := math.MaxInt32 // import ��math�� ������
    for i:=0; i<=n-k; i++ {
        left, right := i, i+k-1
        current := nums[right] - nums[left]
        result = min(result, current)
    }

    return result
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}