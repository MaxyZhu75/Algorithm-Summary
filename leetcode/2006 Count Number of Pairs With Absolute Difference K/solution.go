func countKDifference(nums []int, k int) int { // LeetCode��һ������֮�ͱ��壻�ù�ϣ��+һ�α���������
    result := 0
    hashRecord := make(map[int]int)
    for _, num := range nums {
        result += hashRecord[num+k] + hashRecord[num-k] // �˴���getOrDefault()����containsKey()�������࣡����
    }
    return result
}