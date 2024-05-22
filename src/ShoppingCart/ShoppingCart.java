package ShoppingCart;


import java.util.UUID;

class Product {
    UUID index;
    String name;
    int cost;

    public Product(UUID index, String name, int cost) {
        this.index = index;
        this.name = name;
        this.cost = cost;
    }
}

class Node {
    Product product;
    Node next;
    public Node(Product product) {
        this(product, null);
    }

    public Node(Product product, Node next) {
        this.product = product;
        this.next = next;
    }
}

public class ShoppingCart {
    private Node head;
    int size = 0;

    public ShoppingCart() {
        head = null;
    }

    public void addItem(String productName, int costOfProduct) {
        if (head == null) {
            head = new Node(new Product(UUID.randomUUID(), productName, costOfProduct));
            size++;
            return;
        }
        Node iterator = head;
        while(iterator.next != null) iterator = iterator.next;
        iterator.next = new Node(new Product(UUID.randomUUID(), productName, costOfProduct));
        size++;
    }

    public int getTotalCost() {
        int sum = 0;
        Node iterator = head;
        while (iterator != null) {
            sum += iterator.product.cost;
            iterator = iterator.next;
        }
        return sum;
    }

    public void removeProduct(UUID index) {
        if (size == 0) return;
        Node iterator = head;
        if (iterator.product.index == index) {
            head = head.next;
            return;
        }
        while (iterator.next != null && iterator.next.product.index != index)
            iterator = iterator.next;
        if (iterator.next == null) return;
        iterator.next = iterator.next.next;
    }
}
