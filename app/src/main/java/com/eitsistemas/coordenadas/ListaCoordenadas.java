package com.eitsistemas.coordenadas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListaCoordenadas extends AppCompatActivity {
    DatabaseHelper miDB;
    ListView listac;
    ArrayList<String> listado = new ArrayList<>();
    Adaptador adaptador;
    Button btnagregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_coordenadas);
        listac =  (ListView) findViewById(R.id.lvlistado);

        miDB = new DatabaseHelper(this);
        btnagregar = (Button)findViewById(R.id.btnagregar);

        cargar_datos();

        listac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setSelected(true);
                String seleccion = listado.get(i);
                String[] partes = seleccion.split(";");
                String lon = partes[1].trim();
                String lat = partes[2].trim();

                //Toast.makeText(ListaCoordenadas.this, "Latitud: "+lat+", Longitud: "+lon, Toast.LENGTH_LONG).show();

                String url = "https://www.google.com/maps/search/?api=1&query="+lon+","+lat+"&zoom=50";
                Intent a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse(url));
                startActivity(a);


            }
        });
    }

    void cargar_datos(){
        Cursor data = miDB.getListaContenidos();

        if(data.getCount()==0){
            Toast.makeText(this,"No hay lista que mostrar",Toast.LENGTH_LONG).show();
        }else{
            try {
                while (data.moveToNext()){

                    String corde = data.getString(1)+"\n ;"+data.getString(2)+"\n ;"+data.getString(3);
                    listado.add(corde);
                    //Toast.makeText(ListaCoordenadas.this, corde, Toast.LENGTH_LONG).show();
                    ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1,listado);
                    listac.setAdapter(listAdapter);


                }


            }catch (Exception e){
                Toast.makeText(ListaCoordenadas.this, "Error: "+ e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

}