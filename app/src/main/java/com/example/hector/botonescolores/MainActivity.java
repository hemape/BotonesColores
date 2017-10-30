package com.example.hector.botonescolores;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout rl;
    private boolean colorFondo=false;
    private boolean colorLetras=false;
    private CheckBox muestra;
    private Button btnFondo;
    private Button btnLetras;
    private TextView longClick;
    private TextView oculto;
    private RatingBar estrellas;
    private TextView contador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFondo = (Button) findViewById(R.id.botonFondo);
        btnLetras = (Button) findViewById(R.id.botonLetras);
        rl = (RelativeLayout) findViewById(R.id.relative);
        muestra = (CheckBox) findViewById(R.id.muestra);
        longClick = (TextView) findViewById(R.id.click);
        oculto = (TextView) findViewById(R.id.oculto);
        estrellas= (RatingBar) findViewById(R.id.estrellas);
        contador = (TextView) findViewById(R.id.cuentaEstrellas);


        estrellas.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                contador.setText("[" + Math.round(estrellas.getRating()) + "/5]");
            }
        });
        longClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast t1;
                t1 = Toast.makeText(getApplicationContext(),"Muchas gracias",Toast.LENGTH_SHORT);
                t1.show();
                return false;
            }

        });
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onClick (View v){
        switch (v.getId()){
            case R.id.botonFondo:

                if(!colorFondo){
                    rl.setBackground(getDrawable(R.color.Rojo));
                    btnFondo.setText("FONDO BLANCO");
                    colorFondo=true;

                }else{
                    rl.setBackground(getDrawable(R.color.White));
                    btnFondo.setText("FONDO ROJO");
                    colorFondo=false;
                }
                break;
            case R.id.botonLetras:

                if(!colorLetras){
                   // no me funciona el cambiar de color el texto del boton, comento como en teoria se deberia hacer.
                    //btnLetras.setTextColor(getColor(R.color.Black));
                    btnLetras.setText("Letras rojas");
                    colorLetras=true;

                }else{
                    // no me funciona el cambiar de color el texto del boton, comento como en teoria se deberia hacer.
                    //btnLetras.setTextColor(getColor(R.color.Rojo));
                    btnLetras.setText("Letras negras");
                    colorLetras=false;
                }
                break;
            case R.id.muestra:
                if (muestra.isChecked()){
                    oculto.setVisibility(View.VISIBLE);

                }else{
                    oculto.setVisibility(View.INVISIBLE);
                }
        }





    }

}