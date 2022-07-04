func maxConsecutiveAnswers(answerKey string, k int) int { // 滑动窗口虫取法！！！
    count := [2]int{}
    maxCount, index, left, right := 0, 0, 0, 0
    for right < len(answerKey) {
        if (answerKey[right] == 'T') {
            index = 0
        } else {
            index = 1
        }
        count[index]++
        if count[index] > maxCount {
            maxCount = count[index];
        }
        if right-left+1 - maxCount > k {
            if (answerKey[left] == 'T') {
                index = 0
            } else {
                index = 1
            }
            count[index]--
            left++
        }
        right++
    }
    return right-left
}