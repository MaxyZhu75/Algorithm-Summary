func canCompleteCircuit(gas []int, cost []int) int {
    n, i := len(gas), 0 // ���ۣ������x�������ˡ�y+1������ô�ӡ�x������y������һ������������ܵ��y+1��������
    for i < n {
        gasSum, costSum, count := 0, 0, 0
        for count < n { // ���ȼ���0������վ������ͼ�ж��ܷ���һ�ܣ�������ܣ��ʹӡ���һ���޷�����ļ���վ����ʼ������飡����
            j := (i+count) % n // ϸ�ڣ�����ѭ����Ҫȡ�࣡����
            gasSum += gas[j]
            costSum += cost[j]
            if costSum > gasSum {
                break
            }
            count++
        }
        if count == n {
            return i
        } else {
            i = i + count + 1
        }
    }
    return -1
}