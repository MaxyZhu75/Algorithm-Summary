func merge(nums1 []int, m int, nums2 []int, n int)  { // ��nums1��벿�ֿճ���������Ӻ���ǰ��˫ָ�룬��ռ临�Ӷ�O(1)������
    p1, p2, tail := m-1, n-1, m+n-1
    for (p1 >= 0 || p2 >= 0) { // ��ѭ��������Ҫ��Ӧ4��case������
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