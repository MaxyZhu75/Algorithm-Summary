func intersect(nums1 []int, nums2 []int) []int { // 方法二：双指针！！！
    sort.Ints(nums1)
    sort.Ints(nums2)
    result := []int{}
    p1, p2 := 0, 0
    for p1 < len(nums1) && p2 < len(nums2) {
        if nums1[p1] == nums2[p2] { // case1：所指元素相等！！！！
            result = append(result, nums1[p1])
            p1++
            p2++
        } else if nums1[p1] < nums2[p2] { // case2：p1所指元素更小！！！
            p1++
        } else { // case3：p2所指元素更小！！！
            p2++
        }
    }
    return result
}
