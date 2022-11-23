import java.util.ArrayList;

public class RBFS {
    private final ArrayList<Node> priorityQueue = new ArrayList<>();
    private final ArrayList<Node> visited = new ArrayList<>();
    RBFS(Node root){
        priorityQueue.add(root);
    }
    protected Node pollFromQueue(){
        int min = priorityQueue.get(0).getNumOfConflicts();
        int index = 0;
        for(int i = 1; i < priorityQueue.size(); i++){
            if(priorityQueue.get(i).getNumOfConflicts() < min){
                min = priorityQueue.get(i).getNumOfConflicts();
                index = i;
            }
        }
        return priorityQueue.remove(index);
    }
    public ArrayList<Integer> execute(){
        if(priorityQueue.size() > 0 && priorityQueue.size() < 4400){ // if priority queue size is bigger than 4400 the
                                                                    // error of heap overload takes place
            Node node = pollFromQueue();
            if(isNotVisited(node)){
                visited.add(node);
                if(node.getNumOfConflicts() == 0) {
                    System.out.println("The depth is " + node.getDepth());
                    return node.getPos();
                }
                else{
                    priorityQueue.addAll(node.getChildren());
                    return execute();
                }
            }else return null;
        }else return null;
    }
    private boolean isNotVisited(Node node){
        for(Node visitedNode: visited){
            if (visitedNode.getPos().equals(node.getPos()))
                return false;
        }
        return true;
    }


}
