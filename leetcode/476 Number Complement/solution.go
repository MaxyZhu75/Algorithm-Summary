func findComplement(num int) int {
    var higherOne int = 1<<30 // 定义该变量检测num中最高位的1所在位置；由于32位为符号位，该题符号位为0，则左移至31位即可！！！
    mask := 0
    for higherOne&num == 0 { // go语言用for循环实现while循环的功能！！！
            higherOne = higherOne>>1 
    }
    mask = (higherOne<<1)-1 // num中最高位的1所在位置假设为第i位，则我们需要i个1的二进制数mask与num异或即可使num取反；易知mask可由higherOne左移减1得到！！！
    return num^mask
}