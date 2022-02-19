func productExceptSelf(nums []int) []int { // 不能将所有数字的乘积除以给定索引处的数字得到答案，而是利用索引左侧所有数字的乘积和右侧所有数字的乘积（即前缀与后缀）相乘得到答案！！！
    n := len(nums)
    result := make([]int, n)

    leftProduct, rightProduct := 1, 1
    result[0] = 1

    for i:=1; i<n; i++ { // 从左往右遍历一次，遍历过程中将每个元素左侧所有乘积结果录入result；其中nums[0]先初始化为1，只算右边乘积结果即可！！！
        leftProduct *= nums[i-1]
        result[i] = leftProduct
    }

    for i:=n-2; i>=0; i-- { // 从右往左遍历一次，遍历过程中将每个元素的右侧所有乘积结果与result中的左侧所有乘积结果相乘；其中nums[n-1]只算左边乘积即可！！！
        rightProduct *= nums[i+1]
        result[i] *= rightProduct
    }

    return result
}