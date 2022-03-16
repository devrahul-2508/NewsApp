package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetailActvity extends AppCompatActivity {
    String title,desc,content,imageUrl,url;
    private TextView TVHeading,TVdesc,TVcont;
    private ImageView IVdetail;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail_actvity);
        title=getIntent().getStringExtra("title");
        desc=getIntent().getStringExtra("desc");
        content=getIntent().getStringExtra("content");
        imageUrl=getIntent().getStringExtra("image");
        url=getIntent().getStringExtra("url");
        TVHeading=findViewById(R.id.TVHeading);
        TVdesc=findViewById(R.id.TVDescription);
        TVcont=findViewById(R.id.TVcontent);
        IVdetail =findViewById(R.id.IVdetail);
        btn=findViewById(R.id.btn);
        TVHeading.setText(title);
        TVdesc.setText(desc);
        TVcont.setText(content);
        Picasso.get().load(imageUrl).into(IVdetail);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(url); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }
}