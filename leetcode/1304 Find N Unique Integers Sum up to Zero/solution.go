func sumZero(n int) []int { // [0], [-1,1], [-1,1,0], [-2,-1,1,2], [-2,-1,-1,2,0]......������
    A := make([]int, n) // ϸ�ڣ�nΪ����ʱ����ĩβΪ��ʼ��Ԫ��0������
    index := 0
    for i:=1; i<=n/2; i++ { // ϸ�ڣ�ע��ѭ����1��n/2������
        A[index] = -i
        index++
        A[index] = i
        index++
    }
    return A
}