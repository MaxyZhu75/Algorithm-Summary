func sumOfUnique(nums []int) int { // ������Ҫʵ��һ�α�������Ҫά������״̬������
    record := make([]int, 101) // ��¼0, 1, 2����״̬�������Ǽ�¼����������
    result := 0

    for _, num := range nums {
        if record[num] == 0 { // ״̬0��֮ǰδ���ֹ��������result����ת��Ϊ״̬1������
            result += num
            record[num] = 1
        } else if record[num] == 1 { // ״̬1��֮ǰ���ֹ�һ�Σ����result�п۳�֮ǰ������ģ���ת��Ϊ״̬2������
            result -= num
            record[num] = 2 // ״̬2��֮ǰ���ֹ���Σ�����ʱ����Լ�¼����ı���result���κβ���������
        } else {
            continue
        }
    }
    
    return result
}