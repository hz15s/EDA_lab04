package lab_04;

public class Test {
    public static void main(String[] args) {
        // Crear un árbol binario de búsqueda
        BST<Integer> bst = new BST<>();

        // Palabra en mayúsculas proporcionada como entrada
        String inputWord = "BACED";

        // Construir el BST considerando el valor decimal de su código ASCII
        for (int i = 0; i < inputWord.length(); i++) {
            char ch = inputWord.charAt(i);
            int asciiValue = (int) ch;
            bst.insert(asciiValue);
        }

        // Visualizar el árbol
        System.out.println("BST construido basado en el valor decimal de los caracteres de la palabra 'BACED':");
        printInOrder(bst.getRoot());
        System.out.println();

        // Prueba de búsqueda
        int searchKey = (int) 'A';
        System.out.println("¿El valor " + searchKey + " está presente en el árbol? " + bst.search(searchKey));

        // Prueba de obtener el mínimo y el máximo
        System.out.println("El valor mínimo en el árbol es: " + (char) bst.getMin().intValue());
        System.out.println("El valor máximo en el árbol es: " + (char) bst.getMax().intValue());


        // Prueba de verificar si un valor es hijo de otro
        int parentValue2 = (int) 'B';
        int childValue2 = (int) 'C';
        System.out.println((char) childValue2 + " es hijo de " + (char) parentValue2 + ": " + bst.son(parentValue2, childValue2));
    }

    // Método para imprimir en orden ascendente
    private static void printInOrder(Node<Integer> node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print((char) node.getData().intValue() + " "); // Convertir el valor ASCII a caracter
            printInOrder(node.getRight());
        }
    }
}
