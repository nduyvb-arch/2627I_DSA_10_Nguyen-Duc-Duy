package week9;


class GeneralTreeArray{
    public static class Node{
        String data;
        int parent;
        int firstchild;
        int nextsibling;

        public Node(String data) {
            this.data = data;
            this.parent = -1;
            this.firstchild = -1;
            this.nextsibling = -1;
        }
    }
    private Node[] tree;

    public GeneralTreeArray(int size){
        tree = new Node[size];
    }

    public void setNode(int index, String data, int parentIndex){
        if(index < 0 || index >= tree.length) return;
        tree[index] = new Node(data);
        tree[index].parent = parentIndex;

        if(parentIndex != -1){
            if(tree[parentIndex].firstchild == -1) tree[parentIndex].firstchild = index;
            else{
                int current = tree[parentIndex].firstchild;
                while(tree[current].nextsibling != -1){
                    current = tree[current].nextsibling;
                }
                tree[current].nextsibling = index;
            }
        }
    }

    public int getParent(int index){
        return tree[index].parent;
    }

    public int getFirstChild(int index){
        return tree[index].firstchild;
    }

    public int getnextSibling(int index){
        return tree[index].nextsibling;
    }
    public void printTree() {
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                System.out.println("Index " + i + " [Data: " + tree[i].data +
                        "] -> Parent: " + tree[i].parent +
                        ", FirstChild: " + tree[i].firstchild +
                        ", NextSibling: " + tree[i].nextsibling);
            }
        }
    }

}
public class w9_Tailop_25021693 {
    public static void main(String[] args){
                int totalSize = 7;
                GeneralTreeArray tree = new GeneralTreeArray(totalSize);

                tree.setNode(0, "A", -1);
                tree.setNode(1, "B", 0);
                tree.setNode(2, "C", 0);
                tree.setNode(3, "D", 0);
                tree.setNode(4, "E", 1);
                tree.setNode(5, "F", 1);
                tree.setNode(6, "G", 2);
                tree.printTree();
        }
}
