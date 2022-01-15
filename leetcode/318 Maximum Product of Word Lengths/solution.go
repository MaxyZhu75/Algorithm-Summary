func maxProduct(words []string) int {
    var n int = len(words)
    var wordBits [1000] int // ע�ⰴ���ַ�ʽ��������ʱ�����С����д��������дn��ᱨ������
    for i, word := range words { 
        for _, letter := range word { // ��������ʹ�ã��˴�����Ҫ��javaһ��ʹ��toCharArray()���������������е���ĸ������
            wordBits[i] |= 1<<(letter-'a') // ���ɣ�Сд��ĸ-��a�����Ϊ���֣���ͬ��ĸ��1�����Ƹ�����ͬ�����á�|���������¼ÿ����ĸ�ĳ��֣�����
        }
    }

    var maxLen int = 0
    for i:=0; i<n; i++ {
        for j:=i+1; j<n; j++ {
            if (wordBits[i]&wordBits[j])==0 { // ע�����������������������wordBits[j]==0�����������򱨴�����
                maxLen = maxNum(maxLen, len(words[i])*len(words[j]))
            }
        }
    }
    return maxLen
}

func maxNum(a int, b int) int {
    if a>b {
        return a
    } else {
        return b
    }
}