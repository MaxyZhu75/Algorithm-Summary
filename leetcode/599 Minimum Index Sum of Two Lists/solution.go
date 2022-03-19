func findRestaurant(list1 []string, list2 []string) []string {
    hashRecord := make(map[string]int) // HashMap��<restaurant��indexSum>��������List������һ�μ�����ɣ�����
    
    for i, restaurant := range list1 {
        hashRecord[restaurant] = i; // �Ȱ�List1��restaurant������ȫ��д�룡����
    }

    result := []string{}
    minIndexSum := math.MaxInt32
    for j, restaurant := range list2 {
        i, ok := hashRecord[restaurant] // Go������ok�������൱��HashMap.cotainsKey();����List2ʱ��HashMap�д���key����ͬ�������Ž��к�������������
        if ok {
            indexSum := i + j;
            if (indexSum < minIndexSum) {
                minIndexSum = indexSum
                result = []string{restaurant} // ���¸�ֵ���൱�����result�Ҽ��뵱ǰrestaurant������
            } else if indexSum == minIndexSum {
                result = append(result, restaurant)
            }
        }
    }

    return result
}