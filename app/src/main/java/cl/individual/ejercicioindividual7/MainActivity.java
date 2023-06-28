package cl.individual.ejercicioindividual7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import cl.individual.ejercicioindividual7.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String fechaConFormato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mostrarToastInicial();
        initListeners();
    }



    private void initListeners() {

        binding.calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Calendar fechaSeleccionada = Calendar.getInstance();
                fechaSeleccionada.set(year,month,dayOfMonth);
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                fechaConFormato = formato.format(fechaSeleccionada.getTime());
            }
        });
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = binding.editText.getText().toString();
                Toast.makeText(MainActivity.this, "Tu mensaje: " + texto + " se enviará el día: " + fechaConFormato , Toast.LENGTH_LONG).show();

            }
        });

        binding.switchTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.switchTheme.isChecked()) {
                    cambiarTema(0);
                    Toast.makeText(getBaseContext(), "Tema oscuro activado", Toast.LENGTH_SHORT).show();
                } else {
                    cambiarTema(1);
                    Toast.makeText(getBaseContext(), "Tema claro activado", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void mostrarToastInicial() {
        Toast.makeText(this, "Bienvenido", Toast.LENGTH_LONG).show();
    }



    private void cambiarTema(int mode) {
        if(mode==0){
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else{
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }



}