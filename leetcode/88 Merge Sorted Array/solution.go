func merge(nums1 []int, m int, nums2 []int, n int)  { // 由nums1后半部分空出，可联想从后往前的双指针，则空间复杂度O(1)！！！
    p1, p2, tail := m-1, n-1, m+n-1
    for (p1 >= 0 || p2 >= 0) { // 该循环条件需要对应4种case！！！
        if p1 < 0 {
            nums1[tail] = nums2[p2]
            p2--
        } else if p2 < 0 {
            nums1[tail] = nums1[p1]
            p1--
        } else if nums1[p1] >= nums2[p2]{
            nums1[tail] = nums1[p1]
            p1--
        } else {
            nums1[tail] = nums2[p2]
            p2--
        }
        
        tail--
    }
}