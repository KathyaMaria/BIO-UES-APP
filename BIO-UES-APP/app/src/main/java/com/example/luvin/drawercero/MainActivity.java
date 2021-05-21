package com.example.luvin.drawercero;

import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import 	androidx.appcompat.widget.Toolbar;


import com.example.luvin.drawercero.Coleccion.ColeccionesInsertarFragment;
import com.example.luvin.drawercero.Coleccion.InformacionFragment;
import com.example.luvin.drawercero.Contactenos.ContactenosFragment;
import com.example.luvin.drawercero.Especimenes.EspecimenesConsultarFragment;
import com.example.luvin.drawercero.Investigaciones.InvestigacionesConsultarFragment;
import com.example.luvin.drawercero.Login.LoginFragment;
import com.example.luvin.drawercero.Login.User;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Spinner tipoColeccion;
    private int ident;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        View header = ((NavigationView)findViewById(R.id.nav_view)).getHeaderView(0);

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
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this, drawer, toolbar,R.string.navegador_abrir_drawer,R.string.navegador_cerrar_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView=findViewById(R.id.nav_view);
       navigationView.setNavigationItemSelectedListener(this);


        //fragmentManager.beginTransaction().replace(R.id.contenedor,new InicioFragment()).commit();



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

        getMenuInflater().inflate(R.menu.menu_opciones,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if (id==R.id.opciones) {
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
            if (id==R.id.nav_colecciones_insertar){
                fragmentManager.beginTransaction().replace(R.id.contenedor, new ColeccionesInsertarFragment()).commit();
            }
            else
                if (id==R.id.nav_investigaciones) {
                    fragmentManager.beginTransaction().replace(R.id.contenedor, new InvestigacionesConsultarFragment()).commit();
                }
                else
                    if (id==R.id.nav_especimenes) {
                        fragmentManager.beginTransaction().replace(R.id.contenedor, new EspecimenesConsultarFragment()).commit();
                    }
                    else
                        if (id==R.id.nav_contactenos) {
                            fragmentManager.beginTransaction().replace(R.id.contenedor, new ContactenosFragment()).commit();
                        }
                        /*else
                            if (id==R.id.nav_informacion) {
                                fragmentManager.beginTransaction().replace(R.id.contenedor, new InformacionFragment()).commit();
                            }*/

         DrawerLayout drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
