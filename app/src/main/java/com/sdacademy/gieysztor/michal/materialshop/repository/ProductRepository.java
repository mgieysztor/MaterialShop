package com.sdacademy.gieysztor.michal.materialshop.repository;

import com.sdacademy.gieysztor.michal.materialshop.R;
import com.sdacademy.gieysztor.michal.materialshop.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RENT on 2017-02-18.
 */

public class ProductRepository implements ProductRepositoryInterface {


    private static ProductRepository mInstance = new ProductRepository();

    private Map<Integer, Product> mProducts = new HashMap<>();

    private ProductRepository() {
        Product product1 = new Product(1,"Zegarek CERTINA", 1250, R.drawable.watch_certina);
        Product product2 = new Product(2,"Zegarek wskazówkowy NONAME", 89, R.drawable.analog_watch);
        Product product3 = new Product(3,"Zegar ścienny", 55, R.drawable.wall_clock);
        Product product4 = new Product(4,"Zegarek kieszonkowy ZLOTY", 650, R.drawable.pocket_watch_gold);
        Product product5 = new Product(5,"Klepsydra", 25, R.drawable.hourglass);

        mProducts.put(1, product1);
        mProducts.put(2, product2);
        mProducts.put(3, product3);
        mProducts.put(4, product4);
        mProducts.put(5, product5);


    }

    public static ProductRepositoryInterface getInstance(){
        return mInstance;
    }

    @Override
    public List<Product> getProducts() {

        return new ArrayList<>(mProducts.values());
    }
}
