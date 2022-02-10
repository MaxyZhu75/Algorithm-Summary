func convertToTitle(columnNumber int) string { // 即转换为26进制，跟普通进制转换思路相同，但此处索引很坑！！！
    var result string = "" 
    
    for (columnNumber != 0) {
        columnNumber-- // 坑点：由于A到Z对应1-26，故每次循环（表示26进制的每一位时）都要先减1！！！
        oneBit := string('A' + columnNumber%26) // 强制转换！！！
        result = oneBit + result
        columnNumber /= 26      
    }

    return result
}