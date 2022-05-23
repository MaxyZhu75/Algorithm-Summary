func checkSubarraySum(nums []int, k int) bool { // 同余定理 + 前缀和 + 哈希表！！！
    n := len(nums)
    if n < 2 {
        return false
    }
    hashRecord := make(map[int]int) // 存储每个余数第一次出现的下标！！！
    hashRecord[0] = -1
    remainder := 0
    for i:=0; i<n; i++ { // 同余定理：如果两个整数 m 与 n 满足 n-m 能被 k 整除，那么 n 和 m 对 k 同余！！！
        remainder = (remainder + nums[i]) % k // 此处运用了前缀和的思想，但此处我们只关心当前前缀和对k的余数！！！
        preIndex, ok := hashRecord[remainder]
        if ok {
            if (i - preIndex) >= 2 {
                return true
            }
        } else {
            hashRecord[remainder] = i
        }
    }
    return false
}