func twoSum(nums []int, target int) []int {
    var n int = len(nums)
    hashRecord := make(map[int]int) // д����ʱע�ⴴ��map�ķ�ʽ�봴��array���𣡣���
    result := make([]int, 2)
    for i:=0; i<n; i++ {
        var checkNum int = target - nums[i]
        index1, ok := hashRecord [checkNum] // ��ס���ִ��뷽ʽ��ok�����ص�ֵ�൱��HashMap.containsKey������key�������һ������������value������ 
        if ok {
            result[0] = i
            result[1] = index1
            return result
        } else {
            hashRecord[nums[i]] = i // map�в�����nums[i]��keyʱ��������������������map
        }
    }
    return result
}