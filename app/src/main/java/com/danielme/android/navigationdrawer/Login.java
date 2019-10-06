package com.danielme.android.navigationdrawer;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cpinedae.movilidad.Tareas.TareaConsultaUsuarioWS;

public class Login extends AppCompatActivity {
    private Button btnIngresar;
    private TextView txtUsuario, textRuta, txtContraseña;
    private String userAdmin = "admin";
    private String contraseñaAdmin = "admin";
    private String ruta = "R1";
    String activo = "";
    String usuario="";
    String contraseña="";
    String cRuta="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnIngresar = findViewById(R.id.btnIngresar);
        txtUsuario = findViewById(R.id.txtUsuario);
        txtContraseña = findViewById(R.id.txtContraseña);
        textRuta = findViewById(R.id.textRuta);


        //ingresarHome atq-091410243
    }

    public String quitaNulo(String var) {
        String res = "";
        if (var != null && var.trim().length() > 0) {
            res = var.trim().replace(".null.", "").replace("null", "").replace(".NULL.", "").replace("NULL", "");
        } else {
            res = "";
        }
        return res.trim();
    }

    public void ingresarHome(View view) {

        if (txtUsuario.getText().toString().trim().equals(userAdmin) && txtContraseña.getText().toString().trim().equals(userAdmin)
                && textRuta.getText().toString().toUpperCase().trim().equals(ruta)) {

            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            finish();
            Toast.makeText(getApplicationContext(), "Ingreso exitoso", Toast.LENGTH_SHORT).show();
        } else if (!txtUsuario.getText().toString().equals("") && !txtContraseña.getText().toString().equals("")
                && !textRuta.getText().toString().toUpperCase().equals("")) {
            usuario= quitaNulo(txtUsuario.getText().toString().trim());
            contraseña =quitaNulo(txtContraseña.getText().toString().trim());
            cRuta = quitaNulo(textRuta.getText().toString());
            System.out.println(usuario+"...."+contraseña+"...."+cRuta);
            AsyncCallWS task = new AsyncCallWS();
            task.execute();

        } else {
            Toast.makeText(this, "Verifica los dotos de login", Toast.LENGTH_SHORT).show();
            txtContraseña.setText("");
//            txtUsuario.setText("");
//            textRuta.setText("");
            txtUsuario.requestFocus();
            // System.out.println("***********************" + activo);
        }

    }

    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            TareaConsultaUsuarioWS consultaUsuario = new TareaConsultaUsuarioWS();
//            String respuesta = consultaUsuario.invokeUsuario("cpineda", "holamundo", 3);
            Integer cod_ruta = Integer.valueOf(cRuta.trim());

            String respuesta = consultaUsuario.invokeUsuario(usuario, contraseña, cod_ruta);
            Log.i("TAG", "Respuesta del WSMovil es [" + respuesta + "]");
            activo = respuesta.replace("<activo>", "").replace("</activo>", "");
            System.out.println("REspuesta del ws........" + activo);


            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            if (activo.equals("S")) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(getApplicationContext(), "Ingreso exitoso", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Verifica los dotos de login", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
