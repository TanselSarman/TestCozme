package com.example.tansel.tezcozme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Tansel on 30.10.2018.
 */

public class SQliteHelper extends SQLiteOpenHelper {

    private static final int database_VERSİON=2;

    private static final String database_NAME="KelimelerDB";
    private static final String table_KELİMELER="Kelimeler";
    private static final String kelime_ID="id";
    private static final String kelime_turkce="turkce";
    private static final String kelime_ingilizce="ingilizce";
    private static final String[] COLUMNS={kelime_ID,kelime_turkce,kelime_ingilizce};

    private static final String CREATE_KELİME_TABLE="CREATE TABLE "
            + table_KELİMELER+ " ("
            + kelime_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + kelime_turkce+ " TEXT, "
            + kelime_ingilizce+ " TEXT )";

    SQLiteDatabase db;


    public SQliteHelper(Context context) {
        super(context, database_NAME, null, database_VERSİON);
         //super(context, String.valueOf(context.getDatabasePath(database_NAME)), null, database_VERSİON);  //İNTERNAL HAFIZA
        // super(context, String.valueOf(new File(Environment.getExternalStorageDirectory(),database_NAME)), null, database_VERSİON); //SD KARTTA OLUŞTURMAK İÇİN


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_KELİME_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+table_KELİMELER);
        this.onCreate(db);

    }


    public void kelimeEkle(String turkce,String ingilizce){
        db=this.getWritableDatabase();
        ContentValues degerler=new ContentValues();
        degerler.put(kelime_turkce,turkce);
        degerler.put(kelime_ingilizce,ingilizce);
        db.insert(table_KELİMELER,null,degerler);
        db.close();



    }

    public Sozluk kelimeGetir(int id){



        db=this.getReadableDatabase();
        //String query="SELECT "+kelime_turkce+" FROM "+table_KELİMELER+" WHERE id='"+id+"'";
        Cursor cursor=db.query(table_KELİMELER,COLUMNS," id = ?",new String[]{String.valueOf(id)},null,null,null );

        if(cursor != null){
            cursor.moveToFirst();

        }
            Sozluk sozcuk=new Sozluk();
            sozcuk.setId(Integer.parseInt(cursor.getString(0)));
            sozcuk.setTurkce(cursor.getString(1));
            sozcuk.setIngilizce(cursor.getString(2));
            db.close();
            return  sozcuk;


}

   public Sozluk soruGetir(int a){


       db=this.getReadableDatabase();
       //String query="SELECT "+kelime_turkce+" FROM "+table_KELİMELER+" WHERE id='"+id+"'";
       Cursor cursor=db.query(table_KELİMELER,COLUMNS," id = ?",new String[]{String.valueOf(a)},null,null,null );

       if(cursor != null){
           cursor.moveToFirst();

       }
       Sozluk sozcuk=new Sozluk();
       sozcuk.setId(Integer.parseInt(cursor.getString(0)));
       sozcuk.setTurkce(cursor.getString(1));
       sozcuk.setIngilizce(cursor.getString(2));
       db.close();
       return  sozcuk;


   }


    public int guncelle(Sozluk sozcuk){

        db=this.getWritableDatabase();
        ContentValues degerler=new ContentValues();
        degerler.put("turkce",sozcuk.getTurkce());
        degerler.put("ingilizce",sozcuk.getIngilizce());
        int i=db.update(table_KELİMELER,degerler," id = ?",new String[]{String.valueOf(sozcuk.getId())});
        db.close();
        return i;


    }




    public ArrayList<Sozluk> kelimeleriGetir(){
        ArrayList<Sozluk> kelimeler=new ArrayList<>();

        String query= "SELECT * FROM "+table_KELİMELER+" ORDER BY turkce";
        db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        Sozluk sozcuk;
        if(cursor.moveToFirst()){

            do {
                sozcuk=new Sozluk();
                sozcuk.setId(Integer.parseInt(cursor.getString(0)));
                sozcuk.setTurkce(cursor.getString(1));
                sozcuk.setIngilizce(cursor.getString(2));
                kelimeler.add(sozcuk);

            }while (cursor.moveToNext());

        }
        db.close();

        return kelimeler;

    }

    public ArrayList<Sozluk> kelimeleriGetirEng(){
        ArrayList<Sozluk> kelimeler=new ArrayList<>();

        String query= "SELECT * FROM "+table_KELİMELER+" ORDER BY ingilizce";
        db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        Sozluk sozcuk;
        if(cursor.moveToFirst()){

            do {
                sozcuk=new Sozluk();
                sozcuk.setId(Integer.parseInt(cursor.getString(0)));
                sozcuk.setTurkce(cursor.getString(1));
                sozcuk.setIngilizce(cursor.getString(2));
                kelimeler.add(sozcuk);

            }while (cursor.moveToNext());

        }
        db.close();

        return kelimeler;

    }


    public void sil(Sozluk sozcuk){
        db=this.getWritableDatabase();
        db.delete(table_KELİMELER,kelime_ID + " = ?",new String[]{String.valueOf(sozcuk.getId())});
        db.close();


    }






}
