func threeSumClosest(nums []int, target int) int { // 见LeetCode第15题！！！
    closest, n := 200000, len(nums)
    sort.Ints(nums)
	for p1:=0; p1<n-2; p1++ {
        if p1 > 0 && nums[p1] == nums[p1-1] {
            continue
        }
        left, right := p1+1, n-1
        for left < right {
            sum := nums[p1] + nums[left] + nums[right]
            if sum == target {
                return target
            } else if sum < target {
                for left < right && nums[left] == nums[left+1] {
                    left++
                }
                left++
            } else {
                for left < right && nums[right] == nums[right-1] {
                    right--
                }
                right--
            }

            if abs(sum-target) < abs(closest-target) { // 对最接近target的sum进行更新！！！
                closest = sum
            }
        }
	}
	return closest
}

func abs(num int) int {
    if num < 0 {
        return -1 * num
    } else {
        return num
    }
}