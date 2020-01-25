import java.util.Iterator;

import Tree.LinkedBinaryTree;

class run {
    public static void main(String[] args) {
        LinkedBinaryTree<Integer> temp = new LinkedBinaryTree<>();
        try {
            temp.addRoot(1188);
            temp.insertLeft(temp.root(), 11);
            temp.insertRight(temp.root(),88);
            Iterator it = temp.iterator();
            for (Integer integer : temp) {
                System.out.println(integer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}

