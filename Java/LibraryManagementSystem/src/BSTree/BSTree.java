package BSTree;


import LinkedList.LinkedList;

public class BSTree<E extends Comparable<E>> {
    public class Node {

        public E info;
        public Node left, right;

        public Node(E x) {
            info = x;
            left = right = null;
        }
    }
        
    private Node root;

    public BSTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public void clear() {
        root = null;
    }

    public Node search(Node p, E x) {
        if (p == null) {
            return (null);
        }
        if (x.compareTo(p.info)==0) {
            return (p);
        }
        if (x.compareTo(p.info)<0) {
            return (search(p.left, x));
        } else {
            return (search(p.right, x));
        }
    }

    public void insert(E x) {
        if (root == null) {
            root = new Node(x);
            return;
        }
        Node f, p;
        p = f = root;

        while (p != null) {
            if (p.info.compareTo(x)==0) {  //sua dong nay
                return;
            }
            f = p;
            if (x.compareTo(p.info)<0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (x.compareTo(f.info)<0) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
    }
    
    public Node deleteByCopy(Node root, E x) {
        if (root == null) {
            return root;
        }

        if (root.info.compareTo(x) > 0) {
            root.left = deleteByCopy(root.left, x);
        } else if (root.info.compareTo(x) < 0) {
            root.right = deleteByCopy(root.right, x);
        } else {
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            Node temp = getMaxOfLeft(root);
            root.info = temp.info;
            root.left = deleteByCopy(root.left, temp.info);
        }
        return root;
    }
    
    public Node getMaxOfLeft(Node curr) {
        curr = curr.left;
        while (curr != null && curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }  
    
    public void toArray(Node p, LinkedList<Node> a) {
        if (p == null) {
            return;
        }
        toArray(p.left, a);
        a.add(p);
        toArray(p.right, a);
    }

    public void breadth() {
        if (root == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p = root;
        while (!q.isEmpty()) {
            try {
                p = (Node) q.dequeue();
            } catch (Exception ex) {
            }
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
            System.out.println(p.info);
        }
    }
    
    public void balance() {
        root = balanceTree(root);
    }

    public Node balanceTree(Node node) {
        if (node == null) {
            return null;
        }

        node.left = balanceTree(node.left);
        node.right = balanceTree(node.right);
        
        int balanceFactor = height(node.left) - height(node.right);

        if (balanceFactor > 1) {
            if (height(node.left.left) < height(node.left.right)) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }

        if (balanceFactor < -1) {
            if (height(node.right.right) < height(node.right.left)) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }
        return node;
    }
    
    public int count(Node p) {
        if (p == null) {
            return 0;
        }
        return 1 + count(p.left) + count(p.right);
    }
    
    public int size(){
        return count(root);
    }
    
    public E get(int i){
        LinkedList<Node> bll = new LinkedList<>();
        toArray(getRoot(), bll);
        return bll.get(i).info;
    }
    
    Node rotateLeft(Node p) {
        if (p == null || p.right == null) {
            return p;
        }
        Node c = p.right;
        p.right = c.left;
        c.left = p;
        return c;
    }
   
    Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            return p;
        }
        Node c = p.left;
        p.left = c.right;
        c.right = p;
        return c;
    }
    
    int height(Node p) {
        if (p == null) {
            return 0;
        }
        return 1 + Math.max(height(p.left), height(p.right));
    }
    
    public Node getNode(int i){
        LinkedList<Node> bll = new LinkedList<>();
        toArray(getRoot(), bll);
        return bll.get(i);
    }
}
