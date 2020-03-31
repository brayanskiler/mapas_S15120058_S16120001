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

    Button aceptar;
    //Origen
    TextView latitudOrigen;
    TextView longitudOrigen;

    //Destino
    TextView latitudDestino;
    TextView longitudDestino;

    public static Intent intent = new Intent();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        aceptar = (Button)findViewById(R.id.btnAceptar);

        //Origen
        latitudOrigen = (TextView)findViewById(R.id.txtLatitud);
        longitudOrigen = (TextView)findViewById(R.id.txtLongitud);

        //Destino
        latitudDestino = (TextView)findViewById(R.id.txtLatitudDestino);
        longitudDestino = (TextView)findViewById(R.id.txtLonfitudDestino);



        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Origen
                intent.putExtra("LatitudOrigen", latitudOrigen.getText().toString());
                intent.putExtra("LongitudOrigen",longitudOrigen.getText().toString());

                //Destino
                intent.putExtra("latituDestino",latitudDestino.getText().toString());
                intent.putExtra("longitudDestino",longitudDestino.getText().toString());


                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
            }
        });


    }

}