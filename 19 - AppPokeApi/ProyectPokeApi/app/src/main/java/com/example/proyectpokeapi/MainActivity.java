package com.example.proyectpokeapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    List<Pokemon> listaPokemones;
    RecyclerView recyclerPokemones;

    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaPokemones = new ArrayList<>();
        recyclerPokemones = findViewById(R.id.recyclerPokemones);
        url ="https://pokeapi.co/api/v2/pokemon";

        cargarPokemones(url);
    }

    public void cargarPokemones(String url){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());


        StringRequest solicitud =  new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("RESPUESTA: " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray results = jsonObject.getJSONArray("results");


                    for (int i = 0; i < results.length(); i++) {
                        JSONObject pokemonJson = results.getJSONObject(i);
                        String nombre = pokemonJson.getString("name");
                        String pokemonUrl = pokemonJson.getString("url");

                        System.out.println("Nombre: " + nombre + "\n" + "URL: " + pokemonUrl);

                        String id = sacarNumeroUrl(pokemonUrl);
                        System.out.println("NUMERO EXTRAIDO: "+ id);

                        Pokemon pokemon = new Pokemon(nombre, pokemonUrl, id);
                        listaPokemones.add(pokemon);
                    }

                    recyclerPokemones.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    AdaptadorPokemon adaptador = new AdaptadorPokemon(listaPokemones);
                    recyclerPokemones.setAdapter(adaptador);

                } catch (JSONException e) {
                    System.out.println("Error al procesar la respuesta JSON:");
                    System.out.println(e.getMessage());
                    Toast.makeText(getApplicationContext(), "Error en Datos Servidor: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor responde con un error:");
                System.out.println(error.getMessage());
                Toast.makeText(getApplicationContext(), "Error en Servidor: " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        queue.add(solicitud);
    }

    public String sacarNumeroUrl(String url){
        Pattern pattern = Pattern.compile("\\/pokemon\\/(\\d+)\\/");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            int temp = Integer.parseInt(matcher.group(1));
            String id = (temp < 10) ? "000" + temp : (temp < 100) ? "00" + temp : (temp < 1000) ? "0" + temp : String.valueOf(temp);
            return id;
        }
        return null;
    }


}