func canJump(nums []int) bool { // ̰�ĵ��ҵ���ǰ�ܵ������Զλ�ã�����
    n, farest := len(nums), 0
    for i:=0; i<n; i++ {
        if i <= farest { // ���������ķ�Χ�ڱ��������ܷ������Զλ�ã�����
            farest = max(farest, i+nums[i])
        }
        if farest >= n-1 {
            return true
        }
    }
    return false
}

func max (a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}