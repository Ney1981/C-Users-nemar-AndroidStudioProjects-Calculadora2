package com.example.calculadora2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Principal extends AppCompatActivity {

    Double num1, num2, resultado;
    int operador;

    // creo la contante del resultado
    public  static final String EXTRA_MESSAGE = "com.example.principal.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void resultado (View view){

        // meto el textView dentro de la variable num2 con un parse para convertir la cadena de texto a double
        TextView tv = findViewById(R.id.textView);
        num2 = Double.parseDouble(tv.getText().toString());

        // miramos que boton de operacion se ha hecho clic (como una especie de menú)
        if (operador==1){
            resultado = num1+num2;
        }
        if (operador==2) {
            resultado = num1 - num2;
        }
        // meto el resultado como un mensaje que se envia a la ActivityResultado para que muestre el resultado
        Intent intent = new Intent(this, ActivityResultado.class);
        String message = resultado.toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void guardarNum1 (View view){
        //guardo el valor del textView
        TextView tv = findViewById(R.id.textView);
        num1 = Double.parseDouble(tv.getText().toString());
        // limpio el textView para el siguiente numero
        tv.setText("");
    }

    public void botonSuma (View view){
        operador = 1;
        // guardo el valor que se ha escrito en el textView en la variable num1
        guardarNum1(view);
    }

    public void botonResta (View view){
        operador = 2;
        // guardo el valor que se ha escrito en el textView en la variable num1
        guardarNum1(view);
    }
    public void botonDivision (View view){
        operador = 3;
        guardarNum1(view);
    }

    public void botonBorrarTodo(View view){
        num1 = 0.0;
        num2 = 0.0;
        TextView tv = findViewById(R.id.textView);
        tv.setText("");
    }


    public void borrarUltimaCifra (View view){
        TextView tv = findViewById(R.id.textView);
        String str = tv.getText().toString();
        str = str.substring(0, str.length()-1);
        tv.setText(str.toString());
    }

    public void boton1 (View view){
        
        TextView tv = findViewById(R.id.textView);
        tv.setText(tv.getText() + "1");
    }
    public void boton2 (View view){
        TextView tv = findViewById(R.id.textView);
        tv.setText(tv.getText() + "2");
    }
    public void boton3 (View view){
        TextView tv = findViewById(R.id.textView);
        tv.setText(tv.getText() + "3");
    }
    public void boton4 (View view){
        TextView tv = findViewById(R.id.textView);
        tv.setText(tv.getText() + "4");
    }
}