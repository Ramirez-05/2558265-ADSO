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

public class SegundaActividad extends AppCompatActivity {

    RadioGroup radioGroup;
    Button btn_registrer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

        radioGroup = findViewById(R.id.radioGroup);
        btn_registrer = findViewById(R.id.btn_registrer);
    }

    public void response(View vista) {
        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

            String respuesta = selectedRadioButton.getText().toString();
            System.out.println("lo que llego del radio --- "+respuesta);
            Intent intencion = new Intent(this, TerceraActividad.class);
            intencion.putExtra("respuesta", respuesta);
            startActivity(intencion);
            finish();
        } else {
            Toast.makeText(SegundaActividad.this, "Por favor, selecciona una respuesta", Toast.LENGTH_SHORT).show();
        }
    }
}