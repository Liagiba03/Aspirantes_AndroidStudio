package com.edu.aspirantes;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.edu.aspirantes.model.Aspirantes;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText txtNombre;
    TextInputEditText txtProBa;
    Spinner spnTipoBa;
    Spinner spnCarrera;
    ImageButton btnResultado;
    ImageButton btnNuevo;
    ImageButton btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre= findViewById(R.id.etxtNombre);
        txtProBa = findViewById(R.id.etxtPromBa);
        btnResultado = findViewById(R.id.buttonResultados1);
        btnNuevo = findViewById(R.id.buttonNuevo);
        btnSalir = findViewById(R.id.botonSalir);
        spnTipoBa = findViewById(R.id.spnTipoBa);
        spnCarrera = findViewById(R.id.spnCarrera);

        ArrayAdapter<CharSequence> adapBa = ArrayAdapter.createFromResource(this,
                R.array.tipoBachillerato,
                android.R.layout.simple_spinner_dropdown_item);
        adapBa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnTipoBa.setAdapter(adapBa);

        ArrayAdapter<CharSequence> adapCa = ArrayAdapter.createFromResource(this,R.array.carrera,
                android.R.layout.simple_spinner_dropdown_item);
        adapCa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCarrera.setAdapter(adapCa);

        //BOTON RESULTADOS
        btnResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txtNombre.getText().toString().trim();
                String prom = txtProBa.getText().toString().trim();

                try {
                    if (nombre.length() ==0 || prom.length()==0){
                        Toast.makeText(getApplicationContext(), "No dejes campos vacios", Toast.LENGTH_SHORT).show();
                    }else if(Integer.parseInt(prom)<0){
                        Toast.makeText(getApplicationContext(), "Valor invalido en promedio", Toast.LENGTH_SHORT).show();
                    }else if(spnTipoBa.getSelectedItemPosition()==0 || spnCarrera.getSelectedItemPosition()==0){
                        Toast.makeText(getApplicationContext(), "Selecciona un campo", Toast.LENGTH_SHORT).show();
                    }else {

                        Aspirantes asp = new Aspirantes();
                        asp.setNombre(nombre);
                        asp.setPromedioBa(Double.parseDouble(prom));
                        asp.setTipoBa(spnTipoBa.getSelectedItemPosition());
                        asp.setCarrera(spnCarrera.getSelectedItem().toString());
                        Toast.makeText(getApplicationContext(), asp.estatus()
                                , Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception ex){
                    Toast.makeText(getApplicationContext(), "Coloca valores válidos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //BOTON SALIR
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //BOTON NUEVO
        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNombre.setText(null);
                txtProBa.setText(null);
                spnTipoBa.setSelection(0);
                spnCarrera.setSelection(0);
            }
        });

    }
}