func asteroidCollision(asteroids []int) []int { // �жϱ�ը����������ջ��ʹ�ã�����
    n := len(asteroids)
    myStack := []int{}
    myStack = append(myStack, asteroids[0]) // ����һ�Ŵ����ȶ���С�����ұ�����һ���µģ����ٴ��ȶ�ǰ������ײ����Щ��ײ�������������η���������

    i := 1
    for i < n {
        if len(myStack) > 0 && myStack[len(myStack)-1] > 0 && asteroids[i] < 0 { // ��ը��������ǰ����ԭ�ȴ���С�����������ƶ��������������ƶ�������
            if myStack[len(myStack)-1] < (-1 * asteroids[i]) { // case1��ԭ�ȵı�ը��ע�������Ŀ���������ԭ�ȵı�ը������ȷ���ȶ�ǰ��������ջ���ƶ�i������
                myStack = myStack[:len(myStack)-1]
            } else if myStack[len(myStack)-1] > (-1 * asteroids[i]) { // case2�������ı�ը������
                i++
            } else { // case3��˫����ը������
                myStack = myStack[:len(myStack)-1]
                i++
            }
        } else { // �����ϱ�ը�������ȶ�������
            myStack = append(myStack, asteroids[i])
            i++
        }
    }

    return myStack;
}