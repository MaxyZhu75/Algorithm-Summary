var original string
var regular string

func isMatch(s string, p string) bool { // ���ӵĶ�̬�滮ת�Ʒ��̣��࿴�ٷ�����Լ���ˮ��Ҷ��֤��������
    original = s
    regular = p
    m, n := len(s), len(p)

    d := make([][]bool, m+1)
    for i:=0; i<=m; i++ {
        d[i] = make([]bool, n+1)
    }
    d[0][0] = true

    for i:=0; i<=m; i++ { // ϸ��һ����dp��ʱi��0��ʼ��j��1��ʼ������
        for j:=1; j<=n; j++ {
            if regular[j-1] == '*' { // case1������*�����÷��Ž���ƥ������ǰһ��Ԫ�أ���ƥ��ʱ��עǰһ��Ԫ�أ�����
                if matches(i, j-1) {
                    d[i][j] = d[i-1][j] || d[i][j-2] // ƥ��ɹ���ȡd[i-1][j]��������滻originalĩβ���ַ���ȡd[i][j-2]�����滻������
                } else {
                    d[i][j] = d[i][j-2] // case2���ǡ�*����ƥ��ʱ��ע��ǰԪ���Ƿ�ƥ�䣡����
                }
            } else { // case2���ǡ�*����ƥ��ʱ��ע��ǰԪ�أ�����
                if matches(i, j) {
                    d[i][j] = d[i-1][j-1]
                } else {
                    d[i][j] = false
                }
            }
        }
    }
    return d[m][n];
}

func matches(i int, j int) bool { // original����i���ַ�����regular����j���ַ���ƥ�����������
    if i == 0 {
        return false // case1��original��Ϊ�����Ȼ�޷�ƥ�䣡����
    }

    if regular[j-1] == '.' {
        return true // case2: "." ����ƥ��������ĸ������
    }

    return original[i-1] == regular[j-1] // case3��������ĸ������ȣ�����
}