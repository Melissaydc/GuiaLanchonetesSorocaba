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

public class DetalhesAlemao extends AppCompatActivity {
    Button btnAbrirMapaAle, btnAbrirSiteAle, btnLigarAle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalhes_alemao);

        btnAbrirMapaAle = (Button)findViewById(R.id.btnAbrirMapaAle);
        btnAbrirSiteAle = (Button)findViewById(R.id.btnAbrirSiteAle);
        btnLigarAle = (Button)findViewById(R.id.btnLigarAle);

        btnAbrirMapaAle.setOnClickListener(v -> {
            Uri gmmIntentUri =
                    Uri.parse("geo:0,0?q=Rua+arthur+gomes+90");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            startActivity(mapIntent);
        });

        btnAbrirSiteAle.setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://alemaoburger.com/");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(intent);
        });

        btnLigarAle.setOnClickListener(v -> {
            Uri uri = Uri.parse("tel:15999999999");
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