func reorderLogFiles(logs []string) []string { // ��д�������򷽷�������
	sort.SliceStable(logs, func(i, j int) bool { // import sort������
		log1 := strings.SplitN(logs[i], " ", 2) // import strings; �ԣ��׸����ո�Ϊ�ָ���������Ϊ�����֣�����
		log2 := strings.SplitN(logs[j], " ", 2)
		isDigit1 := unicode.IsDigit(rune(log1[1][0])) // import unicode; ע������������ҪǿתΪrune������
		isDigit2 := unicode.IsDigit(rune(log2[1][0]))
		if !isDigit1 && !isDigit2 {
			if log1[1] != log2[1] {
                return log1[1] < log2[1] // ���ֵ�˳��Ƚ������ַ�����С���򷵻�true������
            } else {
                return log1[0] < log2[0]
            }
		} else {
            return !isDigit1 && isDigit2  // ��Go��д�����У�����true��ʾ���������������Ҫ����������������false��ʾ���������������Ҫ��������������
        }
	})
	return logs
}