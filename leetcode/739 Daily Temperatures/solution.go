func dailyTemperatures(temperatures []int) []int { // ���䵥��ջ������
    n := len(temperatures)
    result := make([]int, n)
    stack := []int{} //��ջ����ջ���¶����ε�����������
    for i:=0; i<n; i++ {
        for len(stack) != 0 && temperatures[i] > temperatures[stack[len(stack)-1]] { // ԭ��ջ�ڿ����ж���¶�С�������ģ�����Ҫ��Ǻ��ջ������
            index :=  stack[len(stack)-1]
            stack = stack[:len(stack)-1]
            result[index] = i - index 
        }
        stack = append(stack, i)
    }
    return result
}