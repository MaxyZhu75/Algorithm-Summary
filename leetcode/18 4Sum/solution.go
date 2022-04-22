func fourSum(nums []int, target int) [][]int { // 类似题目为三数之和，此题仅多一个指针！！！
	result := [][]int{} // p1，p2，left，right指向的值可以相同，但不能重复往result添加已存在的答案组合！！！
    n := len(nums)
    if (n < 4) {
        return result
    }

    sort.Ints(nums) // 先排序！！！

	for p1:=0; p1<n-3; p1++ {
        if p1 > 0 && nums[p1] == nums[p1-1] { // 记住三个剪枝操作，加强代码效率！！！
            continue
        }
		if nums[p1] + nums[p1+1] + nums[p1+2] + nums[p1+3] > target {
            break
        }
        if nums[p1] + nums[n-1] + nums[n-2] + nums[n-3] < target {
            continue
        }
		
        for p2:=p1+1; p2<n-2; p2++ {
            if p2 > p1+1 && nums[p2] == nums[p2-1] { // 记住三个剪枝操作，加强代码效率！！！
                continue
            }
            if nums[p1] + nums[p2] + nums[p2+1] + nums[p2+2] > target {
                break
            }
            if nums[p1] + nums[p2] + nums[n-1] + nums[n-2] < target {
                continue
            }

            left, right := p2+1, n-1 // 当前p1，p2固定，对left和right写while循环的双指针！！
            for left < right {
                sum := nums[p1] + nums[p2] + nums[left] + nums[right]
                if sum == target {
                    result = append(result, []int{nums[p1], nums[p2], nums[left], nums[right]}) // append一个数组！！！
                    for left < right && nums[left] == nums[left+1] {
                        left++
                    }
                    left++
                    for left < right && nums[right] == nums[right-1] { // 此处循环旨在提前移动指针使下一个答案不重复！！！
                        right--
                    }
                    right--
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
            }
        
        
        }
	}
	return result
}