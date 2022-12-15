package hajarshaufi.ftmk.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.BreakIterator;
import java.util.Calendar;

public class FirstActivity extends AppCompatActivity {

    TextView txtvwAge;
    EditText edtName, edtYear;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        txtvwAge = (TextView) findViewById(R.id.txtvwAge);
        edtName = (EditText) findViewById(R.id.edtTxtName);
        edtYear = (EditText) findViewById(R.id.edtYear);
    }

    public void fnGreet(View vw){

        String strName = edtName.getText().toString();
        txtvwAge.setText("Hellooo and Welcome..." + strName);
    }

    public void fnCountAge(View view)
    {
        String strName = edtName.getText().toString();
        String strAge = edtYear.getText().toString();
        int intYear = Integer.parseInt(strAge);
        int intCurrentYear = 2022;
        int intAge = intCurrentYear - intYear;
        txtvwAge.setText("Hi " + strName + "! Your age is "+ intAge);
    }

    public void fnThreadActivity(View vw)
    {
        Intent intent = new Intent(this, ThreadedActivity.class);
        String strMsg = ((EditText) findViewById(R.id.edtTxtName)).getText().toString();
        intent.putExtra("varStr1", strMsg);
        startActivity(intent);
    }

    public void fnGoNext(View view)
    {
        Intent intent = new Intent(this, SecondActivityUser.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "This happen when app is about to pause"
        , Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "This happen when app is about to stop"
                , Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "This happen when app is about to destroy"
                , Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "This happen when app is about to restarting"
                , Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "This happen when app is about to resuming"
                , Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "This happen when app is about to started"
                , Toast.LENGTH_SHORT).show();
    }
}