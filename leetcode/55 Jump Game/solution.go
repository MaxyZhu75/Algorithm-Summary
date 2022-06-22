func canJump(nums []int) bool { // 贪心地找到当前能到达的最远位置！！！
    n, farest := len(nums), 0
    for i:=0; i<n; i++ {
        if i <= farest { // 在能跳到的范围内遍历，看能否更新最远位置！！！
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