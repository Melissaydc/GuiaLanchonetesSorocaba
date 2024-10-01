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

public class DetalhesArtesanos extends AppCompatActivity {
    Button btnAbrirMapa, btnAbrirSite, btnLigar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_detalhes_artesanos);

        btnAbrirMapa = (Button)findViewById(R.id.btnAbrirMapa);
        btnAbrirSite = (Button)findViewById(R.id.btnAbrirSite);
        btnLigar = (Button)findViewById(R.id.btnLigar);

        btnAbrirMapa.setOnClickListener(v -> {
            Uri gmmIntentUri =
                    Uri.parse("geo:0,0?q=Avenida+washington+luiz+1382");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            startActivity(mapIntent);
        });

        btnAbrirSite.setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://app.cardapioweb.com/artesanos_burger#promocoes");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(intent);
        });

        btnLigar.setOnClickListener(v -> {
            Uri uri = Uri.parse("tel:15991482264");
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