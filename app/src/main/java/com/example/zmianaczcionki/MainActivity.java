package com.example.zmianaczcionki;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tekstSize, tekstDni;
    EditText inputText;
    SeekBar seekBar;
    Button buttonNext;
    String[] day={"Poniedziałek","Wtorek","Środa","Czwartek","Piątek", "Sobota","Niedziela"};
    int dzienIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

tekstSize=findViewById(R.id.textView);
tekstDni=findViewById(R.id.textDni);
inputText=findViewById(R.id.inputText);
seekBar=findViewById(R.id.seekBar);
buttonNext=findViewById(R.id.buttonText);

seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        tekstSize.setText("Rozmiar "+Integer.toString(progress));
        tekstDni.setTextSize((float)progress);
        inputText.setTextSize((float)progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
});

buttonNext.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        dzienIndex+=1;
        if(dzienIndex==day.length)dzienIndex=0;
        tekstDni.setText(day[dzienIndex]);
    }
});
    }
}