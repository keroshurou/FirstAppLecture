package hajarshaufi.ftmk.com;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.jar.Attributes;

import hajarshaufi.ftmk.com.databinding.ActivityStudentMainBinding;

public class StudentMainActivity extends AppCompatActivity {

    private ActivityStudentMainBinding binding;
    private Student student;

    private Vector<Student> students;
    private StudentAdapter adapter;
    private DatePickerDialog datePicker;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);

        binding = ActivityStudentMainBinding.inflate(getLayoutInflater());
        DB = new DBHelper(this);

        setContentView(binding.getRoot());

        binding.edtBirthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                int mHour = cldr.get(Calendar.HOUR_OF_DAY);
                int mMinute = cldr.get(Calendar.MINUTE);
                String strDay ="";
                // date picker dialog
                datePicker = new DatePickerDialog(StudentMainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                                binding.edtBirthdate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                datePicker.show();
            }
        });

//        students = new Vector<>();
//        adapter = new StudentAdapter(getLayoutInflater(),students);
//
//        binding.rcvStud.setAdapter(adapter);
//        binding.rcvStud.setLayoutManager(new LinearLayoutManager(this));
//        displayData();

        binding.fabAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = binding.edtFullName.getText().toString();
                String studNo = binding.edtStudNum.getText().toString();
                String email = binding.edtEmail.getText().toString();
                String birth = binding.edtBirthdate.getText().toString();
                String gender = "";
                String state = binding.spnState.getSelectedItem().toString();

                if(binding.rbMale.isChecked())
                    gender = binding.rbMale.getText().toString();
                else if(binding.rbFemale.isChecked())
                    gender = binding.rbFemale.getText().toString();

                Boolean checkInsert = DB.insertData(fullName, studNo, email, birth, gender, state);
                if (checkInsert == true)
                    Toast.makeText(StudentMainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(StudentMainActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();

                binding.edtFullName.setText("");
                binding.edtBirthdate.setText("");
                binding.edtEmail.setText("");
                binding.edtStudNum.setText("");
            }
        });

        binding.viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(StudentMainActivity.this, StudentList.class);
                startActivity(intent);

                /*Cursor res = DB.getData();
                if (res.getCount() == 0){
                    Toast.makeText(StudentMainActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Full Name: " + res.getString(0) +"\n");
                    buffer.append("Student No: " + res.getString(1) +"\n");
                    buffer.append("Email: " + res.getString(2) +"\n");
                    buffer.append("Date of Birth: " + res.getString(3) +"\n");
                    buffer.append("Gender: " + res.getString(4) +"\n");
                    buffer.append("State: " + res.getString(5) +"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(StudentMainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Students Entries");
                builder.setMessage(buffer.toString());
                builder.show();*/
            }
        });
    }

    /*private void displayData(){
        Cursor cursor = DB.getData();
        if (cursor.getCount() == 0){
            Toast.makeText(StudentMainActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()){
            buffer.append("Full Name: " + cursor.getString(0) +"\n");
            buffer.append("Student No: " + cursor.getString(1) +"\n");
            buffer.append("Email: " + cursor.getString(2) +"\n");
            buffer.append("Date of Birth: " + cursor.getString(3) +"\n");
            buffer.append("Gender: " + cursor.getString(4) +"\n");
            buffer.append("State: " + cursor.getString(5) +"\n\n");
        }
    }*/

    /**private void fnAddToRest(View view) {

        String url = "http://192.168.212.86/RESTAPI/rest_api.php";
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG", "RESPONSE IS " + response);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
                    // on below line we are displaying a success toast message.
                    Toast.makeText(getApplicationContext(), "Respond from server" +
                            jsonObject.getString("respond"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();

                String fullname = binding.edtFullName.getText().toString();
                String studNo = binding.edtStudNum.getText().toString();
                String email = binding.edtEmail.getText().toString();
                String birth = binding.edtBirthdate.getText().toString();
                String gender = "";
                String state = binding.spnState.getSelectedItem().toString();

                if(binding.rbMale.isChecked())
                    gender = binding.rbMale.getText().toString();
                else if(binding.rbFemale.isChecked())
                    gender = binding.rbFemale.getText().toString();

                params.put("selectFn", "fnSaveData");
                params.put("stud_name", fullname);
                params.put("stud_no", studNo);
                params.put("stud_gender", gender);
                params.put("stud_state", state);
                params.put("stud_dob", birth);

                return params;
            }
        };
        queue.add(request);
    }

    private void fnAdd(View view)
    {
        String fullname = binding.edtFullName.getText().toString();
        String studNo = binding.edtStudNum.getText().toString();
        String email = binding.edtEmail.getText().toString();
        String birth = binding.edtBirthdate.getText().toString();
        String gender = "";
        String state = binding.spnState.getSelectedItem().toString();

        if(binding.rbMale.isChecked())
            gender = binding.rbMale.getText().toString();
        else if(binding.rbFemale.isChecked())
            gender = binding.rbFemale.getText().toString();

        student = new Student(fullname,studNo,email,gender,birth, state);

        students.add(student);
        adapter.notifyItemInserted(students.size());
    }*/

}