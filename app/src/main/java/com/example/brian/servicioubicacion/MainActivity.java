package com.example.brian.servicioubicacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;


public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationClient;
    Button aceptar;

    TextView latitudOrigen;
    TextView longitudOrigen;

    public static Intent intent = new Intent();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        aceptar = (Button)findViewById(R.id.btnAceptar);
        latitudOrigen = (TextView)findViewById(R.id.txtLatitud);
        longitudOrigen = (TextView)findViewById(R.id.txtLongitud);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object
                            String msj = "Latitud: "+ String.valueOf(location.getLatitude())
                                    + "\nLongitud: " + location.getLongitude();

                            Toast.makeText(MainActivity.this, msj,
                                    Toast.LENGTH_LONG).show();
                            Log.i("MiUbi", msj);
                        }else {Log.i("MiUbi", "Sin ubicaciòn ");}


                    }
                });

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent.putExtra("LatitudOrigen", latitudOrigen.getText().toString());
                intent.putExtra("LongitudOrigen",longitudOrigen.getText().toString());

                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
            }
        });


    }

}