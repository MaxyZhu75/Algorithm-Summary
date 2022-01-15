func twoSum(nums []int, target int) []int {
    var n int = len(nums)
    hashRecord := make(map[int]int) // 写代码时注意创建map的方式与创建array区别！！！
    result := make([]int, 2)
    for i:=0; i<n; i++ {
        var checkNum int = target - nums[i]
        index1, ok := hashRecord [checkNum] // 记住这种代码方式；ok所返回的值相当于HashMap.containsKey；若该key存在则第一个变量返回其value！！！ 
        if ok {
            result[0] = i
            result[1] = index1
            return result
        } else {
            hashRecord[nums[i]] = i // map中不存在nums[i]的key时，将该数及其索引存入map
        }
    }
    return result
}