/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
    if list1 == nil {  // ���ұ߽磡����
        return list2
    }
    if list2 == nil {
        return list1
    }
    var mergedList *ListNode = nil  // �����µĺϲ������������
    if list1.Val < list2.Val {  // ע��ListNode��������ָ��ָ���׵�ַ���ݣ�����
        mergedList = list1  // ���ݲ�ͬ�����ʼ��������
        mergedList.Next = mergeTwoLists(list1.Next, list2)  // recursion������
    } else {
        mergedList = list2
        mergedList.Next = mergeTwoLists(list1, list2.Next)
    }
    return mergedList
}