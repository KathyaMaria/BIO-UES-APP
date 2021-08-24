package com.example.luvin.drawercero.Especimenes;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Base64;
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
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.app.Activity.RESULT_OK;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.content.ContentValues.TAG;
import static android.database.Cursor.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class EspecimenesRegistrarDatoPreliminarFragment extends Fragment implements Response.Listener<JSONObject>,
        Response.ErrorListener , View.OnClickListener{

    private Especimen especimenesViewModel;
    RequestQueue rq;
    JsonRequest jrq;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener; //llamado de la interfaz

    private static final String CARPETA_PRINCIPAL = "misImagenesApp/";//directorio principal
    private static final String CARPETA_IMAGEN = "imagenes";//carpeta donde se guardan las fotos
    private static final String DIRECTORIO_IMAGEN = CARPETA_PRINCIPAL + CARPETA_IMAGEN;//ruta carpeta de directorios
    private String path;//almacena la ruta de la imagen
    File fileImagen;
    Bitmap bitmap;

    private final int MIS_PERMISOS = 100;
    private static final int COD_SELECCIONA = 10;
    private static final int COD_FOTO = 20;
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
    private String mCurrentPhotoPath;
    private ContentValues values;
    private Uri imageUri;
    private Bitmap thumbnail;
    String imageurl;
    private static final String TAG = "EspecimenesRegistrarDatoPreliminarFragment";
    private static final int PICTURE_RESULT = 122 ;

    public EspecimenesRegistrarDatoPreliminarFragment() {
        // Required empty public constructor
    }

    public static EspecimenesInsertarFragment newInstance() { return new EspecimenesInsertarFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_especimenes, container, false);
        tipoInvestigacion = (TextInputLayout) view.findViewById(R.id.TextInputLayoutInvestigacions);
        investigaciones = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextViewInvestigacion);
        lugarColecta=(EditText)view.findViewById(R.id.editTextLugarColecta);
        fechaColecta=(EditText)view.findViewById(R.id.editTextFechaColecta);
        horaColecta=(EditText)view.findViewById(R.id.editTextHoraColecta);

        listaRecolector = (TextInputLayout) view.findViewById(R.id.TextInputLayoutColector);
        recolector = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextViewColector);
        latitud=(EditText)view.findViewById(R.id.editTextCoordenadaLatitud);
        longitud=(EditText)view.findViewById(R.id.editTextCoordenadaLongitud);
        cantidadEspecimenes=(EditText)view.findViewById(R.id.editCantidadEspecimenesFragmentEspecimen);
        tipoMuestra=(EditText)view.findViewById(R.id.editTextTipoMuestra);
        caracteristicas=(EditText)view.findViewById(R.id.editTextCaracteristicas);
        peso=(EditText)view.findViewById(R.id.editTextPeso);
        tamaño=(EditText)view.findViewById(R.id.editTextTamaño);
        habitat=(EditText)view.findViewById(R.id.editTextHabitat);
        btnCamara=(ImageButton) view.findViewById(R.id.tomarFotoButton);
        imageView = (ImageView)view.findViewById(R.id.imageView);
        btnGuardar = (Button) view.findViewById(R.id.buttonIngresarEspecimenes);
        btnGaleria = (ImageButton) view.findViewById(R.id.seleccionarDesdeGaleria);
        rq = Volley.newRequestQueue(getContext());


      /*  if (ContextCompat.checkSelfPermission(getContext(), WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA}, 1000);
        }

*/

        /*btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarWebService();
            }
        }); */

   /*     btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCamara();

            }

        });  //this works fine*/

      //  imageView.setOnClickListener((View.OnClickListener) this);
        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    //Check permissions for Android 6.0+
                    if(!checkExternalStoragePermission()){
                        return;
                    }
                }

                values = new ContentValues();
                values.put(MediaStore.Images.Media.TITLE, "MyPicture");
                values.put(MediaStore.Images.Media.DESCRIPTION, "Photo taken on " + System.currentTimeMillis());
                imageUri = getActivity().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, PICTURE_RESULT);
            }
        });
        btnGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    //Check permissions for Android 6.0+
                    if(!checkExternalStoragePermission()){
                        return;
                    }
                }
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,COD_SELECCIONA);
            }
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
     //   arrayListInvestigaciones = new ArrayList<>();
//        arrayListInvestigaciones.add(String.valueOf(investigacionesViewModel.getIdTipo()));


        // ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(getActivity().getApplicationContext(),
        //       android.R.layout.activity_list_item,TipoColeccion);
     //   ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
       //         android.R.layout.simple_spinner_dropdown_item, arrayListInvestigaciones);
        //investigaciones.setAdapter(arrayAdapter);
        //investigaciones.setThreshold(1);

        //Seleccion de los tipos de Dominio
       /* investigaciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        }); */

        return view;

    }
    private boolean checkExternalStoragePermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission not granted.");
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 225);
        } else {
            Log.i(TAG, "You already have permission!");
            return true;
        }

        return false;
    }

    public String getRealPathFromURI(Uri contentUri) {
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContext().getContentResolver().query(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    static final int REQUEST_IMAGE_CAPTURE=1;

   /*private void abrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getActivity().getPackageManager()) != null){
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {

                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.TITLE, "MyPicture");
                values.put(MediaStore.Images.Media.DESCRIPTION, "Photo taken on " + System.currentTimeMillis());
                photoURI = getContext().getContentResolver().insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

                //Uri photoURI = FileProvider.getUriForFile(AddActivity.this, "com.example.android.fileprovider", photoFile);

                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }*/

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir =getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }
    private void abrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getActivity().getPackageManager()) != null){
            //Valida que se pueda usar el recurso de la camara
            getActivity().startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    } // este es el que tenia antes ya funcionando


    /*public ContentResolver getContentResolver() {
        return null;
    }*/

    private Uri photoURI;
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       /*super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode== RESULT_OK){
            Bitmap bitmap;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), photoURI);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } */
        switch (requestCode) {
            case PICTURE_RESULT:
                if (requestCode == PICTURE_RESULT)
                    if (resultCode == Activity.RESULT_OK) {
                        try {
                            thumbnail = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), imageUri);
                            imageView.setImageBitmap(thumbnail);
                            imageurl = getRealPathFromURI(imageUri);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
            case COD_SELECCIONA:
                if (requestCode == COD_SELECCIONA)
                    if (resultCode == Activity.RESULT_OK) {
                       imageUri=data.getData();
                       imageView.setImageURI(imageUri);

                    }
        }
    }


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
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
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
    public void onClick(View v) {

    }
   /* @Override
    public void onActivityCreated ( @Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        especimenesViewModel = new ViewModelProvider(this).get(Especimen.class);
        // TODO: Use the ViewModel
    }*/

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}


