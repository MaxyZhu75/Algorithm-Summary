func canCross(stones []int) bool { // �����Ż������Ķ�̬�滮������
    n := len(stones)
    d := make([][]bool, n, n) // �ܷ�ͨ������Ծ����distance���ӡ�ǰһ�����Ϊj��ʯ�ӡ��ﵽ����ǰ���Ϊi��ʯ�ӡ�������
    for i:=0; i<n; i++ {
        d[i] = make([]bool, n)
    }
    d[0][0] = true

    for i:=1; i<n; i++ { // ÿ����Ծ֮����Ծ������������1��������i-1��ʯ��ʱ��֮ǰ��������i-1�Σ���һ�������� i �ľ��룡����
        if stones[i]-stones[i-1] > i {
            return false // �Ż�����һ�������i��ʯ������i?1��ʯ�Ӿ��볬��iʱ�����ܱض��޷������յ㣬ֱ��return������
        }
    }

    distance := 0
    for i:=0; i<n; i++ {
        for j:=i-1; j>=0; j-- {
            distance = stones[i] - stones[j]
            if distance > j+1 { // �Ż����۶���ͬ��������j��ʯ��ʱ����һ��������j+1�ľ��룡����
                break // ���ڵ������j�������ֵ�ǰ��Ϊ��Ծ���벻�����޷������ֱ��break�˳�ѭ��������
            }
            d[i][distance] = d[j][distance-1] || d[j][distance] || d[j][distance+1] // ת�Ʒ��̣�����
            if i == n-1 && d[n-1][distance] { // �����յ㣡����
                return true
            }
        }
    }
    return false
}