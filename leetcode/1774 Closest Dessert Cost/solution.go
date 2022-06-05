func closestCost(baseCosts []int, toppingCosts []int, target int) int { // 0-1�������Σ���LeetCode��416�⣡����
    M := 20000 // ȷ��׼ȷ��M��Ϊ������������M���Ϊ20000����ȷ������Ϊtarget��base����[1, 10000]�����۳���20000��ز������Ž⣡����
    d := make([]bool, M+1)
    for _, base := range baseCosts { // �����base������
        d[base] = true
    }
    for _, topping := range toppingCosts { // ͬһ��toppingֻ��һ�εõ��Ķ��ۣ�����
        for j:=M; j>=1; j-- {
            if j > topping {
                d[j] = d[j] || d[j-topping]
            }
        }
    }
    for _, topping := range toppingCosts { // ͬһ��topping�������ܵõ��Ķ��ۣ���
        for j:=M; j>=1; j-- {
            if j > topping {
                d[j] = d[j] || d[j-topping]
            }
        }
    }
    result, difference, minDiff := 0, 0, 20000
    for i:=1; i<=M; i++ { // �𰸿��ܳ���target������Ҫ��abs�жϣ�����
        difference = abs(i-target)
        if d[i] == true && difference < minDiff {
            result = i
            minDiff = difference
        }
    }
    return result
}

func abs(num int) int {
    if num < 0 {
        num = num * -1
    }
    return num
}