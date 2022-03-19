func subarraySum(nums []int, k int) int { // ǰ׺��+��ϣ������
    prefixSum, result := 0, 0
    hashRecord := map[int]int{}
    hashRecord[0] = 1
    for i:=0; i<len(nums); i++ {
        prefixSum += nums[i]
        count, ok := hashRecord[prefixSum-k] // Ҫ�㣺��ѯ��ȡ����ǰ׺��Ϊ prefixSum - k ������������
        if ok {
            result += count
        }
        hashRecord[prefixSum] += 1
    }
    return result
}