class Solution {
    public String toHex(int num) { // 本质是对长度为32的二进数进行分组，每4个数一组共八组！！！
        if (num == 0) {
            return "0";
        }

        String[] hexNum = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

        StringBuilder sb = new StringBuilder();
        while (num != 0) { // 关于补码问题并不需要做处理，因为计算机二进制数本身就是补码表示的！！！
            String oneBit = hexNum[num & 0b1111]; // 本题与普通进制转换不同，没有用%与/操作，因为其对负数的输出有要求！！！
            sb.append(oneBit);
            num >>>= 4; // 由于循环条件是num不为0，我们每次处理完一组数后需要使用无符号右移（高位补0）！！！
        }

        return sb.reverse().toString();
    }
}