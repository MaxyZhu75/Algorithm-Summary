func findShortestSubArray(nums []int) int {
    n := len(nums)
    hashRecord := make(map[int]int)
    firstIndex := make(map[int]int)
    lastIndex := make(map[int]int)

    for i:=0; i<n; i++ { // 记录第一次出现位置，最后一次出现位置，以及统计频率次数！！！
        if hashRecord[nums[i]] == 0 {
            firstIndex[nums[i]] = i
        }
        hashRecord[nums[i]]++
        lastIndex[nums[i]] = i
    }

    maxDegree := 0
    minLength := math.MaxInt32
    for num, degree := range hashRecord {
        if degree > maxDegree { // case1：当前所找到唯一的最大的度（严格大于），对maxDegree与minLength进行更新！！！
            maxDegree = degree
            minLength = lastIndex[num] - firstIndex[num]
        } else if degree == maxDegree { // case2：当前所找到不唯一的最大的度，需要判断是否更新minLength！！！
            if (lastIndex[num] - firstIndex[num] < minLength) {
                minLength = lastIndex[num] - firstIndex[num]
            }
        }

    }

    return minLength+1
}