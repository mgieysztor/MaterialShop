package com.sdacademy.gieysztor.michal.materialshop.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.sdacademy.gieysztor.michal.materialshop.R;
import com.sdacademy.gieysztor.michal.materialshop.model.Product;
import com.sdacademy.gieysztor.michal.materialshop.repository.ProductRepository;
import com.sdacademy.gieysztor.michal.materialshop.repository.ProductRepositoryInterface;
import com.sdacademy.gieysztor.michal.materialshop.view.widget.ProductCardView;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ProductCardView.ProductCardViewInterface {

    @BindViews({R.id.product_1, R.id.product_2, R.id.product_3, R.id.product_4, R.id.product_5})
    List<ProductCardView> mProductCardViews;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.design_navigation_view)
    NavigationView mNavigationView;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.activity_main)
    View mActivityMain;

    @BindView(R.id.bottom_navigation)
    BottomNavigationView mBottomNavigationView;


    private ProductRepositoryInterface mProductRepository = ProductRepository.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupToolbar();
        displayData();
        setupActionDrawerToggle();
        setupNavigationView();
        setupBottomNavigationView ();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            return;
        }
//        new AlertDialog.Builder(this)
//                .setTitle("Wyjście")
//                .setMessage("Czy na pewno chcesz wyj sc z aplikacji?")
//                .setPositiveButton(R)

        super.onBackPressed();
    }

    @Override
    public void onProductClicked(Product product) {
        Intent intent = new Intent(this, ProductDetailsActivity.class);
        intent.putExtra(ProductDetailsActivity.INTENT_PRODUCT_ID, product.getmId());
        startActivity(intent);
        Log.d("Shop", "Product clicked " + product.getmName());
    }

    @OnClick(R.id.add_new_product)
    public void onAddProductClicked(View view) {
//        Toast.makeText(this, "New product click", Toast.LENGTH_SHORT).show();
//        Snackbar mSnackbar = Snackbar.make(mRootLayout, "Brak internetu", Snackbar.LENGTH_LONG)
//                .setAction("Odśwież", new )

        Snackbar.make(mActivityMain, "Brak internetu", Snackbar.LENGTH_LONG)
                .setAction("Dodaj lokalnie", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), AddProduct.class);
                        startActivity(intent);


//                        addProductLocally();
                    }
                })
                .show();
        Log.d("Shop", "New product click");

    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Czas to pieniądz...");
        mToolbar.setSubtitle("SKLEP z zegarkami");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void displayData() {
        List<Product> products = mProductRepository.getProducts();

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            mProductCardViews.get(i).bindTo(product, this);

        }
    }

    private void addProductLocally() {
        Log.d("AddButtonLocally", "Kliknięto dodaj product lokalnie");
        Toast.makeText(this, "New product click", Toast.LENGTH_SHORT).show();
        AddProduct asdad = new AddProduct();
        Intent intent = new Intent();
        asdad.startActivity(intent);
    }

    private void setupActionDrawerToggle() {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                mToolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
//                deselectItems();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

//            private void deselectItems() {
//                Menu menu = new mNavigationView.getMenu();
//                int size = menu.size();
//                for (int i = 0; i < size; i++) {
//                    menu.getItem(i).setChecked(false);
//                }

//            }
        };
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void setupNavigationView() {
        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        mDrawerLayout.closeDrawer(GravityCompat.START);

                        switch (item.getItemId()) {
                            case R.id.about_me:
                                Toast.makeText(MainActivity.this, "Action1", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.about_app:
                                Toast.makeText(MainActivity.this, "Action2", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.terms:
                                Toast.makeText(MainActivity.this, "Action3", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;

                    }
                });
    }

    private void setupBottomNavigationView(){
        mBottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.basket:
                                Toast.makeText(MainActivity.this, "Action1", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.account:
                                Toast.makeText(MainActivity.this, "Action2", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.delivery:
                                Toast.makeText(MainActivity.this, "Action3", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;


                    }
                }
        );
    }
}
