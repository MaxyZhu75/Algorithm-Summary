class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        if (n == 1 || bits[n-2] == 0) return true; // case1：数组长度为1；或结尾是00！！！
        return !checkEncode(bits, n-2); // case2：结尾是10！！！
    }

    public boolean checkEncode(int[] bits, int length) { // 检查除去末尾的10，前面的bits能否合理编码！！！
        int pointer = 0;
        while (pointer < length) {
            pointer = (bits[pointer] == 0) ? pointer+1 : pointer+2;
        }

        return pointer == length;
    }
}