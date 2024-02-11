package com.example.yalimarcedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textViewLevel1;
    private TextView textViewLevel2;
    private TextView textViewLevel3;
    private TextView text2Level2;
    private TextView text2Level1;
    private TextView text2Level3;
    private Button buttonLevel1;
    private Button buttonLevel2;
    private Button buttonLevel3;
    private Button button;
    private EditText AnsLevel1;
    private EditText AnsLevel2;
    private EditText AnsLevel3;
    private ImageView ivLevel1;
    private ImageView ivLevel2;
    private ImageView ivLevel3;


    private int rnd1;
    private int rnd2;
    private int rnd3;
    private int rnd4;
    private int rnd5;
    private int rnd6;
    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewLevel1 = findViewById(R.id.textViewLevel1);
        textViewLevel2 = findViewById(R.id.textViewLevel2);
        textViewLevel3 = findViewById(R.id.textViewLevel3);
        text2Level1 = findViewById(R.id.text2Level1);
        text2Level2 = findViewById(R.id.text2Level2);
        text2Level3 = findViewById(R.id.text2Level3);
        buttonLevel1 = findViewById(R.id.buttonLevel1);
        buttonLevel2 = findViewById(R.id.buttonLevel2);
        buttonLevel3 = findViewById(R.id.buttonLevel3);
        button = findViewById(R.id.button);
        AnsLevel1 = findViewById(R.id.AnsLevel1);
        AnsLevel2 = findViewById(R.id.AnsLevel2);
        AnsLevel3 = findViewById(R.id.AnsLevel3);
        ivLevel1 = findViewById(R.id.ivLevel1);
        ivLevel2 = findViewById(R.id.ivLevel2);
        ivLevel3 = findViewById(R.id.ivLevel3);

        rnd1 = generateRandomNumber();
        rnd2 = generateRandomNumber();

        textViewLevel1.setText("" + rnd1);
        text2Level1.setText("" + rnd2);
        textViewLevel2.setText("number");
        text2Level2.setText("number");
        textViewLevel3.setText("number");
        text2Level3.setText("number");
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 90) + 10;
    }

    public void check1(View view) {
        String ans1 = AnsLevel1.getText().toString();
        ivLevel1.setVisibility(view.VISIBLE);
        if (Integer.parseInt(ans1) != (rnd1 + rnd2))
            ivLevel1.setImageResource(R.drawable.img_1);
        else {
            ivLevel1.setImageResource(R.drawable.img);
            sum++;
        }
        rnd3= rnd1+rnd2;
        rnd4 =generateRandomNumber();
        textViewLevel2.setText(""+rnd3);
        text2Level2.setText(""+rnd4);

    }

    public void check2(View view) {
        String ans2=AnsLevel2.getText().toString();
        ivLevel2.setVisibility(view.VISIBLE);
        if(Integer.parseInt(ans2)!=(rnd3+rnd4))
            ivLevel2.setImageResource(R.drawable.img_1);
        else{
            ivLevel2.setImageResource(R.drawable.img);
            sum++;
        }
        rnd5 = rnd3+rnd4;
        rnd6 =generateRandomNumber();
        textViewLevel3.setText(""+rnd5);
        text2Level3.setText(""+rnd6);
    }


    public void check3(View view) {
        String ans3=AnsLevel3.getText().toString();
        ivLevel3.setVisibility(view.VISIBLE);
        if(Integer.parseInt(ans3)!=(rnd5+rnd6))
            ivLevel3.setImageResource(R.drawable.img_1);
        else{
            ivLevel3.setImageResource(R.drawable.img);
            sum++;
        }
        double success = ((double)sum/3)*100;
        Toast.makeText(MainActivity.this,
                (sum+"/3"+","+success+"%"),Toast.LENGTH_LONG).show();
        sum=0;
    }

    public void restart(View view) {
        ivLevel1.setVisibility(view.INVISIBLE);
        ivLevel2.setVisibility(view.INVISIBLE);
        ivLevel3.setVisibility(view.INVISIBLE);
        rnd1=generateRandomNumber();
        rnd2=generateRandomNumber();
        textViewLevel1.setText(""+rnd1);
        text2Level1.setText(""+rnd2);
        textViewLevel2.setText("number");
        text2Level2.setText("number");
        textViewLevel3.setText("number");
        text2Level3.setText("number");
        AnsLevel1.setText(null);
        AnsLevel2.setText(null);
        AnsLevel3.setText(null);
    }
}

