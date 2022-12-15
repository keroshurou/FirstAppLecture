package hajarshaufi.ftmk.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    TextView txtVw1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtVw1 = findViewById(R.id.textView);
    }

    public void fnChangeText(View view)
    {
        txtVw1.setText(R.string.success);
    }
}