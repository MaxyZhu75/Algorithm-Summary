func findCenter(edges [][]int) int { // ���Ľ���������һ�����г��֣�����
    if edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] {
        return edges[0][0]
    }
    return edges[0][1]
}