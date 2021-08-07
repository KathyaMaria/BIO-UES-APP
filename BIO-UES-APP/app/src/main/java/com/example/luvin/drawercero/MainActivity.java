package com.example.luvin.drawercero;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import 	androidx.appcompat.widget.Toolbar;

import com.example.luvin.drawercero.Espamen.ConsultarListaEspamen;
import com.example.luvin.drawercero.Especies.ConsultarListaEspecies;
import com.example.luvin.drawercero.Especimen.EspecimenFragment;
import com.example.luvin.drawercero.Login.LoginFragment;
import com.example.luvin.drawercero.Zonas.ConsultarListaZonasFragment;
import com.example.luvin.drawercero.Zonas.Zona;
import com.example.luvin.drawercero.Zonas.ZonaAdapter;
import com.example.luvin.drawercero.interfaces.IFragments;
import com.example.luvin.drawercero.Coleccion.InformacionFragment;
import com.example.luvin.drawercero.Contactenos.ContactenosFragment;
import com.example.luvin.drawercero.Dominios.ConsultarListaDominiosFragment;
import com.example.luvin.drawercero.Especimenes.EspecimenesConsultarFragment;
import com.example.luvin.drawercero.Investigaciones.InvestigacionesConsultarFragment;
import com.example.luvin.drawercero.Login.User;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,IFragments {

    Spinner tipoColeccion;
    private int ident;
    private User user;
    GoogleSignInClient mGoogleSignInClient;
    private List<Zona> listaZona;
    private ZonaAdapter adapter = new ZonaAdapter(listaZona);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        View header = ((NavigationView)findViewById(R.id.nav_view)).getHeaderView(0);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        try{
            Bundle bundle = getIntent().getExtras();
            user = bundle.getParcelable("DATA_USER");
            if(bundle!=null){
                ident = user.getId();
                ((TextView) header.findViewById(R.id.tv_nombre_user_nav_header)).setText(user.getName());
                ((TextView) header.findViewById(R.id.tv_email_user_nav_header)).setText(user.getEmail());
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Una Accion",Snackbar.LENGTH_LONG).setAction("Accion",null).show();
            }
        });

        DrawerLayout drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this, drawer,
                toolbar,R.string.navegador_abrir_drawer,R.string.navegador_cerrar_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView=findViewById(R.id.nav_view);
       navigationView.setNavigationItemSelectedListener(this);

        fragmentManager.beginTransaction().replace(R.id.contenedor,new InicioFragment()).commit();
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer=(DrawerLayout)findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones,menu);
        // getMenuInflater().inflate(R.menu.menu_opciones,menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if (id==R.id.opciones) {
            signOut();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();

        FragmentManager fragmentManager=getSupportFragmentManager();



       if (id==R.id.nav_inicio) {
            fragmentManager.beginTransaction().replace(R.id.contenedor, new InicioFragment()).commit();
        }
        else
            if (id==R.id.nav_colecciones_consultar){
                fragmentManager.beginTransaction().replace(R.id.contenedor, new InformacionFragment()).commit();
            }
            else
            /*if (id==R.id.nav_colecciones_insertar){
                fragmentManager.beginTransaction().replace(R.id.contenedor, new DominioConsultarFragment()).commit();
            }
            else */
                if (id==R.id.nav_especimenes) {
                        fragmentManager.beginTransaction().replace(R.id.contenedor, new EspecimenesConsultarFragment()).commit();
                    }
                    else
                    if (id==R.id.nav_dominios) {
                        fragmentManager.beginTransaction().replace(R.id.contenedor, new ConsultarListaDominiosFragment()).commit();
                    }
                    else
                    if (id==R.id.nav_especiesAmenazadas) {
                        fragmentManager.beginTransaction().replace(R.id.contenedor, new ConsultarListaEspamen()).commit();
                    }
                    else
                    if (id==R.id.nav_zonas) {
                        fragmentManager.beginTransaction().replace(R.id.contenedor, new ConsultarListaZonasFragment()).commit();
                    }
                    else
                    if (id==R.id.nav_especies) {
                        fragmentManager.beginTransaction().replace(R.id.contenedor, new ConsultarListaEspecies()).commit();
                    }
                    else
                        if (id==R.id.nav_contactenos) {
                            fragmentManager.beginTransaction().replace(R.id.contenedor, new ContactenosFragment()).commit();
                        }
                        /*else
                            if (id==R.id.nav_informacion) {
                                fragmentManager.beginTransaction().replace(R.id.contenedor, new InformacionDominioFragment()).commit();
                            }*/

         DrawerLayout drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                      //  finish();

                       // Intent in = new Intent(MainActivity.this, LoginFragment.class);

                        //after pressing back button it wouldn't take to previous task and instead close the app
                        //in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                       // startActivity(in);

                        Toast.makeText(MainActivity.this, "Signed Out successfully", Toast.LENGTH_LONG).show();
                        finish();
                        Intent intent =  new Intent(MainActivity.this, LoginFragment.class);
                    }
                });
    }
}
