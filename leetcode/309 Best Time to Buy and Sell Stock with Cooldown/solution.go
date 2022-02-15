func maxProfit(prices []int) int { // DP��״̬ת�����⣬�ؼ�Ū�������״̬��״̬���壡����
    d := make([]int, 3)

    d[0], d[1], d[2] = -prices[0], 0, 0 // basecase������
    for i:=1 ; i<len(prices); i++ { // ÿ��ѭ��������ʱ��������ΪҪ�õ���һ�δ洢�Ľ����������
        zero := max(d[0], d[1]-prices[i]) // �� d[i][0] = Math.max(d[i-1][0], d[i-1][1]-prices[i])������
        one := max(d[1], d[2]) // �� d[i][1] = Math.max(d[i-1][1], d[i-1][2])������
        two := d[0] + prices[i] // �� d[i][2] = d[i-1][0] + prices[i]������
        d[0], d[1], d[2] = zero, one, two
    }

    return max(d[1], d[2]) // ���һ��ϣ������������Ϲ�Ʊ�϶��Ѷ�����·���������ںɰ������
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}