package com.example.barelee.view.users;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.barelee.R;

import de.hdodenhof.circleimageview.CircleImageView; // Thư viện CircleImageView để làm avatar tròn

public class ProfileActivity extends AppCompatActivity {

    private CircleImageView avatarImageView;
    private TextView nameTextView, emailTextView, pointsTextView, ratingTextView, favoriteTextView;
    private TextView settingsTextView, exchangeTextView, reviewTextView, logoutTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Khởi tạo các thành phần giao diện
        avatarImageView = findViewById(R.id.avatarImageView);
        nameTextView = findViewById(R.id.nameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        pointsTextView = findViewById(R.id.pointsTextView);
        ratingTextView = findViewById(R.id.ratingTextView);
        favoriteTextView = findViewById(R.id.favoriteTextView);
        settingsTextView = findViewById(R.id.settingsTextView);
        exchangeTextView = findViewById(R.id.exchangeTextView);
        reviewTextView = findViewById(R.id.reviewTextView);
        logoutTextView = findViewById(R.id.logoutTextView);

        // Gán dữ liệu mẫu (có thể thay bằng dữ liệu từ server hoặc SharedPreferences)
        loadProfileData();

        // Xử lý sự kiện cho các nút điều hướng
        settingsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến màn hình cài đặt tài khoản
                // Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
                // startActivity(intent);
            }
        });

        exchangeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến màn hình đổi khoán sử dụng
                // Intent intent = new Intent(ProfileActivity.this, ExchangeActivity.class);
                // startActivity(intent);
            }
        });

        reviewTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến màn hình đánh giá sản phẩm
                // Intent intent = new Intent(ProfileActivity.this, ReviewActivity.class);
                // startActivity(intent);
            }
        });

        logoutTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý đăng xuất (ví dụ: xóa SharedPreferences, quay về màn hình login)
                //SharedPreferences.Editor editor = getSharedPreferences("user_prefs", MODE_PRIVATE).edit();
                // editor.clear();
                // editor.apply();
                // Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                // startActivity(intent);
                // finish();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void loadProfileData() {
        // Dữ liệu mẫu
        String name = "Lê Việt My";
        String email = "my.le@gmail.com";
        int points = 24;
        int rating = 12;
        int favorite = 8;
        String avatarUrl = "https://example.com/bear_avatar.png"; // Thay bằng URL thật

        // Gán dữ liệu vào giao diện
        nameTextView.setText(name);
        emailTextView.setText(email);
        pointsTextView.setText("Điểm: " + points);
        ratingTextView.setText("Đánh giá: " + rating);
        favoriteTextView.setText("Yêu thích: " + favorite);

        // Tải hình ảnh avatar bằng Glide
        Glide.with(this)
                .load(avatarUrl)
                .apply(RequestOptions.circleCropTransform()) // Làm tròn hình ảnh
                .placeholder(R.drawable.ic_placeholder) // Hình placeholder khi tải
                .error(R.drawable.ic_error) // Hình khi tải lỗi
                .into(avatarImageView);
    }
}