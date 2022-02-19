func maximumProduct(nums []int) int { // 思路为排序或一次遍历扫描！！！
    max1, max2, max3 := math.MinInt32, math.MinInt32, math.MinInt32// case1：数组中全是非负数或全是非正数，则结果应为最大的三个数相乘！！！
    min1, min2 := math.MaxInt32, math.MaxInt32 // case2：数组中有正数有负数，则最大乘积既可能是三个最大正数的乘积，也可能是两个最小负数与最大正数的乘积！！！

    for _, num := range nums { // 注意变量初始化以及遍历时更新变量的if-else写法！！！
        if num > max1 {
            max3 = max2
            max2 = max1
            max1 = num
        } else if num > max2 {
            max3 = max2
            max2 = num
        } else if num > max3 {
            max3 = num
        }

        if num < min1 {
            min2 = min1
            min1 = num
        } else if num < min2 {
            min2 = num
        }
    }

    return max(max1*max2*max3, min1*min2*max1) // 本题在一次遍历中找出最大的三个数和最小的两个数即可；最后对max1*max2*max3和min1*min2*max1两种结果形式取最大值！！！
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}