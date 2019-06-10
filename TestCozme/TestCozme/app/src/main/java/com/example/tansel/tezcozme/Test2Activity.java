package com.example.tansel.tezcozme;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

/**
 * Created by Tansel on 30.10.2018.
 */

public class Test2Activity extends AppCompatActivity implements View.OnClickListener {

    Button btn_yeni2,btn_Sonuc2;
    RadioButton check_A2,check_B2,check_C2,check_D2;
    RadioGroup radio_Grp2;
    TextView txt_soru_sayisi2,txt_dogru_sayisi2;
    TextView txt_Soru2;
    Context context=this;
    SQliteHelper db=new SQliteHelper(context);
    List<Sozluk> listSozluk;
    Sozluk soru;
    int Id;
    int a;
    ImageView img_A2,img_B2,img_C2,img_D2;

    Sozluk cevap2,cevap3,cevap4;

    int sayi2,sayi3,sayi4;

    final Random random2=new Random();

    int soruSayisi2=1;
    int dogruSayisi2=0;






    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2_layout);
        init();





        txt_soru_sayisi2.setText(String.valueOf(soruSayisi2));
        txt_dogru_sayisi2.setText(String.valueOf(dogruSayisi2));


        check_A2.setOnClickListener(this);
        check_B2.setOnClickListener(this);
        check_C2.setOnClickListener(this);
        check_D2.setOnClickListener(this);


        db.getReadableDatabase();

        listSozluk=db.kelimeleriGetir();

        Id=listSozluk.size();






        a=zarAt();

        soru=db.soruGetir(a);



        txt_Soru2.setText(String.valueOf(soru.getTurkce()));
        answers();








        btn_yeni2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_A2.setImageDrawable(null);
                img_B2.setImageDrawable(null);
                img_C2.setImageDrawable(null);
                img_D2.setImageDrawable(null);
                soruSayisi2++;
                txt_soru_sayisi2.setText(String.valueOf(soruSayisi2));
                txt_dogru_sayisi2.setText(String.valueOf(dogruSayisi2));
                check_A2.setChecked(false);
                check_B2.setChecked(false);
                check_C2.setChecked(false);
                check_D2.setChecked(false);

                bosalt();

                zarAt();

                soru=db.soruGetir(a);
                txt_Soru2.setText(String.valueOf(soru.getTurkce()));

                answers();


            }
        });

        btn_Sonuc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });






    }



    public int zarAt(){


        int rastlar[] = new int[4];
        int i=0;



        for(i=0;i<4;i++){
            rastlar[i]=random2.nextInt(Id)+1;

        }



        a=rastlar[0];
        sayi2=rastlar[1];
        sayi3=rastlar[2];
        sayi4=rastlar[3];

        return a;


    }


    public void answers(){

        db.getReadableDatabase();
        listSozluk=db.kelimeleriGetir();

        Id=listSozluk.size();

        int b=random2.nextInt(4)+1;

        if(b==1){
            check_A2.setText(soru.getIngilizce());




            Sozluk cevap1,cevap2,cevap3;

            cevap1=db.soruGetir(sayi2);
            cevap2=db.soruGetir(sayi3);
            cevap3=db.soruGetir(sayi4);

            check_B2.setText(cevap1.getIngilizce());
            check_C2.setText(cevap2.getIngilizce());
            check_D2.setText(cevap3.getIngilizce());




        }
        if (b==2){
            check_B2.setText(soru.getIngilizce());


            Sozluk cevap1,cevap2,cevap3;

            cevap1=db.soruGetir(sayi2);
            cevap2=db.soruGetir(sayi3);
            cevap3=db.soruGetir(sayi4);

            check_A2.setText(cevap1.getIngilizce());
            check_C2.setText(cevap2.getIngilizce());
            check_D2.setText(cevap3.getIngilizce());

        }
        if(b==3){
            check_C2.setText(soru.getIngilizce());

            Sozluk cevap1,cevap2,cevap3;

            cevap1=db.soruGetir(sayi2);
            cevap2=db.soruGetir(sayi3);
            cevap3=db.soruGetir(sayi4);

            check_A2.setText(cevap1.getIngilizce());
            check_B2.setText(cevap2.getIngilizce());
            check_D2.setText(cevap3.getIngilizce());

        }
        if(b==4){
            check_D2.setText(soru.getIngilizce());

            Sozluk cevap1,cevap2,cevap3;

            cevap1=db.soruGetir(sayi2);
            cevap2=db.soruGetir(sayi3);
            cevap3=db.soruGetir(sayi4);

            check_A2.setText(cevap1.getIngilizce());
            check_B2.setText(cevap2.getIngilizce());
            check_C2.setText(cevap3.getIngilizce());

        }




    }







    public void bosalt(){

        check_A2.setText("");
        check_B2.setText("");
        check_C2.setText("");
        check_D2.setText("");


    }

    public void init(){
        txt_Soru2=findViewById(R.id.txt_Soru2);
        btn_yeni2=findViewById(R.id.btn_yeni2);
        check_A2=findViewById(R.id.check_A2);
        check_B2=findViewById(R.id.check_B2);
        check_C2=findViewById(R.id.check_C2);
        check_D2=findViewById(R.id.check_D2);
        radio_Grp2=findViewById(R.id.radio_Grp2);
        txt_soru_sayisi2=findViewById(R.id.txt_soru_sayi2);
        txt_dogru_sayisi2=findViewById(R.id.txt_dogru_sayisi2);
        btn_Sonuc2=findViewById(R.id.btn_Sonuc2);
        img_A2=findViewById(R.id.img_A2);
        img_B2=findViewById(R.id.img_B2);
        img_C2=findViewById(R.id.img_C2);
        img_D2=findViewById(R.id.img_D2);




    }


    @Override
    public void onClick(View v) {

        String cevap;
        String dogru;
        dogru=soru.getIngilizce();

        switch (v.getId()){

            case R.id.check_A2:
                cevap= (String) check_A2.getText();
                if(cevap.equals(dogru)){
                    dogruSayisi2++;
                    txt_dogru_sayisi2.setText(String.valueOf(dogruSayisi2));
                    img_A2.setImageResource(R.drawable.trueee);
                    Toast.makeText(context,"Cevap Doğru",Toast.LENGTH_SHORT).show();
                }
                else{
                    img_A2.setImageResource(R.drawable.falseee);
                    Toast.makeText(context,"Cevap Yanlış",Toast.LENGTH_SHORT).show();
                }


                break;
            case R.id.check_B2:

                cevap= (String) check_B2.getText();
                if(cevap.equals(dogru)){
                    dogruSayisi2++;
                    txt_dogru_sayisi2.setText(String.valueOf(dogruSayisi2));
                    img_B2.setImageResource(R.drawable.trueee);
                    Toast.makeText(context,"Cevap Doğru",Toast.LENGTH_SHORT).show();
                }
                else{
                    img_B2.setImageResource(R.drawable.falseee);
                    Toast.makeText(context,"Cevap Yanlış",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.check_C2:

                cevap= (String) check_C2.getText();
                if(cevap.equals(dogru)){
                    dogruSayisi2++;
                    txt_dogru_sayisi2.setText(String.valueOf(dogruSayisi2));
                    img_C2.setImageResource(R.drawable.trueee);
                    Toast.makeText(context,"Cevap Doğru",Toast.LENGTH_SHORT).show();
                }
                else{
                    img_C2.setImageResource(R.drawable.falseee);
                    Toast.makeText(context,"Cevap Yanlış",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.check_D2:

                cevap= (String) check_D2.getText();
                if(cevap.equals(dogru)){
                    dogruSayisi2++;
                    txt_dogru_sayisi2.setText(String.valueOf(dogruSayisi2));
                    img_D2.setImageResource(R.drawable.trueee);
                    Toast.makeText(context,"Cevap Doğru",Toast.LENGTH_SHORT).show();
                }
                else{
                    img_D2.setImageResource(R.drawable.falseee);
                    Toast.makeText(context,"Cevap Yanlış",Toast.LENGTH_SHORT).show();
                }
                break;



        }

    }
}
