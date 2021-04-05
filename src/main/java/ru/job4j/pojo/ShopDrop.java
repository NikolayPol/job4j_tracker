package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        for (int i = index; i < products.length - 1; i++) {
            products[i] = products[i + 1];
        }
        products[products.length - 1] = null;

//        if (index == products.length - 1) {
//            products[index] = null;
//        } else if (products[index + 1] != null) {
//            products[index] = products[index + 1];
//            products[index + 1] = null;
//        }
        return products;
    }
}
