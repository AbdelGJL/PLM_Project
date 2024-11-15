package com.example.plm;// DBManager.java
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";
    private static Connection connection;

    // Méthodes de connexion
    public static void connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database successfully");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
    }

    public static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Database connection closed");
        }
    }

    // Méthodes CRUD pour User
    public static void createUser(User user) throws SQLException {
        String sql = "INSERT INTO users (user_id, name, role, access_level, email, password, created_at) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getRole());
            pstmt.setString(4, user.getAccessLevel());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getPassword());
            pstmt.setTimestamp(7, new Timestamp(user.getCreatedAt().getTime()));
            pstmt.executeUpdate();
        }
    }

    public static User getUser(String userId) throws SQLException {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToUser(rs);
            }
        }
        return null;
    }

    public static void updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET name = ?, role = ?, access_level = ?, email = ?, password = ?, updated_at = ? WHERE user_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getRole());
            pstmt.setString(3, user.getAccessLevel());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPassword());
            //pstmt.setTimestamp(6, new Timestamp(new Date().getTime()));
            pstmt.setString(7, user.getUserId());
            pstmt.executeUpdate();
        }
    }

    public static void deleteUser(String userId) throws SQLException {
        String sql = "DELETE FROM users WHERE user_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.executeUpdate();
        }
    }

    public static List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(mapResultSetToUser(rs));
            }
        }
        return users;
    }

    // Méthodes CRUD pour Product
    public static void createProduct(Product product) throws SQLException {
        String sql = "INSERT INTO products (product_id, name, category, range, reference, price, stock_quantity) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, product.getProductId());
            pstmt.setString(2, product.getName());
            pstmt.setString(3, product.getCategory());
            pstmt.setString(4, product.getRange());
            pstmt.setString(5, product.getReference());
            pstmt.setDouble(6, product.getPrice());
            pstmt.setInt(7, product.getStockQuantity());
            pstmt.executeUpdate();
        }
    }

    public static Product getProduct(String productId) throws SQLException {
        String sql = "SELECT * FROM products WHERE product_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, productId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToProduct(rs);
            }
        }
        return null;
    }

    public static void updateProduct(Product product) throws SQLException {
        String sql = "UPDATE products SET name = ?, category = ?, range = ?, reference = ?, price = ?, stock_quantity = ? WHERE product_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getCategory());
            pstmt.setString(3, product.getRange());
            pstmt.setString(4, product.getReference());
            pstmt.setDouble(5, product.getPrice());
            pstmt.setInt(6, product.getStockQuantity());
            pstmt.setString(7, product.getProductId());
            pstmt.executeUpdate();
        }
    }

    public static void deleteProduct(String productId) throws SQLException {
        String sql = "DELETE FROM products WHERE product_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, productId);
            pstmt.executeUpdate();
        }
    }

    public static List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                products.add(mapResultSetToProduct(rs));
            }
        }
        return products;
    }

    // Méthodes CRUD pour Order
    public static void createOrder(Order order) throws SQLException {
        connection.setAutoCommit(false);
        try {
            // Insérer la commande
            String orderSql = "INSERT INTO orders (order_id, date, status, client_id, total_amount) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(orderSql)) {
                pstmt.setString(1, order.getOrderId());
                pstmt.setTimestamp(2, new Timestamp(order.getDate().getTime()));
                pstmt.setString(3, order.getStatus());
                pstmt.setString(4, order.getClient().getClientId());
                pstmt.setDouble(5, order.getTotalAmount());
                pstmt.executeUpdate();
            }

            // Insérer les items de la commande
            String itemSql = "INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(itemSql)) {
                for (OrderItem item : order.getItems()) {
                    pstmt.setString(1, order.getOrderId());
                    pstmt.setString(2, item.getProduct().getProductId());
                    pstmt.setInt(3, item.getQuantity());
                    pstmt.setFloat(4, item.getPrice());
                    pstmt.executeUpdate();
                }
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public static Order getOrder(String orderId) throws SQLException {
        Order order = null;
        String orderSql = "SELECT * FROM orders WHERE order_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(orderSql)) {
            pstmt.setString(1, orderId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                order = mapResultSetToOrder(rs);

                // Récupérer les items de la commande
                String itemSql = "SELECT * FROM order_items WHERE order_id = ?";
                try (PreparedStatement itemPstmt = connection.prepareStatement(itemSql)) {
                    itemPstmt.setString(1, orderId);
                    ResultSet itemRs = itemPstmt.executeQuery();
                    while (itemRs.next()) {
                        OrderItem item = mapResultSetToOrderItem(itemRs);
                        order.addItem(item);
                    }
                }
            }
        }
        return order;
    }

    public static void updateOrder(Order order) throws SQLException {
        connection.setAutoCommit(false);
        try {
            // Mettre à jour la commande
            String orderSql = "UPDATE orders SET status = ?, total_amount = ? WHERE order_id = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(orderSql)) {
                pstmt.setString(1, order.getStatus());
                pstmt.setDouble(2, order.getTotalAmount());
                pstmt.setString(3, order.getOrderId());
                pstmt.executeUpdate();
            }

            // Supprimer les anciens items
            String deleteItemsSql = "DELETE FROM order_items WHERE order_id = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(deleteItemsSql)) {
                pstmt.setString(1, order.getOrderId());
                pstmt.executeUpdate();
            }

            // Insérer les nouveaux items
            String itemSql = "INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(itemSql)) {
                for (OrderItem item : order.getItems()) {
                    pstmt.setString(1, order.getOrderId());
                    pstmt.setString(2, item.getProduct().getProductId());
                    pstmt.setInt(3, item.getQuantity());
                    pstmt.setFloat(4, item.getPrice());
                    pstmt.executeUpdate();
                }
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public static void deleteOrder(String orderId) throws SQLException {
        connection.setAutoCommit(false);
        try {
            // Supprimer les items de la commande
            String deleteItemsSql = "DELETE FROM order_items WHERE order_id = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(deleteItemsSql)) {
                pstmt.setString(1, orderId);
                pstmt.executeUpdate();
            }

            // Supprimer la commande
            String deleteOrderSql = "DELETE FROM orders WHERE order_id = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(deleteOrderSql)) {
                pstmt.setString(1, orderId);
                pstmt.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    // Méthodes CRUD pour Client
    public static void createClient(Client client) throws SQLException {
        String sql = "INSERT INTO clients (client_id, name, contact_info, email, address) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, client.getClientId());
            pstmt.setString(2, client.getName());
            pstmt.setString(3, client.getContactInfo());
            pstmt.setString(4, client.getEmail());
            pstmt.setString(5, client.getAddress());
            pstmt.executeUpdate();
        }
    }

    public static Client getClient(String clientId) throws SQLException {
        String sql = "SELECT * FROM clients WHERE client_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, clientId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToClient(rs);
            }
        }
        return null;
    }

    public static void updateClient(Client client) throws SQLException {
        String sql = "UPDATE clients SET name = ?, contact_info = ?, email = ?, address = ? WHERE client_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, client.getName());
            pstmt.setString(2, client.getContactInfo());
            pstmt.setString(3, client.getEmail());
            pstmt.setString(4, client.getAddress());
            pstmt.setString(5, client.getClientId());
            pstmt.executeUpdate();
        }
    }

    public static void deleteClient(String clientId) throws SQLException {
        String sql = "DELETE FROM clients WHERE client_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, clientId);
            pstmt.executeUpdate();
        }
    }

    // Méthodes de mapping ResultSet vers objets
    private static User mapResultSetToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserId(rs.getString("user_id"));
        user.setName(rs.getString("name"));
        user.setRole(rs.getString("role"));
        user.setAccessLevel(rs.getString("access_level"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setCreatedAt(rs.getTimestamp("created_at"));
        user.setUpdatedAt(rs.getTimestamp("updated_at"));
        return user;
    }

    private static Product mapResultSetToProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setProductId(rs.getString("product_id"));
        product.setName(rs.getString("name"));
        product.setCategory(rs.getString("category"));
        product.setRange(rs.getString("range"));
        product.setReference(rs.getString("reference"));
        product.setPrice(rs.getDouble("price"));
        product.setStockQuantity(rs.getInt("stock_quantity"));
        return product;
    }

    private static Order mapResultSetToOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setOrderId(rs.getString("order_id"));
        order.setDate(rs.getTimestamp("date"));
        order.setStatus(rs.getString("status"));

        // Récupérer le client associé
        String clientId = rs.getString("client_id");
        order.setClient(getClient(clientId));

        return order;
    }

    // Fonctions à développer
    private static OrderItem mapResultSetToOrderItem(ResultSet rs) throws SQLException {
        OrderItem item = new OrderItem(); // A refaire
        return item; // A refaire
    }

    private static Client mapResultSetToClient(ResultSet rs) {
        return null;
    }
}