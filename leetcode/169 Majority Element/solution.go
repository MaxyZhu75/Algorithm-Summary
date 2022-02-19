func majorityElement(nums []int) int { // Boyer-MooreͶƱ��������
    candidate, vote := nums[0], 0
    for _, num := range nums {
        if vote == 0 { // case1������ѡ�˲���majority����majority��������Ǻ�ѡ��һ�𷴶Ժ�ѡ�ˣ�����ѡ��һ������̨����vote==0ʱ��������ѡ�٣�����
            candidate = num
        }

        if candidate == num { // case2������ѡ����majority , ��majority��֧���Լ����������Ǻ�ѡ�˻ᷴ�ԣ�������֪majorityƱ������һ�룬������һ����ɹ���ѡ������
            vote++
        } else {
            vote--
        }
    }
    return candidate
}