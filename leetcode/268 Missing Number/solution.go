func missingNumber(nums []int) int {
    var n int = len(nums)
    result := 0 // 0����������n���0^n�������Ϊn��������
    for i, num := range nums { // ��������n���������n^n�����Ϊ0�Ľ��ۣ�������0~n�Լ�ÿ������Ԫ�ؽ��������������ý����Ϊ��Ŀ����ȱʧ����������
        result ^= i^num
    }
    result ^= n
    return result
}