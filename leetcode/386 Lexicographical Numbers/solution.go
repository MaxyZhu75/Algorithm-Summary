func lexicalOrder(n int) []int { // �����ⷨ����LeetCode��440�⣻����Ϊ�ֵ�������������
    result := make([]int, n)
    root := 1
    for i:=0; i<n; i++ {
        result[i] = root // ÿ��ѭ������result��ӽڵ㣡����
        if root*10 <= n { // case1����rootΪ��㣬ͨ����10���������ƶ�������
            root *= 10
        } else { // case2��root��ͬ��ڵ��У���1��9���Һ����ƶ�������
            for root%10 == 9 || root+1 > n { // ��ͬ��ĩβ�ڵ�������������10�˻���һ�㣡����
                root /= 10
            }
            root++
        }
    }
    return result
}