func compressString(S string) string {
    n := len(S)
    if n <= 1 {
        return S
    }

    previous := S[0]; // Go������string��������ȡ�ַ��ܷ��㣡����
    count := 1;
    result := "" // ����byte��intת���鷳���ַ���Ƭ[]byte������������֣��˴�Ӧ��ֱ�Ӷ���string���ַ���������

    for i:=1; i<n; i++ {
        if S[i] == previous {
            count++
        } else {
            result = result + string(previous) // ��byteǿתΪstring����ֱ���� "+" ��ӣ�����
            byteCount := strconv.Itoa(count) // import "strconv"���ַ�������Itoa()�ɽ�intתΪstring������
            result = result + byteCount
            count = 1
            previous = S[i]
        }
    }

    result = result + string(previous) // ���һ���ַ�ѭ����δ��ӣ�����
    byteCount := strconv.Itoa(count)
    result = result + byteCount

    if len(result) >= n {
        return S
    }

    return result
}