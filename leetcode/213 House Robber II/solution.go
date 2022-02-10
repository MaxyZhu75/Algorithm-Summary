func rob(nums []int) int { // �����ǻ���LeetCode198��Ķ�̬�滮������
    n := len(nums)
    if n == 1 {
        return nums[0]
    }
    if n == 2 {
        return max(nums[0], nums[1]) 
    }

    robEntry := houseRobber(nums, 0, n-2) // case1����ѭ������ڣ�����ĩβ������
    passEntry := houseRobber(nums, 1, n-1) // case2������ѭ������ڣ���ĩβ������
    return max(robEntry, passEntry)
}

func houseRobber(nums []int, start int, end int) int { // ��LeetCode198�⣬�˴���ע�⵱ʹ��ԭnums����ʱ��Ҫ��start������ʼ���ɣ���������0��������
    n := end - start + 1
    if n == 1 {
        return nums[start]
    }
    if n == 2{
        return max(nums[start], nums[end])
    }

    pre1, pre2 := max(nums[start], nums[start+1]), nums[start]
    for i:=2; i<n; i++ {
        current := max(pre1, pre2+nums[start+i])
        pre2 = pre1 
        pre1 = current
    }
    return pre1
}

func max(a int, b int) int {
    if a>= b {
        return a
    } else {
        return b
    }
}