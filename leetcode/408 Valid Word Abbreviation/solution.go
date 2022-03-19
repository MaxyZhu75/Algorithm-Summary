func validWordAbbreviation(word string, abbr string) bool { // Ҫ�㣺�����ֵĴ�������
    n := len(word)
    pointer, digit := 0, 0 // word�е�ָ�룻abbr�е����֣�����
    for i, letter := range abbr {
        if letter == '0' && digit == 0 { // case1������ǰ��0��digit����0˵��ǰһ���ַ�������������ĸ������
            return false;
        }
        if letter >= '0' && letter <= '9' { // case2���������֣���������д�������˳��ͳ�ƶ�λ�������֣�����
            digit = digit * 10 + int(letter-'0')
        } else { // case3��������ĸ������
            pointer += digit // ��word��ָ���ƶ���Ȼ��digit��Ҫ���㣡����
            digit = 0
            if pointer >= n || word[pointer] != abbr[i] { // ָ��Խ�����ĸ��ƥ��˵����д������ֱ�ӷ��أ�ע��letterΪrune���ͣ��˴�����ֱ��ʹ�ã�����
                return false
            }
            pointer++
        }
    }
    return digit == n - pointer // ��дĩβ�����ֲ�δ��֤����Ҫ��ѭ������֤������
}