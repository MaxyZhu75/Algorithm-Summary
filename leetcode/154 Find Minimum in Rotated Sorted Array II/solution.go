func findMin(nums []int) int { // ���ظ�Ԫ�ء����ֲ��ҡ�������
    low, high := 0, len(nums)-1
    for low < high {
        mid := (high-low)/2 + low
        if nums[mid] < nums[high] {
            high = mid
        } else if nums[mid] == nums[high] { // ϸ�ڣ�����������ȵ����Σ������ų�high������
            high--
        } else {
            low = mid + 1
        }
    }
    return nums[low]
}