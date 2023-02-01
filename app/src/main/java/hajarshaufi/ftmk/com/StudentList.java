package hajarshaufi.ftmk.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> fullName, studNo, email, birth, gender, state;
    DBHelper DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        DB = new DBHelper(this);
        fullName = new ArrayList<>();
        studNo = new ArrayList<>();
        email = new ArrayList<>();
        birth = new ArrayList<>();
        gender = new ArrayList<>();
        state = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new MyAdapter(this, fullName, studNo, email, birth, gender, state);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
    }

    private void displayData() {

        Cursor cursor = DB.getData();
        if (cursor.getCount() == 0){
            Toast.makeText(StudentList.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else {

            while (cursor.moveToNext()){
                fullName.add(cursor.getString(0));
                studNo.add(cursor.getString(1));
                email.add(cursor.getString(2));
                birth.add(cursor.getString(3));
                gender.add(cursor.getString(4));
                state.add(cursor.getString(5));
            }
        }
    }
}