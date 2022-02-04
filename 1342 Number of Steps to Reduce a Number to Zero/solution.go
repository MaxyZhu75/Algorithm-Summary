func numberOfSteps(num int) int {
    count := 0
    for (num > 0) {
        if num == 1{ // 1要先特殊处理！！！
            count++
            break
        } else if num % 2 == 0 {
            num /= 2
            count++
        } else {
            num--
            count++
        }
    }
    return count
}