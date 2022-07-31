func isValidSerialization(preorder string) bool {
    n, i, slots := len(preorder), 0, 1
    for i < n {
        if (slots == 0) {
            return false // ��û�������ûslot�ˣ��޷�������䣡����
        }
        if preorder[i] == ',' {
            i++
        } else if preorder[i] == '#' { // �ս������1��slot������
            slots--
            i++
        } else {
            for i < n && preorder[i] != ',' { // �����ֶ��꣬�����ľ���ֵ������
                i++
            }
            slots++ // �ǿսڵ�����1��slot�������һ���ṩ2��slot����2-1=1������
        }
    }
    return slots == 0
}