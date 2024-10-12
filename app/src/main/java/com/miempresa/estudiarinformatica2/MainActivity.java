package com.miempresa.estudiarinformatica2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnBorrar;
    private Spinner spnCiclo;
    private Spinner spnPoblacion;
    private Spinner spnTipo;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar vistas
        btnBorrar = findViewById(R.id.btnBorrar);
        spnCiclo = findViewById(R.id.spnCiclo);
        spnPoblacion = findViewById(R.id.spnPoblacion);
        spnTipo = findViewById(R.id.spnTipo);
        txtResultado = findViewById(R.id.txtResultado);

        // Listener común para los Spinners
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                mostrar();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        };

        // Asignar los listeners a cada Spinner
        spnCiclo.setOnItemSelectedListener(itemSelectedListener);
        spnPoblacion.setOnItemSelectedListener(itemSelectedListener);
        spnTipo.setOnItemSelectedListener(itemSelectedListener);

        // Asignar la funcionalidad al botón borrar
        btnBorrar.setOnClickListener(v -> borrar());
    }

    // Método para mostrar el resumen
    private void mostrar() {
        String ciclo = spnCiclo.getSelectedItem().toString();
        String poblacion = spnPoblacion.getSelectedItem().toString();
        String tipo = spnTipo.getSelectedItem().toString();

        String resumen = ciclo + " en " + poblacion + " de forma " + tipo;
        txtResultado.setText(resumen);
    }

    // Método para borrar las selecciones y el resumen
    private void borrar() {
        spnCiclo.setSelection(0);
        spnPoblacion.setSelection(0);
        spnTipo.setSelection(0);
        txtResultado.setText("");
    }
}
