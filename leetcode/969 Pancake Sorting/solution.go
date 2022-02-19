func pancakeSort(arr []int) []int { // 煎饼排序问题，找到最短解法是NP-Hard问题！！！
    n := len(arr)
    var result []int = []int{}

    for i:=n-1; i>0; i-- { // 从尾部向前整理，每次循环将待排序数组中最大的数往后放；i表示当前待排序数组的末尾！！！

        currentMax := 0 // 找出当前最大的待排序数的索引！！！
        for j:=1; j<=i; j++ {
            if arr[j] >= arr[currentMax] {
                currentMax = j
            }
        }

        if currentMax == i { // case1：若最大的待排序数已经在待排序数组末尾，则不需要反转！！！
            continue
        }

        reverse(arr, currentMax) // case2：若最大的待排序数不在待排序数组末尾，则通过两次反转将该数放在末尾！！！
        reverse(arr, i)
        result = append(result, currentMax+1)
        result = append(result, i+1)
    }

    return result
}

func reverse(arr []int, end int) {
    p1, p2 := 0, end
    for (p1 < p2) {
        arr[p1], arr[p2] = arr[p2], arr[p1]
        p1++
        p2--
    }
}