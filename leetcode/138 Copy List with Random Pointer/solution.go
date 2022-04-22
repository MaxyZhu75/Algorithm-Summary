/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Next *Node
 *     Random *Node
 * }
 */

func copyRandomList(head *Node) *Node { ���������������ռ�ΪO(1)������ѭ����Ӧ�ٷ��������Ų���ʾ��ͼ������
    if head == nil {
        return nil
    }
    
    for node := head; node != nil; node = node.Next.Next { // ���������ڵ㲢���ӣ��� A-B-C �� A-A��-B-B��-C-C�� ������
        nodeCopy := Node{node.Val, node.Next, nil}
        node.Next = &nodeCopy
    }
    
    for node := head; node != nil; node = node.Next.Next { // ��������������ڵ��Random��ȷ���ӣ�����
        nodeCopy := node.Next // �˴���ָ�룬ָ��������Ľڵ㣡����
        if node.Random != nil {
            nodeCopy.Random = node.Random.Next
        } else {
            nodeCopy.Random = nil
        }
    }

    headCopy := head.Next // �洢�����صĿ���ͷ�ڵ�ָ�룡����
    for node := head; node != nil; node = node.Next { // �Ͽ�ԭ�����뿽�������ָ�룬��������ȷ�������ӣ��� A-A��-B-B��-C-C�� �� A-B-C �� A��-B��-C�� ������
        nodeCopy := node.Next // �˴���ָ�룬ָ��������Ľڵ㣡����
        node.Next = node.Next.Next
        if nodeCopy.Next != nil {
            nodeCopy.Next = nodeCopy.Next.Next
        } else {
            nodeCopy.Next = nil
        }
    }
    return headCopy
}