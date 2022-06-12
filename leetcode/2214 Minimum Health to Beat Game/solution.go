func minimumHealth(damage []int, armor int) int64 { // ̰�ĵ���max��armor���˺�������
    sum, max := 0, 0
    for _, current := range damage {
        sum += current
        max = maxTwo(max, current)
    }
    return int64(sum - minTwo(max, armor) + 1) // �����Ҫʣһ��Ѫ������
}

func maxTwo(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}

func minTwo(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}