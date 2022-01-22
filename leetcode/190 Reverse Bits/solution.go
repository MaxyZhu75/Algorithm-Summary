func reverseBits(num uint32) uint32 {
    var result uint32 = 0
    for i:=31; i>=0; i-- {
        mask := num & 1 // 由于每次循环末尾会将num右移一位，则此处每次循环的mask取最低位的1bit即可！！！
        oneBit := mask << i // 算数左移将该bit移动至相应位置！！！
        result |= oneBit // 添加到结果用或运算！！！
        num >>= 1
    }
    return result
}