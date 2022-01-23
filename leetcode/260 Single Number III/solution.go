func singleNumber(nums []int) []int {
    var allXor int = 0 // 0����������n���0^n�������Ϊn��������
    for _, num := range nums {
        allXor ^= num // ��������n���������n^n�����Ϊ0��������Ԫ��ȫ�����Ľ������������ֻ����һ�ε����ֵ������������
    }
    feature := allXor & (-allXor) // Ҫ�㣺������������n��λ����n&(-n)�Ľ��Ϊn���λ��1���˴����ʾ����ֻ����һ�ε������ڶ����Ʊ�ʾ����͵Ķ��߳��ֲ�ͬ��λ������
    group1, group2 := 0, 0
    var result = make([]int, 2)
    for _, num := range nums {
        if feature&num == 0 { // ��ʱ������feature��һ��������iλ��Ϊ0��1�����������Ϊ���飬ע������ֻ����һ�ε����ֱ�Ȼ�ڲ�ͬ�飡����
            group1 ^= num
        } else {
            group2 ^= num
        }
    }
    result[0], result[1] = group1, group2 // ����ֻ����һ�ε����ָ����ڲ�ͬ�飻��������Ԫ�ؽԳ������Σ�����n���������n^n�����Ϊ0���ʸ�����������Ľ����Ϊ�𰸣�����
    return result
}