func numberOfWeakCharacters(properties [][]int) int {
    maxDefense, weak := 0, 0
    
	sort.Slice(properties, func (i int, j int) bool { // �ؼ��㣺�˴�����Ҫ��ѭ�������򣡣���
        if properties[i][0] == properties[j][0] { // ����һ���������鹥���������У�����
            return properties[i][1] < properties[j][1] // �������������ͬ���Ӽ��������������У�����
        } else {
            return properties[j][0] < properties[i][0]
        }
    })

    for _, property := range properties {
        if property[1] < maxDefense { // ������ͬ�������Ӽ��У��������ѱ����ڸ��Ӽ�������棬��֤�˱������Ӽ��ڲ�ʱ�����ܲ���weak++������
            weak++
        } else {
            maxDefense = property[1] // ����������������
        }
    }
    
    return weak
}