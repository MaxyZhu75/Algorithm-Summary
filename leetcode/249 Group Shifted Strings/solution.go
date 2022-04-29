func groupStrings(strings []string) [][]string { // ��ϣ��洢��ĸ֮��Ĳ�ֵ����
    hashRecord := make(map[string][]string) // �洢��ʽ��{����ĸ��ʾ�Ĳ�ֵ����ֵ��ͬ�����}��hashRecord["cd"] = ["acf", "gil", "xzc"]������
    for _, s := range strings {
        hashKey := getHash(s) // ��д��ϣֵ���㣡����
        if hashRecord[hashKey] == nil {
            hashRecord[hashKey] = []string{}
        }
        hashRecord[hashKey] = append(hashRecord[hashKey], s)
    }

    result := [][]string{}
    for _, group := range hashRecord { // ��ĸ���ֵ��ͬ���Ѿ��ֵ�ͬһ�飬��ÿ�����𰸣�����
        result = append(result, group)
    }
    return result
}

func getHash(s string) string { // �����ַ���ÿ���ַ�֮��Ĳ�ֵ���ʾΪ�ַ�������["acf", "gil", "xzc"]�����[2,3]��ת����Ӣ����ĸ��ʾ��Ϊ[c,d]������
    hashValue := []byte{}
    for i:=1; i<len(s); i++ {
        hashValue = append(hashValue, byte((s[i]-s[i-1]+26) % 26 + 'a')) // �����ֵҪ������ĸ��ѭ������Ҫ�ֶ� +26 �� %26 ������
    }
    return string(hashValue)
}