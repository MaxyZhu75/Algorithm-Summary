var original string
var regular string

func isMatch(s string, p string) bool { // ���ӵĶ�̬�滮ת�Ʒ��̣��࿴���ٷ�����Լ���ˮ��Ҷ��֤��������
    original = s
    regular = p
    m, n := len(s), len(p)

    d := make([][]bool, m+1) // original��i���ַ���regular��j���ַ�ƥ�����������
    for i:=0; i<=m; i++ {
        d[i] = make([]bool, n+1)
    }
    d[0][0] = true

    for i:=0; i<=m; i++ {                               // Ҫ��һ����dp��ʱi��0��ʼ��j��1��ʼ������
        for j:=1; j<=n; j++ {
            if regular[j-1] == '*' {                    // case1��regular��j���ַ�Ϊ * ������
                if matches(i, j-1) { 				    // ע�⣺��ʹ�ܹ�ƥ�� * Ҳ����ѡ���滻���滻0���ַ���������
                    d[i][j] = d[i-1][j] || d[i][j-2]    // �ܹ�ƥ�䣬ȡd[i-1][j]��������滻originalĩβ���ַ����˴�����ö����ǰ�滻���ٸ��ַ���ȡdp�� * ��������µ�ǰһ��״̬���ɣ���ȡd[i][j-2]���� * �滻original���0���ַ�������
                } else {
                    d[i][j] = d[i][j-2]					// ���ܹ�ƥ�䣬ȡd[i][j-2]���� * �滻original���0���ַ�������
                }
            } else {                         		    // case2��regular��j���ַ�Ϊ��ĸ�� "." ������
                if matches(i, j) {
                    d[i][j] = d[i-1][j-1]				// ȡd[i-1][j-1]��������ͨ�ַ�����*��ƥ��ɹ�������
                } else {
                    d[i][j] = false					    // ������ͨ�ַ�����*��ƥ�䲻�ɹ�������
                }
            }
        }
    }
    return d[m][n];
}

func matches(i int, j int) bool {
    if i == 0 {
        return false // case1��original��Ϊ�����Ȼ�޷�ƥ�䣡����
    }

    if regular[j-1] == '.' { // case2: "." ����ƥ��������ĸ������
        return true
    }

    return original[i-1] == regular[j-1] // case3��������ĸ������ȣ�����
}