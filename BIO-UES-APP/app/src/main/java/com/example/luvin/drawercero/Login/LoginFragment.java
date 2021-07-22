package com.example.luvin.drawercero.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.luvin.drawercero.Inicio.InicioFragment;
import com.example.luvin.drawercero.MainActivity;
import com.example.luvin.drawercero.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.HashMap;
import java.util.Map;

import com.facebook.FacebookSdk;

public class LoginFragment extends AppCompatActivity {
    private Button acceder;
    private TextView registrar;
    private EditText editemail;
    private EditText editpassword;
    private ProgressDialog progreso;
    private RequestQueue requestQueue;
    StringRequest stringRequest;
    LoginButton loginButton;
    private CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_fragment);

        editemail = (EditText)findViewById(R.id.edtUsuario);
        editpassword = (EditText)findViewById(R.id.edtPassword);
        acceder = (Button)findViewById(R.id.btnLogin);
        registrar = (TextView)findViewById(R.id.signup);
        requestQueue = Volley.newRequestQueue(this);
        ProgressBar progressBar;
        progressBar=findViewById(R.id.progress);


        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                IraMain();

            }

            @Override
            public void onCancel() {

                Toast.makeText(getApplicationContext(),"se cancelo el inicio de sesion", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(FacebookException error) {

            }
        });


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
        acceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  email, password;

                email = String.valueOf(editemail.getText());
                password = String.valueOf(editpassword.getText());
                if(!editemail.equals("")&&!editpassword.equals("")){
                    progressBar.setVisibility(View.VISIBLE);
                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "email";
                            field[1] = "password";
                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = email ;
                            data[1] = password;
                            PutData putData = new PutData("http://192.168.1.26/BIO-UES-APP/loginSevices/login.php",
                                    "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if(result.equals("Login Success")){
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }else {
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                    //End ProgressBar (Set visibility to GONE)
                                    //Log.i("PutData", result);
                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(), "Todos los campos son requeridos", Toast.LENGTH_SHORT).show();
                }
            }
        });

       /* acceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               iniciarSesion("http://192.168.1.18/BIO-UES-APP/login_movil.php");
            }
        }); */
    }

    private void IraMain() {

        Intent intent = new Intent(LoginFragment.this, MainActivity.class);
        finish();
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        callbackManager.onActivityResult(requestCode, resultCode, data);
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

        String sEmail = editemail.getText().toString();
        String sPassword = editpassword.getText().toString();

        if (sEmail.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(sEmail).matches()) {
            editemail.setError("Introduzca una dirección de correo electrónico válida");
            valid = false;
        } else {
            editemail.setError(null);
        }

        if (sPassword.isEmpty() || editpassword.length() < 4 || editpassword.length() > 10) {
            editpassword.setError("Entre 4 y 10 caracteres alfanuméricos");
            valid = false;
        } else {
            editpassword.setError(null);
        }

        return valid;
    }

    private void iniciarSesion(String URL){

       if (!validar()) return;

        progreso = new ProgressDialog(this);
        progreso.setMessage("Iniciando...");
        progreso.show();
        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
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
                parametros.put("email",editemail.getText().toString());
                parametros.put("password",editpassword.getText().toString());
                return parametros;
            }

        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}