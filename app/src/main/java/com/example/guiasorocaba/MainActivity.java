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

public class MainActivity extends AppCompatActivity {

    Button btnArtesanos, btnAlemao, btnJaws;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnArtesanos = (Button)findViewById(R.id.btnArtesanos);
        btnAlemao = (Button)findViewById(R.id.btnAlemao);
        btnJaws = (Button)findViewById(R.id.btnJaws);

        btnArtesanos.setOnClickListener(v -> {
            Intent i = new Intent(this,DetalhesArtesanos.class);
            startActivity(i);
        });

        btnAlemao.setOnClickListener(v -> {
            Intent i = new Intent(this,DetalhesAlemao.class);
            startActivity(i);
        });

        btnJaws.setOnClickListener(v -> {
            Intent i = new Intent(this,DetalhesJaws.class);
            startActivity(i);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}