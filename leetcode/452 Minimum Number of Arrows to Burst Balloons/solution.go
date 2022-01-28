func findMinArrowShots(points [][]int) int { // �൱�����ʲ��ص��������������ע���ص��Ķ��������𣬶˵���ͬҲ���ص�����[1, 2]��[2, 3]������
   
    sort.Slice(points, func(i int, j int) bool { // ��̰��˼����LeetCode��435����ͬ������
        return points[i][1] < points[j][1]
    })

    var previous []int = points[0]
    shots := 1
    for _, point := range points {
        if point[0] > previous[1] {
            shots++
            previous = point
        }
    }
    return shots
}