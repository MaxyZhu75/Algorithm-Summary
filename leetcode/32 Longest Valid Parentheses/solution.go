func longestValidParentheses(s string) int { // ����һ�����Ե�ջ������
    result := 0 // ʼ�ձ���ջ��Ԫ��Ϊ��ǰ�Ѿ���������Ԫ���С����һ��û�б�ƥ��������ŵ��±꡹��ջ������Ԫ��ά���������ŵ��±꡹������
    stack := []int{}
    stack = append(stack, -1) // ����һ��Ϊ������������ջ�����������±�����ʣ��ʱ���ǰ��ѹ��-1������ 
    for i:=0; i<len(s); i++ {
        if s[i] == '(' { // case1���������±�ֱ����ջ������
            stack = append(stack, i)
        } else { // case2�����������ȵ���ջ��������
            stack = stack[:len(stack)-1]
            if len(stack) == 0 {
                stack = append(stack, i) // ��ջΪ���򽫵�ǰ����������ѹ�룻�ǿ�����¡����Ч���ŵĳ��ȡ�������
            } else {
                result = max(result, i-stack[len(stack)-1])
            }
        }
    }
    return result
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}