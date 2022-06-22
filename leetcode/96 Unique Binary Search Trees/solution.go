func numTrees(n int) int { // 根据「卡塔兰数」公式定义直接计算！！！
    C := 1 // C0的值！！！
    for i := 0; i < n; i++ { // 公式计算其他值！！！
        C = C * 2 * (2 * i + 1) / (i + 2);
    }
    return C // 返回Cn！！！
}