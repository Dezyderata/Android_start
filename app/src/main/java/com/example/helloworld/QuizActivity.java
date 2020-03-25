package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    Button wroc, b_odpowiedz1, b_odpowiedz2, b_odpowiedz3, b_odpowiedz4;
    int wynik;
    ImageView vir_image;
    Random r;
    List<VirusItem> virus_list;
    int turn = 1;
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        r = new Random();

        wroc = findViewById(R.id.back_to_main_activity);

        vir_image = findViewById(R.id.vir_image);
        b_odpowiedz1 = findViewById(R.id.ans1);
        b_odpowiedz2 = findViewById(R.id.ans2);
        b_odpowiedz3 = findViewById(R.id.ans3);
        b_odpowiedz4 = findViewById(R.id.ans4);

        virus_list = new ArrayList<>();
        DBVirus myDB = new DBVirus();

        for(int i = 0; i < myDB.viruses.length; i++){
            virus_list.add(new VirusItem(myDB.viruses[i], myDB.images[i]));
        }

        Collections.shuffle(virus_list);

        newQuestion(turn);
        b_odpowiedz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b_odpowiedz1.getText().toString().equalsIgnoreCase(virus_list.get(turn -1).getName())){
                    Toast.makeText(QuizActivity.this, "Zgadza sie!", Toast.LENGTH_SHORT).show();
                    score++;
                    if(turn < virus_list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(QuizActivity.this, "Skonczyles gre z wynikiem: "+score, Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }else{
                    Toast.makeText(QuizActivity.this, "Nie tym razem!", Toast.LENGTH_SHORT).show();
                    if(turn < virus_list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(QuizActivity.this, "Skonczyles gre z wynikiem: "+score, Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }

            }
        });
        b_odpowiedz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b_odpowiedz2.getText().toString().equalsIgnoreCase(virus_list.get(turn -1).getName())){
                    Toast.makeText(QuizActivity.this, "Zgadza sie!", Toast.LENGTH_SHORT).show();
                    score++;
                    if(turn < virus_list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(QuizActivity.this, "Skonczyles gre z wynikiem: "+score, Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }else{
                    Toast.makeText(QuizActivity.this, "Nie tym razem!", Toast.LENGTH_SHORT).show();
                    if(turn < virus_list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(QuizActivity.this, "Skonczyles gre z wynikiem: "+score, Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
        b_odpowiedz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b_odpowiedz3.getText().toString().equalsIgnoreCase(virus_list.get(turn -1).getName())){
                    Toast.makeText(QuizActivity.this, "Zgadza sie!", Toast.LENGTH_SHORT).show();
                    score++;
                    if(turn < virus_list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(QuizActivity.this, "Skonczyles gre z wynikiem: "+score, Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }else{
                    Toast.makeText(QuizActivity.this, "Nie tym razem!", Toast.LENGTH_SHORT).show();
                    if(turn < virus_list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(QuizActivity.this, "Skonczyles gre z wynikiem: "+score, Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }

            }
        });
        b_odpowiedz4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b_odpowiedz4.getText().toString().equalsIgnoreCase(virus_list.get(turn -1).getName())){
                    Toast.makeText(QuizActivity.this, "Zgadza sie!", Toast.LENGTH_SHORT).show();
                    score++;
                    if(turn < virus_list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(QuizActivity.this, "Skonczyles gre z wynikiem: "+score, Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }else{
                    Toast.makeText(QuizActivity.this, "Nie tym razem!", Toast.LENGTH_SHORT).show();
                    if(turn < virus_list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(QuizActivity.this, "Skonczyles gre z wynikiem: "+score, Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }

            }
        });

        wroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

    }
    private void newQuestion(int number){
        vir_image.setImageResource(virus_list.get(number -1).getImage());

        int correct_ans = r.nextInt(4) + 1;

        int firstButton = number - 1;
        int secondButton;
        int thirdButton;
        int forthButton;
        switch (correct_ans){
            case 1:
                b_odpowiedz1.setText(virus_list.get(firstButton).getName());
                do {
                    secondButton = r.nextInt(virus_list.size());
                }while(secondButton == firstButton);
                do {
                    thirdButton = r.nextInt(virus_list.size());
                }while(thirdButton == firstButton || thirdButton == secondButton);
                do {
                    forthButton = r.nextInt(virus_list.size());
                }while(forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

                b_odpowiedz2.setText(virus_list.get(secondButton).getName());
                b_odpowiedz3.setText(virus_list.get(thirdButton).getName());
                b_odpowiedz4.setText(virus_list.get(forthButton).getName());
                break;
            case 2:
                b_odpowiedz2.setText(virus_list.get(firstButton).getName());
                do {
                    secondButton = r.nextInt(virus_list.size());
                }while(secondButton == firstButton);
                do {
                    thirdButton = r.nextInt(virus_list.size());
                }while(thirdButton == firstButton || thirdButton == secondButton);
                do {
                    forthButton = r.nextInt(virus_list.size());
                }while(forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

                b_odpowiedz1.setText(virus_list.get(secondButton).getName());
                b_odpowiedz3.setText(virus_list.get(thirdButton).getName());
                b_odpowiedz4.setText(virus_list.get(forthButton).getName());
                break;
            case 3:
                b_odpowiedz3.setText(virus_list.get(firstButton).getName());
                do {
                    secondButton = r.nextInt(virus_list.size());
                }while(secondButton == firstButton);
                do {
                    thirdButton = r.nextInt(virus_list.size());
                }while(thirdButton == firstButton || thirdButton == secondButton);
                do {
                    forthButton = r.nextInt(virus_list.size());
                }while(forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

                b_odpowiedz2.setText(virus_list.get(secondButton).getName());
                b_odpowiedz1.setText(virus_list.get(thirdButton).getName());
                b_odpowiedz4.setText(virus_list.get(forthButton).getName());
                break;
            case 4:
                b_odpowiedz4.setText(virus_list.get(firstButton).getName());
                do {
                    secondButton = r.nextInt(virus_list.size());
                }while(secondButton == firstButton);
                do {
                    thirdButton = r.nextInt(virus_list.size());
                }while(thirdButton == firstButton || thirdButton == secondButton);
                do {
                    forthButton = r.nextInt(virus_list.size());
                }while(forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

                b_odpowiedz2.setText(virus_list.get(secondButton).getName());
                b_odpowiedz3.setText(virus_list.get(thirdButton).getName());
                b_odpowiedz1.setText(virus_list.get(forthButton).getName());
                break;
        }

    }

}
