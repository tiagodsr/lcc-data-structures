import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BTree<T> {   
    private BTNode<T> root; // raiz da arvore
 
    // Construtor
    BTree() {
       root = null;
    }
 
    // Getter e Setter para a raiz
    public BTNode<T> getRoot() {return root;}
    public void setRoot(BTNode<T> r) {root = r;}
 
    // Verificar se arvore esta vazia
    public boolean isEmpty() {
       return root == null;
    }
 
    // --------------------------------------------------------
 
    // Numero de nos da arvore   
    public int numberNodes() {
       return numberNodes(root);
    }
 
    private int numberNodes(BTNode<T> n) {
       if (n == null) return 0;
       return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }
 
    // --------------------------------------------------------
 
    // Altura da arvore
    public int depth() {
       return depth(root);
    }
 
    private int depth(BTNode<T> n) {
       if (n == null) return -1;
       return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }
 
    // --------------------------------------------------------
    
    // O elemento value esta contido na arvore?
    public boolean contains(T value) {
       return contains(root, value);
    }
 
    private boolean contains(BTNode<T> n, T value) {
       if (n==null) return false;
       if (n.getValue().equals(value)) return true;
       return contains(n.getLeft(), value) || contains(n.getRight(), value);
    }
 
    // --------------------------------------------------------
 
    // Imprimir arvore em PreOrder
    public void printPreOrder() {
       System.out.print("PreOrder:");
       printPreOrder(root);
       System.out.println();
    }
 
    private void printPreOrder(BTNode<T> n) {
       if (n==null) return;
       System.out.print(" " + n.getValue() );
       printPreOrder(n.getLeft());
       printPreOrder(n.getRight());
    }
 
    // --------------------------------------------------------
    
    // Imprimir arvore em InOrder
    public void printInOrder() {
       System.out.print("InOrder:");
       printInOrder(root);
       System.out.println();
    }
 
    private void printInOrder(BTNode<T> n) {
       if (n==null) return;
       printInOrder(n.getLeft());
       System.out.print(" " + n.getValue());
       printInOrder(n.getRight());
    }
 
    // --------------------------------------------------------
 
    // Imprimir arvore em PostOrder
    public void printPostOrder() {
       System.out.print("PostOrder:");
       printPostOrder(root);
       System.out.println();
    }
 
    private void printPostOrder(BTNode<T> n) {
       if (n==null) return;
       printPostOrder(n.getLeft());
       printPostOrder(n.getRight());
       System.out.print(" " + n.getValue());
    }
 
    // --------------------------------------------------------
 
    // Imprimir arvore numa visita em largura (usando TAD Fila)
    public void printBFS() {
       System.out.print("BFS:");
       
       MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
       q.enqueue(root);
       while (!q.isEmpty()) {
          BTNode<T> cur = q.dequeue();
          if (cur != null) {
             System.out.print(" " + cur.getValue());
             q.enqueue(cur.getLeft());
             q.enqueue(cur.getRight());
          }
       }
       System.out.println();
    }
 
    // --------------------------------------------------------
    
    // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
    public void printDFS() {
       System.out.print("DFS:");
       
       MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
       q.push(root);
       while (!q.isEmpty()) {
          BTNode<T> cur = q.pop();
          if (cur != null) {
             System.out.print(" " + cur.getValue());
             q.push(cur.getLeft());
             q.push(cur.getRight());
          }
       }
       System.out.println();
    }

    // TREINO TESTE PRÁTICO 2 //

    // -----------------------------------------------------------------------------------------------------------------------------//

    // ED204 Contando folhas
    public int numberLeafs(){
      return numberLeafs(root);
    }

    private int numberLeafs(BTNode<T> n){
      if (n == null) return 0;
      else if (n.getLeft() == null && n.getRight()== null){
         return 1;
      }
      return numberLeafs(n.getLeft()) + numberLeafs(n.getRight());
    }

    // ED205 Árvores Estritamente Binárias

    public boolean strict(){
      return strict(root);
    }

    private boolean strict(BTNode<T> n){
      if (n == null) return true;
      if (n.getLeft() == null && n.getRight() == null){
         return true;
      }
      if (n.getLeft() != null && n.getRight() != null){
         return strict(n.getLeft()) && strict(n.getRight());
      }
      else return false;
    }

    // ED206 Percorrendo caminhos

    public T path(String s){
      return path(root, s);
    }

    private T path(BTNode<T> n, String path){
      if (path.isEmpty()){
         return n.getValue();
      }
      char direcao = path.charAt(0);
      if (direcao == 'R'){
         return path(root, path.substring(1));
      }
      else if (direcao == 'E' && n.getLeft()!= null){
         return path(n.getLeft(), path.substring(1));
      } 
      else if (direcao == 'D' && n.getRight() != null){
         return path(n.getRight(), path.substring(1));
      }
      return null;
    }

    // ED207 Nós Profundos

    public int nodesLevel(int k){
      return nodesLevel(root, k);
    }

    private int nodesLevel(BTNode<T> n, int k){
      if (n == null) return 0;
      if (k == 0) return 1;
      else{
         return nodesLevel(n.getLeft(),(k-1)) + nodesLevel(n.getRight(),(k-1));
      }

    }

    // ED233 Árvores na Terra dos Dados

    // Devolver a quantidade de nós internos ou seja os nós com pelo menos um filho

    public int internal(){
      return internal(root);
    }

    private int internal(BTNode<T> n){
      if (n == null) return 0;
      if (n.getLeft() != null || n.getRight() != null){
         return 1 + internal(n.getLeft()) + internal(n.getRight());
      }
      return 0;
    }

    // Remover da árvore todos os nós com profundidade ≥d

    public void cut (int d){
      if (d <= 0){
         root = null;
         return;
      }
      cut(root,d,0);
    }

    private void cut(BTNode<T> n,int d, int level){
      if (n == null){
         return;
      }
      if (level != d-1){
         cut(n.getLeft(), d, level + 1);
         cut(n.getRight(), d, level + 1);
      }
      else {
         n.setLeft(null);
         n.setRight(null);
      }
    }

    // Devolver um array [a,b] onde a é a quantidade máxima de nós num único
    // nível de profundidade, e b é a quantidade de níveis com essa quantidade a de nós

   public int[] maxLevel() {
    List<Integer> levelCounts = new ArrayList<>();
    maxLevel(root, 0, levelCounts);

    int maxNodes = 0;
    int levelsWithMaxNodes = 0;

    for (int count : levelCounts) {
        if (count > maxNodes) {
            maxNodes = count;
            levelsWithMaxNodes = 1;
        } else if (count == maxNodes) {
            levelsWithMaxNodes++;
        }
    }
    return new int[]{maxNodes, levelsWithMaxNodes};
   }

   private void maxLevel(BTNode<T> n, int level, List<Integer> levelCounts) {
      if (n == null) return;
      if (levelCounts.size() <= level) {
         levelCounts.add(0);
      }
      levelCounts.set(level, levelCounts.get(level) + 1);
      maxLevel(n.getLeft(), level + 1, levelCounts);
      maxLevel(n.getRight(), level + 1, levelCounts);
   }


   // ED239 Métodos para Árvores Binárias

   // Deve devolver a quantidade de nós que são filhos únicos

   public int count(){
      return count(root);
   }

   private int count(BTNode<T> n){
      if (n == null) return 0;
      if (n.getLeft() != null && n.getRight() == null) return 1 + count(n.getLeft());
      if (n.getLeft() == null && n.getRight() != null) return 1 + count(n.getRight());
      return count(n.getLeft()) + count(n.getRight());
   }

   // Deve devolver o nível de altura mais baixo 
   // (mais próximo da raíz) onde é possível encontrar um nó com valor v.

   public int level(T v){
      return level(root,v,0);
   }

   private int level(BTNode<T> n, T v, int currentLevel){
      if (n == null) return -1;
      if (n.getValue().equals(v)) return currentLevel;

      int leftLevel = level(n.getLeft(), v, currentLevel + 1);
      int rightLevel = level(n.getRight(), v, currentLevel + 1);

      if (leftLevel == -1) return rightLevel;
      if (rightLevel == -1) return leftLevel;
      return Math.min(leftLevel,rightLevel);
   }

   // O menor valor de cada nível de uma árvore 

   public static int[] mins(BTree <Integer> t){
      int[] arr = new int[t.depth()];
      for(int i=0 ; i< arr.length; i++){
         arr[i] = Integer.MAX_VALUE;
      }
      check (t.getRoot(),0,arr);
      return arr;
   }

   private static void check (BTNode <Integer> n, int lvl, int[] arr){
      if (n == null) return;
      if (n.getValue() < arr[lvl] ) arr[lvl] = n.getValue();
      check(n.getLeft(), lvl+1, arr);
      check(n.getRight(), lvl+1, arr);
   }

   // Contar o número total de nós com valores pares

   public static int countEven(BTree<Integer> t){
      return countEven(t.root);
   }

   private static int countEven(BTNode<Integer> n){
      if (n == null){
         return 0;
      }
      if (n.getValue() % 2 == 0){
         return 1 + countEven(n.getLeft()) + countEven(n.getRight());
      }
      return countEven(n.getLeft()) + countEven(n.getRight());
   }
  
  // Podando uma árvore

   public static int[] prune(BTree<Integer> t) {
      if (t == null || t.isEmpty()) {
         return new int[0];
      }
      List<Integer> removedLeaves = new ArrayList<>();
      t.setRoot(prune(t.getRoot(), removedLeaves)); 

      int[] result = new int[removedLeaves.size()];
      for (int i = 0; i < removedLeaves.size(); i++) {
         result[i] = removedLeaves.get(i);
      }
      return result;
   }

   private static BTNode<Integer> prune(BTNode<Integer> node, List<Integer> removedLeaves) {
      if (node == null) return null;

      if (node.getLeft() == null && node.getRight() == null) {
         removedLeaves.add(node.getValue());
         return null;
      }

      // Decrementa o valor do nó atual
      node.setValue(node.getValue() - 1);
      // Chamada recursiva para os filhos esquerdo e direito
      node.setLeft(prune(node.getLeft(), removedLeaves));
      node.setRight(prune(node.getRight(), removedLeaves));
      return node;
   }
}

