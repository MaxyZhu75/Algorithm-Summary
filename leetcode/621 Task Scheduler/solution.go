func leastInterval(tasks []byte, n int) int { // ̰�ģ�Ԥ����϶��գ�����
    frequencies := make([]int, 26)
    for _, task := range tasks {
        frequencies[task-'A']++ // ͳ��ÿ����ĸ����Ƶ�ʣ�����
    }

    sort.Ints(frequencies)
    slot := frequencies[25]-1
    idle := slot * n // �Ƚ����ִ���������ĸ���п�����ÿ��slot�ɡ�n����϶����ɣ�����
    
	for i:=24; i>=0 && idle>0; i-- { // ����������ĸ���ռ�ÿ�϶��ÿ��slotͬһ����ĸ�������һ�Σ�����϶����������ѭ��������
        if frequencies[i] >= slot { // �������ĸƵ�������Ƶ����ͬ������ĸռ�ÿ�϶ʱֻռ��slot����϶����ʣ��һ������β����ӡ�������
            idle -= slot
        } else {
            idle -= frequencies[i]
        }
    }

    if idle <= 0 {
        return len(tasks) // ȫ����϶��������ʣ����ĸ��β����ӣ������ڵ�����������������
    } else {
        return idle + len(tasks)
    }
}