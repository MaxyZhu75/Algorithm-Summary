func reverseVowels(s string) string {

    p1, p2 := 0, len(s)-1
    splitString := []byte(s) // ǿ��ת��Ϊ[]byte������

    for (p1 <= p2) { // ˫ָ�룻ע��ѭ�������Ͳ�ͬcase���߼����������׳�������
        letter1 := string(splitString[p1]) // ǿ��ת��Ϊstring������
        letter2 := string(splitString[p2])
        if !strings.Contains("aeiouAEIOU", letter1) { // case1��������������Ԫ�����ƶ���ָ�루���۶�ָ��������ֻ��һ��ָ������һ��ѭ��ֻ�ƶ�һ��ָ�뼴�ɣ�������
            p1++;
        } else if !strings.Contains("aeiouAEIOU", letter2) { // import "strings"������ַ���A�Ƿ�����ַ���B����strings.Contains(A, B)������
            p2--;
        } else { // case2�����ҽ�������ָ�붼ָ��Ԫ��ʱ�Ž�����ͬʱ�ƶ�������
            splitString[p1], splitString[p2] = splitString[p2], splitString[p1] // Go���Կ�ֱ��һ�д��뽻��������
            p1++
            p2--
        }
    }

    result := string(splitString) // ǿ��ת��Ϊstring������
    return result
}