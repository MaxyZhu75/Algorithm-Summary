func maxProfit(k int, prices []int) int { // Ҫ��һ��������ʱʼ�ռ�ס��������Ŀ���Ƿ�������ͬһ�����벢����������һ���������յĴ𰸶������ܵ�Ӱ�죬��Ϊ��һ��������������Ϊ�㣡����
    n := len(prices)
    k = min(k, n/2) // k�����ֵ���Դﵽ10^9, ��n�����ֻ�ܽ���n/2�ʽ��ף�����
    if k == 0 {
        return 0
    }

    d := make([]int, 2*k) // DP��״̬ת�����⣬k�ν��׿ɶ���2*k��״̬��������ʱ����LeetCode123��k=2��Ӧ������
    for j:=0; j<2*k; j+=2 {
        d[j] = -prices[0] // Ҫ�������1�����гֹ�״̬basecase������
    }

    for i:=0; i<n; i++ {  // ÿ��ѭ��������ʱ��������ΪҪ�õ���һ�δ洢�Ľ����������
        temp := make([]int, 2*k)
        
        for j:=0; j<2*k; j++ {
            if j == 0 {
                temp[j] = max(d[0], -prices[i]) // �� d[i][0] = Math.max(d[i-1][0], -prices[i])������
            } else if j % 2 == 0 {
                temp[j] = max(d[j-1]-prices[i], d[j]) // �� d[i][j] = Math.max(d[i-1][j-1]-prices[i], d[i-1][j])������
            } else {
                temp[j] = max(d[j-1]+prices[i], d[j]) // �� d[i][j] = Math.max(d[i-1][j-1]+prices[i], d[i-1][j])������
            }
        }
        
        for j:=0; j<2*k; j++ {
            d[j] = temp[j]
        }
    }

    return d[2*k-1] // Ҫ������dp���̻Ὣǰ�ν��׵Ľ��ת�Ƶ����Ŀ���״̬�У�����
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}
