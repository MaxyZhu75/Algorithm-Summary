func removeElement(nums []int, val int) int { // ˫ָ�룡����
    left, right := 0, len(nums)-1 // left������Ҫ������Ԫ�أ�right�Ҳ����ɾ��Ԫ�أ�����������
    for left <= right {
        if nums[left] == val {
            nums[left] = nums[right]
            right--
        } else {
            left++
        }
    }
    return left
}