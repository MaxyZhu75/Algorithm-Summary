func numberOfWeakCharacters(properties [][]int) int {
    maxDefense, weak := 0, 0
    
	sort.Slice(properties, func (i int, j int) bool { // 关键点：此处排序要遵循两个规则！！！
        if properties[i][0] == properties[j][0] { // 规则一：整个数组攻击降序排列！！！
            return properties[i][1] < properties[j][1] // 规则二：攻击相同的子集按防守升序排列！！！
        } else {
            return properties[j][0] < properties[i][0]
        }
    })

    for _, property := range properties {
        if property[1] < maxDefense { // 由于相同攻击的子集中，最大防御已被放在该子集的最后面，则保证了遍历该子集内部时不可能产生weak++！！！
            weak++
        } else {
            maxDefense = property[1] // 更新最大防御！！！
        }
    }
    
    return weak
}