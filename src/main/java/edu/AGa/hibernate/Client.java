package edu.AGa.hibernate;

public class Client {
    public static void main(String[] args) {
        Session session = new Session();
        String productSql = session.getSql(Product.class);
        System.out.println("SQL для Product: " + productSql);
    }
}
