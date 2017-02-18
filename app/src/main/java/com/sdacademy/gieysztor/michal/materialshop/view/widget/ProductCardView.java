package com.sdacademy.gieysztor.michal.materialshop.view.widget;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sdacademy.gieysztor.michal.materialshop.R;
import com.sdacademy.gieysztor.michal.materialshop.model.Product;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by RENT on 2017-02-18.
 */

public class ProductCardView extends CardView {

    public interface ProductCardViewInterface {
        void onProductClicked (Product product);

    }

    @BindView(R.id.product_image)
    ImageView mProductImage;

    @BindView(R.id.product_name)
    TextView mProductName;

    @BindView(R.id.product_price)
    TextView mProductPrice;

    public ProductCardView(Context context) {
        super(context);
        init();
    }

    public ProductCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public ProductCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public void init(){
        inflate(getContext(), R.layout.view_product_card_view, this);
        ButterKnife.bind(this);


    }

    public void bindTo(final Product product, final ProductCardViewInterface productCardViewIntercafe) {
        mProductName.setText(product.getmName());
        mProductPrice.setText(String.valueOf(product.getmPrice()));
        mProductImage.setImageResource(product.getmImageResId());

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                productCardViewIntercafe.onProductClicked(product);
            }
        });

    }
}
