package com.example.luvin.drawercero;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        NavigationView navigationView=(NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contenedor,new InicioFragment()).commit();

        /*SPINNER TIPO COLECCION
        Spinner tipoColeccion=(Spinner) findViewById(R.id.spinnerTipoColeccion);
        ArrayList<String> aList= new ArrayList<>();
        aList.add("Humeda");
        aList.add("Seca");
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,aList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoColeccion.setAdapter(adapter);

        tipoColeccion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
*/

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
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();

        FragmentManager fragmentManager=getSupportFragmentManager();

        if (id==R.id.nav_inicio) {
            fragmentManager.beginTransaction().replace(R.id.contenedor, new InicioFragment()).commit();
        }
        else
            if (id==R.id.nav_colecciones_consultar){
                fragmentManager.beginTransaction().replace(R.id.contenedor, new ColeccionesConsultarFragment()).commit();
            }
            else
            if (id==R.id.nav_colecciones_insertar){
                fragmentManager.beginTransaction().replace(R.id.contenedor, new ColeccionesInsertarFragment()).commit();
            }
            else
                if (id==R.id.nav_investigaciones) {
                    fragmentManager.beginTransaction().replace(R.id.contenedor, new InvestigacionesFragment()).commit();
                }
                else
                    if (id==R.id.nav_especimenes) {
                        fragmentManager.beginTransaction().replace(R.id.contenedor, new EspecimenesFragment()).commit();
                    }
                    else
                        if (id==R.id.nav_contactenos) {
                            fragmentManager.beginTransaction().replace(R.id.contenedor, new ContactenosFragment()).commit();
                        }
                        else
                            if (id==R.id.nav_informacion) {
                                fragmentManager.beginTransaction().replace(R.id.contenedor, new InformacionFragment()).commit();
                            }

         DrawerLayout drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
