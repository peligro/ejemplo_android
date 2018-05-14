package tamila.cl.ejemploandroid.vistas;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import tamila.cl.ejemploandroid.R;
public class MenuDrawerActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_drawer);
        //showToolbar("Menú Drawer",true);
        showDrawer();
    }
    public void showDrawer()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.menu_1:
                Toast.makeText(getApplicationContext(),"Se hizo clic en menú 1",Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_2:
                Toast.makeText(getApplicationContext(),"Se hizo clic en menú 2",Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_3:
                Toast.makeText(getApplicationContext(),"Se hizo clic en menú 3",Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_4:
                Toast.makeText(getApplicationContext(),"Se hizo clic en menú 4",Toast.LENGTH_LONG).show();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
