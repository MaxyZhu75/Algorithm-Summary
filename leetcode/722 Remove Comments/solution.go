func removeComments(source []string) []string { // �������������
    inBlock := false
    sb := ""
    result := []string{}
    for _, line := range source {
        if (!inBlock) {
            sb = "" // ��ȡÿ�д���ʱ����ע�ͣ�Ҫ����sb������
        }
        i := 0
        for i < len(line) {
            if !inBlock && i+1<len(line) && line[i] == '/' && line[i+1] == '*' {
                inBlock = true // case1������ע����������/*���������������������ַ�������״̬����Ϊ��ע���У�����
                i++
            } else if inBlock && i+1<len(line) && line[i] == '*' && line[i+1] == '/' {
                inBlock = false // case2����ע����������*/���������������������ַ�������״̬����Ϊ����ע���У�����
                i++
            } else if !inBlock && i+1<len(line) && line[i] == '/' && line[i+1] == '/' {
                break; // case3������ע����������//���������ȼ�����Ը��е����ಿ��ֱ��break������
            } else if !inBlock {
                sb = sb + string(line[i]) // case4����Ч���룬��Ҫ��¼������
            }
            i++
        }
        if !inBlock && len(sb) > 0 { // ���м�¼�������ж��Ƿ���Ҫ��ӵ����������
            result = append(result, sb)
        }
    }
    return result
}