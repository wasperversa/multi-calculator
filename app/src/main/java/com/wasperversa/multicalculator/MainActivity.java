package com.wasperversa.multicalculator;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.LinearLayout;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.wasperversa.multicalculator.databinding.ActivityMainBinding;

/**
 * Main activity of the application.
 * This activity displays the main menu with various calculator options and a bottom navigation bar.
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_main);
        //CardView cal1 = findViewById(R.id.cal1);
        //CardView cal2 = findViewById(R.id.cal2);
        //CardView cal3 = findViewById(R.id.cal3);
        //CardView cal4 = findViewById(R.id.cal4);
        //CardView cal5 = findViewById(R.id.cal5);
        //CardView cal6 = findViewById(R.id.cal6);
        //CardView cal7 = findViewById(R.id.cal7);
        //CardView home = findViewById(R.id.home);
        //CardView contact = findViewById(R.id.contact);
        //CardView bottomNav = findViewById(R.id.bottomNav);
        //CardView share = findViewById(R.id.share);
        //CardView rating = findViewById(R.id.rating);
        //CardView update = findViewById(R.id.update);


        binding.bottomNav.setOnClickListener(v -> showBottomSheetDialog());

        binding.cal1.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, NormalCalculator.class)));
        binding.cal2.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, BMICalculator.class)));
        binding.cal3.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AgeCalculator.class)));
        binding.cal4.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, DiscountCalculator.class)));
        binding.cal5.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ScientificCalculator.class)));
        binding.cal6.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, EMICalculator.class)));
        binding.cal7.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, PercentageCalculator.class)));

        binding.home.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show());
        binding.contact.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Contact.class)));
    }

    private void showBottomSheetDialog() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog_layout);

        LinearLayout share = bottomSheetDialog.findViewById(R.id.share);
        LinearLayout rating = bottomSheetDialog.findViewById(R.id.rating);
        LinearLayout contact = bottomSheetDialog.findViewById(R.id.contact);

        if (share != null) {
            share.setOnClickListener(v -> {
                // Implement share functionality
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Check out this app!");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Download the MultiCalculator app here: https://github.com/wasperversa/multi-calculator");
                startActivity(Intent.createChooser(shareIntent, "Share via"));

                Toast.makeText(MainActivity.this, "Share is Clicked", Toast.LENGTH_SHORT).show();
            });
        }

        if (rating != null) {
            rating.setOnClickListener(v -> {

                // Implement rating functionality
                Toast.makeText(MainActivity.this, "Rating is Clicked", Toast.LENGTH_SHORT).show();
            });
        }

        if (contact != null) {
            contact.setOnClickListener(v -> {
                // Implement contact functionality
                Toast.makeText(MainActivity.this, "Update is Clicked", Toast.LENGTH_SHORT).show();
            });
        }

        bottomSheetDialog.show();
    }

}