package com.example.guiasorocaba;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetalhesJaws extends AppCompatActivity {
    Button btnAbrirMapaJaws, btnAbrirSiteJaws, btnLigarJaws;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalhes_jaws);

        btnAbrirMapaJaws = (Button)findViewById(R.id.btnAbrirMapaJaws);
        btnAbrirSiteJaws = (Button)findViewById(R.id.btnAbrirSiteJaws);
        btnLigarJaws = (Button)findViewById(R.id.btnLigarJaws);

        btnAbrirMapaJaws.setOnClickListener(v -> {
            Uri gmmIntentUri =
                    Uri.parse("geo:0,0?q=Rua+arthur+gomes+492");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            startActivity(mapIntent);
        });

        btnAbrirSiteJaws.setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://www.instagram.com/jawsburgers/");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(intent);
        });

        btnLigarJaws.setOnClickListener(v -> {
            Uri uri = Uri.parse("tel:15996095459");
            Intent intent = new Intent(Intent.ACTION_CALL,uri);
            int permissionCheck =
                    ContextCompat.checkSelfPermission(this,
                            android.Manifest.permission.CALL_PHONE);
            if (permissionCheck !=
                    PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,new
                        String[]{android.Manifest.permission.CALL_PHONE},1);
            } else {
                startActivity(intent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}