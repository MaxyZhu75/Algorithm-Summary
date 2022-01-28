func lengthOfLIS(nums []int) int {
    n := len(nums)
    result := 1
    d := make([]int, n+1)
    d[0], d[1] = 0, 1 // basecase������
    for i:=2; i<n+1; i++ { // ��㣺��dp��ÿһ�����꣡����
        d[i] = 1 // basecaseȫ����Ϊ1������
        for j:=1; j<i; j++ { // �ڲ㣺��ĳһ��ʱ�����������������
            if nums[i-1] > nums[i-1-j] {
                d[i] = max(d[i], d[i-j]+1)
            }
        }
        result = max(result, d[i]) // ���µ�ǰdp������󳤶������У�����
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