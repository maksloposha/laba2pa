import java.util.ArrayList;

public class Tree{
    private final Node root;
    public Node getRoot(){
        return root;
    }
    Tree(Node root){
        this.root = root;
    }
    public void generateBranch(Node parent, int index){
        if(index < 8){
        int col = parent.getPos().get(index);
        int startCol = col;                  // start column of queen
        do{                                 // creating children of the node by moving queen through the line
            ArrayList<Integer> child = new ArrayList<>(parent.getPos());
            if(col + 1 != startCol ){
                if(col + 1 <= 8) {
                    child.set(index, col + 1);
                    col++;
                    parent.addChild(new Node(child, index));
                }else {
                    if(startCol == 1) break;
                    child.set(index, 1);
                    col = 1;
                    parent.addChild(new Node(child, index));
                }
            }
            else break;
        } while (true);
        for(Node node: parent.getChildren()){
            generateBranch(node, index+1);
        }
        }
    }
}
