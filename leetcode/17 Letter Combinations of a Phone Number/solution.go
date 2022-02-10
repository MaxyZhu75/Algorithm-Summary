var result []string // ���ݾ�����Ŀ����������DFS���⣬��Ҫͳ��������ϵĸ������ʱ���û��ݽ��������
var sb string // Ҫ��һ���ɽ������������ǰ����������

func letterCombinations(digits string) []string {
    result = []string{}
    sb = "" 
    if len(digits) == 0 {
        return result
    }
    dfsBackTrack(digits)
    return result
}

func dfsBackTrack(digits string) { // �޷���ֵ��ֱ�ӶԶ���Ľ����������������
    letters := [10]string {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}

    if len(sb) == len(digits) { // �ݹ����ҳ��ڣ�����
        result = append(result, sb)
        return
    }

    position := len(sb) // ���ɾ��ĩβ��ĸʱ������position��������ʾsb.length()����Ϊ�ݹ��ı��������Ѿ���һ������һ��ҪС�ģ�����
    curretDigit := digits[position] - '0'
    curretletters := letters[curretDigit]
    for i:=0; i<len(curretletters); i++ { // Ҫ�����DFS�ƶ������а���������Ҫ�����裬�ұ��밴˳��ִ�У�����
        sb = sb + string(curretletters[i]) // ����һ������ѷ��ʣ�������Ҫ��sb.length()���ƣ������ĸ��sb���ȸı䣬�൱�ڱ�Ƿ��ʣ�����
        dfsBackTrack(digits) // �������dfs���µݹ飡����
        sb = sb[:len(sb)-1] // �����������δ���ʣ�������Ҫ��sb.length()���ƣ�ɾ�����һ����ĸ��sb���ȸı䣬�൱�ڱ��δ���ʣ�����
    }
}