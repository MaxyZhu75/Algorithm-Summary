type Tuple struct { // 首先我们需要将username，timestamp和website这3个东西绑定起来！！！
    username string
    timestamp int
    website string
}

func mostVisitedPattern(username []string, timestamp []int, website []string) []string {
    visit := make([]Tuple, len(username))
    for i:=0; i<len(username); i++ {
        visit[i] = Tuple{username[i], timestamp[i], website[i]} // 把所有浏览记录元组放入visit数组！！！
    }
	
    sort.Slice(visit, func(i, j int) bool {
        return visit[i].timestamp < visit[j].timestamp // 重写数组排序方法，按照timestamp排序，保证用户的访问记录有序！！！
    })
	
    hashRecord := make(map[string][]Tuple) // 使用HashMap存储每个用户各自浏览记录元组！！！
    for i:=0; i<len(visit); i++ {
        hashRecord[visit[i].username] = append(hashRecord[visit[i].username], visit[i]) // 哈希表存储形式：<username，浏览记录元组的数组>！！！
    }
    
    scores := make(map[[3]string]int)
    for _, userTuples := range hashRecord {
        count := make(map[[3]string]int)
        for i:=0; i<len(userTuples); i++ { // 三重遍历用户访问过的website，获得当前user所有的访问路径组合！！！
            for j:=i+1; j<len(userTuples); j++ {
                for k:=j+1; k<len(userTuples); k++ {
                    pattern := [3]string{userTuples[i].website, userTuples[j].website, userTuples[k].website}
		    count[pattern] = 1 // 对于当前同一个user，该访问路径计入score时只计1分！！！
                }
            }
        }
        for pattern, points := range count { // 注意循环位置，遍历完当前user访问记录后算分！！！
            scores[pattern] += points
        }
    }
    
    max := -1
    result := [3]string{}
    for pattern, score := range scores { // 获取最大分数的访问模式！！！
        if score > max {
            result = pattern
            max = score
        } else if score == max { // 如果访问模式具有相同的最大分数，取字典序排列最小的那个！！！
            if pattern[0] < result[0] || (pattern[0] == result[0] && pattern[1] < result[1] || (pattern[0] == result[0] && pattern[1] == result[1] && pattern[2] < result[2])) {
                result = pattern
            }
        }
    }
    return []string{result[0], result[1], result[2]}
}
