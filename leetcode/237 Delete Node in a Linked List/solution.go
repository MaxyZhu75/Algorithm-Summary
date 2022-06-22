/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func deleteNode(node *ListNode) { // 由于无法访问head，必然无法知道前驱节点；只能伪装成儿子，跳过儿子直接养孙子！！！
    node.Val = node.Next.Val
    node.Next = node.Next.Next
}