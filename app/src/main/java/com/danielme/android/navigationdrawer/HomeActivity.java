package com.danielme.android.navigationdrawer;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.cpinedae.movilidad.adaptador.ConexionSQLiteHelper;
import com.cpinedae.movilidad.modelo.Usuario;
import com.cpinedae.movilidad.utilidades.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        DrawerLayout.DrawerListener {

    private DrawerLayout drawerLayout;
    private String[] usuarioList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Bundle bundle = getIntent().getExtras();
        usuarioList = new String[3];
        usuarioList = bundle.getStringArray("usuario");
//        Toast.makeText(HomeActivity.this, "longitud del usurio " + usuarioList.length,
//                Toast.LENGTH_SHORT).show();
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db_Movilidad", null, 1);
        try {
            SQLiteDatabase db = conn.getWritableDatabase();
            int boorar = db.delete("usuario", null, null);
            System.out.println("....." + boorar);
            ContentValues values = new ContentValues();
            values.put(Utilidades.campoUsuario, usuarioList[0]);
            values.put(Utilidades.campoRuta, usuarioList[1]);
            values.put(Utilidades.campoContraseña, usuarioList[2]);
            Toast.makeText(this, "registro " + usuarioList[0] + "-" + usuarioList[1], Toast.LENGTH_SHORT).show();

            db.insert("usuario", null, values);
            db.close();
            //Toast.makeText(this, "registro ", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        MenuItem menuItem = navigationView.getMenu().getItem(0);
        onNavigationItemSelected(menuItem);
        menuItem.setChecked(true);

        drawerLayout.addDrawerListener(this);

        View header = navigationView.getHeaderView(0);
        header.findViewById(R.id.header_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, getString(R.string.title_click),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int title;
        Fragment fragment;
        FragmentManager fragmentManager;
        switch (menuItem.getItemId()) {
            case R.id.agenda:
                title = R.string.menu_agenda;
                fragment = HomeContentFragment.newInstance(getString(title));
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.home_content, fragment).commit();
                break;
            case R.id.nav_sincronizar:
                title = R.string.menu_sincronizar;
                fragment = Sincronizar.newInstance(getString(title));
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.home_content, fragment).commit();
                break;
            case R.id.nav_informe:
                title = R.string.menu_informe;
                fragment = Informe.newInstance(getString(title));
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.home_content, fragment).commit();
                break;
            case R.id.nav_config:
                title = R.string.menu_config;
                fragment = Configuracion.newInstance(getString(title));
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.home_content, fragment).commit();
                break;
            case R.id.nav_salir:
                title = R.string.menu_salir;
                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
                Toast.makeText(this, "Cerrar sesión.", Toast.LENGTH_LONG).show();

                break;
            default:
                throw new IllegalArgumentException("menu option not implemented!!");
        }


        setTitle(getString(title));

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onDrawerSlide(@NonNull View view, float v) {
        //cambio en la posición del drawer
    }

    @Override
    public void onDrawerOpened(@NonNull View view) {
        //el drawer se ha abierto completamente
//    Toast.makeText(this, getString(R.string.navigation_drawer_open),
//            Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDrawerClosed(@NonNull View view) {
        //el drawer se ha cerrado completamente
    }

    @Override
    public void onDrawerStateChanged(int i) {
        //cambio de estado, puede ser STATE_IDLE, STATE_DRAGGING or STATE_SETTLING
    }

}
