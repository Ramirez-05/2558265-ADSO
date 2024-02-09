package com.example.preguntasv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.preguntasv2.utils.Config;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Detail extends AppCompatActivity {

    TextView etq_fechaInicio;
    TextView etq_fechaFin;
    TextView etq_preguntas;
    TextView etq_preguntasCorrectas;
    TextView etq_preguntasIncorrectas;

    String id;
    String fechaInicio;
    String fechaFin;
    String preguntas;
    String preguntasCorrectas;
    String preguntasIncorrectas;


    Config dataConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        dataConfig = new Config(getApplicationContext());
        etq_fechaInicio = findViewById(R.id.etq_fechaInicio);
        etq_fechaFin = findViewById(R.id.etq_fechaFin);
        etq_preguntas = findViewById(R.id.etq_preguntas);
        etq_preguntasCorrectas = findViewById(R.id.etq_preguntasCorrectas);
        etq_preguntasIncorrectas = findViewById(R.id.etq_preguntasIncorrectas);

        SharedPreferences archivo = getSharedPreferences("app_preguntas", Context.MODE_PRIVATE);
        fechaInicio = archivo.getString("fecha_inicio", null);
        fechaFin = archivo.getString("fecha_fin", null);
        preguntas = archivo.getString("cant_preguntas", null);
        preguntasCorrectas = archivo.getString("cant_ok", null);
        preguntasIncorrectas = archivo.getString("cant_error", null);

        etq_fechaInicio.setText(fechaInicio);
        etq_fechaFin.setText(fechaFin);
        etq_preguntas.setText(preguntas);
        etq_preguntasCorrectas.setText(preguntasCorrectas);
        etq_preguntasIncorrectas.setText(preguntasIncorrectas);

        id = archivo.getString("id", null);

        obtenerRespuestas(id);

    }

    public  void obtenerRespuestas(String id){
        System.out.println("Iniciando consumo de respuestas ");

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = dataConfig.getEndPoint("/getRespuestas.php");

        StringRequest solicitud =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject datos = new JSONObject(response);

                    if (datos.getBoolean("status")){

                        String num_pregunta = datos.getJSONObject("respuestas").getJSONObject("pregunta").getString("id");
                        String descripcion = datos.getJSONObject("respuestas").getJSONObject("pregunta").getString("descripcion");

                    }else{
                        Toast.makeText(getApplicationContext(),"Usuario no encontrado",Toast.LENGTH_LONG).show();
                    }

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
        }){
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", id);

                return params;
            }
        };



        queue.add(solicitud);
    }


}