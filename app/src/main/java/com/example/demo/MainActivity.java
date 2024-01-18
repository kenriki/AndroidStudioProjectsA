package com.example.demo;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.demo.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * 足し算イベント
     * @param view
     */
    public void onButton1(View view){
        //Editの取得
        EditText eT1 = (EditText)findViewById(R.id.eT1);
        EditText eT2 = (EditText)findViewById(R.id.eT2);

        //EditからStringへ変換
        String str1 = eT1.getText().toString();
        String str2 = eT2.getText().toString();

        // intに変換
        int num1= Integer.parseInt(str1);
        int num2= Integer.parseInt(str2);

        // 計算
        int sum = num1 + num2;
        ((TextView)findViewById(R.id.tvAns)).setText("" + sum);
    }

    /**
     * 引き算イベント
     * @param view
     */
    public void onButton2(View view){
        //Editの取得
        EditText eT1 = (EditText)findViewById(R.id.eT1);
        EditText eT2 = (EditText)findViewById(R.id.eT2);

        //EditからStringへ変換
        String str1 = eT1.getText().toString();
        String str2 = eT2.getText().toString();

        // intに変換
        int num1= Integer.parseInt(str1);
        int num2= Integer.parseInt(str2);

        // 計算
        int sum = 0;
        if(num1 > num2){
            sum = num1 - num2;
        }
        else {
            sum = num2 - num1;
        }
        //int sum = num1 + num2;
        ((TextView)findViewById(R.id.tvAns)).setText("" + sum);
    }

    /**
     * 掛け算イベント
     * @param view
     */
    public void onButton3(View view){
        //Editの取得
        EditText eT1 = (EditText)findViewById(R.id.eT1);
        EditText eT2 = (EditText)findViewById(R.id.eT2);

        //EditからStringへ変換
        String str1 = eT1.getText().toString();
        String str2 = eT2.getText().toString();

        // intに変換
        int num1= Integer.parseInt(str1);
        int num2= Integer.parseInt(str2);

        // 計算
        int sum = num1 * num2;
        ((TextView)findViewById(R.id.tvAns)).setText("" + sum);
    }

    /**
     * わり算イベント
     * @param view
     */
    public void onButton4(View view){
        //Editの取得
        EditText eT1 = (EditText)findViewById(R.id.eT1);
        EditText eT2 = (EditText)findViewById(R.id.eT2);

        //Editか らStringへ変換
        String str1 = eT1.getText().toString();
        String str2 = eT2.getText().toString();

        // doubleに変換
        double num1= Double.parseDouble(str1);
        double num2= Double.parseDouble(str2);

        // 計算
        double sum = 0;

        if(num1 > num2){
            sum = num1 / num2;
        }
        else {
            sum = num2 / num1;
        }

        ((TextView)findViewById(R.id.tvAns)).setText("" + sum);
    }

    /**
     * 消費税10%イベント
     * @param view
     */
    public void onButton5(View view){
        //Editの取得
        EditText eT1 = (EditText)findViewById(R.id.eT1);

        //Editか らStringへ変換
        String str1 = eT1.getText().toString();

        // デフォルトの値には０を入れる
        double num1=0;

        // doubleに変換
        num1= Double.parseDouble(str1);

        // 計算
        int sum = 0;
        // 税率初期値
        double tax = 1.1;

        if(num1 != 0){
            sum = (int) Math.floor(num1 * tax);
        }
        else {
            sum = 0;
        }

        ((TextView)findViewById(R.id.tvAns)).setText("" + sum);
    }

    /**
     * 消費税8%イベント
     * @param view
     */
    public void onButton6(View view){
        //Editの取得
        EditText eT1 = (EditText)findViewById(R.id.eT1);

        //Editか らStringへ変換
        String str1 = eT1.getText().toString();

        // デフォルトの値には０を入れる
        double num1=0;

        // doubleに変換
        num1= Double.parseDouble(str1);

        // 計算
        int sum = 0;
        // 税率初期値
        double tax = 1.08;

        if(num1 != 0){
            sum = (int) Math.floor(num1 * tax);
        }
        else {
            sum = 0;
        }

        ((TextView)findViewById(R.id.tvAns)).setText("" + sum);
    }

    /**
     * 20%引き イベント
     * @param view
     */
    public void onButton20(View view){
        //Editの取得
        EditText eT1 = (EditText)findViewById(R.id.eT1);

        //Editか らStringへ変換
        String str1 = eT1.getText().toString();

        // デフォルトの値には０を入れる
        double price=0;

        // doubleに変換
        price= Double.parseDouble(str1);

        // 計算
        double sum = 0;
        // 税率初期値
        double discount = 0.2;

        if(price != 0){
            sum = (int) Math.floor((price * (1-discount)));
        }
        else {
            sum = 0;
        }

        ((TextView)findViewById(R.id.tvAns)).setText("" + sum);
    }

    /**
     * 30%引き イベント
     * @param view
     */
    public void onButton30(View view){
        //Editの取得
        EditText eT1 = (EditText)findViewById(R.id.eT1);

        //Editか らStringへ変換
        String str1 = eT1.getText().toString();

        // デフォルトの値には０を入れる
        double price=0;

        // doubleに変換
        price= Double.parseDouble(str1);

        // 計算
        double sum = 0;
        // 税率初期値
        double discount = 0.3;

        if(price != 0){
            sum = (int) Math.floor((price * (1-discount)));
        }
        else {
            sum = 0;
        }

        ((TextView)findViewById(R.id.tvAns)).setText("" + sum);
    }

    /**
     * 50%引き イベント
     * @param view
     */
    public void onButton50(View view){
        //Editの取得
        EditText eT1 = (EditText)findViewById(R.id.eT1);

        //Editか らStringへ変換
        String str1 = eT1.getText().toString();

        // デフォルトの値には０を入れる
        double price=0;

        // doubleに変換
        price= Double.parseDouble(str1);

        // 計算
        double sum = 0;
        // 税率初期値
        double discount = 0.5;

        if(price != 0){
            sum = (int) Math.floor((price * (1-discount)));
        }
        else {
            sum = 0;
        }

        ((TextView)findViewById(R.id.tvAns)).setText("" + sum);
    }

    /**
     * 15%引き イベント
     * @param view
     */
    public void onButton15(View view){
        //Editの取得
        EditText eT1 = (EditText)findViewById(R.id.eT1);

        //Editか らStringへ変換
        String str1 = eT1.getText().toString();

        // デフォルトの値には０を入れる
        double price=0;

        // doubleに変換
        price= Double.parseDouble(str1);

        // 計算
        double sum = 0;
        // 税率初期値
        double discount = ((double) 15 / 100);

        if(price != 0){
            sum = (int) Math.floor((price - (price * discount)));
        }
        else {
            sum = 0;
        }

        ((TextView)findViewById(R.id.tvAns)).setText("" + sum);
    }

    /**
     * テキストエリアと結果エリアをクリアする
     * @param view
     */
    public void onClear(View view){
        ((EditText)findViewById(R.id.eT1)).getText().clear();
        ((EditText)findViewById(R.id.eT2)).getText().clear();
        ((TextView)findViewById(R.id.tvAns)).setText("こたえのエリア");
    }
}