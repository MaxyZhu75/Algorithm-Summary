func moveZeroes(nums []int)  { // һ�α�������˫ָ���ֱ�Ӱ����������ǣ�����
    n := len(nums)
    nonZeroIndex := 0
    for i:=0 ; i<n; i++ {
        if nums[i] != 0 {
            nums[nonZeroIndex] = nums[i]
            nonZeroIndex++
        }
    }
    for i:=nonZeroIndex; i<n; i++ {
        nums[i] = 0
    }
}