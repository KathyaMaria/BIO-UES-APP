package com.example.luvin.drawercero.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
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
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {
    private TextView loginLink;
    private EditText editpassword;
    private EditText editnombre;
    private EditText editemail;
    private Button registrar;
    private int request_code = 1;
    private Bitmap bitmap;
    private ProgressDialog progreso;
    ProgressBar progressBar;
    RequestQueue requestQueue; //permitara la conexion directamente del web service
    StringRequest stringRequest;
    String URL_SERVIDOR = "http://192.168.1.18/BIO-UES-APP/registro.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        loginLink = (TextView) findViewById(R.id.link_login);
        editnombre = (EditText) findViewById(R.id.edtNamesRegistro);
        editemail = (EditText) findViewById(R.id.edtCorreoElectronicoRegistro);
        editpassword = (EditText) findViewById(R.id.edtPasswordRegistro);
        registrar = (Button) findViewById(R.id.btn_registro_usuario);
        progressBar=findViewById(R.id.progress);

        requestQueue = Volley.newRequestQueue(this);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, email, password;
                name = String.valueOf(editnombre.getText());
                email = String.valueOf(editemail.getText());
                password = String.valueOf(editpassword.getText());
                if(!editnombre.equals("")&& !editemail.equals("")&&!editpassword.equals("")){
                    progressBar.setVisibility(View.VISIBLE);
                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[3];
                            field[0] = "fullname";
                            field[1] = "email";
                            field[2] = "password";
                            //Creating array for data
                            String[] data = new String[3];
                            data[0] = name;
                            data[1] = email ;
                            data[2] = password;
                            PutData putData = new PutData("http://192.168.1.18/BIO-UES-APP/loginSevices/signup.php",
                                    "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if(result.equals("Sign Up Success")){
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(),LoginFragment.class);
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
                //registrar();
            }
        });


        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginFragment.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                finish();
            }
        });

}
}
