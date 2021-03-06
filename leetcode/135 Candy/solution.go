func candy(ratings []int) int { // 按高度走势分组分析！！！
    n := len(ratings)
    result := 1;
    increase, decrease, rightmost := 1, 0, 1 // increase表示严格递增序列的长度；decrease表示严格递减序列的长度；rightmost表示最新计算的前一高度！！！
    for i:=1; i<n; i++ {
        if ratings[i] >= ratings[i-1] { // case1：严格递增或持平！！！
            decrease = 0
            if ratings[i] == ratings[i-1] { // 注意持平需要重新变为1；所以此时rightmost既能代表当前高度，也能代表严格递增序列的长度！！！
                rightmost = 1
            } else {
                rightmost++
            }
            result += rightmost
            increase = rightmost
        } else { // case2：严格递减！！！
            decrease++
            if decrease == increase { // 当前整组同学包括极大值同学需要整体+1！！！
                decrease++
            }
            result += decrease // 要点：加入结果的数值要从当前整组同学的总和来看，而不是准确地逐个累加当前数量！！！
            rightmost = 1
        }
    }
    return result
}