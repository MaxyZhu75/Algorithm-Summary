func search(nums []int, target int) int { // ����������Ķ��ֲ��ң�����
    n := len(nums)
    low, high := 0, n-1
    for low <= high { // Ҫ�㣺������һ��Ϊ��������һ����һ��������ģ���һ������������Ҳ���ǲ������򣡣���
        mid := low + (high-low)/2
        if target == nums[mid] {
            return mid
        } else if nums[low] <= nums[mid] { // case1��ǰ�벿��ȷ�����򣬺�벿�ֲ�ȷ��������
            if nums[low] <= target && target < nums[mid] {
                high = mid - 1 // target��ǰ�벿�֣�����
            } else {
                low = mid + 1 // target�ں�벿�֣�����
            }
        } else { // case2����벿��ȷ������ǰ�벿�ֲ�ȷ��������
            if nums[mid] < target && target <= nums[high] {
                low = mid + 1 // target�ں�벿�֣�����
            } else {
                high = mid - 1 // target��ǰ�벿�֣�����
            }
        }
    }
    return -1
}