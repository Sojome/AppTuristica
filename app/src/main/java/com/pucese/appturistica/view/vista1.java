package com.pucese.appturistica.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.pucese.appturistica.Adapter;
import com.pucese.appturistica.LoginActivity;
import com.pucese.appturistica.R;

public class vista1 extends AppCompatActivity {

    RecyclerView ViewRecycler;


    String s1[], s2[], s3[];
    int images [] = {
            R.drawable.esmeraldas_playa,
            R.drawable.muisne,
            R.drawable.cevicheria_lider,
            R.drawable.cisne,
            R.drawable.pacomiler,
            R.drawable.terminal,
            R.drawable.municipio,
            R.drawable.gran_aki
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista1);

        ViewRecycler = findViewById(R.id.ViewRecycler);

        s1= getResources().getStringArray(R.array.Lugares_turísticos);
        s2= getResources().getStringArray(R.array.Tiempo);
        s3= getResources().getStringArray(R.array.N_megusta);

        Adapter adapter = new Adapter(this, s1, s2, s3, images);
        ViewRecycler.setAdapter(adapter);
        ViewRecycler.setLayoutManager(new LinearLayoutManager(this));
    }
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();//logout
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }
}