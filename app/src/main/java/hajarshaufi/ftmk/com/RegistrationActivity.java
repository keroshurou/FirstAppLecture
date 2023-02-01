package hajarshaufi.ftmk.com;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;

import hajarshaufi.ftmk.com.databinding.ActivityRegistrationBinding;

public class RegistrationActivity extends AppCompatActivity {

    DatePickerDialog datePicker;
    ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.edtBirthdate.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View view, boolean b){

                fnInvokeDatePicker();
            }
        });

        binding.fabAddUser.setOnClickListener(this::fnAddUser);
    }

    private void fnInvokeDatePicker() {

        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);

        //date picker dialog
        datePicker = new DatePickerDialog(RegistrationActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {

                binding.edtBirthdate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
            }
        },year, month, day);
        datePicker.show();
    }

    private void fnAddUser(View view) {

        String strFullName = binding.edtFullName.getText().toString();
        String strPwd = binding.edtPwd.getText().toString();
        String strEmail = binding.edtEmail.getText().toString();
        String strAddress = binding.edtAddress.getText().toString();
        String strBirth = binding.edtBirthdate.getText().toString();
        String strGender = "";

        if (binding.rbMale.isChecked())
            strGender = binding.rbMale.getText().toString();
        else if (binding.rbFemale.isChecked())
            strGender = binding.rbFemale.getText().toString();

        User user = new User(strFullName, strPwd, strAddress, strEmail, strBirth, strGender);

        Intent intent = new Intent(this, SecondActivityUser.class);
//        intent.putExtra("objUser", "\nFull Name: " + user.getStrFullName() +
//                "\nPassword: " + user.getStrPwd() + "\nEmail : " + user.getStrEmail() + "\nBirthdate : "
//        + user.getStrBirthdate() + "\nAddress : " + user.getStrAddress() + "\nGender : " + user.getStrGender());
        startActivity(intent);
    }
}