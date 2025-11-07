
class BinTreeNodeInt {
    int data;
    BinTreeNodeInt left; // izquierda
    BinTreeNodeInt right; // derecha

    BinTreeNodeInt(int value) {// Constructor
        data = value;
        left = null;
        right = null;
    }
}

public class BinTreeInt {

    private BinTreeNodeInt root;

    public BinTreeInt() {
        root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    // Valida el nodo, si no tienen nada lo coloca ahí, sino valida el siguiente nodo (hoja), dependiendo del valor
    // que tenga left o right y como están nulos lo cola ahí
    private BinTreeNodeInt insertRec(BinTreeNodeInt node, int value) { 
        if (node == null) {
            return new BinTreeNodeInt(value);
        } else {
            if (value < node.data) {
                node.left = insertRec(node.left, value);
            } else if (value > node.data) {
                node.right = insertRec(node.right, value);
            }
            return node;
        }
    }

    public void inOrderTraversal() {
        System.out.print("inOrderTraversal: ");
        inOrderTraversalRec(root); //Llama al nodo (raiz)
        System.out.println();
    }

    public void preOrderTraversal() {
        System.out.print("preOrderTraversal: ");
        preOrderTraversalRec(root);
        System.out.println();
    }

    public void postOrderTraversal() {
        System.out.print("postOrderTraversal: ");
        postOrderTraversalRec(root);
        System.out.println();
    }

    //
    private void inOrderTraversalRec(BinTreeNodeInt node) { //Valida 4 izquierda (2)
        if (node != null) {
            inOrderTraversalRec(node.left);
            //Valida 2 izquierda (1), no hay nada, imprime el nodo (1)
            //valida der de (1) nada, termina e imprime el nodo (2)
            //Valida 2 derecha (3), luego izq de este, imprime y derecha
            //Termina el izq de 4 y lo imprime, sigue con la derecha, igual validando izq, imprime, derecha
            System.out.print(node.data + " "); //Imprime el nodo despues de validar izq
            inOrderTraversalRec(node.right);
        }
    }

    private void preOrderTraversalRec(BinTreeNodeInt node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraversalRec(node.left);
            preOrderTraversalRec(node.right);
        }
    }

    private void postOrderTraversalRec(BinTreeNodeInt node) {
        if (node != null) {
            postOrderTraversalRec(node.left);
            postOrderTraversalRec(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        BinTreeInt tree = new BinTreeInt();
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);
        tree.inOrderTraversal();
        tree.preOrderTraversal();
        tree.postOrderTraversal();
    }
}
