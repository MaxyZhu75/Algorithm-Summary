class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        if (n == 1 || bits[n-2] == 0) return true; // case1�����鳤��Ϊ1�����β��00������
        return !checkEncode(bits, n-2); // case2����β��10������
    }

    public boolean checkEncode(int[] bits, int length) { // ����ȥĩβ��10��ǰ���bits�ܷ������룡����
        int pointer = 0;
        while (pointer < length) {
            pointer = (bits[pointer] == 0) ? pointer+1 : pointer+2;
        }

        return pointer == length;
    }
}