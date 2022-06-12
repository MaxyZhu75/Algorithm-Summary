func searchRange(nums []int, target int) []int { // ����ģʽ�Ķ��ֲ��ң����ұ߽���Ҫ��ͬ�ж�����������
    left := partition(nums, target, 0) // ���ҵ�һ�����ڵ���target���±ꣻ��LeetCode��35�⣡����
    right := partition(nums, target, 1) - 1 // ���ҵ�һ������target���±꣬Ȼ���ȥ1������
    if left <= right && nums[left] == target && nums[right] == target { // ɸѡ��Ч���������
        return []int{left, right}
    }
    return []int{-1, -1}
}

func partition(nums []int, target int, mode int) int {
    low, high, result := 0, len(nums)-1, len(nums) // ϸ�ڣ�����ʧ��ʱ���ص������鳤��n������
    for low <= high {
        mid := (high-low)/2 + low
        if nums[mid] > target || (mode == 0 && nums[mid] >= target) { // ���Ӷ�ģʽ���жϣ�����
            result = mid
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return result
}