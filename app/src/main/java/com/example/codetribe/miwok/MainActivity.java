package com.example.codetribe.miwok;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String categoryLanguage = "";
    TextView numbers, family, colors, phrases;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    //code
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //set the content of the activity to use the activity main.xml file

        //Find view that shows the categories
        numbers = (TextView) findViewById(R.id.numbers);
        family = (TextView) findViewById(R.id.family);
        colors = (TextView) findViewById(R.id.colors);
        phrases = (TextView) findViewById(R.id.phrases);

        //onClickListener for numbers
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
                Toast.makeText(view.getContext(), "Numbers", Toast.LENGTH_SHORT).show();
                numbersIntent.putExtra("categoryLanguage_", categoryLanguage);
                startActivity(numbersIntent);


            }
        });
        //OnClickListener for family
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);
                Toast.makeText(view.getContext(), "Family", Toast.LENGTH_SHORT).show();
                familyIntent.putExtra("categoryLanguage_", categoryLanguage);
                startActivity(familyIntent);
            }
        });
        //OnClickListener for colors
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);
                Toast.makeText(view.getContext(), "Colors", Toast.LENGTH_SHORT).show();
                colorsIntent.putExtra("categoryLanguage_", categoryLanguage);
                startActivity(colorsIntent);
            }
        });
        //OnClickListener for phrases
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                Toast.makeText(view.getContext(), "Phrases", Toast.LENGTH_SHORT).show();
                phrasesIntent.putExtra("categoryLanguage_", categoryLanguage);
                startActivity(phrasesIntent);
            }
        });


    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.defaultmiwok:
                ChangeLanguage(0);
                return true;
            case R.id.isizulu:
                ChangeLanguage(1);
                return true;
            case R.id.sepedi:
                ChangeLanguage(2);
                return true;
            case R.id.venda:
                ChangeLanguage(3);
                return true;
            case R.id.tsonga:
                ChangeLanguage(4);
                return true;
            case R.id.afrikaans:
                ChangeLanguage(5);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void ChangeLanguage(int number) {
        if (number == 0) {
            categoryLanguage = "defaultmiwok";
            numbers.setText("Numbers");
            colors.setText("Colors");
            family.setText("Family");
            phrases.setText("Phrases");
            getSupportActionBar().setTitle("English");
        }
        else if (number == 1) {
            categoryLanguage = "isizulu";
            numbers.setText("Inombolo");
            colors.setText("Imibala");
            family.setText("Amalungu Omndeni");
            phrases.setText("Imishwana");
            getSupportActionBar().setTitle("Isizulu");
        }
        else if (number == 2) {
            categoryLanguage = "sepedi";
            numbers.setText("Dinomoro");
            colors.setText("Mebala");
            family.setText("Baleloko");
            phrases.setText("Mafoko");
            getSupportActionBar().setTitle("Sepedi");
        }
        else if (number == 3) {
            categoryLanguage = "venda";
            numbers.setText("Nomboro");
            colors.setText("Mivhala");
            family.setText("Mirado Ya Muta");
            phrases.setText("Mitaladzi");
            getSupportActionBar().setTitle("Venda");
        }
        else if (number == 4) {
            categoryLanguage = "tsonga";
            numbers.setText("Tinomboro");
            colors.setText("Mivhala");
            family.setText("Muhlovo");
            phrases.setText("Timhaka");
            getSupportActionBar().setTitle("Tsonga");
        }
        else if (number == 5) {
            categoryLanguage = "afrikaans";
            numbers.setText("Nommers");
            colors.setText("Kleure");
            family.setText("Gesin");
            phrases.setText("Frases");
            getSupportActionBar().setTitle("Afrikaans");
        }else {
            categoryLanguage = "none";
        }
        }

    }

