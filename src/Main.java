import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter 1 if you want to use LDFS algorithm and 2 if you want RBFS");
        Scanner scanner = new Scanner(System.in);
        int flag = scanner.nextInt();
        long startTime = System.currentTimeMillis();
        System.out.println("Start table:");
        ArrayList<Integer> startTable = generateTable();
        for(String item: getResult(startTable)){
            System.out.println(item);
        }
        System.out.println("\n\n");
        System.out.println("Result table:");
        if(flag == 1)
            for(String item: getResult(LDFS(startTable))){
                System.out.println(item);
            }
        else
            for(String item: getResult(RBFS(startTable))){
            System.out.println(item);
            }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
    public static ArrayList<Integer> generateTable(){
        ArrayList<Integer> startTable = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            startTable.add((int) ((Math.random() * (9 - 1)) + 1));
        }
        return startTable;
    }
    public static ArrayList<Integer> LDFS(ArrayList<Integer> startTable){
        Tree tree = new Tree(new Node(startTable, 0));
        tree.generateBranch(tree.getRoot(),0);
        LDFS ldfs = new LDFS(tree.getRoot());
        return ldfs.execute();
    }
    public static ArrayList<Integer> RBFS(ArrayList<Integer> startTable){
        Tree tree = new Tree(new Node(startTable, 0));
        tree.generateBranch(tree.getRoot(),0);
        RBFS rbfs = new RBFS(tree.getRoot());
        return rbfs.execute();
    }
    public static ArrayList<String> getResult(ArrayList<Integer> list){
        if(Objects.isNull(list)){
          ArrayList<String> res = new ArrayList<>();
          res.add("Cannot find the key");
          return res;
        }
        ArrayList<String> result = new ArrayList<>();
        for(Integer item: list){
            String str = "";
            for(int i = 0; i < 8; i++){
                if(item-1 != i){
                    str += "_";
                }else str += "Q";
            }
            result.add(str);
        }
        return result;
    }
}