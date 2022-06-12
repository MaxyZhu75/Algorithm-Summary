func intToRoman(num int) string {
    values := []int{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1} // �ɴ�С�洢���п��õĻ������ּ���Ӧ�ַ�������
    symbols := []string{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"} // ע������������������Ҫ��Ӧ������
    var result string = ""
    for i:=0; i<len(values); i++ { // ̰�ĵشӴ�С�������õ����֣�����
        for num >= values[i] {
            num -= values[i]
            result = result + symbols[i]
        }
        if num == 0 { // �����ɣ����ڣ�����
            break
        }
    }
    return result
}