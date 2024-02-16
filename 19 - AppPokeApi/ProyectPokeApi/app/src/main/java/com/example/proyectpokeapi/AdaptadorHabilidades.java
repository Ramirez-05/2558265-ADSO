package com.example.proyectpokeapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorHabilidades extends RecyclerView.Adapter<AdaptadorHabilidades.ViewHolder>{

    List<String> listahabilidadesPokemon;

    public AdaptadorHabilidades(List<String> listahabilidadesPokemon ){
        this.listahabilidadesPokemon = listahabilidadesPokemon;
    }

    @NonNull
    @Override
    public AdaptadorHabilidades.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.habilidades, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorHabilidades.ViewHolder holder, int position) {
        String temp = listahabilidadesPokemon.get(position);
        holder.cargarDatos(temp);
    }


    @Override
    public int getItemCount() {
        return listahabilidadesPokemon.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView habilidad;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            habilidad = itemView.findViewById(R.id.habilidad);
        }

        public void cargarDatos(String temp) {

            habilidad.setText(temp);

        }
    }
}
