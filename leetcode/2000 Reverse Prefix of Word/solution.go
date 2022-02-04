func reversePrefix(word string, ch byte) string {
    stopIndex := strings.IndexByte(word, ch) // import "strings"��IndexByte(string, byte)�൱��java��indexOf()������
    p1, p2 := 0, stopIndex
    result := []byte(word) // �൱��java��toCharArray()��string����immutable������ֱ�ӷ�ת������
    if stopIndex == -1 || stopIndex == 0 {
        return word
    }
    for (p1 <= p2) {
        result[p1], result[p2] = result[p2], result[p1] // Go������byte[]����ֱ�ӽ����ܷ��㣡����
        p1++
        p2--
    }
    return string(result)
}