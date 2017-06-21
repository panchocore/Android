package ec.com.fgallardo.formulario;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList strings = new ArrayList();
    //public int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View g = findViewById(R.id.btnGuardar);
        g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                EditText cedula = (EditText) findViewById(R.id.txtCedula);
                EditText nombre = (EditText) findViewById(R.id.txtNombre);

                //strings[i] = new String(cedula.getText().toString());
                //i += 1;

                if (cedula.getText().toString().isEmpty() || nombre.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), R.string.ingresar_datos, Toast.LENGTH_SHORT).show();
                else {
                    strings.add(cedula.getText().toString() + "-" + nombre.getText().toString());
                    cedula.setText("");
                    nombre.setText("");

                    Toast.makeText(getApplicationContext(), R.string.mensaje_guardar, Toast.LENGTH_SHORT).show();
                }

            }
        });


        final View l = findViewById(R.id.btnListar);
        l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                Toast.makeText(getApplicationContext(), R.string.mensaje_listar, Toast.LENGTH_SHORT).show();

                //Toast.makeText(getApplicationContext(), strings[0], Toast.LENGTH_LONG).show();


                EditText lst = (EditText) findViewById(R.id.lista);
                for (int i = 0; i < strings.size(); i++) {
                    String cadena = new String(strings.get(i) + "\n");
                    lst.setText(lst.getText() + cadena);
                }

                EditText nombre = (EditText) findViewById(R.id.txtNombre);

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(nombre.getWindowToken(), 0);

            }
        });
    }
}
