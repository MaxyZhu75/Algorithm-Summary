func compareVersion(version1 string, version2 string) int { // 双指针！！！
    num1, num2 := 0, 0
    n, m := len(version1), len(version2)
    i, j := 0, 0
    for i < n || j < m  { // 计算比较「.」分割的数字！！！
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
        } else { // 细节：最后需要同时移动指针！！！
            i++
            j++
        }
    }
    return 0
}