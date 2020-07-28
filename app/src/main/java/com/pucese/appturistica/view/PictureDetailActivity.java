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
        /*ImageView imageHeader=(ImageView) findViewById(R.id.imageHeader);
        String url=getIntent().getExtras().getString("picture");
        Picasso.get().load(url).into(imageHeader);*/

    }
    public void showToolbar(String tittle, boolean upButton)
    {
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsingToolbar);
    }

}