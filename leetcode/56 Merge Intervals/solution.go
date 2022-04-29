func merge(intervals [][]int) [][]int {
    sort.SliceStable(intervals, func(i int, j int) bool { // �Ȱ���˵��С�������򣡣���
        return intervals[i][0] < intervals[j][0]
    })

    n := len(intervals)
    left, right, preRight := intervals[0][0], intervals[0][1], 0
    result := [][]int{{left, right}}
    for i:=1; i<n; i++ {
        left = intervals[i][0]
        right = intervals[i][1]
        preRight = result[len(result)-1][1] // ��ȡresultĩβԪ�ص��Ҷ˵㣡����
        if left > preRight {
            result = append(result, []int{left, right}) // case1������ǰ������˵���ǰһ�����Ҷ˵㲻�ཻ���򽫵�ǰ���������result������
        } else {
            result[len(result)-1][1] = max(preRight, right) // case2������ǰ������˵���ǰһ�����Ҷ˵��ཻ������Ҫ������resultĩβԪ�ص��Ҷ˵㣡����
        }
    }
    return result
}

func max(a int, b int) int {
    if a > b {
        return a
    } else {
        return b
    }
}