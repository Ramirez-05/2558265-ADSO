package com.example.pruebarecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText campoBusqueda;
    FloatingActionButton btnBuscar;
    RecyclerView recyclerPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoBusqueda = findViewById(R.id.campoBusqueda);
        btnBuscar = findViewById(R.id.btnBuscar);

        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Oscar Loaiza", "85", "MASCULINO", "23454", "oscar@gmail.com", "INACTIVO"));
        listaPersonas.add(new Persona("Paco Perez", "15", "FEMENINO", "24R42", "paco@gmail.com", "ACTIVO"));

        recyclerPersonas = findViewById(R.id.recyclerPersonas);
        recyclerPersonas.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        AdaptadorPersona adaptador = new AdaptadorPersona(listaPersonas);
        recyclerPersonas.setAdapter(adaptador);
    }
}