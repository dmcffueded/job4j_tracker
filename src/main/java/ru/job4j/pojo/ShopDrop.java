package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        for (int i = index; i <= products.length - 1; i++) {
            if (index < products.length - 1) {
                Product product = products[i + 1];
                products[index] = product;
                index++;
            } else {
                products[i] = null;
            }
        }
        return products;
    }
}