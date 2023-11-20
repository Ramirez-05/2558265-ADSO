package com.example.firstaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SegundaActividad extends AppCompatActivity {

    RadioGroup radioGroup;
    Button btn_registrer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

        radioGroup = findViewById(R.id.radioGroup);
        btn_registrer = findViewById(R.id.btn_registrer);

        // Recibe la lista actualizada de actividades
        Class<?>[] activitiesArray = (Class<?>[]) getIntent().getSerializableExtra("activitiesList");

    }


    public void response(View view) {

        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

            String respuesta = selectedRadioButton.getText().toString();
            System.out.println("lo que llego del radio --- "+respuesta);

            if (!activitiesList.isEmpty()) {
                Random random = new Random();
                int randomIndex = random.nextInt(activitiesList.size());


                // Obtiene la clase de la actividad aleatoria y la elimina de la lista
                Class<?> randomActivityClass = activitiesList.remove(randomIndex);

                // Crea un intent para iniciar la actividad aleatoria
                Intent intent = new Intent(this, randomActivityClass);

                // Inicia la actividad con el intent
                startActivity(intent);
            } else {
                // Si no hay más actividades, muestra un mensaje
                Toast.makeText(MainActivity.this, "Has mostrado todas las actividades", Toast.LENGTH_SHORT).show();
            }
            finish();
        } else {
            Toast.makeText(MainActivity.this, "Por favor, selecciona una respuesta", Toast.LENGTH_SHORT).show();
        }
    }
}




}