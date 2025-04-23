package edu.AGa.hibernate;

@Table(name = "products")
public class Product {
    @Column(name = "product_id")
    private int productId;

    @Column
    private String name;

    @Column(name = "price")
    private double listPrice;

    public Product(int productId, String name, double listPrice) {
        this.productId = productId;
        this.name = name;
        this.listPrice = listPrice;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    @Override
    public String toString() {
        return "{ProductId: " + this.getProductId() + ", Name: " + this.getName() + ", ListPrice: " + this.getListPrice() + "}";
    }
}
