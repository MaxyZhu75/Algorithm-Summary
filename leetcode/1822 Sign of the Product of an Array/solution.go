func arraySign(nums []int) int { // ��������ű仯���ɣ�����Ҫ���˻�������
    sign := 1
    for _, num := range nums {
        if num == 0 {
            return 0
        } else if num < 0 {
            sign *= -1
        }
    }
    return sign
}