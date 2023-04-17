package com.eitsistemas.coordenadas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private static LayoutInflater inflater = null;

    Context contexto;
    ArrayList<Coordenadas> datos;
    int[] coordenadaid;

    public Adaptador(Context conexto,  ArrayList<Coordenadas> datos)
    {
        this.contexto = conexto;
        this.datos = datos;

        inflater = (LayoutInflater)conexto.getSystemService(conexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.detalle_coordenadas, null);

        TextView direccion = (TextView) vista.findViewById(R.id.tvdireccion);
        TextView latitud = (TextView) vista.findViewById(R.id.tvlatitud);
        TextView longitud = (TextView) vista.findViewById(R.id.tvlongitud);

        Coordenadas item = datos.get(i);

        direccion.setText(item.getDireccion());
        latitud.setText(item.getLatitud());
        longitud.setText(item.getLatitud());

        return vista;
    }

    @Override
    public int getCount() {
        return coordenadaid.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
