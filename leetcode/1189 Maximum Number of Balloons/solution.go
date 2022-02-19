func maxNumberOfBalloons(text string) int { // 即简单统计次数，并取所需字母里数量最少的！！！
    n := len(text)
    record := make([]int, 5)
    for i:=0; i<n; i++ {
        if text[i] == 'b' {
            record[0]++
        } else if text[i] == 'a' {
            record[1]++
        } else if text[i] == 'l' {
            record[2]++
        } else if text[i] == 'o' {
            record[3]++
        } else if text[i] == 'n' {
            record[4]++
        }
    }
    
    record[2] /= 2
    record[3] /= 2
    sort.Ints(record);
    return record[0];
}