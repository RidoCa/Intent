package com.rido.intent1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Class name for Log tag
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    // Unique tag required for the intent extra
    public static final String EXTRA_MESSAGE = "com.rido.intent1.extra.MESSAGE";
    // EditText view for the nama
    private EditText mMessageEditText;
    // EditText view for the alamat
    private EditText mMessageEditText2;
    // EditText view for the no
    private EditText mMessageEditText3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize all the view variables.
        mMessageEditText = (EditText) findViewById(R.id.editText_main);
        mMessageEditText2 = (EditText) findViewById(R.id.editText_main2);
        mMessageEditText3 = (EditText) findViewById(R.id.editText_main3);
    }

    /**
     * Handle the onClick for the "Send" button. Gets the value of the main EditText,
     * creates an intent, and launches the second activity with that intent.
     *
     * The return intent from the second activity is onActivityResult().
     * @param view The view (Button) that was clicked.
     */
    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");

        Intent intent = new Intent(this, SecondActivity.class);
        String nama = mMessageEditText.getText().toString();
        String alamat = mMessageEditText2.getText().toString();
        String noHp = mMessageEditText3.getText().toString();

        String[] messages = new String[] {nama,alamat,noHp};

        intent.putExtra(EXTRA_MESSAGE, messages);
        startActivity(intent);
    }
}
