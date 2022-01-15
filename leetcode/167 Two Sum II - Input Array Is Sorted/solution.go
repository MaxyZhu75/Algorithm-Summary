func twoSum(numbers []int, target int) []int {
    var n int = len(numbers)
    p1 := 0; // 最简单的双指针练习题！！！
    p2 := n-1;
    result := make([]int,2)
    for i:=0; i<n; i++ {
        sum := numbers[p1] + numbers[p2]
        if sum == target {
            result[0], result[1] = p1+1, p2+1
        } else if sum < target {
            p1++
        } else {
            p2--
        }
    }
    return result
}