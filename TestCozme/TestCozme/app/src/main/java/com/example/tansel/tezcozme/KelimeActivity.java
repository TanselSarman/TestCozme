package com.example.tansel.tezcozme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KelimeActivity extends AppCompatActivity {
    TextView turkceAdi,ingilizceAdi,txt_id;
    Button btn_Sil,btn_guncelle;
    EditText yeniTurkce,yeniİngilizce;

    Context context=this;
    SQliteHelper db;
    Sozluk seciliSozcuk;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kelime_layout);

        turkceAdi=findViewById(R.id.turkceAdi);
        ingilizceAdi=findViewById(R.id.ingilizceAdi);
        yeniİngilizce=findViewById(R.id.yeniİngilizce);
        yeniTurkce=findViewById(R.id.yeniTurkce);
        btn_Sil=findViewById(R.id.btn_Sil);
        btn_guncelle=findViewById(R.id.btn_guncelle);
        txt_id=findViewById(R.id.txt_id);



        db=new SQliteHelper(KelimeActivity.this);

       Intent intent=getIntent();
       final int id=intent.getIntExtra("id",-1);

       seciliSozcuk=db.kelimeGetir(id);
       turkceAdi.setText(seciliSozcuk.getTurkce());
       ingilizceAdi.setText(seciliSozcuk.getIngilizce());
       String seciliId=String.valueOf(seciliSozcuk.getId());

       txt_id.setText(seciliId);

       btn_guncelle.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               seciliSozcuk.setTurkce(yeniTurkce.getText().toString());
               seciliSozcuk.setIngilizce(yeniİngilizce.getText().toString());

               db.guncelle(seciliSozcuk);
               Intent intent=new Intent(context,KelimlerActivity.class);
               startActivity(intent);
           }
       });

       btn_Sil.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               db.sil(seciliSozcuk);
               Intent intent=new Intent(context,KelimlerActivity.class);
               startActivity(intent);

           }
       });













    }
}
