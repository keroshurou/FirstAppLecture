package hajarshaufi.ftmk.com;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "Student.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table StudentDetails(fullName TEXT primary key, studNo TEXT, email TEXT, birth TEXT, gender TEXT, state TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists StudentDetails");
    }

    public Boolean insertData (String fullName, String studNo, String email, String birth, String gender, String state){

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fullName", fullName);
        contentValues.put("studNo", studNo);
        contentValues.put("email", email);
        contentValues.put("birth", birth);
        contentValues.put("gender", gender);
        contentValues.put("state", state);
        long result = DB.insert("StudentDetails", null, contentValues);
        if (result == -1){
            return false;
        } else {
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from StudentDetails", null);
        return cursor;
    }
}
