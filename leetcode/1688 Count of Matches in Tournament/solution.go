func numberOfMatches(n int) int { // 方法一：模拟！！！
    teamNum, matches, result := n, 0, 0 // 数学方法请见Java版本答案！！！
    for(teamNum >= 2) {
        if teamNum%2 == 1 {
            matches = (teamNum-1) / 2
            teamNum = (teamNum-1) / 2 + 1
        } else {
            matches = teamNum / 2
            teamNum /= 2
        }
        result += matches
    }
    return result
}