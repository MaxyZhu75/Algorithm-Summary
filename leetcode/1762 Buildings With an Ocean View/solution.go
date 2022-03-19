func findBuildings(heights []int) []int { // �Ӻ���ǰ������̰�ĵؼ��뺣�������ɣ�ע�������˳����Ҫ������ʹ��Stack���ݽṹ������
    n := len(heights)
    myStack := []int{n-1}
    highest := heights[n-1]
    for i:=n-2; i>=0; i-- {
        if heights[i] > highest {
            myStack = append(myStack, i)
            highest = heights[i]
        }
    }

    m := len(myStack)
    result := []int{}
    for i:=m-1; i>=0; i-- {
        result = append(result, myStack[i])
    }
    return result
}