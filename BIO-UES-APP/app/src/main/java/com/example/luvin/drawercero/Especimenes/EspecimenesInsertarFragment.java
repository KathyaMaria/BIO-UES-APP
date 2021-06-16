package com.example.luvin.drawercero.Especimenes;


import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.luvin.drawercero.Investigaciones.InvestigacionViewModel;
import com.example.luvin.drawercero.R;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.Manifest.permission_group.CAMERA;
import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class EspecimenesInsertarFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {
    private EspecimenesViewModel especimenesViewModel;
    RequestQueue rq;
    JsonRequest jrq;



    final int COD_SELECCIONA=10;
    final int COD_FOTO=20;

    private static final int REQUEST_IMAGE_CAMERA=101;
    private static final int REQUEST_PERMISSION_CAMERA=101;

    Button btnGuardar, btnCancelar;
    ImageButton btnCamara, btnGaleria;
    ImageView imageView;
    public static final int MY_DEFAULT_TIMEOUT = 50000;

    EditText nombreComun;
    TextInputLayout tipoInvestigacion;
    InvestigacionViewModel investigacionesViewModel;
    AutoCompleteTextView investigaciones = null;
    EditText lugarColecta;
    EditText fechaColecta;
    EditText horaColecta;
    TextInputLayout listaRecolector;
    AutoCompleteTextView recolector = null;
    TextInputLayout listaReino;
    AutoCompleteTextView reino = null;
    EditText latitud;
    EditText longitud;
    EditText cantidadEspecimenes;
    EditText tipoMuestra;
    EditText caracteristicas;
    EditText peso;
    EditText tamaño;
    EditText habitat;
    String path;

    public EspecimenesInsertarFragment() {

        // Required empty public constructor
    }

    public static EspecimenesInsertarFragment newInstance() { return new EspecimenesInsertarFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_colecciones_insertar, container, false);
        tipoInvestigacion = (TextInputLayout) view.findViewById(R.id.TextInputLayoutInvestigacions);
        investigaciones = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextViewInvestigacion);
        lugarColecta=(EditText)view.findViewById(R.id.editTextLugarColecta);
        fechaColecta=(EditText)view.findViewById(R.id.editTextFechaColecta);
        horaColecta=(EditText)view.findViewById(R.id.editTextHoraColecta);

        listaRecolector = (TextInputLayout) view.findViewById(R.id.TextInputLayoutColector);
        recolector = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextViewColector);
        listaReino = (TextInputLayout) view.findViewById(R.id.TextInputLayoutReino);
        reino = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextViewReino);
        latitud=(EditText)view.findViewById(R.id.editTextCoordenadaLatitud);
        longitud=(EditText)view.findViewById(R.id.editTextCoordenadaLongitud);
        cantidadEspecimenes=(EditText)view.findViewById(R.id.editCantidadEspecimenesFragmentEspecimen);
        tipoMuestra=(EditText)view.findViewById(R.id.editTextTipoMuestra);
        caracteristicas=(EditText)view.findViewById(R.id.editTextCaracteristicas);
        peso=(EditText)view.findViewById(R.id.editTextPeso);
        tamaño=(EditText)view.findViewById(R.id.editTextTamaño);
        habitat=(EditText)view.findViewById(R.id.editTextHabitat);
        imageView = (ImageView)view.findViewById(R.id.imageView);
        btnCamara=(ImageButton) view.findViewById(R.id.tomarFoto);
        btnGuardar = (Button) view.findViewById(R.id.buttonIngresarEspecimenes);
        rq = Volley.newRequestQueue(getContext());


      /*  if(validaPermisos()){
            btnCamara.setEnabled(true);
        }else{
            btnCamara.setEnabled(false);
        } */

        if (ContextCompat.checkSelfPermission(getContext(), WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA}, 1000);
        }

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                 //  if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA)==
                    //        PackageManager.PERMISSION_GRANTED){
                     //  abrirCamara();
              tomarFoto(view);
            }
                  //  }else{
                     //   ActivityCompat.requestPermissions(getActivity(),new String[]{ Manifest.permission.CAMERA},
                     //           REQUEST_PERMISSION_CAMERA);
                  //  }
               // }else abrirCamara();
           // }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar_especimen("http://198.168.1.18:80/BIO-UES-APP/EspecimenesController.php");
            }
        });


        ArrayList<String> arrayListInvestigaciones;
        ArrayAdapter<String> arrayAdapterInvestigaciones;
        String TipoInvestigacion[] = {"", "Humeda", "Seca"};

        tipoInvestigacion = (TextInputLayout) view.findViewById(R.id.tipoColecciones);
        investigaciones = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextViewColecciones);
        arrayListInvestigaciones = new ArrayList<>();
        arrayListInvestigaciones.add(String.valueOf(investigacionesViewModel.getIdTipo()));


        // ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(getActivity().getApplicationContext(),
        //       android.R.layout.activity_list_item,TipoColeccion);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, arrayListInvestigaciones);
        investigaciones.setAdapter(arrayAdapter);
        investigaciones.setThreshold(1);

        //Seleccion de los tipos de Coleccion
        investigaciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,
                            new EspecimenesInsertarFragment()).commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;

    }
    String mCurrentPhotoPath;
    private File createImageFile() throws IOException{

        String timeStamp = new SimpleDateFormat("yyyyMddd_HHmss").format(new Date());
        String imageFileName="Backup_"+timeStamp+"_";
        File storageDir=getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image=File.createTempFile(imageFileName,".jpg",storageDir);
        mCurrentPhotoPath=image.getAbsolutePath();
        return image;
    }

    static final int REQUEST_TAKE_PHOTO=1;

    public void tomarFoto(View view){
        Intent takePictureInent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureInent.resolveActivity(getActivity().getPackageManager())!= null){
            File photoFile=null;
            try {
                photoFile=createImageFile();
            }catch (IOException ex){

        }
            if(photoFile!=null){
            Uri photoUri=FileProvider.getUriForFile(getActivity(),"com.example.luvin.drawercero",photoFile);
            takePictureInent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
            getActivity().startActivityForResult(takePictureInent,REQUEST_TAKE_PHOTO);
            }
        }
    }

     /* private boolean validaPermisos() {

        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            return true;
        }

        if (getContext().checkSelfPermission(CAMERA) == PackageManager.PERMISSION_GRANTED)
            if (getContext().checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                return true;
            }

        if((shouldShowRequestPermissionRationale(CAMERA)) ||
                (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE))){
            cargarDialogoRecomendacion();
        }else{
            requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,CAMERA},100);
        }

        return false;
    } */

    private void abrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getActivity().getPackageManager()) != null){
            getActivity().startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }

    static final int REQUEST_IMAGE_CAPTURE=1;
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==REQUEST_IMAGE_CAPTURE){
            if(resultCode== RESULT_OK){

                Bitmap bitmap=(Bitmap)data.getExtras().get("data");
                imageView.setImageBitmap(bitmap);
                Log.i("TAG","Result=>"+bitmap);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    /*
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imgBitmap);
        }
    }
 */
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(), "No Se pudó registrar el especimen " + error.toString() + nombreComun.getText().toString(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getContext(), "Se ha registrado el especimen " +nombreComun.getText().toString(),
                Toast.LENGTH_SHORT).show();
        limpiarCajas();
    }

    /*
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==100){
            if(grantResults.length==2 && grantResults[0]==PackageManager.PERMISSION_GRANTED
                    && grantResults[1]==PackageManager.PERMISSION_GRANTED){
                btnCamara.setEnabled(true);
            }else{
                solicitarPermisosManual();
            }
        }

    } */

    /*private void solicitarPermisosManual() {
        final CharSequence[] opciones={"si","no"};
        final AlertDialog.Builder alertOpciones=new AlertDialog.Builder(getContext());
        alertOpciones.setTitle("¿Desea configurar los permisos de forma manual?");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opciones[i].equals("si")){
                    Intent intent=new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri=Uri.fromParts("package",getContext().getPackageName(),null);
                    intent.setData(uri);
                    startActivity(intent);
                }else{
                    Toast.makeText(getContext().getApplicationContext(),"Los permisos no fueron aceptados",Toast.LENGTH_SHORT).show();
                    dialogInterface.dismiss();
                }
            }
        });
        alertOpciones.show();
    }
*/
   /*private void cargarDialogoRecomendacion() {
        AlertDialog.Builder dialogo=new AlertDialog.Builder(getContext());
        dialogo.setTitle("Permisos Desactivados");
        dialogo.setMessage("Debe aceptar los permisos para el correcto funcionamiento de la App");

        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,CAMERA},100);
            }
        });
        dialogo.show();
    }*/

  /*  public void onclick(View view) {
        cargarImagen();
    } */

 /*   private void cargarImagen() {

        final CharSequence[] opciones={"Tomar Foto","Cargar Imagen","Cancelar"};
        final AlertDialog.Builder alertOpciones=new AlertDialog.Builder(getContext());
        alertOpciones.setTitle("Seleccione una Opción");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opciones[i].equals("Tomar Foto")){
                    tomarFotografia();
                }else{
                    if (opciones[i].equals("Cargar Imagen")){
                        Intent intent=new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/");
                        startActivityForResult(intent.createChooser(intent,"Seleccione la Aplicación"),COD_SELECCIONA);
                    }else{
                        dialogInterface.dismiss();
                    }
                }
            }
        });
        alertOpciones.show();

    }*/

    /* private void tomarFotografia() {
        File fileImagen=new File(Environment.getExternalStorageDirectory(),RUTA_IMAGEN);
        boolean isCreada=fileImagen.exists();
        String nombreImagen="";
        if(isCreada==false){
            isCreada=fileImagen.mkdirs();
        }

        if(isCreada==true){
            nombreImagen=(System.currentTimeMillis()/1000)+".jpg";
        }


        path= Environment.getExternalStorageDirectory()+
                File.separator+RUTA_IMAGEN+File.separator+nombreImagen;

        File imagen=new File(path);

        Intent intent=null;
        intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        ////
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N)
        {
            String authorities=getContext().getApplicationContext().getPackageName()+".provider";
            Uri imageUri= FileProvider.getUriForFile(getContext(),authorities,imagen);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        }else
        {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagen));
        }
        startActivityForResult(intent,COD_FOTO);

        ////
    } */

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){

            switch (requestCode){
                case COD_SELECCIONA:
                    Uri miPath=data.getData();
                    imagen.setImageURI(miPath);
                    break;

                case COD_FOTO:
                    MediaScannerConnection.scanFile(this, new String[]{path}, null,
                            new MediaScannerConnection.OnScanCompletedListener() {
                                @Override
                                public void onScanCompleted(String path, Uri uri) {
                                    Log.i("Ruta de almacenamiento","Path: "+path);
                                }
                            });

                    Bitmap bitmap= BitmapFactory.decodeFile(path);
                    imagen.setImageBitmap(bitmap);

                    break;
            }


        }
    } */

/*
    @Override
    //Permisos para abrir la camara
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (permissions.length>0&& grantResults[0]==PackageManager.PERMISSION_GRANTED){
            abrirCamara();
        }else{
            Toast.makeText(getContext(),"Se necesitan habilitar los permisos de la camara",Toast.LENGTH_SHORT).show();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    */


   /*  @Override
   public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==REQUEST_IMAGE_CAMERA){
            if(resultCode== RESULT_OK){

                Bitmap bitmap=(Bitmap)data.getExtras().get("data");
                imageView.setImageBitmap(bitmap);
                Log.i("TAG","Result=>"+bitmap);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void goToCamera(){
        Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (cameraIntent.resolveActivity(getActivity().getPackageManager()) == null){
            startActivityForResult(cameraIntent,REQUEST_IMAGE_CAMERA);
        }
    } */



    void limpiarCajas() {
        investigaciones.setText("");
        nombreComun.setText("");
        lugarColecta.setText("");
        fechaColecta.setText("");
        horaColecta.setText("");
        latitud.setText("");
        longitud.setText("");
        cantidadEspecimenes.setText("");
        tipoMuestra.setText("");
        caracteristicas.setText("");
        peso.setText("");
        tamaño.setText("");
        habitat.setText("");
    }


    void registrar_especimen(String URL) {
        StringRequest stringRequest=new StringRequest(Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getContext(), "Registro Guardado con Exito", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String,String>  getParams() throws AuthFailureError{
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("idTipo",tipoInvestigacion.getEditText().toString().trim());
                parametros.put("lugarColecta",lugarColecta.getText().toString().trim());
                parametros.put("fechaColecta",fechaColecta.getText().toString().trim());
                parametros.put("horaColecta",horaColecta.getText().toString().trim());
                parametros.put("listaRecolector",listaRecolector.getEditText().toString().trim());
                parametros.put("listaReino",listaReino.getEditText().toString().trim());
                parametros.put("latitud",latitud.getText().toString().trim());
                parametros.put("longitud",longitud.getText().toString().trim());
                parametros.put("cantidadEspecimenes",cantidadEspecimenes.getText().toString().trim());
                parametros.put("tipoMuestra",tipoMuestra.getText().toString().trim());
                parametros.put("caracteristicas",caracteristicas.getText().toString().trim());
                parametros.put("peso",peso.getText().toString().trim());
                parametros.put("tamano",tamaño.getText().toString().trim());
                parametros.put("habitat",habitat.getText().toString().trim());

                return parametros;
            }
        };
        rq=Volley.newRequestQueue(getContext());
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(

                MY_DEFAULT_TIMEOUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        rq.add(stringRequest);
    }
    @Override
    public void onActivityCreated ( @Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        especimenesViewModel = new ViewModelProvider(this).get(EspecimenesViewModel.class);
        // TODO: Use the ViewModel



    }
}


