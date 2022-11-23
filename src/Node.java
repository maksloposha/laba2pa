import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    private final ArrayList<Integer> pos;
    private final int depth;
    private final List<Node> children ;
    private int numOfConflicts;
    Node(ArrayList<Integer> pos, int depth){
        this.pos = pos;
        this.children = new ArrayList<>();
        this.numOfConflicts = 0;
        for(int i = 0; i < 8; i++){  // counting of conflicts in table
            for(int j = 0; j < 8; j++){
                if(i != j){
                    if(i+1 - pos.get(i) == j+1 - pos.get(j) || i+1 + pos.get(i) == j+1 + pos.get(j))
                        this.numOfConflicts++;
                    else if(Objects.equals(pos.get(i), pos.get(j)))
                        this.numOfConflicts++;
                }
            }
        }
        this.numOfConflicts /= 2;
        this.depth = depth;
    }
    public ArrayList<Integer> getPos(){
        return pos;
    }

    public int getNumOfConflicts() {
        return numOfConflicts;
    }

    public void addChild(Node child){
        children.add(child);
    }
    public List<Node> getChildren() {
        return children;
    }

    public int getDepth() {
        return depth;
    }
}
