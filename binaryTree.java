class BinaryTree {
  int root;
  BinaryTree left;
  BinaryTree right;
  
  public BinaryTree(int _root, BinaryTree _left, BinaryTree, _right) {
    root = _root;
    left = new BinaryTree(_left);
    right = new BinaryTree(_right);
  }

  public BinaryTree(int _root) {
    root = new BinaryTree(_root);
  }

  public static void printLevels(Binarytree node){
    int height = BinaryTree.height(node);

    for(int i = 1; i <= height; ++i){
      System.out.printf("%d. level -> ", i);
      printCurrentLevel(node, i);
      System.out.println("");
    }
  }

  private void printCurrentLevel(Binarytree node, int level){
    if(node != null){
      if(level == 1){
        System.out.printf("%d ", node.root);
      } else if(level > 1){
        printCurrentLevel(node.left, level-1);
        printCurrentLevel(node.right, level-1);
      }
    }
  }

  public static int height(Binarytree node){
    if(node == null){
      return 0;
    } else {
      int l = height(node.left);
      inr r = height(node.right);
      
      return l > r ? l + 1 : r + 1;
    }
  }
}

class Main {  
  public static void main(String args[]) { 
    System.out.println(""); 
  } 
}
