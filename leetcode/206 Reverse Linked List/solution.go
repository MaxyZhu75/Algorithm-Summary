/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseList(head *ListNode) *ListNode {
    var previous, current *ListNode = nil, head // 经典方法：头插法，定义previous, current, nextNode三个变量解决！！！
    for (current != nil) {
        var nextNode *ListNode = current.Next // nextNode即下次待处理的节点，局部变量暂时存储！！！
        current.Next = previous // ListNode.Next在等号左边被定义时，可以确定指针指向，相当于与等号右边连接（此处右边为链表先前已反转的部分）！！！
        previous = current // 此时current结点已经反转地与先前处理过的链表连接，则存入previous！！！
        current = nextNode // 后移至下次循环的待处理节点！！！
    }
    return previous // 返回的是已处理的链表previous！！！
}