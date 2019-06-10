package com.example.tansel.tezcozme;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Tansel on 30.10.2018.
 */

public class EklemeActivity extends AppCompatActivity  {

    Context context=this;
    EditText edt_turkce,edt_ingilizce;
    Button btn_ekle;

    SQliteHelper db=new SQliteHelper(context);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ekleme_layout);
        edt_turkce=findViewById(R.id.edt_turkce);
        edt_ingilizce=findViewById(R.id.edt_ingilizce);
        btn_ekle=findViewById(R.id.btn_ekle);
        db.getWritableDatabase();
        db.getReadableDatabase();





        btn_ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String turkce= edt_turkce.getText().toString();
                String ingilizce= edt_ingilizce.getText().toString();

                db.kelimeEkle(turkce,ingilizce);
                finish();
            }
        });






    }



}
