func convertToBase7(num int) string {
    if num == 0 {
        return "0"
    }

    isNegative := false // �Ȼ�Ϊ������������
    if num < 0 {
        num = -num
        isNegative = true
    }

    var result string = ""
    for (num > 0) { // ע��ߵ�λ˳�����⣡����
        oneBit := strconv.Itoa(num % 7)
        result = oneBit + result
        num /= 7
    }

    if isNegative {
        result = "-" + result // �ж��Ƿ��ϸ��ţ�����
    }

    return result
}