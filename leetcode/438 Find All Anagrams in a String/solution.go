func findAnagrams(s string, p string) []int { // �������ڣ�����
    result := []int{}
    var sCount, pCount [26]int // ע�⣺�˴�������make��������Ϊ֮��==�����ܱȽ�slice���ݣ�����
    for i:=0; i<len(p); i++ { // �洢��p��������ĸ������������
        pCount[int(p[i]-'a')]++
    }
    for i:=0; i<len(s); i++ { // ͳ�ƴ�СΪ��k���Ļ��������ڣ���s��������ĸ������������
        sCount[int(s[i]-'a')]++
        if i >= len(p) {
            sCount[int(s[i-len(p)]-'a')]--
        }
        if pCount == sCount { // �Ƚ������������Ƿ���ͬ���ɣ�����
            result = append(result, i-len(p)+1)
        }
    }
    return result
}