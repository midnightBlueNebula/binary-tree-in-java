class BinaryTree {
  Integer root;
  BinaryTree left;
  BinaryTree right;
  
  public BinaryTree(int _root, int _left, int _right) {
    root = _root;
    left = new BinaryTree(_left);
    right = new BinaryTree(_right);
  }

  public BinaryTree(int _root) {
    root = _root;
  }

  public void add(int val){
    BinaryTree current = this;
    
    while(current != null){
      if(val == current.root){
        current = null;
      } else if(val > current.root){
        if(current.right == null){
          current.right = new BinaryTree(val);
          current = null;
        } else {
          current = current.right;
        }
      } else if(val < current.root){
        if(current.left == null){
          current.left = new BinaryTree(val);
          current = null;
        } else {
          current = current.left;
        }
      } else if(current.root == null){
        current.root = val;
      }
    }
  }

  public void delete(int val){
    BinaryTree current = this.find(val);
    if(current == null){
      System.out.println("Value does not exists in binary tree.");
    } else {
      if(current.left != null){
        current.root = current.left.root;
        current.left = current.left.left;
        current.right = current.left.right;
      } else if(current.right != null){
        current.root = current.right.root;
        current.left = current.right.left;
        current.right = current.right.right;
      } else {
        current.root = null;
      }
    }
  }

  public BinaryTree find(int val){
    BinaryTree current = this;

    while (current != null && current.root != null){
      if(val == current.root){
        return current;
      } else if(val < current.root){
        current = current.left;
      } else {
        current = current.right;
      }
    }

    return current;
  }

  public static void printLevels(BinaryTree node){
    int height = BinaryTree.height(node);

    for(int i = 1; i <= height; ++i){
      System.out.printf("%d. level -> ", i);
      printCurrentLevel(node, i);
      System.out.println("");
    }
  }

  private static void printCurrentLevel(BinaryTree node, int level){
    if(node != null && node.root != null){
      if(level == 1){
        System.out.printf("%d ", node.root);
      } else if(level > 1){
        printCurrentLevel(node.left, level-1);
        printCurrentLevel(node.right, level-1);
      }
    }
  }

  public static int height(BinaryTree node){
    if(node == null || node.root == null){
      return 0;
    } else {
      int l = height(node.left);
      int r = height(node.right);
      
      return l > r ? l + 1 : r + 1;
    }
  }
}

class Main {  
  public static void main(String args[]) {
    BinaryTree tree = new BinaryTree(100,80,120);
    
    tree.add(30);
    tree.add(150);
    tree.add(90);
    tree.add(115);
    BinaryTree.printLevels(tree);
  } 
}
