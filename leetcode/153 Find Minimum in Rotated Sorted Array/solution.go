func findMin(nums []int) int { // �����ظ�Ԫ�أ�ֱ�ӳ��桸���ֲ��ҡ�������
    low, high := 0, len(nums)-1
    for low < high {
        mid := (high-low)/2 + low
        if nums[mid] <= nums[high] {
            high = mid
        } else {
            low = mid + 1
        }
    }
    return nums[low]
}