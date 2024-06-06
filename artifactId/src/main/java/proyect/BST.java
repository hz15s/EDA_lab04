// Clase BST la cual implementa la interfaz Comparable
public class BST<T extends Comparable<T>> {
    private Node<T> root;

    public BST() {
        this.root = null;
    }
            
    public Node<T> getRoot() {
        return this.root;
    }

    // Método Insert para realizar a búsqueda de un nodo llamado a la función recursiva
    public void insert(T data) {
        this.root = insertRecursive(this.root, data);
    }

    // Método recursivo para insertar una data al árbol BST usando el método compareTo
    private Node<T> insertRecursive(Node<T> root, T data) {
        if (root == null) {
            return new Node<>(data);
        }

        if (data.compareTo(root.getData()) < 0) {
            root.setLeft(insertRecursive(root.getLeft(), data));
        } else if (data.compareTo(root.getData()) > 0) {
            root.setRight(insertRecursive(root.getRight(), data));
        }

        return root;
    }

    // Método Search el cual llama a su función recursiva para realizar la búsqueda
    public boolean search(T data) {
        return searchRecursive(this.root, data);
    }

    // Version recursiva del método search para buscar si es que existe un nodo en el BST
    private boolean searchRecursive(Node<T> root, T data) {
        if (root == null) {
            return false;
        }

        if (data.compareTo(root.getData()) == 0) {
            return true;
        } else if (data.compareTo(root.getData()) < 0) {
            return searchRecursive(root.getLeft(), data);
        } else {
            return searchRecursive(root.getRight(), data);
        }
    }

    // Métodos get para obtener tanto el mayor como el menor dato del BST
    public T getMin() {
        if (this.root == null) {
            return null;
        }

        Node<T> current = this.root;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }

        return current.getData();
    }

    public T getMax() {
        if (this.root == null) {
            return null;
        }

        Node<T> current = this.root;
        while (current.getRight() != null) {
            current = current.getRight();
        }

        return current.getData();
    }

    // Método parent para llamar a parentRecursive que implementa la funcion
    public T parent(T data) {
        return parentRecursive(this.root, null, data);
    }

    // Método recursivo para retornar la data del nodo padre en caso tenga
    private T parentRecursive(Node<T> current, Node<T> parent, T data) {
        if (current == null) {
            return null;
        }

        if (current.getData().equals(data)) {
            return parent != null ? parent.getData() : null;
        }

        if (data.compareTo(current.getData()) < 0) {
            return parentRecursive(current.getLeft(), current, data);
        } else {
            return parentRecursive(current.getRight(), current, data);
        }
    }


    // Método para verificar si el nodo es hijo de otro
    public boolean son(T parentData, T childData) {
        return sonRecursive(this.root, parentData, childData);
    }

    // Son recursivo para implementar la funcion anterior pero de manera recursiva
    private boolean sonRecursive(Node<T> root, T parentData, T childData) {
        if (root == null) {
            return false;
        }
    
        if (root.getData().equals(parentData)) {
            return searchRecursive(root, childData);
        }
    
        return sonRecursive(root.getLeft(), parentData, childData) || sonRecursive(root.getRight(), parentData, childData);
    }

}

// Método para visualizar la gráfica del BST tree ya craedo
public void visualizar() {
    Graph graph = new SingleGraph("BST Tree");
    graph.setAttribute("ui.stylesheet", styleSheet);
    graph.setAutoCreate(true);
    graph.setStrict(false);

    visualizarRec(root, graph, 0, 0, 0);

    for (Node node : graph) {
        node.setAttribute("ui.label", node.getId());
    }

    graph.display();
}

// Método para generar la vista de manera recursiva, ya que va recorriendo los nodos hijos
private void visualizarRec(Nodo<T> node, Graph graph, int x, int y, int level) {
    System.out.println("a");
    System.out.println(x);
    System.out.println(y);
    if (node != null) {
        String id = node.getData().toString();
        graph.addNode(id).setAttribute("xy", x, -y);

        if (node.getLeft() != null) {
            String leftId = node.getLeft().getData().toString();
            graph.addEdge(id + leftId, id, leftId, true);
            visualizarRec(node.getLeft(), graph, x - (1 << (4 - level)), y + 1, level + 1);
            System.out.println("L");
            
        }

        if (node.getRight() != null) {
            String rightId = node.getRight().getData().toString();
            graph.addEdge(id + rightId, id, rightId, true);
            visualizarRec(node.getRight(), graph, x + (1 << (4 - level)), y + 1, level + 1);
            System.out.println("R");
            
        }
    }
}