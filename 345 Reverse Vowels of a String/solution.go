func reverseVowels(s string) string {

    p1, p2 := 0, len(s)-1
    splitString := []byte(s) // 强制转换为[]byte！！！

    for (p1 <= p2) { // 双指针；注意循环条件和不同case的逻辑，否则结果易出错！！！
        letter1 := string(splitString[p1]) // 强制转换为string！！！
        letter2 := string(splitString[p2])
        if !strings.Contains("aeiouAEIOU", letter1) { // case1：但凡遇见不是元音则移动该指针（无论都指向辅音还是只有一个指向辅音，一次循环只移动一个指针即可）！！！
            p1++;
        } else if !strings.Contains("aeiouAEIOU", letter2) { // import "strings"；检测字符串A是否包含字符串B则用strings.Contains(A, B)！！！
            p2--;
        } else { // case2：当且仅当两个指针都指向元音时才交换且同时移动！！！
            splitString[p1], splitString[p2] = splitString[p2], splitString[p1] // Go语言可直接一行代码交换！！！
            p1++
            p2--
        }
    }

    result := string(splitString) // 强制转换为string！！！
    return result
}