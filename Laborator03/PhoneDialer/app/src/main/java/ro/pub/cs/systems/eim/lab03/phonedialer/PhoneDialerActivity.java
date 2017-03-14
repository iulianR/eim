package ro.pub.cs.systems.eim.lab03.phonedialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PhoneDialerActivity extends AppCompatActivity {
    private EditText editText;

    private class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.backspace) {
                System.out.println("Here");
                String text = editText.getText().toString();
                editText.setText(text.substring(0, text.length() - 1));
            } else if (v.getId() == R.id.call) {
                if (ContextCompat.checkSelfPermission(PhoneDialerActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                            PhoneDialerActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            0);
                } else {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + editText.getText().toString()));
                    startActivity(intent);
                }
            } else if (v.getId() == R.id.refuse) {
                finish();
            } else {
                Button button = (Button)v;
                editText.append(button.getText());
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button digit;
        ImageButton button;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);

        editText = (EditText)findViewById(R.id.editText);
        digit = (Button)findViewById(R.id.digit1);
        digit.setOnClickListener(new ButtonListener());
        digit = (Button)findViewById(R.id.digit2);
        digit.setOnClickListener(new ButtonListener());
        digit = (Button)findViewById(R.id.digit3);
        digit.setOnClickListener(new ButtonListener());
        digit = (Button)findViewById(R.id.digit4);
        digit.setOnClickListener(new ButtonListener());
        digit = (Button)findViewById(R.id.digit5);
        digit.setOnClickListener(new ButtonListener());
        digit = (Button)findViewById(R.id.digit6);
        digit.setOnClickListener(new ButtonListener());
        digit = (Button)findViewById(R.id.digit7);
        digit.setOnClickListener(new ButtonListener());
        digit = (Button)findViewById(R.id.digit8);
        digit.setOnClickListener(new ButtonListener());
        digit = (Button)findViewById(R.id.digit9);
        digit.setOnClickListener(new ButtonListener());
        digit = (Button)findViewById(R.id.digit0);
        digit.setOnClickListener(new ButtonListener());

        button = (ImageButton)findViewById(R.id.backspace);
        button.setOnClickListener(new ButtonListener());
        button = (ImageButton)findViewById(R.id.call);
        button.setOnClickListener(new ButtonListener());
        button = (ImageButton)findViewById(R.id.refuse);
        button.setOnClickListener(new ButtonListener());
    }
}
