/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeNthFromEnd(head *ListNode, n int) *ListNode { // ����˫ָ���������ȷ���������λ�ã�����
    p1, p2 := head, head
    for i:=0; i<n; i++ { // ��ϵʵ����֪��p2����n��������p1��p2һ���ߣ�ֱ��p2����ĩβ�����Ա�֤p1��ָ������ԭ����ĵ�����n+1���ڵ㣡����
        p2 = p2.Next
    }

    if p2 == nil { // Ҫ�㣺�����ƽڵ������£��˴�����ͨ���÷�ʽ�ж���Ҫɾ���Ľڵ��Ƿ�Ϊͷ�ڵ㣻����Ҫɾ������ͷ��㣬��ֱ�ӷ���head.next������
        return head.Next
    }

    for (p2.Next != nil) { // ����p1��ָ������ԭ����ĵ�����n+1���ڵ㣬�˴�����headִ��ɾ��������n���ڵ�Ĳ������÷�ʽ����ɾ��ͷ��㣬ӦԤ�ȶ��Ƿ�ɾ��ͷ�������жϺʹ���������
        p2 = p2.Next
        p1 = p1.Next
    }
    
    p1.Next = p1.Next.Next
    
    return head
}