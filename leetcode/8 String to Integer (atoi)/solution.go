func myAtoi(s string) int {
    n, result, pointer := len(s), 0, 0
    negative := false
    
    for pointer < n && s[pointer] == ' ' { // ����һ���������õ�ǰ���ո񣡣���
        pointer++
    }

    if pointer == n { // ����������ָ���Ƿ�ﵽĩβ�������Զ�ȡ�����ţ�����
        return result
    }
    if s[pointer] == '-' {
        negative = true
        pointer++
    } else if s[pointer] == '+' {
        pointer++
    }

    currentDigit := 0
    for pointer < n && s[pointer] >= '0' && s[pointer] <= '9' { // �������������ֲ��ֽ��д�������
        currentDigit = int(s[pointer] - '0')
        result = result*10 + currentDigit // ʹ��Go����ʱ��result�����Ƚ������㣬��ֱ���ж��Ƿ�������ɣ���ΪintΪ64λ������
        if result > math.MaxInt32 {
            if negative == true {
                return math.MinInt32
            } else {
                return math.MaxInt32
            }
        }
        pointer++
    }

    if negative == true {
        return -1 * result
    } else {
        return result
    }
}