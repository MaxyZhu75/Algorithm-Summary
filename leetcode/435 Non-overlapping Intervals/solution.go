func eraseOverlapIntervals(intervals [][]int) int { // ����ѡ��̰�ģ����γ̽���ʱ������ÿ��ѡ����������ģ�����
    var allClass, scheduledClass int = len(intervals), 1

    sort.Slice(intervals, func(i int, j int) bool { // import "sort"���ص��ס������ʽ������
        return intervals[i][1] < intervals[j][1] // Ҫ����intervals�������������ص���bool������
    })

    var previous []int = intervals[0]
    for _, interval := range intervals {
        if interval[0] >= previous[1] {
            scheduledClass++
            previous = interval
        }
    }
    return allClass - scheduledClass
}