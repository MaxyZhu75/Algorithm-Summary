func isPerfectSquare(num int) bool { // 平方：1, 4, 9, 16, 25 ......！！！
    toNextSquare := 1 // 平方的间隔是以3开始，2为差值的等差数列：3, 5, 7, 9 ......！！！
    for (num > 0) { // 写成减法循环减间隔来判断比较简单！！！
        num -= toNextSquare
        toNextSquare += 2
    }

    return num == 0
}