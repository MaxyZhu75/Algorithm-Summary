func totalMoney(n int) int {
    var week, leftDays int = n/7, n%7
    sum := 0
    for i:=1; i<=week; i++ {
        thisWeek := 7*i+1+2+3+4+5+6
        sum += thisWeek
    }
    if leftDays != 0 {
        for i:=0; i<leftDays; i++ {
            lastWeek := (week+1)+i
            sum  += lastWeek
        }
    }
    return sum
}