func findTargetSumWays(nums []int, target int) int { // 难点：将该问题转化为SubsetSum问题！！！
    numsSum := sum(nums) // 该数组将被划分为正数组负数组两部分记作P和N，由于数组本身元素皆为非负数，则可推导 P-N=target；即 P-(numsSum-P)=target；即 P=(target+numsSum)/2！！！
    if numsSum < abs(target) || (numsSum + target) % 2 == 1 { // case1：注意target可能为负！！！
        return 0                                              // case2：SubsetSum目标和明显需要是整数！！！
    }
    M := (numsSum + target) / 2

    d := make([]int, M+1)
    d[0] = 1 // basecase！！！
    for _, num := range nums {
        for j:=M; j>=0; j-- {
            if j >= num { // dp方程类似硬币找零问题，都是统计多少种方法！！！
                d[j] = d[j] + d[j-num] // case1: d[i][j] = d[i-1][j] + d[i-1][j-num]！！！
            }                          // case2: d[i][j] = d[i-1][j]！！！
        }
    }

    return d[M]
}

func sum(nums []int) int {
    sum := 0
    for _, num := range nums {
        sum += num
    }
    return sum
}

func abs(a int) int {
    if a >= 0 {
        return a
    } else {
        return -a
    }
}
