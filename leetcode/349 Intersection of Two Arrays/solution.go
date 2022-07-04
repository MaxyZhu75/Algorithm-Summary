func intersection(nums1 []int, nums2 []int) []int {
    sort.Ints(nums1)
    sort.Ints(nums2)
    result := []int{}
    p1, p2 := 0, 0
    for p1 < len(nums1) && p2 < len(nums2) {
        if nums1[p1] == nums2[p2] { // case1����ָԪ����ȣ�����
            if len(result) == 0 || nums1[p1] != result[len(result)-1] { // ��֤����Ԫ�ص�Ψһ�ԣ�����
                result = append(result, nums1[p1])
            }
            p1++
            p2++
        } else if nums1[p1] < nums2[p2] { // case2��p1��ָԪ�ظ�С������
            p1++
        } else { // case3��p2��ָԪ�ظ�С������
            p2++
        }
    }
    return result
}