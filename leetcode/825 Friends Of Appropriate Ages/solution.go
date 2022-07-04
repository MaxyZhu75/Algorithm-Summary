func numFriendRequests(ages []int) int { // ���� + ǰ׺�� ������
    count := [121]int{}
    for _, age := range ages {
        count[age]++
    }
    pSum := [121]int{}
    for i:=1; i<=120; i++ {
        pSum[i] = pSum[i-1] + count[i]
    }
    result := 0 // ���������ϲ�Ϊ��0.5*ages[x]+7 < ages[y] <= ages[x] ������
    for i:=15; i<=120; i++ { // ��֪15�����µ�x���Ҳ���������ʽ��y�ģ�����
        if count[i] > 0 {
            lower := int(i/2 + 7) // ϸ�ڣ�����ȡ��������
            result += count[i] *(pSum[i]-pSum[lower]-1) // ϸ�ڣ�pSum�±���ages�±����1��ĩβ��1Ϊ��ȥx��������
        }
    }
    return result
}