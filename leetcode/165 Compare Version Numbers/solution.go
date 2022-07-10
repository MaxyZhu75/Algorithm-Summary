func compareVersion(version1 string, version2 string) int { // ˫ָ�룡����
    num1, num2 := 0, 0
    n, m := len(version1), len(version2)
    i, j := 0, 0
    for i < n || j < m  { // ����Ƚϡ�.���ָ�����֣�����
        num1, num2 = 0, 0
        for i < n && version1[i] != '.' {
            num1 = num1*10 + int(version1[i]-'0')
            i++
        }
        for j < m && version2[j] != '.' {
            num2 = num2*10 + int(version2[j]-'0')
            j++
        }
        if num1 < num2 {
            return -1
        } else if num1 > num2 {
            return 1
        } else { // ϸ�ڣ������Ҫͬʱ�ƶ�ָ�룡����
            i++
            j++
        }
    }
    return 0
}