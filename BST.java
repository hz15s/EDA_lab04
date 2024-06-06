    public class BST<T extends Comparable<T>> {
        private Node<T> root;

        public BST() {
            this.root = null;
        }
                
        public Node<T> getRoot() {
            return this.root;
        }

        // Insert
        public void insert(T data) {
            this.root = insertRecursive(this.root, data);
        }
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

        // Search
        public boolean search(T data) {
            return searchRecursive(this.root, data);
        }
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

        // Gets
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

        // Parent
        public T parent(T data) {
            return parentRecursive(this.root, null, data);
        }
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

        

        // Son
        public boolean son(T parentData, T childData) {
            return sonRecursive(this.root, parentData, childData);
        }
        private boolean sonRecursive(Node<T> root, T parentData, T childData) {
            if (root == null) {
                return false;
            }
        
            if (root.getData().equals(parentData)) {
                return searchRecursive(root, childData);
            }
        
            return sonRecursive(root.getLeft(), parentData, childData) || sonRecursive(root.getRight(), parentData, childData);
        }

        // ----------------------------------------------------------------------
    }
