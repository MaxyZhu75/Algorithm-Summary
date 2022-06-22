func coinChange(coins []int, amount int) int { // ���䶯̬�滮���⣡����
    d := make([]int, amount+1) // d[i]��ʾ��ɽ��i�������ٵ�Ӳ������������
    for i:=1; i<=amount; i++ {
        d[i] = amount+1
    }
    d[0] = 0
    for i:=1; i<=amount; i++ {
        for j:=0; j<len(coins); j++ {
            if coins[j] <= i {
                d[i] = min(d[i], d[i-coins[j]] + 1) // ת�Ʒ��̣�d[i] = min{d[i]...d[i-coins[j]]+1} ������
            }
        }
    }
    if d[amount] > amount {
        return -1
    } else {
        return d[amount]
    }
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}