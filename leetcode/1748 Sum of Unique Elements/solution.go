func sumOfUnique(nums []int) int { // 本题若要实现一次遍历，需要维护三个状态！！！
    record := make([]int, 101) // 记录0, 1, 2三种状态，并不是记录次数！！！
    result := 0

    for _, num := range nums {
        if record[num] == 0 { // 状态0：之前未出现过；则加入result，且转化为状态1！！！
            result += num
            record[num] = 1
        } else if record[num] == 1 { // 状态1：之前出现过一次；则从result中扣除之前所加入的，且转化为状态2！！！
            result -= num
            record[num] = 2 // 状态2：之前出现过多次，但此时无需对记录结果的变量result做任何操作！！！
        } else {
            continue
        }
    }
    
    return result
}