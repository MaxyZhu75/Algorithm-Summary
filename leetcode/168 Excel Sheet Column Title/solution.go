func convertToTitle(columnNumber int) string { // ��ת��Ϊ26���ƣ�����ͨ����ת��˼·��ͬ�����˴������ܿӣ�����
    var result string = "" 
    
    for (columnNumber != 0) {
        columnNumber-- // �ӵ㣺����A��Z��Ӧ1-26����ÿ��ѭ������ʾ26���Ƶ�ÿһλʱ����Ҫ�ȼ�1������
        oneBit := string('A' + columnNumber%26) // ǿ��ת��������
        result = oneBit + result
        columnNumber /= 26      
    }

    return result
}