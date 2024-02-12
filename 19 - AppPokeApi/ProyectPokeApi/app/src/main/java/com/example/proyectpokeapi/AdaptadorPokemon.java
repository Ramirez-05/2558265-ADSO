package com.example.proyectpokeapi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class AdaptadorPokemon extends RecyclerView.Adapter<AdaptadorPokemon.ViewHolder> {

    List<Pokemon> listaPokemones;

    public AdaptadorPokemon(List<Pokemon> listaPokemones ){
        this.listaPokemones = listaPokemones;
    }

    @NonNull
    @Override
    public AdaptadorPokemon.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return  new  ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPokemon.ViewHolder holder, int position) {
        Pokemon temp = listaPokemones.get(position);
        holder.cargarDatos(temp);
    }

    @Override
    public int getItemCount() {
        return listaPokemones.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView etqNombrePoke;
        ImageView btnPokemon;
        Context contexto;
        TextView etqEnumeracionPoke;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etqNombrePoke = itemView.findViewById(R.id.etqNombrePoke);
            btnPokemon =itemView.findViewById(R.id.btnPokemon);
            etqEnumeracionPoke = itemView.findViewById(R.id.etqEnumeracionPoke);
        }

        public void cargarDatos(Pokemon pokemon){

            etqEnumeracionPoke.setText(pokemon.getId());

            etqNombrePoke.setText(pokemon.getNombre());

            btnPokemon.setOnClickListener(new View.OnClickListener(){

                public  void onClick(View v){
                    String nombre = pokemon.getNombre();

                    Intent intencion = new Intent( contexto, DetallePokemon.class );
                    intencion.putExtra("nombre", nombre);

                    contexto.startActivity(intencion);
                }
            });

        }
    }
}
