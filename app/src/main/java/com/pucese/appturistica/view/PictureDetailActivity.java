package com.pucese.appturistica.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.content.Intent;
import android.os.Build;
import android.transition.Fade;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.pucese.appturistica.R;
import com.squareup.picasso.Picasso;

public class PictureDetailActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);
        showToolbar(" ",true);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
        {
            getWindow().setEnterTransition(new Fade());
        }

        Intent i = getIntent();

        ImageView imageHeader=(ImageView) findViewById(R.id.imageHeader);
        String url=i.getStringExtra("picture");
        Picasso.get().load(url).into(imageHeader);

        //nombre
        TextView nombreT = (TextView) findViewById(R.id.userNameDetail);
        String name = i.getStringExtra("name");
        nombreT.setText(name);

        //Like
        TextView likeNumberDetail = (TextView) findViewById(R.id.likeNumberDetail);
        String like = i.getStringExtra("like");
        likeNumberDetail.setText(like);

        //Titulo
        TextView tituloT = (TextView) findViewById(R.id.titleImage);
        String title = i.getStringExtra("titulo");
        tituloT.setText(title);

        //Descripción
        TextView textContentImageDetail = (TextView) findViewById(R.id.textContentImageDetail);
        String comentarios = i.getStringExtra("description");
        textContentImageDetail.setText(comentarios);

    }

    public void showToolbar(String tittle, boolean upButton)
    {
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsingToolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

}