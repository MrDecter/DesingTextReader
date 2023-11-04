package com.example.desingtextreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private String[] namerArr = new String[] {"Vlad", "Steman", "Vladimin", "Oleg", "Pavel"};
    private ListView list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        list_view = findViewById(R.id.problem_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.name_item_desing, R.id.user_desing, namerArr);
        list_view.setAdapter(adapter);
    }

    /**
     * Обработчики кнопок
     */

    // Переход на главную страницу
    public void goMain (View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // Оповещение
    public void goProblem(View v){
        Toast.makeText(this, "Вы уже здесь.", Toast.LENGTH_SHORT).show();
    }
}