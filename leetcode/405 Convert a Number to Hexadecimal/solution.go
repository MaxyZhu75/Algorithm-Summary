func toHex(num int) string { // 本质是对长度为32的二进数进行分组，每4个数一组共八组！！！
    if num == 0 {
        return "0"
    }

    hexNum := []string{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"}

    var result string = ""
    var uintNum uint32 = uint32(num) // 注意Go语言中没有无符号右移的运算，>>表示算数移位；因此需要先把该数强制转型为uint32，再去使用>>移位符号（此时作用相当于>>>）！！！
    for (uintNum != 0) { // 关于补码问题并不需要做处理，因为计算机二进制数本身就是补码表示的！！！
        oneBit := hexNum[uintNum & 15] // 即 num & 0b1111；本题与普通进制转换不同，没有用%与/操作，因为其对负数的输出有要求！！！
        result = oneBit + result
        uintNum >>= 4 // 由于循环条件是num不为0，我们每次处理完一组数后需要使用无符号右移（高位补0）！！！
    }

    return result
}