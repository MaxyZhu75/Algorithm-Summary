type Tuple struct { // ����������Ҫ��username��timestamp��website��3������������������
    username string
    timestamp int
    website string
}

func mostVisitedPattern(username []string, timestamp []int, website []string) []string {
    visit := make([]Tuple, len(username))
    for i:=0; i<len(username); i++ {
        visit[i] = Tuple{username[i], timestamp[i], website[i]} // �����������¼Ԫ�����visit���飡����
    }
	
    sort.Slice(visit, func(i, j int) bool {
        return visit[i].timestamp < visit[j].timestamp // ��д�������򷽷�������timestamp���򣬱�֤�û��ķ��ʼ�¼���򣡣���
    })
	
    hashRecord := make(map[string][]Tuple) // ʹ��HashMap�洢ÿ���û����������¼Ԫ�飡����
    for i:=0; i<len(visit); i++ {
        hashRecord[visit[i].username] = append(hashRecord[visit[i].username], visit[i]) // ��ϣ��洢��ʽ��<username�������¼Ԫ�������>������
    }
    
	scores := make(map[[3]string]int)
    for _, userTuples := range hashRecord {
        count := make(map[[3]string]int)
        for i:=0; i<len(userTuples); i++ { // ���ر����û����ʹ���website����õ�ǰuser���еķ���·����ϣ�����
            for j:=i+1; j<len(userTuples); j++ {
                for k:=j+1; k<len(userTuples); k++ {
                    pattern := [3]string{userTuples[i].website, userTuples[j].website, userTuples[k].website}
					count[pattern] = 1 // ���ڵ�ǰͬһ��user���÷���·������scoreʱֻ��1�֣�����
                }
            }
        }
        for pattern, points := range count { // ע��ѭ��λ�ã������굱ǰuser���ʼ�¼����֣�����
            scores[pattern] += points
        }
    }
    
	max := -1
    result := [3]string{}
    for pattern, score := range scores { // ��ȡ�������ķ���ģʽ������
        if score > max {
            result = pattern
            max = score
        } else if score == max { // �������ģʽ������ͬ����������ȡ�ֵ���������С���Ǹ�������
            if pattern[0] < result[0] || (pattern[0] == result[0] && pattern[1] < result[1] || (pattern[0] == result[0] && pattern[1] == result[1] && pattern[2] < result[2])) {
                result = pattern
            }
        }
    }
    return []string{result[0], result[1], result[2]}
}