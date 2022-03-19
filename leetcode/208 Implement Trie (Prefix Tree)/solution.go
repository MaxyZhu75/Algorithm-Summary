type Trie struct { // Trie�ֵ���struct������
    children [26]*Trie // �����ӽڵ�����Ϊ26��Сд��ĸ������
    isEnd bool // ��ʾ�Ƿ�Ϊ�ַ����Ľ�β������
}

func Constructor() Trie { // Trie���캯��������
    return Trie{}
}

func (t *Trie) Insert(word string) { // ����һ�������ַ���������
    node := t
    for _, letter := range word {
        index := letter - 'a'
        if node.children[index] == nil {
            node.children[index] = &Trie{} // ��Ϊ�գ���û�и�·���������½ڵ㣡����
        }
        node = node.children[index] // ��Ȼ������Ǳ������
    }
    node.isEnd = true // ������������isEndΪtrue������
}

func (t *Trie) SearchPrefix(prefix string) *Trie { // ������������ǰ׺������
    node := t
    for _, letter := range prefix {
        index := letter - 'a'
        if node.children[index] == nil { // case1����Ϊ�գ���û�и�·����ֱ�ӷ���null������
            return nil
        } else {
            node = node.children[index] // case2��·�����ڣ�������Ǳ������
        }
    }
    return node
}

func (t *Trie) Search(word string) bool {
    node := t.SearchPrefix(word)
    return node != nil && node.isEnd
}

func (t *Trie) StartsWith(prefix string) bool {
    return t.SearchPrefix(prefix) != nil
}

/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */