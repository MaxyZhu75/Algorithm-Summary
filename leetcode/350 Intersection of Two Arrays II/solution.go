func intersect(nums1 []int, nums2 []int) []int { // 方法二：双指针！！！
    sort.Ints(nums1) // 进阶问题：假设已排序！！！
    sort.Ints(nums2)
    m, n := len(nums1), len(nums2)
    p1, p2 := 0, 0

    result := []int{}
    for p1 < m && p2 < n {
        if nums1[p1] < nums2[p2] { //「所指元素较小的指针」需要移动！！！
            p1++
        } else if nums1[p1] > nums2[p2] {
            p2++
        } else {
            result = append(result, nums1[p1])
            p1++
            p2++
        }
    }
    return result
}