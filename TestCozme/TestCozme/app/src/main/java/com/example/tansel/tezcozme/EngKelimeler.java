package com.example.tansel.tezcozme;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tansel on 30.10.2018.
 */

public class EngKelimeler extends AppCompatActivity {
    ListView listemiz;


    List<Sozluk> listSozluk;
    Context context=this;
    SQliteHelper db=new SQliteHelper(context);


    ArrayAdapter<String> mAdapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kelimeler_layout);
        listemiz=findViewById(R.id.listemiz);
        db.getWritableDatabase();




        listSozluk=db.kelimeleriGetirEng();
        List<String> turkceKelime=new ArrayList<>();
        List<String> ingilizceKelime=new ArrayList<>();

        for(int i=0;i<listSozluk.size();i++){
            turkceKelime.add(i,listSozluk.get(i).getTurkce());
            ingilizceKelime.add(i,listSozluk.get(i).getIngilizce());



        }



        mAdapter=new ArrayAdapter<String>(context,R.layout.satir_layout,R.id.satir1,ingilizceKelime);

        listemiz.setAdapter(mAdapter);



        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent=new Intent(context,KelimeActivity.class);
                intent.putExtra("id",listSozluk.get(position).getId());

                startActivityForResult(intent,-1);


            }
        });






    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        listSozluk=db.kelimeleriGetirEng();
        List<String> ingilizceKelime=new ArrayList<>();

        for(int i=0;i<listSozluk.size();i++){
            ingilizceKelime.add(i,listSozluk.get(i).getIngilizce());



        }

        mAdapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,ingilizceKelime);
        listemiz.setAdapter(mAdapter);
    }
}
