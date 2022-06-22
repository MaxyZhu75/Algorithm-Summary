func longestConsecutive(nums []int) int { // ����ʱ����ɣ���ϣ������
    hashRecord := map[int]bool{}
    for _, num := range nums { // �洢����Ԫ����ȥ�أ�����
        hashRecord[num] = true
    }
    result := 0
    for num, _ := range hashRecord {
        if !hashRecord[num-1] { // ���ۣ�������ԭ�������num-1��������ö����numΪ��ͷ���������н������ʱnum��Ȼ�Ѿ������ʹ���������
			current := num
            count := 1
            for hashRecord[current+1] { // ͳ�Ƶ�ǰ����г��ȣ�����
                current++
                count++
            }
            if result < count {
                result = count
            }
        }
    }
    return result
}