func constructArray(n int, k int) []int { // ��ǰk+1��Ԫ�ع�����k������ͬ�Ĳ�ֵ������Ϊ��1, k+1, 2, k, 3, k-1, ... , k/2, k/2+1, k+2, k+3, ... , n-1, n ������
    result := make([]int, n)
    result[0] = 1
    difference := k
    for i:=1; i<=k; i++ { // ǰk+1�������湹�죡����
        if i % 2 == 1 {
            result[i] = result[i-1] + difference
        } else {
            result[i] = result[i-1] - difference
        }
        difference--
    }

    for i:=k+1; i<n; i++ { // ʣ�����˳������������
        result[i] = i+1
    }

    return result
}