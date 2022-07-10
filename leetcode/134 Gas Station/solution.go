func canCompleteCircuit(gas []int, cost []int) int {
    n, i := len(gas), 0 // 结论：如果「x」到不了「y+1」，那么从「x」到「y」的任一点出发都不可能到达「y+1」！！！
    for i < n {
        gasSum, costSum, count := 0, 0, 0
        for count < n { // 首先检查第0个加油站，并试图判断能否环绕一周；如果不能，就从「第一个无法到达的加油站」开始继续检查！！！
            j := (i+count) % n // 细节：由于循环需要取余！！！
            gasSum += gas[j]
            costSum += cost[j]
            if costSum > gasSum {
                break
            }
            count++
        }
        if count == n {
            return i
        } else {
            i = i + count + 1
        }
    }
    return -1
}