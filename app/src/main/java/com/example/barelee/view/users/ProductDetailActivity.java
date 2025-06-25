package com.example.barelee.view.users;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.barelee.R;
import com.google.android.material.button.MaterialButton;

public class ProductDetailActivity extends AppCompatActivity {

    private ImageView productImage;
    private TextView  productName, reviewCount, salePrice, originalPrice, discountBadge, productDescription;
    private RatingBar ratingBar;
    private MaterialButton btnAddToWishlist, btnBuyNow;
    private ImageButton btnBack, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);

        // Initialize views
        initViews();

        // Set up click listeners
        setupClickListeners();

        // Load product data
        loadProductData();
    }

    private void initViews() {
        productImage = findViewById(R.id.productImage);
        productName = findViewById(R.id.productName);
        reviewCount = findViewById(R.id.reviewCount);
        salePrice = findViewById(R.id.salePrice);
        originalPrice = findViewById(R.id.originalPrice);
        discountBadge = findViewById(R.id.discountBadge);
        productDescription = findViewById(R.id.productDescription);
        ratingBar = findViewById(R.id.ratingBar);

        btnAddToWishlist = findViewById(R.id.btnAddToWishlist);
        btnBuyNow = findViewById(R.id.btnBuyNow);
        btnBack = findViewById(R.id.btnBack);
    }

    private void setupClickListeners() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnAddToWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToWishlist();
            }
        });

        btnBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyProduct();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void loadProductData() {
        // In a real app, you would load this data from an API or database
        // For this example, we'll use hardcoded values matching the XML layout

        // Load product image using Glide (assuming you have the library added to your project)
        Glide.with(this)
                .load("https://example.com/product_image.jpg")
                .placeholder(R.drawable.product_image)
                .into(productImage);

        productName.setText("Advanced Snail 96 Mucin Power Essence");
        reviewCount.setText("(2,456 đánh giá)");
        salePrice.setText("580.000đ");
        originalPrice.setText("650.000đ");
        discountBadge.setText("-20%");
        ratingBar.setRating(5.0f);

        // Product description is already set in the XML layout
    }


    private void addToWishlist() {
        // Implement add to wishlist functionality
        Toast.makeText(this, "Đã thêm vào danh sách yêu thích", Toast.LENGTH_SHORT).show();
    }

    private void buyProduct() {
        // Implement buy now functionality
        Toast.makeText(this, "Đang chuyển đến trang thanh toán", Toast.LENGTH_SHORT).show();
    }

    public TextView getProductDescription() {
        return productDescription;
    }
}
