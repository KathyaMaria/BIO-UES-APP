package com.example.luvin.drawercero.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.luvin.drawercero.MainActivity;
import com.example.luvin.drawercero.R;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {
    private TextView loginLink;
    private EditText password;
    private EditText nombre;
    private EditText email;
    private Button registrar;
    private int request_code = 1;
    private Bitmap bitmap;
    private ProgressDialog progreso;
    RequestQueue requestQueue; //permitara la conexion directamente del web service
    StringRequest stringRequest;
    String URL_SERVIDOR = "http://192.168.1.18/BIO-UES-APP/registro.php";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        loginLink = (TextView)findViewById(R.id.link_login);
        nombre = (EditText)findViewById(R.id.edtNamesRegistro);
        email = (EditText)findViewById(R.id.edtCorreoElectronicoRegistro);
        password = (EditText)findViewById(R.id.edtPasswordRegistro);
               registrar = (Button)findViewById(R.id.btn_registro_usuario);

        requestQueue = Volley.newRequestQueue(this);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar();
            }
        });


        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginFragment.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                finish();
            }
        });
    }
    public void registrar() {

        if (!validar()) return;
        progreso = new ProgressDialog(this);
        progreso.setMessage("Iniciando...");
        progreso.show();
                StringRequest stringRequest;
        stringRequest = new StringRequest(Request.Method.POST, URL_SERVIDOR,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        // En este apartado se programa lo que deseamos hacer en caso de no haber errores

                        if(response.equals("ERROR 1")) {
                            Toast.makeText(SignupActivity.this, "Se deben de llenar todos los campos.", Toast.LENGTH_SHORT).show();
                        } else if(response.equals("ERROR 2")) {
                            Toast.makeText(SignupActivity.this, "Fallo el registro.", Toast.LENGTH_SHORT).show();
                        } else if(response.equals("MENSAJE")) {
                            Toast.makeText(SignupActivity.this, "Registro exitoso. Ya puede ingresar sus credenciales",
                                    Toast.LENGTH_LONG).show();

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // En caso de tener algun error en la obtencion de los datos
                Toast.makeText(SignupActivity.this, "ERROR CON LA CONEXION", Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                // En este metodo se hace el envio de valores de la aplicacion al servidor
                Map<String, String> parametros = new Hashtable<String, String>();
                parametros.put("name", nombre.getText().toString().trim());
                parametros.put("email", email.getText().toString().trim());
                parametros.put("password", password.getText().toString().trim());

                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(SignupActivity.this);
        requestQueue.add(stringRequest);
    }

   /* private void Registrar() {

     if (!validar()) return;

        progreso = new ProgressDialog(this);
        progreso.setMessage("Iniciando...");
        progreso.show();
        String url = "http://192.168.1.18/BIO-UES-APP/register_movil.php";

        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                User userParcelable = new User();;
                Log.i("RESPUESTA JSON: ",""+response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.names().get(0).equals("success")){
                        nombre.setText("");
                        email.setText("");
                        password.setText("");
                        userParcelable.setName(jsonObject.getJSONArray("users").getJSONObject(0).getString("name"));
                        userParcelable.setEmail(jsonObject.getJSONArray("users").getJSONObject(0).getString("email"));
                        userParcelable.setPassword(jsonObject.getJSONArray("users").getJSONObject(0).getString("password"));


                        Toast.makeText(getApplicationContext(),jsonObject.getString("success"),Toast.LENGTH_SHORT).show();
                        progreso.dismiss();

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("DATA_USER",userParcelable.toString());
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),jsonObject.getString("error"),Toast.LENGTH_SHORT).show();
                        Log.i("RESPUESTA JSON: ",""+jsonObject.getString("error"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                progreso.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"No se ha podido conectar",Toast.LENGTH_SHORT).show();
                Log.i("ERROR: ",""+error.toString());
                progreso.dismiss();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {//para enviar los datos mediante POST
                String sNombre = nombre.getText().toString();
                String sEmail = email.getText().toString();
                String sPassword =  password.getText().toString();


                Map<String,String> parametros = new HashMap<>();
                parametros.put("name",sNombre);
                parametros.put("email",sEmail);
                  parametros.put("password",sPassword);
                //estos parametros son enviados a nuestro web service

                return parametros;
            }
        };

        requestQueue.add(stringRequest);
    } */



    private boolean validar() {
        boolean valid = true;

        String sNombre = nombre.getText().toString();
        String sEmail = email.getText().toString();
        String sPassword = password.getText().toString();


        if (sNombre.isEmpty() || sNombre.length() < 3) {
            nombre.setError("Ingrese al menos 3 caracteres");
            valid = false;
        } else {
            nombre.setError(null);
        }

        if (sEmail.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(sEmail).matches()) {
            email.setError("Dirección de correo electrónico no válida");
            valid = false;
        } else {
            email.setError(null);
        }

        if (sPassword.isEmpty() || password.length() < 4 || password.length() > 10) {
            password.setError("Ingrese entre 4 a 10 caracteres alfanuméricos");
            valid = false;
        } else {
            password.setError(null);
        }

        return valid;
    }

}
