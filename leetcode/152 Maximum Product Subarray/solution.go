func maxProduct(nums []int) int { //「正向逆向结合」！！！
    n := len(nums)
    left := make([]int, n) // 结论：假设所有正负号情况，若数组中没有0的话，那么拥有最大乘积的子数组一定以nums[0]开始（前缀数组）或者以nums[n-1]结尾（后缀数组）！！！
    right := make([]int, n)
    left[0], right[n-1] = nums[0], nums[n-1]
    for i:=1; i<n; i++ { // 正向逆向统计各元素前后缀数组！！！
        if left[i-1] == 0 {
            left[i] = nums[i] // 若遇到元素为0，即前缀（后缀）数组乘积为0，则重新从当前元素开始计算前缀乘积即可！！！
        } else {
            left[i] = left[i-1]*nums[i]
        }
        if right[n-i] == 0 { // 逆向同理！！！
            right[n-i-1] = nums[n-1-i]
        } else {
            right[n-i-1] = right[n-i]*nums[n-1-i]
        }
    }
    result := math.MinInt32
    for i:=0; i<n; i++ {
        result = max(result, left[i], right[n-1-i])
    }
    return result
}

func max (a int, b int, c int) int {
    if a >= b && a >= c {
        return a
    } else if b >= a && b >= c{
        return b
    } else {
        return c
    }
}