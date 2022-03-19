/**
 * Definition for Node.
 * type Node struct {
 *     Val int
 *     Left *Node
 *     Right *Node
 *     Parent *Node
 * }
 */

func lowestCommonAncestor(p *Node, q *Node) *Node { // 方法二：双指针；LeetCode160题相交链表的二叉树版本！！！
    p1, p2 := p, q
    for p1 != p2 {
        if p1 == nil {
            p1 = q
        } else {
            p1 = p1.Parent
        }
        if p2 == nil {
            p2 = p
        } else {
            p2 = p2.Parent
        }
    }
    return p1;
}