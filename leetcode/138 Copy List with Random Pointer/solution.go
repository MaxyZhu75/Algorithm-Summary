/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Next *Node
 *     Random *Node
 * }
 */

func copyRandomList(head *Node) *Node { 方法二：迭代；空间为O(1)；三个循环对应官方解答的三张步骤示意图！！！
    if head == nil {
        return nil
    }
    
    for node := head; node != nil; node = node.Next.Next { // 创建拷贝节点并链接：从 A-B-C 到 A-A’-B-B’-C-C’ ！！！
        nodeCopy := Node{node.Val, node.Next, nil}
        node.Next = &nodeCopy
    }
    
    for node := head; node != nil; node = node.Next.Next { // 将拷贝链表各个节点的Random正确链接！！！
        nodeCopy := node.Next // 此处是指针，指向待操作的节点！！！
        if node.Random != nil {
            nodeCopy.Random = node.Random.Next
        } else {
            nodeCopy.Random = nil
        }
    }

    headCopy := head.Next // 存储待返回的拷贝头节点指针！！！
    for node := head; node != nil; node = node.Next { // 断开原链表与拷贝链表的指针，并各自正确独立链接：从 A-A’-B-B’-C-C’ 到 A-B-C 与 A’-B’-C’ ！！！
        nodeCopy := node.Next // 此处是指针，指向待操作的节点！！！
        node.Next = node.Next.Next
        if nodeCopy.Next != nil {
            nodeCopy.Next = nodeCopy.Next.Next
        } else {
            nodeCopy.Next = nil
        }
    }
    return headCopy
}