package hajarshaufi.ftmk.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class SecondActivityUser extends AppCompatActivity {

    TextView userTxtVw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_user);
        setTitle("Second Activity");
        userTxtVw = findViewById(R.id.userTxtVw);

        User user = (User) getIntent().getSerializableExtra("objUser");
        userTxtVw.setText("Information registered : \n\n" + "\nFull Name: " + user.getStrFullName() +
                "\nPassword: " + user.getStrPwd() + "\nEmail : " + user.getStrEmail() + "\nBirthdate : "
                + user.getStrBirthdate() + "\nAddress : " + user.getStrAddress() + "\nGender : " + user.getStrGender());
    }
}