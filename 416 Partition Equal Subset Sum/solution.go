func canPartition(nums []int) bool { // SubsetSum, Partition, 01Knapsack这三个npc问题DP的思路一致！！！
    M := sumValue(nums)
    if M % 2 == 1 {
        return false
    } else {
        M /= 2
    }

    d := make([]bool, M+1) // 要点一：一维数组形式下d[j]既表示d[i][j]，又表示d[i-1][j]（前i件物品状态仅与前i-1件物品状态有关）！！！
    d[0] = true // basecase！！！

    for _, num := range nums {
        for j:=M ; j>=1; j-- { // 要点二：一维数组表示时内循环必须由大到小；因为若由小到大，更新d[j]时所取d[j-num]是被更新过的脏数据！！！
            if j >= num {
                d[j] = d[j] || d[j-num] // case1: d[i][j] = d[i-1][j] || d[i-1][j-num]！！！
            }                           // case2: d[i][j] = d[i-1][j]！！！
        }
    }

    return d[M]
}

func sumValue(nums []int) int {
    sum := 0;
    for _, num := range nums {
        sum += num
    }
    return sum
}