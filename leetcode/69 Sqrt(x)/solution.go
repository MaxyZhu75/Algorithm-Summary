func mySqrt(x int) int {
    var low, high, result int = 0 ,x, 0 // 此题为二分查找思想的基础题之一；基于二分查找的不同题目在具体实现时各自略有区别，要根据题意想清楚以下几点！！！
    for (low <= high) { // 要点一：low与high的初始化设定，以及while的出口条件！！！
        mid := low + (high-low)/2 // 中值这样写可以避免溢出问题；注意此处为int型！！！
        square := mid * mid  // 此处使用int接收乘法结果存在溢出问题，除了转型为long，还可以考虑用除法标记sqrt= x/mid作为判断条件！！！
        if square <= x { // 要点二：简单的二分查找划分为等于小于大于三种情况，具体题目应具体分析对应操作！！！
            result = mid  // 此处在小于及等于目标的情况下皆需要更新result，直至low等于high时，result从下方最逼近目标，即一定符合答案所要求的舍弃小数只取整数！！！
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    return result // 要点三：最后返回的是low, high还是新定义一个结果变量！！！
}