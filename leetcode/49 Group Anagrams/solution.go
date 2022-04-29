func groupAnagrams(strs []string) [][]string { // ��ϣ��+���򣡣���
    hashRecord := make(map[string][]string) // �洢��ʽΪ(������str��ԭstr�б�)������
    for _, str := range strs {
        letters := []byte(str)
        sort.Slice(letters, func(i int, j int) bool { // ��д�����ֵ������򣡣���
            return letters[i] < letters[j]
        })
        key := string(letters)
        hashRecord[key] = append(hashRecord[key], str)
    }

    result := make([][]string, 0, len(hashRecord))
    for _, group := range hashRecord {
        result = append(result, group)
    }
    return result
}