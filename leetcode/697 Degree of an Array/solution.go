func findShortestSubArray(nums []int) int {
    n := len(nums)
    hashRecord := make(map[int]int)
    firstIndex := make(map[int]int)
    lastIndex := make(map[int]int)

    for i:=0; i<n; i++ { // ��¼��һ�γ���λ�ã����һ�γ���λ�ã��Լ�ͳ��Ƶ�ʴ���������
        if hashRecord[nums[i]] == 0 {
            firstIndex[nums[i]] = i
        }
        hashRecord[nums[i]]++
        lastIndex[nums[i]] = i
    }

    maxDegree := 0
    minLength := math.MaxInt32
    for num, degree := range hashRecord {
        if degree > maxDegree { // case1����ǰ���ҵ�Ψһ�����Ķȣ��ϸ���ڣ�����maxDegree��minLength���и��£�����
            maxDegree = degree
            minLength = lastIndex[num] - firstIndex[num]
        } else if degree == maxDegree { // case2����ǰ���ҵ���Ψһ�����Ķȣ���Ҫ�ж��Ƿ����minLength������
            if (lastIndex[num] - firstIndex[num] < minLength) {
                minLength = lastIndex[num] - firstIndex[num]
            }
        }

    }

    return minLength+1
}