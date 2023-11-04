package com.example.desingtextreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private EditText name_text, complaint_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_text = findViewById(R.id.name_text);
        complaint_text = findViewById(R.id.complaint_text);
    }

    /**
     * Обработчики кнопок
     */

    // Оповещение
    public void goMain (View v){
        Toast.makeText(this, "Вы уже здесь.", Toast.LENGTH_SHORT).show();
    }

    // Переход на страницу с жалобами
    public void goProblem(View v){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    /**
     * Обработчики жалоб
     */

    // Сохранение жалобы
    public void saveDate(View v){
        String user_name = name_text.getText().toString();
        String user_complaint = complaint_text.getText().toString();

        try {
            FileOutputStream file_output = openFileOutput("user_info.txt", MODE_PRIVATE);
            file_output.write((user_name + " : " + user_complaint).getBytes());
            file_output.close();
            name_text.setText("");
            complaint_text.setText("");
            Toast.makeText(this, "Сохранено", Toast.LENGTH_LONG).show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Загрузка жалобы
    public void loadDate(View v){
        try {
            FileInputStream file_input = openFileInput("user_info.txt");
            InputStreamReader reader = new InputStreamReader(file_input);
            BufferedReader buf_read = new BufferedReader(reader);

            StringBuilder string_buffer = new StringBuilder();
            String lines="";
            while ((lines = buf_read.readLine()) != null){
                string_buffer.append(lines);
            }
            Toast.makeText(this,string_buffer, Toast.LENGTH_LONG).show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}