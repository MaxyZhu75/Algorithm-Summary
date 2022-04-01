/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Left *Node
 *     Right *Node
 * }
 */

var head *Node // 链表头节点！！！
var tail *Node // 链表尾结点！！！

func treeToDoublyList(root *Node) *Node { // 中序遍历递归解决！！！
    if root == nil {
        return nil
    }
    head, tail = nil, nil
    inoerderTraversal(root)
    head.Left = tail // 循环链表：将头节点和尾节点连上！！！
    tail.Right = head
    return head
}

func inoerderTraversal(root *Node) { // 中序遍历：左根右！！！
    if root == nil {
        return
    }
    
    inoerderTraversal(root.Left)

    if tail == nil {
        head = root // 首次进入递归时记录root为头节点！！！
    } else {
        root.Left = tail // 双向链表：双向的指针链接！！！
        tail.Right = root
    }
    tail = root // 每层递归更新尾节点！！！

    inoerderTraversal(root.Right)
}