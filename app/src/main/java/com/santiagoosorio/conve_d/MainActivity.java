package com.santiagoosorio.conve_d;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText evalor,eres;
    Button bconv;
    RadioButton rbpd,rbdp;
    int ban;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        evalor = (EditText)findViewById(R.id.evalor);
        eres = (EditText)findViewById(R.id.eres);
        bconv = (Button) findViewById(R.id.bconv);
        rbdp = (RadioButton) findViewById(R.id.rbdp);
        rbpd = (RadioButton) findViewById(R.id.rbpd);

        bconv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double valor,resultado=0.0;
                valor = Double.parseDouble(evalor.getText().toString());
                if(ban==0)
                    Toast.makeText(MainActivity.this, "Seleccione conversión", Toast.LENGTH_SHORT).show();
                if(ban==1)
                    resultado = valor * 3000;
                if(ban==2)
                    resultado = valor /3000;
                eres.setText(String.valueOf("$"+resultado));
            }
        });
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbdp:
                if (checked)
                    ban=1;
                    // Pirates are the best
                    break;
            case R.id.rbpd:
                if (checked)
                    ban=2;
                    // Ninjas rule
                    break;
        }
    }


}
