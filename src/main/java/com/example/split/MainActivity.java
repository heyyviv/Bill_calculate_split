package com.example.split;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText base_amount,split_friend;
    TextView answer;
    Button calculate;
    SeekBar tip_percent;
    private Double tip=1.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        base_amount=findViewById(R.id.base_text);
        split_friend=findViewById(R.id.split_among);
        calculate=findViewById(R.id.submit_btn);
        tip_percent=findViewById(R.id.tip_seekbar);
        answer=findViewById(R.id.answer_value);


        tip_percent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress!=0){
                    tip= new Double(progress);
                }
                Toast.makeText(MainActivity.this,"Progress "+progress,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String base_word=base_amount.getText().toString();
                String split_word=split_friend.getText().toString();
                Double base_value=Double.parseDouble(base_word);
                Double split_value=Double.parseDouble(split_word);
                Double value=((tip/100)*base_value);
                Double amount= new Double(((base_value+value)/split_value));
                String last_value=String.valueOf(amount);
                answer.setText(last_value);


            }
        });


    }
}
