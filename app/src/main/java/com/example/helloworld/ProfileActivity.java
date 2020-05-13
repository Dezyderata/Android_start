package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;




public class ProfileActivity extends AppCompatActivity {

    private Button mBtGoBack;
    int plec;
    double masa, wzrost, wiek = 0, kalorie = 0;
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
        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.plec);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton cokolwiek = (RadioButton) findViewById(checkedId);
                plec = radioGroup.indexOfChild(cokolwiek);
            }
        });
        policz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
            if(this.plec == 0 && wiek != 0){
                kalorie = 655.1 + (9.567 * masa) + (1.85 * wzrost * 100.0) - (4.68 * wiek);
                TextView odpowiedz = findViewById(R.id.kalorie);
                odpowiedz.setText(String.valueOf(kalorie));
            }
            if(this.plec == 1 && wiek != 0){
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
}
