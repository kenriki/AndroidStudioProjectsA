package com.example.demo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ﾒｰﾙｱﾌﾟﾘ起動
        mailInitButtonAction();
    }

    private void mailInitButtonAction() {
        FloatingActionButton mailFab = (FloatingActionButton) findViewById(R.id.fab);
        mailFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "ﾒｰﾙｱﾌﾟﾘを起動します", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                // メールアプリ起動
                composeEmail();
            }
        });

    }

    private void composeEmail() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, "riki.kenmochi@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "問い合わせ");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * 入力チェックのエラー文言 TODO メッセージのpropertiesファイルで持ちたいな
     */
    private final String CHECK_TEXT_MSG1 = "入力がありません！";
    /**
     * テキストボックス1個で使える機能用のフラグ切り分け
     */
    private final String CHECK_TEXT_FLG_A = "discount";
    /**
     * 結果格納かエラーメッセージかの場合分け用のフラグ
     */
    private boolean checkFlag = false;

    /**
     * 入力チェック TODO 共通化したいな
     */
    private String checkValue(String x, String y, EditText eT1, EditText eT2, String check_result) {
        if (Objects.equals(y, CHECK_TEXT_FLG_A)) {
            x = eT1.getText().toString();
            if (x.equals("") || y.equals("")) {
                check_result = CHECK_TEXT_MSG1;
                checkFlag = true;
            }
        } else {
            x = eT1.getText().toString();
            y = eT2.getText().toString();
            if (x.equals("") || y.equals("")) {
                check_result = CHECK_TEXT_MSG1;
                checkFlag = true;
            }
        }
        return check_result;
    }


    /**
     * 足し算イベント
     *
     * @param view
     */
    public void onButton1(View view) {
        //Editの取得
        EditText eT1 = (EditText) findViewById(R.id.eT1);
        EditText eT2 = (EditText) findViewById(R.id.eT2);

        //EditからStringへ変換
        String str1 = eT1.getText().toString();
        String str2 = eT2.getText().toString();

        String check_result = "";
        check_result = checkValue(str1, str2, eT1, eT2, check_result);

        if (checkFlag) {
            ((TextView) findViewById(R.id.tvAns)).setText(String.valueOf(check_result));
        } else {
            // intに変換
            int num1 = Integer.parseInt(str1);
            int num2 = Integer.parseInt(str2);

            // 計算
            int sum = num1 + num2;

            ((TextView) findViewById(R.id.tvAns)).setText(String.valueOf(sum));
        }
        // チェックフラグを元に戻す
        checkFlag = false;

    }

    /**
     * 引き算イベント
     *
     * @param view
     */
    public void onButton2(View view) {
        //Editの取得
        EditText eT1 = (EditText) findViewById(R.id.eT1);
        EditText eT2 = (EditText) findViewById(R.id.eT2);

        //EditからStringへ変換
        String str1 = eT1.getText().toString();
        String str2 = eT2.getText().toString();

        String check_result = "";
        check_result = checkValue(str1, str2, eT1, eT2, check_result);

        if (checkFlag) {
            ((TextView) findViewById(R.id.tvAns)).setText(String.valueOf(check_result));
        } else {
            // intに変換
            int num1 = Integer.parseInt(str1);
            int num2 = Integer.parseInt(str2);

            // 計算
            int sum = 0;
            if (num1 > num2) {
                sum = num1 - num2;
            } else {
                sum = num2 - num1;
            }

            ((TextView) findViewById(R.id.tvAns)).setText(String.valueOf(sum));
        }
        // チェックフラグを元に戻す
        checkFlag = false;
    }

    /**
     * 掛け算イベント
     *
     * @param view
     */
    public void onButton3(View view) {
        //Editの取得
        EditText eT1 = (EditText) findViewById(R.id.eT1);
        EditText eT2 = (EditText) findViewById(R.id.eT2);

        //EditからStringへ変換
        String str1 = eT1.getText().toString();
        String str2 = eT2.getText().toString();

        String check_result = "";
        check_result = checkValue(str1, str2, eT1, eT2, check_result);

        if (checkFlag) {
            ((TextView) findViewById(R.id.tvAns)).setText(String.valueOf(check_result));
        } else {
            // intに変換
            int num1 = Integer.parseInt(str1);
            int num2 = Integer.parseInt(str2);

            // 計算
            int sum = num1 * num2;

            ((TextView) findViewById(R.id.tvAns)).setText(String.valueOf(sum));
        }
        // チェックフラグを元に戻す
        checkFlag = false;
    }

    /**
     * わり算イベント
     *
     * @param view
     */
    public void onButton4(View view) {
        //Editの取得
        EditText eT1 = (EditText) findViewById(R.id.eT1);
        EditText eT2 = (EditText) findViewById(R.id.eT2);

        //Editか らStringへ変換
        String str1 = eT1.getText().toString();
        String str2 = eT2.getText().toString();

        String check_result = "";
        check_result = checkValue(str1, str2, eT1, eT2, check_result);

        if (checkFlag) {
            ((TextView) findViewById(R.id.tvAns)).setText(String.valueOf(check_result));
        } else {
            // intに変換
            int num1 = Integer.parseInt(str1);
            int num2 = Integer.parseInt(str2);

            // 計算
            double sum = 0;

            if (num1 > num2) {
                sum = num1 / num2;
            } else {
                sum = num2 / num1;
            }

            ((TextView) findViewById(R.id.tvAns)).setText(String.valueOf(sum));
        }
        // チェックフラグを元に戻す
        checkFlag = false;
    }

    /**
     * 消費税10%イベント
     *
     * @param view
     */
    public void onButton5(View view) {
        //Editの取得
        EditText eT1 = (EditText) findViewById(R.id.eT1);
        EditText eT2 = (EditText) findViewById(R.id.eT2);

        //Editか らStringへ変換
        String str1 = eT1.getText().toString();

        String check_result = "";
        check_result = checkValue(str1, CHECK_TEXT_FLG_A, eT1, eT2, check_result);

        if (checkFlag) {
            ((TextView) findViewById(R.id.tvAns)).setText(String.valueOf(check_result));
        } else {
            // デフォルトの値には０を入れる
            double num1 = 0;

            // doubleに変換
            num1 = Double.parseDouble(str1);

            // 計算
            int sum = 0;
            // 税率初期値
            double tax = 1.1;

            if (num1 != 0) {
                sum = (int) Math.floor(num1 * tax);
            } else {
                sum = 0;
            }

            ((TextView) findViewById(R.id.tvAns)).setText(String.valueOf(sum));
        }
        // チェックフラグを元に戻す
        checkFlag = false;
    }

    /**
     * 消費税8%イベント
     *
     * @param view
     */
    public void onButton6(View view) {
        //Editの取得
        EditText eT1 = (EditText) findViewById(R.id.eT1);
        EditText eT2 = (EditText) findViewById(R.id.eT2);

        //Editか らStringへ変換
        String str1 = eT1.getText().toString();

        String check_result = "";
        check_result = checkValue(str1, CHECK_TEXT_FLG_A, eT1, eT2, check_result);

        if (checkFlag) {
            ((TextView) findViewById(R.id.tvAns)).setText(String.valueOf(check_result));
        } else {
            // デフォルトの値には０を入れる
            double num1 = 0;

            // doubleに変換
            num1 = Double.parseDouble(str1);

            // 計算
            int sum = 0;
            // 税率初期値
            double tax = 1.08;

            if (num1 != 0) {
                sum = (int) Math.floor(num1 * tax);
            } else {
                sum = 0;
            }

            ((TextView) findViewById(R.id.tvAns)).setText(String.valueOf(sum));
        }
        // チェックフラグを元に戻す
        checkFlag = false;
    }

    /**
     * 20%引き イベント
     *
     * @param view
     */
    public void onButton20(View view) {
        //Editの取得
        EditText eT1 = (EditText) findViewById(R.id.eT1);
        EditText eT2 = (EditText) findViewById(R.id.eT2);

        //Editか らStringへ変換
        String str1 = eT1.getText().toString();

        String check_result = "";
        check_result = checkValue(str1, CHECK_TEXT_FLG_A, eT1, eT2, check_result);

        if (checkFlag) {
            ((TextView) findViewById(R.id.tvAns)).setText(String.valueOf(check_result));
        } else {
            // デフォルトの値には０を入れる
            double num1 = 0;

            // doubleに変換
            num1 = Double.parseDouble(str1);

            // デフォルトの値には０を入れる
            double price = 0;

            // doubleに変換
            price = Double.parseDouble(str1);

            // 計算
            double sum = 0;
            // 税率初期値
            double discount = 0.2;

            if (price != 0) {
                sum = (int) Math.floor((price * (1 - discount)));
            } else {
                sum = 0;
            }

            ((TextView) findViewById(R.id.tvAns)).setText(String.valueOf(sum));
        }
        // チェックフラグを元に戻す
        checkFlag = false;
    }

    /**
     * 30%引き イベント
     *
     * @param view
     */
    public void onButton30(View view) {
        //Editの取得
        EditText eT1 = (EditText) findViewById(R.id.eT1);
        EditText eT2 = (EditText) findViewById(R.id.eT2);

        //Editか らStringへ変換
        String str1 = eT1.getText().toString();

        String check_result = "";
        check_result = checkValue(str1, CHECK_TEXT_FLG_A, eT1, eT2, check_result);

        if (checkFlag) {
            ((TextView) findViewById(R.id.tvAns)).setText(String.valueOf(check_result));
        } else {
            // デフォルトの値には０を入れる
            double num1 = 0;

            // doubleに変換
            num1 = Double.parseDouble(str1);

            // デフォルトの値には０を入れる
            double price = 0;

            // doubleに変換
            price = Double.parseDouble(str1);

            // 計算
            double sum = 0;
            // 税率初期値
            double discount = 0.3;

            if (price != 0) {
                sum = (int) Math.floor((price * (1 - discount)));
            } else {
                sum = 0;
            }

            ((TextView) findViewById(R.id.tvAns)).setText(String.valueOf(sum));
        }
        // チェックフラグを元に戻す
        checkFlag = false;
    }

    /**
     * 50%引き イベント
     *
     * @param view
     */
    public void onButton50(View view) {
        //Editの取得
        EditText eT1 = (EditText) findViewById(R.id.eT1);
        EditText eT2 = (EditText) findViewById(R.id.eT2);

        //Editか らStringへ変換
        String str1 = eT1.getText().toString();

        String check_result = "";
        check_result = checkValue(str1, CHECK_TEXT_FLG_A, eT1, eT2, check_result);

        if (checkFlag) {
            ((TextView) findViewById(R.id.tvAns)).setText(String.valueOf(check_result));
        } else {
            // デフォルトの値には０を入れる
            double num1 = 0;

            // doubleに変換
            num1 = Double.parseDouble(str1);

            // デフォルトの値には０を入れる
            double price = 0;

            // doubleに変換
            price = Double.parseDouble(str1);

            // 計算
            double sum = 0;
            // 税率初期値
            double discount = 0.5;

            if (price != 0) {
                sum = (int) Math.floor((price * (1 - discount)));
            } else {
                sum = 0;
            }

            ((TextView) findViewById(R.id.tvAns)).setText(String.valueOf(sum));
        }
        // チェックフラグを元に戻す
        checkFlag = false;
    }

    /**
     * 15%引き イベント
     *
     * @param view
     */
    public void onButton15(View view) {
        //Editの取得
        EditText eT1 = (EditText) findViewById(R.id.eT1);
        EditText eT2 = (EditText) findViewById(R.id.eT2);

        //Editか らStringへ変換
        String str1 = eT1.getText().toString();

        String check_result = "";
        check_result = checkValue(str1, CHECK_TEXT_FLG_A, eT1, eT2, check_result);

        if (checkFlag) {
            ((TextView) findViewById(R.id.tvAns)).setText(String.valueOf(check_result));
        } else {
            // デフォルトの値には０を入れる
            double num1 = 0;

            // doubleに変換
            num1 = Double.parseDouble(str1);

            // デフォルトの値には０を入れる
            double price = 0;

            // doubleに変換
            price = Double.parseDouble(str1);

            // 計算
            double sum = 0;
            // 税率初期値
            double discount = ((double) 15 / 100);

            if (price != 0) {
                sum = (int) Math.floor((price - (price * discount)));
            } else {
                sum = 0;
            }

            ((TextView) findViewById(R.id.tvAns)).setText(String.valueOf(sum));
        }
        // チェックフラグを元に戻す
        checkFlag = false;
    }

    /**
     * テキストエリアと結果エリアをクリアする
     *
     * @param view
     */
    public void onClear(View view) {
        ((EditText) findViewById(R.id.eT1)).getText().clear();
        ((EditText) findViewById(R.id.eT2)).getText().clear();
        ((TextView) findViewById(R.id.tvAns)).setText("こたえのエリア");
    }

}