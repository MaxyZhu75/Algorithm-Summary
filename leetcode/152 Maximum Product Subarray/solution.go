func maxProduct(nums []int) int { //�����������ϡ�������
    n := len(nums)
    left := make([]int, n) // ���ۣ����������������������������û��0�Ļ�����ôӵ�����˻���������һ����nums[0]��ʼ��ǰ׺���飩������nums[n-1]��β����׺���飩������
    right := make([]int, n)
    left[0], right[n-1] = nums[0], nums[n-1]
    for i:=1; i<n; i++ { // ��������ͳ�Ƹ�Ԫ��ǰ��׺���飡����
        if left[i-1] == 0 {
            left[i] = nums[i] // ������Ԫ��Ϊ0����ǰ׺����׺������˻�Ϊ0�������´ӵ�ǰԪ�ؿ�ʼ����ǰ׺�˻����ɣ�����
        } else {
            left[i] = left[i-1]*nums[i]
        }
        if right[n-i] == 0 { // ����ͬ������
            right[n-i-1] = nums[n-1-i]
        } else {
            right[n-i-1] = right[n-i]*nums[n-1-i]
        }
    }
    result := math.MinInt32
    for i:=0; i<n; i++ {
        result = max(result, left[i], right[n-1-i])
    }
    return result
}

func max (a int, b int, c int) int {
    if a >= b && a >= c {
        return a
    } else if b >= a && b >= c{
        return b
    } else {
        return c
    }
}