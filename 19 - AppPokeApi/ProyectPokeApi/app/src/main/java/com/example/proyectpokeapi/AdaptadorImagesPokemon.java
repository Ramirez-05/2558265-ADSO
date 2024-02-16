package com.example.proyectpokeapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdaptadorImagesPokemon extends RecyclerView.Adapter<AdaptadorImagesPokemon.ViewHolder>{

    List<String> listaImagesPokemon;

    public AdaptadorImagesPokemon(List<String> listaImagesPokemon ){
        this.listaImagesPokemon = listaImagesPokemon;
    }

    @NonNull
    @Override
    public AdaptadorImagesPokemon.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.images, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorImagesPokemon.ViewHolder holder, int position) {
        String temp = listaImagesPokemon.get(position);
        holder.cargarDatos(temp);
    }

    @Override
    public int getItemCount() {
        return listaImagesPokemon.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imagenPokemon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenPokemon = itemView.findViewById(R.id.imagenPokemon);
        }

        public void cargarDatos(String temp) {
            if (temp != null && !temp.isEmpty()){
                Picasso.get().load(temp).into(imagenPokemon);
            }
        }
    }
}
