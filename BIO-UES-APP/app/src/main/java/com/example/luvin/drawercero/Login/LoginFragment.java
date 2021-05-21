package com.example.luvin.drawercero.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.luvin.drawercero.MainActivity;
import com.example.luvin.drawercero.R;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginFragment extends AppCompatActivity {
    private Button acceder;
    private TextView registrar;
    private EditText email;
    private EditText password;
    private ProgressDialog progreso;
    private RequestQueue requestQueue;
    StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_fragment);

        email = (EditText)findViewById(R.id.edtUsuario);
        password = (EditText)findViewById(R.id.edtPassword);
        acceder = (Button)findViewById(R.id.btnLogin);
        registrar = (TextView)findViewById(R.id.signup);
        requestQueue = Volley.newRequestQueue(this);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                finish();
            }
        });

        acceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               iniciarSesion("http://192.168.1.18/BIO-UES-APP/login_movil.php");
            }
        });
    }


   /* private void iniciar() {

        if (!validar()) return;

        progreso = new ProgressDialog(this);
        progreso.setMessage("Iniciando...");
        progreso.show();
        String url = "http://192.168.1.18/BIO-UES-APP/login_movil.php";

        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                User userParcelable = new User();;
                Log.i("RESPUESTA JSON: ",""+response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.names().get(0).equals("success")){
                        email.setText("");
                        password.setText("");


                        userParcelable.setName(jsonObject.getJSONArray("user").getJSONObject(0).getString("email"));
                        userParcelable.setPassword(jsonObject.getJSONArray("user").getJSONObject(0).getString("password"));

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
                progreso.dismiss();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {//para enviar los datos mediante POST
                String sEmail = email.getText().toString();
                String sPassword =  password.getText().toString();

                Map<String,String> parametros = new HashMap<>();
                parametros.put("email",sEmail);
                parametros.put("password",sPassword);
                //estos parametros son enviados a nuestro web service

                return parametros;
            }
        };

        requestQueue.add(stringRequest);
    }*/

    private boolean validar() {
        boolean valid = true;

        String sEmail = email.getText().toString();
        String sPassword = password.getText().toString();

        if (sEmail.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(sEmail).matches()) {
            email.setError("Introduzca una dirección de correo electrónico válida");
            valid = false;
        } else {
            email.setError(null);
        }

        if (sPassword.isEmpty() || password.length() < 4 || password.length() > 10) {
            password.setError("Entre 4 y 10 caracteres alfanuméricos");
            valid = false;
        } else {
            password.setError(null);
        }

        return valid;
    }

    private void iniciarSesion(String URL){
        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginFragment.this,"Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginFragment.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("email",email.getText().toString());
                parametros.put("password",password.getText().toString());
                return parametros;
            }

        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}