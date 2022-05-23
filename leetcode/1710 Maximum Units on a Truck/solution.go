func maximumUnits(boxTypes [][]int, truckSize int) int { // 贪心地加入价值最大的即可！！！
    n, result := len(boxTypes), 0

    sort.Slice(boxTypes, func(i int, j int) bool {
        return boxTypes[i][1] > boxTypes[j][1]
    })

    for i:=0; i<n; i++ {
        if boxTypes[i][0] <= truckSize {
            result += boxTypes[i][0] * boxTypes[i][1]
            truckSize -= boxTypes[i][0]
        } else {
            result += truckSize * boxTypes[i][1]
            return result
        }
    }
    return result
}