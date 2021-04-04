package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        for (int i = index; i < products.length - 1; i++) {
            if ((i + 1) <= products.length) {
                Product product = products[i + 1];
                products[i] = product;
                products[i + 1] = null;
            } else {
                products[i] = null;
            }
        }
        return products;
    }
}
