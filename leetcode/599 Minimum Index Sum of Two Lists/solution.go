func findRestaurant(list1 []string, list2 []string) []string {
    hashRecord := make(map[string]int) // HashMap存<restaurant，indexSum>，则两个List各遍历一次即可完成！！！
    
    for i, restaurant := range list1 {
        hashRecord[restaurant] = i; // 先把List1中restaurant的索引全部写入！！！
    }

    result := []string{}
    minIndexSum := math.MaxInt32
    for j, restaurant := range list2 {
        i, ok := hashRecord[restaurant] // Go语言中ok的作用相当于HashMap.cotainsKey();遍历List2时，HashMap中存在key（相同餐厅）才进行后续操作！！！
        if ok {
            indexSum := i + j;
            if (indexSum < minIndexSum) {
                minIndexSum = indexSum
                result = []string{restaurant} // 重新赋值，相当于清空result且加入当前restaurant！！！
            } else if indexSum == minIndexSum {
                result = append(result, restaurant)
            }
        }
    }

    return result
}