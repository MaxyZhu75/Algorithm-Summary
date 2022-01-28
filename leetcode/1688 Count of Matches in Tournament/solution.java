class Solution { // 方法二：数学！！！
    public int numberOfMatches(int n) { // 模拟方法请见Go语言版本答案！！！
        return n-1; // 按题意只有经过一场比赛，一支队伍才会被淘汰；由于最后只决出一个胜者，必然需要淘汰n-1支队伍，即必然进行n-1场比赛！！！
    }
}