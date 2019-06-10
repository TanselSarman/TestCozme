package com.example.tansel.tezcozme;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btn_eng_kelimeler,btn_tur_eng,btn_kelime_ekle,btn_teste_basla,btn_kelimeler;
    Context context=this;
    SQliteHelper db=new SQliteHelper(context);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btn_teste_basla.setOnClickListener(this);
        btn_kelime_ekle.setOnClickListener(this);
        btn_kelimeler.setOnClickListener(this);
        btn_tur_eng.setOnClickListener(this);
        btn_eng_kelimeler.setOnClickListener(this);
        db.getWritableDatabase();






    }

    public void init(){
        btn_kelime_ekle=findViewById(R.id.btn_kelime_ekle);
        btn_teste_basla=findViewById(R.id.btn_teste_basla);
        btn_kelimeler=findViewById(R.id.btn_kelimeler);
        btn_tur_eng=findViewById(R.id.btn_tur_eng);
        btn_eng_kelimeler=findViewById(R.id.btn_eng_kelimeler);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        Intent intent;


        switch (id){
            case R.id.btn_kelime_ekle:
                intent=new Intent(context,EklemeActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_teste_basla:
                intent=new Intent(context,TestActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_kelimeler:
                intent = new Intent(context,KelimlerActivity.class);
                startActivity(intent);

                break;

            case R.id.btn_tur_eng:
                intent = new Intent(context,Test2Activity.class);
                startActivity(intent);

                break;

            case R.id.btn_eng_kelimeler:
                intent = new Intent(context,EngKelimeler.class);
                startActivity(intent);

                break;
        }
    }


}
