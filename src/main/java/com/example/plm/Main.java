package com.example.plm;

// Main.java
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();

        try {
            // Exemple de création d'un utilisateur
            User user = new User();
            user.setUserId("U001");
            user.setName("John Doe");
            user.setRole("ADMIN");
            user.setAccessLevel("HIGH");
            user.setEmail("john@example.com");
            user.setPassword("encrypted_password");

            boolean userCreated = controller.createUser(user);
            if (userCreated) {
                System.out.println("User created successfully");
            }

            // Exemple de création d'un produit
            Product product = new Product();
            product.setProductId("P001");
            product.setName("Sample Product");
            product.setCategory("Electronics");
            product.setRange("Premium");
            product.setReference("REF001");
            product.setPrice(999.99);

            boolean productCreated = controller.createProduct(product);
            if (productCreated) {
                System.out.println("Product created successfully");
            }

            // Exemple de récupération d'un utilisateur
            User retrievedUser = controller.getUser("U001");
            if (retrievedUser != null) {
                System.out.println("Retrieved user: " + retrievedUser.toString());
            }

            // Exemple de création d'une commande
            Order order = new Order();
            order.setOrderId("O001");
            order.setClient(new Client("C001", "Client Name", "Contact Info", "client@example.com", "Address"));

            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(2);
            item.setPrice((float) product.getPrice());

            order.addItem(item);
            order.createOrder();

            // Autres exemples d'utilisation...

        } finally {
            controller.closeConnection();
        }
    }
}