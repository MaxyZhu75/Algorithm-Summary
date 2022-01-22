func nextGreatestLetter(letters []byte, target byte) byte { // 对于已经排好序的数组，应该联想到二分查找的思想！！！
    var low, high, resultIndex int = 0, len(letters)-1, 0 // 该题二分查找的框架与69题求开方类似，具体细节应具体问题具体分析！！！
    if letters[high] <= target { // Go语言byte字符直接比大小即可；若移项相减与0比大小答案会出错！！！
        return letters[0] // 若数组中最大的字母不大于target，由题目所述的循环可知，直接返回头部元素！！！
    }
    for (low <= high) {
        mid := low + (high-low)/2
        if letters[mid] > target {
            resultIndex = mid // 此处在字母大于target的情况下皆需要更新resultIndex，直至low等于high时，result从上方最逼近目标，即一定符合答案所述比目标字母大的最小字母！！！
            high = mid-1
        } else {
            low = mid+1
        }
    }
    return letters[resultIndex]
}