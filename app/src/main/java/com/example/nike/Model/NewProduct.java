package com.example.nike.Model;

public class NewProduct {
    private int imageResIdNewProduct;
    private String nameNewProduct;

    public NewProduct(int imageResIdNewProduct, String nameNewProduct) {
        this.imageResIdNewProduct = imageResIdNewProduct;
        this.nameNewProduct = nameNewProduct;
    }

    public int getImageResIdNewProduct() {
        return imageResIdNewProduct;
    }

    public String getNameNewProduct() {
        return nameNewProduct;
    }
}
