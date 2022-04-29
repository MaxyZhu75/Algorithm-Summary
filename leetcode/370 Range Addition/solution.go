func getModifiedArray(length int, updates [][]int) []int { // 差分数组求解（Range Caching）！！！
    array := make([]int, length)
    start, end, inc := 0, 0, 0
    for _, operation := range updates { // 只在操作区间的边界上存储变化的值（而不是整个区间都进行更新）！！！
        start, end , inc = operation[0], operation[1], operation[2]
        array[start] += inc // array[start] = array[start] + inc！！！
        if end < length-1 {
            array[end+1] -= inc // array[end+1] = array[end+1] - inc！！！
        }
    }
    for i:=1; i<length; i++ {
        array[i] = array[i] + array[i-1] // array[i] = array[i] + array[i-1]！！！
    }
    return array
}