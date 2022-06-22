func findUnsortedSubarray(nums []int) int { //���������������⡹������
    n := len(nums) // ����������numsA��numsB��numsC����numsB���������������齫����˵��numsA��numsC������δ�ı䣡����
    max, min := math.MinInt32, math.MaxInt32
    right, left := -1, -1
    for i:=0; i<n; i++ { // ���򣡣���
        if nums[i] < max {
            right = i // ���������ұ�������Ԫ�ر�Ȼ�ı�max����¼�¡����һ�Ρ�����ı�max��λ��ΪnumsB���ұ߽磡����
        } else {
            max = nums[i]
        }
    }
    for i:=n-1; i>=0; i-- {
        if nums[i] > min {
            left = i // �����������������Ԫ�ر�Ȼ�ı�min����¼�¡����һ�Ρ�����ı�min��λ��ΪnumsB����߽磡����
        } else {
            min = nums[i]
        }
    }
    if right == -1 {
        return 0
    } else {
        return right-left+1
    }
}