package com.example.preguntasv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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

                // -- Cambiar el color del fondo
                ColorDrawable colorDrawable = new ColorDrawable(Color.rgb(232, 251, 248));

                // Crear un array de capas para combinar fondo y borde
                Drawable[] capas = {colorDrawable, getBorde()};

                LayerDrawable layerDrawable = new LayerDrawable(capas);
                etiqueta.setBackground(layerDrawable);

                //-- agregamos espacio interno
                etiqueta.setPadding(50,55,50,5);

                // -- Agregamos márgenes
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                int margenPixels = 15;
                layoutParams.setMargins(margenPixels, margenPixels, margenPixels, margenPixels);
                etiqueta.setLayoutParams(layoutParams);

                // -- Agregamos el tamaño de la letra
                float tamanoLetra = 18;  // Ajusta el valor del tamaño de letra según tus preferencias
                etiqueta.setTextSize(tamanoLetra);

                etiqueta.setTypeface(null, Typeface.BOLD);

                etiqueta.setText("Numero "+(i+1)+"\n");
                etiqueta.append("Fecha Inicio "+cuestionario.getString("fecha_inicio")+"\n");
                etiqueta.append("N° Preguntas "+cuestionario.getString("cant_preguntas")+"\n");
                etiqueta.append("N° OK "+cuestionario.getString("cant_ok")+" N° ERROR "+cuestionario.getString("cant_error")+"\n");
                System.out.println("REVISANDO RES "+etiqueta);

                etiqueta.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            String id =  cuestionario.getString("id");
                            String fecha_inicio =  cuestionario.getString("fecha_inicio");
                            String fecha_fin =  cuestionario.getString("fecha_fin");
                            String num_preguntas =  cuestionario.getString("cant_preguntas");
                            String preguntas_ok =  cuestionario.getString("cant_ok");
                            String preguntas_error =  cuestionario.getString("cant_error");

                            cambiarActivity(id, fecha_inicio,fecha_fin,num_preguntas, preguntas_ok, preguntas_error);

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });


                layoutCuestionarios.addView(etiqueta);

            }

        }catch (JSONException e){
            throw  new RuntimeException(e);
        }

    }

    private GradientDrawable getBorde() {
        GradientDrawable borde = new GradientDrawable();
        borde.setColor(Color.TRANSPARENT);  // Fondo transparente
        borde.setStroke(8, Color.rgb(66, 135, 161));
        return borde;
    }

    public void cambiarActivity
            (String id,
             String fecha_inicio,
             String fecha_fin,
             String cant_preguntas,
             String preguntas_ok,
             String preguntas_error){

        SharedPreferences archivo = getSharedPreferences( "app_preguntas", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = archivo.edit();
        editor.putString("id_", id);
        editor.putString("fecha_inicio", fecha_inicio);
        editor.putString("fecha_fin", fecha_fin);
        editor.putString("cant_preguntas", cant_preguntas);
        editor.putString("cant_ok", preguntas_ok);
        editor.putString("cant_error", preguntas_error);

        editor.apply();

        Intent intencion = new Intent(getApplicationContext(), Detail.class );
        startActivity(intencion);
        finish();

    }


}