func threeSum(nums []int) [][]int { // Java答案与Go答案的变量定义有区别，因为定义一样时LeetCode上会发现另一种有内存或时间溢出问题；但两种解法都基于排序+双指针！！！
    n := len(nums) // 要点一：left代表左边界元素，对于一组相同的数会指最左边那一个；mid和right为中间的元素和右边界的元素！！！
    result := [][]int{} // left，mid，right的值可以相同，但不能重复往result添加已存在的答案组合！！！
	
    sort.Ints(nums) // sort.Ints()数组排序！！！

	for i:=0; i<n-2; i++ {
		left := nums[i]
		if left > 0 { // 要点二：左边界右边元素都不小于左边界元素值，直接退出！！！
			break
		}
		if i > 0 && left == nums[i-1] { // 要点三：分别确定left，mid，right位置（对于一组相同的数left会指在最左边）！！！
			continue
		}
		
        	p1, p2 := i+1, n-1 // 要点四：当前left固定（left在外层循环移），定义mid和right的双指针p1和p2，并写while循环！！！
		for (p1 < p2) { 
			mid, right := nums[p1], nums[p2]
			if left + mid + right == 0 {
				result = append(result, []int{left, mid, right})
				for (p1 < p2 && nums[p1] == mid) { // 要点五：注意该移动指针的写法与Java答案区分！！！
					p1++
				}
				for (p1 < p2 && nums[p2] == right) { // 此处循环是为了使下一个答案不重复！！！
					p2--
				}
			} else if left + mid + right < 0 {
				p1++
			} else {
				p2--
			}
		}
	}
	return result
}
