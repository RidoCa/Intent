package com.rido.intent1;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Get the intent that launched this activity, and the message in
        // the intent extra.

        Intent intent = getIntent();
        String[] messages = intent.getStringArrayExtra(MainActivity.EXTRA_MESSAGE);
        TextView namaTextView = (TextView) findViewById (R.id.text_nama);
        TextView alamatTextView = (TextView) findViewById (R.id.text_alamat);
        TextView noHpTextView = (TextView) findViewById (R.id.text_noHp);

        if (messages != null) {

        namaTextView.setText ("Nama   : " +messages[0]);
        alamatTextView.setText ("Alamat : " +messages[1]);
        noHpTextView.setText ("No Hp  : " +messages[2]);
        }


    }

    public void shareText(View view) {
        Intent intent = getIntent();
        String[] messages = intent.getStringArrayExtra(MainActivity.EXTRA_MESSAGE);

        String datadiri = "Nama " + messages[0] + "\n" + "Alamat "+messages[1] + "\n" + "NoHp " +messages[2];
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(datadiri)
                .startChooser();
    }
}
