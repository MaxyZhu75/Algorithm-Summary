func isOneBitCharacter(bits []int) bool {
    n := len(bits)
    if n == 1 || bits[n-2] == 0 { // case1�����鳤��Ϊ1�����β��00������
        return true
    }
    return !checkEncode(bits, n-2) // case2����β��10������
}

func checkEncode(bits []int, length int) bool { // ����ȥĩβ��λ��10��ǰ���bits�ܷ������룡����
    pointer := 0
    for (pointer < length) {
        if bits[pointer] == 0 {
            pointer++
        } else {
            pointer += 2
        }
    }
    return pointer == length
}