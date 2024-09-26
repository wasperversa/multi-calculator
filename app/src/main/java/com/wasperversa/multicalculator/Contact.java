package com.wasperversa.multicalculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.wasperversa.multicalculator.databinding.ActivityContactBinding;

public class Contact extends AppCompatActivity {

    private ActivityContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.home.setOnClickListener(v -> {
            Intent g = new Intent(Contact.this, MainActivity.class);
            startActivity(g);
        });
        binding.phone.setOnClickListener( v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:+919344265853")); // Replace with your number
            startActivity(intent);
        });

        binding.mail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:sibikrish2005@gmail.com")); // Replace with your number
            startActivity(intent);
        });
    }
}