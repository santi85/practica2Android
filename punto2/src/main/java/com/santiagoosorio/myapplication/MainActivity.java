package com.santiagoosorio.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText enumero1,enumero2,eresultado;
    Button bcalcular;
    RadioButton rbmul,rbdivision,rbsuma,rbresta;
    int ban;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enumero1 = (EditText)findViewById(R.id.enumero1);
        enumero2 = (EditText)findViewById(R.id.enumero2);
        eresultado = (EditText)findViewById(R.id.eresultado);
        bcalcular = (Button) findViewById(R.id.bcalcular);
        rbdivision = (RadioButton)findViewById(R.id.rbdivision);
        rbmul = (RadioButton)findViewById(R.id.rbmul);
        rbresta = (RadioButton)findViewById(R.id.rbresta);
        rbsuma = (RadioButton)findViewById(R.id.rbsuma);

        bcalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Double numero1,numero2,resultado=0.0;
                numero1 = Double.parseDouble(enumero1.getText().toString());
                numero2 = Double.parseDouble(enumero2.getText().toString());
                if(ban==0)
                    Toast.makeText(MainActivity.this, "Seleccione una operación", Toast.LENGTH_SHORT).show();
                if(ban==1)
                    resultado = numero1 - numero2;
                if(ban==2)
                    resultado = numero1 + numero2;
                if (ban==3)
                    resultado = numero1 * numero2;
                if (ban==4)
                    resultado = numero1 / numero2;

                eresultado.setText(String.valueOf(resultado));
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbresta:
                if (checked)
                    ban=1;
                // Pirates are the best
                break;
            case R.id.rbsuma:
                if (checked)
                    ban=2;
                // Ninjas rule
                break;
            case R.id.rbmul:
                if (checked)
                    ban=3;
                // Ninjas rule
                break;
            case R.id.rbdivision:
                if (checked)
                    ban=4;
                // Ninjas rule
                break;
        }
    }
}
