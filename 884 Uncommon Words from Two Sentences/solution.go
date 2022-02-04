func uncommonFromSentences(s1 string, s2 string) []string {
     wordList1 := strings.Split(s1, " ") // Go�����ַ����ָ����������
     wordList2 := strings.Split(s2, " ")
     result := []string{} // ��������飡����

     hashRecord := make(map[string]int)
     for _, word := range wordList1 {
         hashRecord[word]++ // Go����map����ֱ��������¼���е��������д����������
     }
     for _, word := range wordList2 {
         hashRecord[word]++
     }

    for word, frequency := range hashRecord {
        if frequency == 1 {
            result = append(result, word) // Go����������ĩβ���Ԫ�ؼǵ���append()������
        }
    }

    return result
}