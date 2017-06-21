package com.corporacionnativo.formulario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String strings[] = new String[5];
    public  int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        String strings[] = new String[5];
        for (int i = 0; i < strings.length; i++)
            strings[i] = new String("Elemento "+i);

        ListView lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strings));
        */


        final View g = findViewById(R.id.btnGuardar);
        g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Toast.makeText(getApplicationContext(),"Guardar",Toast.LENGTH_SHORT).show();

                EditText cedula = (EditText) findViewById(R.id.txtCedula);

                strings[i] = new String(cedula.getText().toString());
                i+=1;

            }
        });

        final View l = findViewById(R.id.btnListar);
        l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                Toast.makeText(getApplicationContext(),"listar",Toast.LENGTH_SHORT).show();

                Toast.makeText(getApplicationContext(),strings[0],Toast.LENGTH_LONG).show();


                ListView lista = (ListView) findViewById(R.id.lista);
                lista.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strings));

            }
        });

    }
}
