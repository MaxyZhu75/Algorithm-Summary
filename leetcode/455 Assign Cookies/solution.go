func findContentChildren(g []int, s []int) int {
    var p1, p2, result int = 0, 0, 0 // ����˼·�������ʹ��̰��˼�룻ʵ��ʱ����˫ָ�룡����
    sort.Ints(g) // Go��������import "sort"������
    sort.Ints(s)
    for (p2 < len(s)) { // ̰������:������С�ı�������θ����С�ĺ��ӣ��Ӷ�ʹ������ĺ���������࣬��ȷ�Կ��ɷ�֤����֤��������
        if p1 > len(g)-1 {
            return len(g)
        }
        if s[p2] >= g[p1] {
            p1++
            p2++
            result++
        } else {
            p2++
        }
    }
    return result
}