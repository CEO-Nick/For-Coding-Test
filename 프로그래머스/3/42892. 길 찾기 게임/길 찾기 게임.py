import sys
sys.setrecursionlimit(10**6)

class node:
    def __init__(self, info):
        self.number = info[2]
        self.data = info[:2]
        self.left = None
        self.right = None
        
def addNode(root, info):
    if info[0] > root.data[0]:
        if not root.right: root.right = node(info)
        else: addNode(root.right, info)
    elif info[0] < root.data[0]:
        if not root.left: root.left = node(info)
        else: addNode(root.left, info)
    
def solution(nodeinfo):
    answer = [[], []]
    nodeidx = dict()
    
    # 노드 번호를 nodeinfo에 추가하기
    for idx, info in enumerate(nodeinfo):
        info.append(idx+1)
    
    # 노드 정렬하기
    nodeinfo.sort(key=lambda x:(-x[1], x[0]))
    
    # 이진 트리 만들기
    root = node(nodeinfo[0])
    for info in nodeinfo[1:]:
        addNode(root, info)
        
    
    # 전위 순회
    def preorder(root, order):
        if root != None:
            order.append(root.number)
            preorder(root.left, order)
            preorder(root.right, order)

    # 후위 순회
    def postorder(root, order):
        if root != None:
            postorder(root.left, order)
            postorder(root.right, order)
            order.append(root.number)
            
    
    preorder(root, answer[0])
    postorder(root, answer[1])
    return answer