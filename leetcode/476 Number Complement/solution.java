class Solution {
    public int findComplement(int num) {
        int higherOne = 1<<30; // 定义该变量检测num中最高位的1所在位置；由于32位为符号位，该题符号位为0，则左移至31位即可！！！
        int mask = 0; 
        while ((num&higherOne)==0){
            higherOne = higherOne>>1; // 该while结构使得higherOne在num中最高位的1所在位置停下！！！
        }
        mask = (higherOne<<1)-1; // num中最高位的1所在位置假设为第i位，则我们需要i个1的二进制数mask与num异或即可使num取反；易知mask可由higherOne左移减1得到！！！
		return num^mask;
    }
}