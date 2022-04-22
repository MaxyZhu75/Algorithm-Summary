func isNumber(s string) bool {
    n, ePosition, result := len(s), -1, false

    for i:=0; i<n; i++ {
        if s[i] == 'e' || s[i] == 'E' {
            if ePosition == -1 {
                ePosition = i // ����ɨ��e��λ�ò���¼������
            } else {
                return false // �����ظ�����e������
            }
        }
    }

    if ePosition != -1 { // case1: �������e���������ǡ��������򡸸����������Ҳ�����ǡ�������������
        result = check(s, 0, ePosition-1, false) && check(s, ePosition+1, n-1, true)
    } else {
        result = check(s, 0, n-1, false) // case2: ���������e �����ο����ǡ��������򡸸�������������
    }

    return result
}

func check(s string, start int, end int, mustInteger bool) bool { // �����ж��Ƿ��ǺϷ��ġ��������򡸸�������������
    if start > end {
        return false
    }
    if s[start] == '+' || s[start] == '-' { // ֻ����λ�����Ƿ���λ������
        start++
    }

    hasDot, hasDigit := false, false
    for i:=start; i<=end; i++ {
        if s[i] == '.' { // case1��С���㡸.��������һ�Σ��Ҳ�����������������
            if mustInteger || hasDot {
                return false
            }
            hasDot = true
        } else if s[i] >= '0' && s[i] <= '9' { // case2�����֡�0~9�����ٳ���һ�Σ�����
            hasDigit = true;
        } else {
            return false; // case3�����ٴγ��ַ���λ������Ч���֣�����
        }
    }
    return hasDigit // ���ٴ���һ�����֣�����
}