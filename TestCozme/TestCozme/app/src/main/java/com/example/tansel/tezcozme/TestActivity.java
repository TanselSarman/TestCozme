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

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_yeni,btn_Sonuc;
    RadioButton check_A,check_B,check_C,check_D;
    RadioGroup radio_Grp;
    TextView txt_soru_sayisi,txt_dogru_sayisi;
    TextView txt_Soru;
    Context context=this;
    SQliteHelper db=new SQliteHelper(context);
    List<Sozluk> listSozluk;
    Sozluk soru;
    int Id;
    int a;
    ImageView img_A,img_B,img_C,img_D;

    Sozluk cevap2,cevap3,cevap4;

    int sayi2,sayi3,sayi4;

    final Random random=new Random();

    int soruSayisi=1;
    int dogruSayisi=0;






    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        init();





        txt_soru_sayisi.setText(String.valueOf(soruSayisi));
        txt_dogru_sayisi.setText(String.valueOf(dogruSayisi));


        check_A.setOnClickListener(this);
        check_B.setOnClickListener(this);
        check_C.setOnClickListener(this);
        check_D.setOnClickListener(this);


        db.getReadableDatabase();

        listSozluk=db.kelimeleriGetir();

        Id=listSozluk.size();






        a=zarAt();

        soru=db.soruGetir(a);



       txt_Soru.setText(String.valueOf(soru.getIngilizce()));
       answers();








       btn_yeni.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               img_A.setImageDrawable(null);
               img_B.setImageDrawable(null);
               img_C.setImageDrawable(null);
               img_D.setImageDrawable(null);
               soruSayisi++;
               txt_soru_sayisi.setText(String.valueOf(soruSayisi));
               txt_dogru_sayisi.setText(String.valueOf(dogruSayisi));
               check_A.setChecked(false);
               check_B.setChecked(false);
               check_C.setChecked(false);
               check_D.setChecked(false);

               bosalt();

               zarAt();

               soru=db.soruGetir(a);
               txt_Soru.setText(String.valueOf(soru.getIngilizce()));

               answers();


           }
       });

       btn_Sonuc.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

           }
       });






    }



    public int zarAt(){


        int rastlar[] = new int[4];
        int i=0;



       for(i=0;i<4;i++){
           rastlar[i]=random.nextInt(Id)+1;

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

        int b=random.nextInt(4)+1;

        if(b==1){
            check_A.setText(soru.getTurkce());




            Sozluk cevap1,cevap2,cevap3;

            cevap1=db.soruGetir(sayi2);
            cevap2=db.soruGetir(sayi3);
            cevap3=db.soruGetir(sayi4);

            check_B.setText(cevap1.getTurkce());
            check_C.setText(cevap2.getTurkce());
            check_D.setText(cevap3.getTurkce());




        }
        if (b==2){
            check_B.setText(soru.getTurkce());


            Sozluk cevap1,cevap2,cevap3;

            cevap1=db.soruGetir(sayi2);
            cevap2=db.soruGetir(sayi3);
            cevap3=db.soruGetir(sayi4);

            check_A.setText(cevap1.getTurkce());
            check_C.setText(cevap2.getTurkce());
            check_D.setText(cevap3.getTurkce());

        }
        if(b==3){
            check_C.setText(soru.getTurkce());

            Sozluk cevap1,cevap2,cevap3;

            cevap1=db.soruGetir(sayi2);
            cevap2=db.soruGetir(sayi3);
            cevap3=db.soruGetir(sayi4);

            check_A.setText(cevap1.getTurkce());
            check_B.setText(cevap2.getTurkce());
            check_D.setText(cevap3.getTurkce());

        }
        if(b==4){
            check_D.setText(soru.getTurkce());

            Sozluk cevap1,cevap2,cevap3;

            cevap1=db.soruGetir(sayi2);
            cevap2=db.soruGetir(sayi3);
            cevap3=db.soruGetir(sayi4);

            check_A.setText(cevap1.getTurkce());
            check_B.setText(cevap2.getTurkce());
            check_C.setText(cevap3.getTurkce());

        }




    }







    public void bosalt(){

        check_A.setText("");
        check_B.setText("");
        check_C.setText("");
        check_D.setText("");


    }

    public void init(){
        txt_Soru=findViewById(R.id.txt_Soru);
        btn_yeni=findViewById(R.id.btn_yeni);
        check_A=findViewById(R.id.check_A);
        check_B=findViewById(R.id.check_B);
        check_C=findViewById(R.id.check_C);
        check_D=findViewById(R.id.check_D);
        radio_Grp=findViewById(R.id.radio_Grp);
        txt_soru_sayisi=findViewById(R.id.txt_soru_sayi);
        txt_dogru_sayisi=findViewById(R.id.txt_dogru_sayisi);
        btn_Sonuc=findViewById(R.id.btn_Sonuc);
        img_A=findViewById(R.id.img_A);
        img_B=findViewById(R.id.img_B);
        img_C=findViewById(R.id.img_C);
        img_D=findViewById(R.id.img_D);




    }


    @Override
    public void onClick(View v) {

        String cevap;
        String dogru;
        dogru=soru.getTurkce();

        switch (v.getId()){

            case R.id.check_A:
                cevap= (String) check_A.getText();
                if(cevap.equals(dogru)){
                    dogruSayisi++;
                    txt_dogru_sayisi.setText(String.valueOf(dogruSayisi));
                    img_A.setImageResource(R.drawable.trueee);
                    Toast.makeText(context,"Cevap Doğru",Toast.LENGTH_SHORT).show();
                }
                else{
                    img_A.setImageResource(R.drawable.falseee);
                    Toast.makeText(context,"Cevap Yanlış",Toast.LENGTH_SHORT).show();
                }


                break;
            case R.id.check_B:

                cevap= (String) check_B.getText();
                if(cevap.equals(dogru)){
                    dogruSayisi++;
                    txt_dogru_sayisi.setText(String.valueOf(dogruSayisi));
                    img_B.setImageResource(R.drawable.trueee);
                    Toast.makeText(context,"Cevap Doğru",Toast.LENGTH_SHORT).show();
                }
                else{
                    img_B.setImageResource(R.drawable.falseee);
                    Toast.makeText(context,"Cevap Yanlış",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.check_C:

                cevap= (String) check_C.getText();
                if(cevap.equals(dogru)){
                    dogruSayisi++;
                    txt_dogru_sayisi.setText(String.valueOf(dogruSayisi));
                    img_C.setImageResource(R.drawable.trueee);
                    Toast.makeText(context,"Cevap Doğru",Toast.LENGTH_SHORT).show();
                }
                else{
                    img_C.setImageResource(R.drawable.falseee);
                    Toast.makeText(context,"Cevap Yanlış",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.check_D:

                cevap= (String) check_D.getText();
                if(cevap.equals(dogru)){
                    dogruSayisi++;
                    txt_dogru_sayisi.setText(String.valueOf(dogruSayisi));
                    img_D.setImageResource(R.drawable.trueee);
                    Toast.makeText(context,"Cevap Doğru",Toast.LENGTH_SHORT).show();
                }
                else{
                    img_D.setImageResource(R.drawable.falseee);
                    Toast.makeText(context,"Cevap Yanlış",Toast.LENGTH_SHORT).show();
                }
                break;



        }

    }
}
