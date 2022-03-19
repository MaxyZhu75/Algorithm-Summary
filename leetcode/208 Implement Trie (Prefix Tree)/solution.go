type Trie struct { // Trie字典树struct！！！
    children [26]*Trie // 本题子节点数组为26个小写字母！！！
    isEnd bool // 表示是否为字符串的结尾！！！
}

func Constructor() Trie { // Trie构造函数！！！
    return Trie{}
}

func (t *Trie) Insert(word string) { // 方法一：插入字符串！！！
    node := t
    for _, letter := range word {
        index := letter - 'a'
        if node.children[index] == nil {
            node.children[index] = &Trie{} // 若为空，则没有该路径，创建新节点！！！
        }
        node = node.children[index] // 必然继续下潜！！！
    }
    node.isEnd = true // 遍历结束后，置isEnd为true！！！
}

func (t *Trie) SearchPrefix(prefix string) *Trie { // 方法二：查找前缀！！！
    node := t
    for _, letter := range prefix {
        index := letter - 'a'
        if node.children[index] == nil { // case1：若为空，则没有该路径，直接返回null！！！
            return nil
        } else {
            node = node.children[index] // case2：路径存在，继续下潜！！！
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