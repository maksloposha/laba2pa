import java.util.ArrayList;
import java.util.Stack;

public class LDFS {

    Node sourceNode;
    int limit = 6;

    public LDFS(Node source){
        this.sourceNode = source;
    }

    public ArrayList<Integer> execute(){
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.add(sourceNode);

        while(!nodeStack.isEmpty()) {
            Node current = nodeStack.pop();
            if(current.getDepth() <= limit) {
            if (current.getNumOfConflicts() == 0) {
                System.out.println("Goal node found in depth " + current.getDepth());
                return current.getPos();
            } else {
                    nodeStack.addAll(current.getChildren());
                }
            }
        }
        System.out.println("Goal node not found within depth limit");
        return null;
    }
}

