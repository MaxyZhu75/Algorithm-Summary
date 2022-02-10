func maxProfit(prices []int, fee int) int { // DP��״̬ת�����⣬�ؼ�Ū�������״̬��״̬���壻��LeetCode309�����ƣ�����
    n := len(prices)
    d := make([]int, 2)
    d[0], d[1] = -prices[0], 0 // basecase������

    for i:=1; i<n; i++ { // ÿ��ѭ��������ʱ��������ΪҪ�õ���һ�δ洢�Ľ����������
        zero := max(d[0], d[1]-prices[i]) // �� d[i][0] = Math.max(d[i-1][0], d[i-1][1]-prices[i])������
        one := max(d[0]+prices[i]-fee, d[1]) // �� d[i][1] = Math.max(d[i-1][0]+prices[i]-fee, d[i-1][1])������
        d[0], d[1] = zero, one
    }
    return d[1] // ���һ��ϣ������������Ϲ�Ʊ�϶��Ѷ�����·���������������ںɰ������
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}