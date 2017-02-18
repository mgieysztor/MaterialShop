package com.sdacademy.gieysztor.michal.materialshop.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.sdacademy.gieysztor.michal.materialshop.R;
import com.sdacademy.gieysztor.michal.materialshop.model.Product;
import com.sdacademy.gieysztor.michal.materialshop.repository.ProductRepository;
import com.sdacademy.gieysztor.michal.materialshop.repository.ProductRepositoryInterface;
import com.sdacademy.gieysztor.michal.materialshop.view.widget.ProductCardView;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ProductCardView.ProductCardViewInterface {

    @BindViews({R.id.product_1, R.id.product_2, R.id.product_3, R.id.product_4, R.id.product_5})
    List<ProductCardView> mProductCardViews;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private ProductRepositoryInterface mProductRepository = ProductRepository.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupToolbar();
        displayData();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onProductClicked(Product product) {
        Intent intent = new Intent(this,ProductDetailsActivity.class);
        intent.putExtra(ProductDetailsActivity.INTENT_PRODUCT_ID,product.getmId());
        startActivity(intent);
        Log.d("Shop", "Product clicked " + product.getmName());



    }

    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Czas to pieniądz...");
        mToolbar.setSubtitle("SKLEP z zegarkami");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void displayData() {
        List<Product> products = mProductRepository.getProducts();

        for (int i = 0; i <products.size() ; i++) {
            Product product = products.get(i);
            mProductCardViews.get(i).bindTo(product, this);

        }
    }
}
