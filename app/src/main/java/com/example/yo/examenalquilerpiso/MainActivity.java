package com.example.yo.examenalquilerpiso;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static String PREFS = "MisPreferencias";
    EditText dia, mes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dia = (EditText) findViewById(R.id.dia);
        mes = (EditText) findViewById(R.id.mes);
        /*
        * Tema 3
        *
        * Al crear el activity buscamos las preferencias por si hubieran datos guardados, así
        * se los mostramos al usuario antes de que escriba nada
        *
        * */
        SharedPreferences preferences = getSharedPreferences(this.PREFS, MODE_PRIVATE);
        this.dia.setText(preferences.getString("dia",""));
        this.mes.setText(preferences.getString("mes",""));
    }

    public void guardar(View v) {
        /*
        * Editamos las preferencias con los datos que haya añadido el usuario y le mostramos un mensaje
        * */
        SharedPreferences preferences = getSharedPreferences(this.PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("dia",dia.getText().toString());
        editor.putString("mes",mes.getText().toString());
        editor.commit();
        Toast.makeText(getApplicationContext(), "Pago guardado", Toast.LENGTH_SHORT).show();
    }

    public void reestablecer(View v) {
        /*
        * Borramos las preferencias y borramos los EditText además de mostrarle un mensaje al usuario
        * para que entienda que ha borrado los ajustes
        * */
        getSharedPreferences(this.PREFS,MODE_PRIVATE).edit().clear().commit();
        this.dia.setText("");
        this.mes.setText("");
        Toast.makeText(getApplicationContext(),"Pago borrado",Toast.LENGTH_SHORT).show();
    }
}
