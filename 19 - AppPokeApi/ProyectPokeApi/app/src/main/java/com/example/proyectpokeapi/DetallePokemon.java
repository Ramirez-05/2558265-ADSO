package com.example.proyectpokeapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
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

public class DetallePokemon extends AppCompatActivity {

    TextView nombrePokemon;
    RecyclerView recyclerImagenes;
    List<String> listaImagesPokemon;
    List<String> listahabilidadesPokemon;
    RecyclerView recyclerHabilidades;
    TextView etqAltura;
    TextView etqPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pokemon);

        nombrePokemon = findViewById(R.id.nombrePokemon);
        recyclerImagenes = findViewById(R.id.recyclerImagenes);
        recyclerHabilidades = findViewById(R.id.recyclerHabilidades);
        etqAltura = findViewById(R.id.etqAltura);
        etqPeso = findViewById(R.id.etqPeso);

        listaImagesPokemon = new ArrayList<>();
        listahabilidadesPokemon = new ArrayList<>();

        Bundle datos = getIntent().getExtras();
        nombrePokemon.setText(datos.getString("nombre"));

        String urlPokemon = datos.getString("url");
        System.out.println("ESTA ES LA URL:" + urlPokemon);

        consumoApiPokemon(urlPokemon);
    }

    public void consumoApiPokemon(String urlApiPokemon){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        StringRequest solicitud =  new StringRequest(Request.Method.GET, urlApiPokemon, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject =new JSONObject(response);
                    System.out.println(jsonObject);

                    listaImagesPokemon.clear();
                    listahabilidadesPokemon.clear();

                    JSONArray abilitys = jsonObject.getJSONArray("abilities");

                    JSONObject sprites = jsonObject.getJSONObject("sprites");
                    String front_default = sprites.getString("front_default");
                    String front_shiny = sprites.getString("front_shiny");
                    String back_default = sprites.getString("back_default");
                    String back_shiny = sprites.getString("back_shiny");

                    listaImagesPokemon.add(front_default);
                    listaImagesPokemon.add(front_shiny);
                    listaImagesPokemon.add(back_default);
                    listaImagesPokemon.add(back_shiny);

                    recyclerImagenes.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL, false));
                    AdaptadorImagesPokemon adaptadorImages = new AdaptadorImagesPokemon(listaImagesPokemon);
                    recyclerImagenes.setAdapter(adaptadorImages);

                    for (int i = 0; i < abilitys.length(); i++) {
                        JSONObject abilityObject = abilitys.getJSONObject(i);
                        JSONObject ability = abilityObject.getJSONObject("ability");
                        String abilityName = ability.getString("name");
                        listahabilidadesPokemon.add(abilityName);
                    }

                    recyclerHabilidades.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    AdaptadorHabilidades adaptador=new AdaptadorHabilidades(listahabilidadesPokemon);
                    recyclerHabilidades.setAdapter(adaptador);

                    String altura = jsonObject.getString("height");
                    String peso = jsonObject.getString("weight");
                    etqAltura.setText(altura);
                    etqPeso.setText(peso);


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


}