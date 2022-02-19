func productExceptSelf(nums []int) []int { // ���ܽ��������ֵĳ˻����Ը��������������ֵõ��𰸣�����������������������ֵĳ˻����Ҳ��������ֵĳ˻�����ǰ׺���׺����˵õ��𰸣�����
    n := len(nums)
    result := make([]int, n)

    leftProduct, rightProduct := 1, 1
    result[0] = 1

    for i:=1; i<n; i++ { // �������ұ���һ�Σ����������н�ÿ��Ԫ��������г˻����¼��result������nums[0]�ȳ�ʼ��Ϊ1��ֻ���ұ߳˻�������ɣ�����
        leftProduct *= nums[i-1]
        result[i] = leftProduct
    }

    for i:=n-2; i>=0; i-- { // �����������һ�Σ����������н�ÿ��Ԫ�ص��Ҳ����г˻������result�е�������г˻������ˣ�����nums[n-1]ֻ����߳˻����ɣ�����
        rightProduct *= nums[i+1]
        result[i] *= rightProduct
    }

    return result
}