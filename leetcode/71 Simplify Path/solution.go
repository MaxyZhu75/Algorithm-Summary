func simplifyPath(path string) string {
    myDeque := []string{}
    for _, name := range strings.Split(path, "/") { // import strings.Split(�ַ������ָ���)������
        if name == ".." { // case1����..�� ������deque�������deque��Ϊ���򵯳�ջ��������
            if len(myDeque) != 0 {
                myDeque = myDeque[:len(myDeque)-1]
            }
        } else if name != "." && name != "" { // case2����.������ַ��������ġ�/���ָ��Ϊ���ַ���������deque������Ԫ��ѹ��ջ��������
            myDeque = append(myDeque, name)
        }
    }
    return "/" + strings.Join(myDeque, "/") // import.strings.Join(�ַ������飬���ӷ�)������
}