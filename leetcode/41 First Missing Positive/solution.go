func firstMissingPositive(nums []int) int {
    n := len(nums)
    for i:=0; i<n; i++ { // 由小到大将所有1到n的数「k」移动到「k-1」位置！！！
        for nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i]-1] { // 细节：位置「k-1」不能放置1到n其他正数；防止死循环！！！
            nums[i], nums[nums[i]-1] = nums[nums[i]-1], nums[i]
        }
    }
    for i:=0; i<n; i++ { // 查找首个不符合条件的即可找到缺失！！！
        if nums[i] != i+1 {
            return i+1
        }
    }
    return n+1 // 对应全部大于等于n+1的情况！！！
}