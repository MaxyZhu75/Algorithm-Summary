func maxProfit(prices []int) int { // Ҫ��һ��������ʱʼ�ռ�ס��������Ŀ���Ƿ�������ͬһ�����벢����������һ���������յĴ𰸶������ܵ�Ӱ�죬��Ϊ��һ��������������Ϊ�㣡����
    d := make([]int, 4) // DP��״̬ת�����⣬�ؼ�Ū�������״̬��״̬���壻��LeetCode309�����ƣ�����
    d[0], d[1], d[2], d[3] = -prices[0], 0, -prices[0], 0 // basecase������

    for i:=1; i<len(prices); i++ { // ÿ��ѭ��������ʱ��������ΪҪ�õ���һ�δ洢�Ľ����������
        zero := max(d[0], -prices[i]) // d[i][0] = Math.max(d[i-1][0], -prices[i])������
        one := max(d[0]+prices[i], d[1]) // d[i][1] = Math.max(d[i-1][0]+prices[i], d[i-1][1])������
        two := max(d[1]-prices[i], d[2]) // d[i][2] = Math.max(d[i-1][1]-prices[i], d[i-1][2])������
        tri := max(d[2]+prices[i], d[3]) // d[i][3] = Math.max(d[i-1][2]+prices[i], d[i-1][3])������
        d[0], d[1], d[2], d[3] = zero, one, two, tri
    }

    return d[3]; // Ҫ��������ڲ���Ҫ������ͬһ�����벢�����������ƣ���ʹ״̬1�������dp����Ҳ�Ὣ��һ�ν��׵Ľ��ת�Ƶ�״̬3�У�����
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}