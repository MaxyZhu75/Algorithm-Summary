func numberOfMatches(n int) int { // ����һ��ģ�⣡����
    teamNum, matches, result := n, 0, 0 // ��ѧ�������Java�汾�𰸣�����
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