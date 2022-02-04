func isIsomorphic(s string, t string) bool {
    record1 := make([]int, 256) // ��¼ÿ���ַ��ϴγ��ֵ�����������
    record2 := make([]int, 256) // ��֪�ַ���������ASCII�ַ���ɣ���С��Ϊ128ʱ�����������

    for i, letter1 := range s { // ��֪�����ַ���������ȣ�����
        letter2 := t[i]
        if record1[letter1] != record2[letter2] { // ���������ַ���ʱ�������Ե�ǰ��ĸ�ϴγ��ֵ�������ͬ��ͬ��������
            return false
        }
        record1[letter1], record2[letter2] = i+1, i+1 // ����Ԫ�س�ʼֵΪ0�����ǰ�0��������ĸδ���֣�����ڼ�¼���ֹ�����ĸ����ʱҪ+1�������֣���ֹ�ѵ�һ�����ֵ���ĸ����Ҳ��¼Ϊ0������������
    }

    return true
}