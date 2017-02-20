package com.sdacademy.gieysztor.michal.materialshop.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.sdacademy.gieysztor.michal.materialshop.R;
import com.sdacademy.gieysztor.michal.materialshop.model.Product;
import com.sdacademy.gieysztor.michal.materialshop.repository.ProductRepository;
import com.sdacademy.gieysztor.michal.materialshop.repository.ProductRepositoryInterface;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by RENT on 2017-02-18.
 */

public class ProductDetailsActivity extends AppCompatActivity {

    public static final String INTENT_PRODUCT_ID = ProductDetailsActivity.class.getSimpleName() + "productId";

    @BindView(R.id.product_name)
    TextView mProductName;

    @BindView(R.id.product_price)
    TextView mProductPrice;

//    @BindView(R.id.product_description)
//    TextView mProductDescription;

    @BindView(R.id.product_image)
    ImageView mProductImageView;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private ProductRepositoryInterface mProductRepository = ProductRepository.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        int productId = bundle.getInt(INTENT_PRODUCT_ID);
        Log.d("Shop", "Product id: " + productId);

        Product product = mProductRepository.getProduct(productId);


//        setupToolbar();
        displayData(product);


    }

    private void displayData(Product product) {
        mProductImageView.setImageResource(product.getmImageResId());
        mProductName.setText(product.getmName());
        mProductPrice.setText(Double.toString(product.getmPrice()));

    }
}
