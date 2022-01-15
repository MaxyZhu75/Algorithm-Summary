func dominantIndex(nums []int) int {
    var n int = len(nums)
    maxNum1 := math.MinInt32 // Go����math�������MinInt32�˴���ʼ����������ʹ�ã�����
    maxNum2 := math.MinInt32
    maxIndex := -1
    for i:=0; i<n; i++ { // һ�α�������nums�����ֵ��ڶ����ֵ�Լ����ֵ���±꣡����
        if nums[i] > maxNum1 { // case1���µ����ֵ������
            maxNum2 = maxNum1
            maxNum1 = nums[i]
            maxIndex = i
        } else if nums[i] > maxNum2 { // case2���µĵڶ����ֵ������
            maxNum2 = nums[i]
        }
    }

    if maxNum1 >= (2*maxNum2) {
        return maxIndex
    }
    return -1
}