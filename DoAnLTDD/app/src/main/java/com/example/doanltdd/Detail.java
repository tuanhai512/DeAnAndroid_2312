package com.example.doanltdd;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doanltdd.controller.Contact;

import java.util.List;

public class Detail extends AppCompatActivity {
    TextView itemclick2_name, itemclick2_noidung;
    ImageView itemclick2_imgView;
    Bundle bundle;
    Button btnNext, btnPrev;
    int position;
    static MediaPlayer mediaPlayer;
    List<Contact> listEX;
    String sName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        itemclick2_name = (TextView) findViewById(R.id.itemclick2_name);
        itemclick2_noidung = (TextView) findViewById(R.id.itemclick2_noidung);
        itemclick2_imgView = (ImageView) findViewById(R.id.itemclick2_imgview);
        btnNext=(Button)findViewById(R.id.btnNext);
        bundle = getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("name");
            String noidung = bundle.getString("noidung");
            setUp(name, noidung);
        }

    }

    private void setUp(String name, String noidung) {
        if (name.equals("Adominal Crunch")) {
            itemclick2_imgView.setImageResource(R.drawable.adominalcrunch);
            itemclick2_name.setText(name);
            itemclick2_noidung.setText(noidung);
        }
        if (name.equals("Bicycle Crunch")) {
            itemclick2_imgView.setImageResource(R.drawable.bicyclecrunches);
            itemclick2_name.setText(name);
            itemclick2_noidung.setText(noidung);
        }




        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // mediaPlayer.stop();
               // mediaPlayer.release();
                position = ((position + 1) % listEX.size());
                Uri u = Uri.parse(listEX.get(position).toString());

                mediaPlayer = MediaPlayer.create(getApplicationContext(), u);

                sName = listEX.get(position).getTitle().toString();
                itemclick2_name.setText(sName);
                mediaPlayer.start();
                //SetTimeTotal();
              //  UpdateTimeSong();
            }
        });

       /* btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();

                position = ((position - 1) < 0) ? (mySongs.size() - 1) : (position - 1);
                Uri u = Uri.parse(mySongs.get(position).toString());
                mediaPlayer = MediaPlayer.create(getApplicationContext(), u);

                sName = mySongs.get(position).getName().toString();
                txtTittle.setText(sName);
                mediaPlayer.start();
               // SetTimeTotal();
               // UpdateTimeSong();
            }
        });*/
    }
}