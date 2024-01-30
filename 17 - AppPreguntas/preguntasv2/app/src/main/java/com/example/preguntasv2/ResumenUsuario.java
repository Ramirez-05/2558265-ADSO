package com.example.preguntasv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.preguntasv2.utils.Config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ResumenUsuario extends AppCompatActivity {

    TextView etq_usuario;
    String nombre_usuario;

    String id_usuario;

    LinearLayout layoutCuestionarios;

    Config dataConfig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_usuario);

        dataConfig = new Config(getApplicationContext());

        etq_usuario = findViewById(R.id.etq_usuario);
        layoutCuestionarios = findViewById(R.id.layoutCuestionarios);

        SharedPreferences archivo = getSharedPreferences("app_preguntas", Context.MODE_PRIVATE);
        id_usuario = archivo.getString("id_usuario", null);
        nombre_usuario = archivo.getString("nombres", null);

        etq_usuario.setText(nombre_usuario);

        obtenerCuestionarios();

    }

    public void cerrarSesion(View vista){
        SharedPreferences sharedPreferences = getSharedPreferences("app_preguntas", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();


        Intent intencion = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intencion);
        finish();
    }

    public void obtenerCuestionarios() {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = dataConfig.getEndPoint("/getCuestionarios.php");

        StringRequest solicitud = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    cargarCuestionarios(jsonObject.getJSONArray("cuestionarios"));
                } catch (JSONException e) {
                    throw new RuntimeException(e);

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor POST responde con un error:");
                System.out.println(error.getMessage());
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("id_usuario", id_usuario);


                return params;
            }
        };

        queue.add(solicitud);

    }

    public void cargarCuestionarios(JSONArray datos){

        try {

            for(int i=0; i<datos.length(); i++){
                JSONObject cuestionario = datos.getJSONObject(i);

                TextView etiqueta = new TextView(getApplicationContext());
                etiqueta.setTextColor(Color.BLACK);
                etiqueta.setText("N "+(i+1)+"\n");
                etiqueta.append("Fecha Inicio "+cuestionario.getString("fecha_inicio")+"\n");
                etiqueta.append("Fecha Fin "+cuestionario.getString("fecha_fin")+"\n");
                etiqueta.append("Preguntas "+cuestionario.getString("cant_preguntas")+"\n");
                etiqueta.append("Correctas "+cuestionario.getString("cant_ok")+"\n");
                etiqueta.append("Erroneas "+cuestionario.getString("cant_error")+"\n\n");

                System.out.println("REVISANDO RES "+etiqueta);

                layoutCuestionarios.addView(etiqueta);


            }

        }catch (JSONException e){
            throw  new RuntimeException(e);
        }


    }


}