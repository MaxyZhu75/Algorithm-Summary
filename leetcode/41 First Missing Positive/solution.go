func firstMissingPositive(nums []int) int {
    n := len(nums)
    for i:=0; i<n; i++ { // ��С��������1��n������k���ƶ�����k-1��λ�ã�����
        for nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i]-1] { // ϸ�ڣ�λ�á�k-1�����ܷ���1��n������������ֹ��ѭ��������
            nums[i], nums[nums[i]-1] = nums[nums[i]-1], nums[i]
        }
    }
    for i:=0; i<n; i++ { // �����׸������������ļ����ҵ�ȱʧ������
        if nums[i] != i+1 {
            return i+1
        }
    }
    return n+1 // ��Ӧȫ�����ڵ���n+1�����������
}