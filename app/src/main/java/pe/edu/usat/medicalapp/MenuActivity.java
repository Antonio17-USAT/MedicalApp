package pe.edu.usat.medicalapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import pe.edu.usat.medicalapp.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {

    //Configuración de la barra superior
    private AppBarConfiguration mAppBarConfiguration;

    //Referencia al binding para enlazar a los controles
    private ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        //Inicializar el binding
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Configurar el toolbar
        setSupportActionBar(binding.appBarMenu.toolbar);

        //Referenciar al contenedor del menú y a la vista de navegación
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        //Configurar la barra de navegación
        mAppBarConfiguration = new AppBarConfiguration.Builder
                (
                        R.id.nav_inicio,
                        R.id.nav_especialidades,
                        R.id.nav_medicos,
                        R.id.nav_registrar_cita,
                        R.id.nav_reprogramar_cita,
                        R.id.nav_calificar_atencion,
                        R.id.nav_acerca_de
                ).setOpenableLayout(drawer).build();

        //Gestionar el intercambio de items del menú: Al cambiar de item, cambia de fragment
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_menu);

        //Vincular el toolbar con el NavControler y la configuración del drawer
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        //Vincular el menú lateral (navigationview) con el NavControler para que que al hacer clic en el item quede seleccionado
        NavigationUI.setupWithNavController(navigationView, navController);

        //Gestionar la navegación hacia el menu inicio, cuando se navega hacia otras opciones desde algun botón ubicado en un fragment
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            boolean handled = NavigationUI.onNavDestinationSelected(menuItem, navController);
            if(handled) drawer.closeDrawers();

            if (menuItem.getItemId() == R.id.nav_inicio){
                navController.popBackStack(R.id.nav_inicio, false); //Navega hacia el menu inicio
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
            return handled;
        });

    }


    @Override
    public boolean onSupportNavigateUp() {
        //Este evento se ejecuta cuando el usuario hace clic en el menú de la equina superior izquierda
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_menu);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }
}