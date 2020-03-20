package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.snackbar.Snackbar;

public class ProfileActivity extends AppCompatActivity {

    private Button mBtGoBack;
    Boolean plec = null;
    double masa, wzrost, wiek, kalorie = 0;
    Button policz;
    String wzrostText, masaText, wiekText, my_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mBtGoBack = findViewById(R.id.bt_go_back);

        mBtGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
        policz = findViewById(R.id.policz);
        policz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
               countBMIAndCalories(v);

            }
        });
    }
    public void countBMIAndCalories(View v){
        wzrostText = ((EditText)findViewById(R.id.wzrost)).getText().toString();
        masaText = ((EditText)findViewById(R.id.masa)).getText().toString();
        wiekText = ((EditText)findViewById(R.id.wiek)).getText().toString();
        try{
            masa = Double.valueOf(masaText);
            wzrost = Double.valueOf(wzrostText);
            wiek = Double.valueOf(wiekText);
            if(this.plec){
                kalorie = 655.1 + (9.567 * masa) + (1.85 * wzrost * 100.0) - (4.68 * wiek);
                TextView odpowiedz = findViewById(R.id.kalorie);
                odpowiedz.setText(String.valueOf(kalorie));
            }
            if(!this.plec){
                kalorie = 66.47 + 13.7*masa + 5.0*wzrost*100.0 - 6.76 * wiek;
                TextView odpowiedz = findViewById(R.id.kalorie);
                odpowiedz.setText(String.valueOf(kalorie));
            }
            if(kalorie == 0){
                TextView odpowiedz = findViewById(R.id.kalorie);
                odpowiedz.setText("brak danych");

            }
            double BMI = masa/(wzrost*wzrost);
            this.setBMIRange(BMI);
            TextView ans = findViewById(R.id.wynik);
            ans.setText(String.valueOf(BMI)+this.my_text);
        }catch (NumberFormatException err){
            Snackbar.make(v, "Incorect values!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }

    }
    public void setBMIRange(double BMI){
        if(BMI <= 18.5){
            this.my_text = " Zjedz cos!";
        }else if( BMI > 18.5 && BMI < 25.0){
            this.my_text = " luzik";
        }else{
            this.my_text = " Czas pocwiczyc!";
        }

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.kobieta:
                if (checked)
                    this.plec = true;
            case R.id.mezczyzna:
                if (checked)
                    this.plec = false;
        }
    }
    public void countCallories(){

    }
}
