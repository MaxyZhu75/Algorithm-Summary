func romanToInt(s string) int {
    hashRecord := map[byte]int{'I':1, 'V':5, 'X':10, 'L':50, 'C':100, 'D':500, 'M':1000}
    
    result, currentVal, nextVal := 0, 0, 0
    for i:=0; i<len(s)-1; i++ {
        currentVal, nextVal = hashRecord[s[i]], hashRecord[s[i+1]]
        if currentVal < nextVal {
            result -= currentVal // case1: С�������ڴ�����ֵ���ߣ��ɹ����֪����6��������ڴ��м�ȥ��С�����ּ��ɣ�����
        } else {
            result += currentVal // case2: С�������ڴ�����ֵ��ұߣ���ô���Խ�ÿ���ַ�����һ��������ֵ���ۼ�ÿ���ַ���Ӧ����ֵ���ɣ�����
        }
    }
    result += hashRecord[s[len(s)-1]] // ĩβ���ֵ�ֵ��Ȼ��Ҫ����𰸣�����
    return result
}