func searchInsert(nums []int, target int) int { // �����ҵ�һ�����ڵ���target���±꣡����
    n := len(nums)
    low, high, result := 0, n-1, n
    for low <= high {
        mid := (high-low)/2 + low // ϸ�ڣ�����ʧ��ʱ����������Ԫ��С��target�����ص������鳤��n������
        if nums[mid] >= target {
            result = mid
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return result
}