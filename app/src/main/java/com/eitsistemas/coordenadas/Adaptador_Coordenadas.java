package com.eitsistemas.coordenadas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador_Coordenadas extends BaseAdapter {
    protected Activity activity;
    protected ArrayList<Coordenadas> items;
    int p;
    Coordenadas c;

    public Adaptador_Coordenadas(Activity activity, ArrayList<Coordenadas> items){
        this.activity = activity;
        this.items = items;
    }

    public void setCoordenadas(int i, Coordenadas c){items.set(i, c);}

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Coordenadas getItem(int position) {return items.get(position);}

    @Override
    public long getItemId(int position) {return items.get(position).getId();}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        p = position;

        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.detalle_coordenadas,null);
        }

        Coordenadas item = items.get(position);

        TextView direccion = (TextView) vi.findViewById(R.id.txtdireccion);
        direccion.setText(item.getDireccion());

        TextView latitud = (TextView) vi.findViewById(R.id.txtlatitud);
        latitud.setText(item.getLatitud());

        TextView longitud = (TextView) vi.findViewById(R.id.txtlongitud);
        longitud.setText(item.getLongitud());

        return vi;
    }
}
