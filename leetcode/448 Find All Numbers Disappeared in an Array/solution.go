func findDisappearedNumbers(nums []int) []int { // ������������������ԭ���޸ģ�����
    n := len(nums)
    for _, num := range nums {
        i := (num-1) % n // ϸ�ڣ����ڵ�ǰnum�����������k��n�������Ҫ��%n������ȷ��index������
        nums[i] += n // ��num��ֵ��Ӧ�����������С�+n������������
    }
    result := []int{}
    for i:=0; i<n; i++ {
        if nums[i] <= n {
            result = append(result, i+1) // δ���ֹ�������Ӧ����������Ȼû����+n��������
        }
    }
    return result
}