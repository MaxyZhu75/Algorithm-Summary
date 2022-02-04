func findTargetSumWays(nums []int, target int) int { // �ѵ㣺��������ת��ΪSubsetSum���⣡����
    numsSum := sum(nums) // �����齫������Ϊ�����鸺���������ּ���P��N���������鱾��Ԫ�ؽ�Ϊ�Ǹ���������Ƶ� N-P=target���� N-(numsSum-N)=target���� N=(target+numsSum)/2������
    if numsSum < abs(target) || (numsSum + target) % 2 == 1 { // case1��ע��target����Ϊ��������
        return 0 											  // case2��SubsetSumĿ���������Ҫ������������
    }
    M := (numsSum + target) / 2

    d := make([]int, M+1)
    d[0] = 1 // basecase������
    for _, num := range nums {
        for j:=M; j>=0; j-- {
            if j >= num { // dp��������Ӳ���������⣬����ͳ�ƶ����ַ���������
                d[j] = d[j] + d[j-num] // case1: d[i][j] = d[i-1][j] + d[i-1][j-num]������
            }						   // case2: d[i][j] = d[i-1][j]������
        }
    }

    return d[M]
}

func sum(nums []int) int {
    sum := 0
    for _, num := range nums {
        sum += num
    }
    return sum
}

func abs(a int) int {
    if a >= 0 {
        return a
    } else {
        return -a
    }
}