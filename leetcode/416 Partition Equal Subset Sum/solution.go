func canPartition(nums []int) bool { // SubsetSum, Partition, 01Knapsack������npc����DP��˼·һ�£�����
    M := sumValue(nums)
    if M % 2 == 1 {
        return false
    } else {
        M /= 2
    }

    d := make([]bool, M+1) // Ҫ��һ��һά������ʽ��d[j]�ȱ�ʾd[i][j]���ֱ�ʾd[i-1][j]��ǰi����Ʒ״̬����ǰi-1����Ʒ״̬�йأ�������
    d[0] = true // basecase������

    for _, num := range nums {
        for j:=M ; j>=1; j-- { // Ҫ�����һά�����ʾʱ��ѭ�������ɴ�С����Ϊ����С���󣬸���d[j]ʱ��ȡd[j-num]�Ǳ����¹��������ݣ�����
            if j >= num {
                d[j] = d[j] || d[j-num] // case1: d[i][j] = d[i-1][j] || d[i-1][j-num]������
            }                           // case2: d[i][j] = d[i-1][j]������
        }
    }

    return d[M]
}

func sumValue(nums []int) int {
    sum := 0;
    for _, num := range nums {
        sum += num
    }
    return sum
}