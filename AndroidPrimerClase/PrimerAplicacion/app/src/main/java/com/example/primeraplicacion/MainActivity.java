package com.example.primeraplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button btn_registrar;
    RadioGroup radioGroup;
    RadioButton radioButtonOption1;
    RadioButton radioButtonOption2;

    ArrayList<Class<? extends Activity>> listaActividades = new ArrayList<>();
    ArrayList<Class<? extends Activity>> listaMezclada = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView titulo = findViewById(R.id.titulo);
        titulo.setText("Pregunta: 1");

        btn_registrar = findViewById(R.id.registrar);
        radioGroup = findViewById(R.id.radioGroup);
        radioButtonOption1 = findViewById(R.id.radioButtonOption1);
        radioButtonOption2 = findViewById(R.id.radioButtonOption2);

        listaActividades.add(SegundaActividad.class);
        listaActividades.add(TerceraActividad.class);
        listaActividades.add(CuartaActividad.class);
        listaActividades.add(QuintaActividad.class);
        listaActividades.add(SextaActividad.class);
        listaActividades.add(SectimaActividad.class);
        listaActividades.add(OctavaActividad.class);
        listaActividades.add(NovenaActividad.class);
        listaActividades.add(DecimaActividad.class);
        listaMezclada = mezclarLista(listaActividades);
        listaMezclada.add(Resultados.class);



    }

    public void registrarRespuesta(View vista){
        Intent intencion = new Intent(this, listaMezclada.get(0));
        ArrayList<Boolean> listaRespuestas = new ArrayList<>();
        ArrayList<Class<? extends Activity>> listaSerializada = new ArrayList<>(listaMezclada);
        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            if(selectedRadioButtonId == radioButtonOption2.getId()){
                listaRespuestas.add(true);
                Log.d("selecionada", "no: ");
            }else{
                listaRespuestas.add(false);
                Log.d("selecionada", "si: ");
            }
            intencion.putExtra("respuestas", listaRespuestas);
            intencion.putExtra("indice", 1);
            intencion.putExtra("actividades", listaSerializada);
            startActivity(intencion);
        } else {
            Log.d("Texto seleccionado", "Ningún RadioButton seleccionado");
        }

    }
    public ArrayList<Class<? extends Activity>> mezclarLista(ArrayList<Class<? extends Activity>> lista) {
        ArrayList<Class<? extends Activity>> listaMezclada = new ArrayList<>(lista);

        Random rand = new Random();
        int n = listaMezclada.size();

        for (int i = 0; i < n; i++) {
            int j = rand.nextInt(n);

            Class<? extends Activity> temp = listaMezclada.get(i);
            listaMezclada.set(i, listaMezclada.get(j));
            listaMezclada.set(j, temp);
        }

        return listaMezclada;
    }

    public void consumoGetJson(View vista){

        System.out.println("Iniciando consumo");

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "http://172.20.10.2:80/APIenPHP/Obtener.php";

        JsonObjectRequest solicitud =  new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("El servidor responde OK");
                System.out.println(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor responde con un error:");
                System.out.println(error.getMessage());
            }
        });
        queue.add(solicitud);
    }






}