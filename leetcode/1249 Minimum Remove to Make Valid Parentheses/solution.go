func minRemoveToMakeValid(s string) string { // ������������������飻��ɾ�������ţ���ɾ���ұ�δƥ��������ţ�����
    tempResult := []byte{}
    leftSum := 0 // ��¼����������������
    leftRemain := 0 // ��¼��ƥ������������������
    
    for i:=0; i<len(s); i++ {
        if s[i] == '(' { // �����Ž���ͳ�ƣ�����
            leftSum++
            leftRemain++
        } else if s[i] == ')' { // �����ŷ������������
            if leftRemain == 0 {
                continue // case1��û�д�ƥ��������ţ���ֱ��continue���൱�ڽ���������ɾ����δappend��������
            } else {
                leftRemain-- // case2��ƥ��ɹ�����ƥ��������������1������
            }
        }
        tempResult = append(tempResult, s[i])
    }

    result := []byte{}
    leftNum := leftSum - leftRemain // ������Ҫ��ӵ�����������������
    for i:=0; i<len(tempResult); i++ {
        if (tempResult[i] == '(') {
            if leftNum == 0 { // ��������������ţ��൱�ڽ������ұ߳��ֵ������Ŷ��ᱻɾ��������
                continue
            } else {
                leftNum--
            }
        }
        result = append(result, tempResult[i])
    }

    return string(result)
}