func leastInterval(tasks []byte, n int) int { // 贪心；预留空隙插空！！！
    frequencies := make([]int, 26)
    for _, task := range tasks {
        frequencies[task-'A']++ // 统计每个字母出现频率！！！
    }

    sort.Ints(frequencies)
    slot := frequencies[25]-1
    idle := slot * n // 先将出现次数最多的字母排列开来，每个slot由「n个空隙」组成！！！
    
	for i:=24; i>=0 && idle>0; i-- { // 遍历其他字母插空占用空隙，每个slot同一种字母至多出现一次；若空隙填满则跳出循环！！！
        if frequencies[i] >= slot { // 若多个字母频率与最大频率相同，该字母占用空隙时只占「slot个空隙」，剩余一个「往尾部添加」！！！
            idle -= slot
        } else {
            idle -= frequencies[i]
        }
    }

    if idle <= 0 {
        return len(tasks) // 全部空隙被填满后，剩余字母往尾部添加，则周期等于总任务数！！！
    } else {
        return idle + len(tasks)
    }
}