func missingElement(nums []int, k int) int {
    low, high := 0, len(nums)-1
    index := 0
    for low <= high { // ���ֲ����ҵ������һ�����ȱʧ���ָ�������k���Ǹ��±꡹������
        mid := (high-low)/2 + low
        if missCount(nums, mid) >= k {
            high = mid-1
        } else {
            index = mid
            low = mid+1
        }
    }
    return nums[index] + (k-missCount(nums, index)) // ȷʵ���ּ�nums[index]���� k-missCount(nums, index) ������
}

func missCount(nums []int, i int) int { // �ܵĿ�϶Ϊnums[i]-nums[0]-1����������Ϊi������������i-1�������ڿ�����(nums[0], nums[i])������
    return (nums[i]-nums[0]-1)-(i-1) // ���ȱʧ����ͳ�Ʒ�����(nums[i]-nums[0]-1)-(i-1)������
}