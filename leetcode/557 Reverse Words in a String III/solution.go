func reverseWords(s string) string { // ָ�����������
    sb := []byte{}
    i := 0
    for i < len(s) {
        start := i // ��¼�����ʵ�һ����ĸ����������
        for i < len(s) && s[i] != ' ' {
            i++
        }
        for k:=1; k <= i-start; k++ { // ��ʱi���ڵ�ǰ���ʺ�Ŀո񴦣�����
            sb = append(sb, s[i-k])
        }
        if i < len(s) && s[i] == ' ' { // ���һ�����ʲ��ؼӿո����൥�ʼӿո���ƶ�i������
            sb = append(sb, ' ')
            i++
        }
    }
    return string(sb)
}