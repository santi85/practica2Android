package com.santiagoosorio.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText elado,ealtura,ebase,eradio,eresultado;
    Button bcalcular;
    TextView tlado,taltura,tbase,tradio,tresultado;
    RadioButton rbtriangulo,rbcirculo,rbcuadrado,rbrectangulo;

    int ban;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        elado = (EditText)findViewById(R.id.elado);
        ealtura = (EditText)findViewById(R.id.ealtura);
        ebase = (EditText)findViewById(R.id.ebase);
        eradio = (EditText)findViewById(R.id.eradio);
        eresultado = (EditText)findViewById(R.id.eresultado);
        bcalcular = (Button)findViewById(R.id.bcalcular);
        rbcirculo = (RadioButton)findViewById(R.id.rbcirculo);
        rbcuadrado = (RadioButton)findViewById(R.id.rbcuadrado);
        rbrectangulo = (RadioButton)findViewById((R.id.rbrectangulo));
        rbtriangulo = (RadioButton)findViewById(R.id.rbtriangulo);
        taltura = (TextView)findViewById(R.id.taltura);
        tbase = (TextView)findViewById(R.id.tbase);
        tlado = (TextView)findViewById(R.id.tlado);
        tradio = (TextView)findViewById(R.id.tradio);
        tresultado = (TextView)findViewById(R.id.tresultado);

        eresultado.setVisibility(View.GONE);
        tresultado.setVisibility(View.GONE);

        bcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eresultado.setVisibility(View.VISIBLE);
                tresultado.setVisibility(View.VISIBLE);
                Double base,altura,lado,radio,resultado=0.0;
                if(ban==0) {
                    Toast.makeText(MainActivity.this, "Seleccione la figura", Toast.LENGTH_SHORT).show();
                    ebase.setVisibility(View.GONE);
                    eradio.setVisibility(View.GONE);
                    ealtura.setVisibility(View.GONE);
                    elado.setVisibility(View.GONE);
                    tbase.setVisibility(View.GONE);
                    tradio.setVisibility(View.GONE);
                    taltura.setVisibility(View.GONE);
                    tlado.setVisibility(View.GONE);
                }
                if(ban==1){
                    base = Double.parseDouble(ebase.getText().toString());
                    altura = Double.parseDouble(ealtura.getText().toString());
                    resultado = (base * altura)/2;
                }
                if(ban==2) {
                    lado = Double.parseDouble(elado.getText().toString());
                    resultado = lado * lado;
                }
                if(ban==3) {
                    base = Double.parseDouble(ebase.getText().toString());
                    altura = Double.parseDouble(ealtura.getText().toString());
                    resultado = altura * base;
                }
                if(ban==4) {
                    radio = Double.parseDouble(eradio.getText().toString());
                    resultado = Math.pow(radio, 2) * 3.1416;
                }
                eresultado.setText(String.valueOf(resultado));
            }
        });

    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {

            case R.id.rbtriangulo:
                if (checked)
                    ban=1;
                tbase.setVisibility(View.VISIBLE);
                ebase.setVisibility(View.VISIBLE);
                taltura.setVisibility(View.VISIBLE);
                ealtura.setVisibility(View.VISIBLE);
                tlado.setVisibility(View.GONE);
                elado.setVisibility(View.GONE);
                eradio.setVisibility(View.GONE);
                tradio.setVisibility(View.GONE);
                break;
            case R.id.rbcuadrado:
                if (checked)
                    ban=2;
                tlado.setVisibility(View.VISIBLE);
                elado.setVisibility(View.VISIBLE);
                ebase.setVisibility(View.GONE);
                eradio.setVisibility(View.GONE);
                ealtura.setVisibility(View.GONE);
                tbase.setVisibility(View.GONE);
                tradio.setVisibility(View.GONE);
                taltura.setVisibility(View.GONE);

                break;
            case R.id.rbrectangulo:
                if (checked)
                    ban=3;
                tbase.setVisibility(View.VISIBLE);
                ebase.setVisibility(View.VISIBLE);
                taltura.setVisibility(View.VISIBLE);
                ealtura.setVisibility(View.VISIBLE);
                eradio.setVisibility(View.GONE);
                tradio.setVisibility(View.GONE);
                tlado.setVisibility(View.GONE);
                elado.setVisibility(View.GONE);

                break;
            case R.id.rbcirculo:
                if (checked)
                    ban=4;
                eradio.setVisibility(View.VISIBLE);
                tradio.setVisibility(View.VISIBLE);
                tbase.setVisibility(View.GONE);
                ebase.setVisibility(View.GONE);
                taltura.setVisibility(View.GONE);
                ealtura.setVisibility(View.GONE);
                tlado.setVisibility(View.GONE);
                elado.setVisibility(View.GONE);
                break;
        }
    }
}

