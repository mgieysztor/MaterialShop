package com.sdacademy.gieysztor.michal.materialshop.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.sdacademy.gieysztor.michal.materialshop.R;

import butterknife.ButterKnife;

/**
 * Created by RENT on 2017-02-20.
 */

public class AddProduct extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_add_product);
        ButterKnife.bind(this);


    }
}
