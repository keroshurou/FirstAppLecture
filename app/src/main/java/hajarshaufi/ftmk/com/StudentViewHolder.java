package hajarshaufi.ftmk.com;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private final TextView lblFullName, lblStudNo, lblGender, lblBirthdate, lblEmail, lblState;

    public StudentViewHolder(@NonNull View itemView){
        super(itemView);
        this.lblFullName = itemView.findViewById(R.id.edtFullName);
        this.lblStudNo = itemView.findViewById(R.id.edtStudNum);
        this.lblGender = itemView.findViewById(R.id.rgGender);
        this.lblBirthdate = itemView.findViewById(R.id.edtBirthdate);
        this.lblEmail = itemView.findViewById(R.id.edtEmail);
        this.lblState = itemView.findViewById(R.id.lblState);
    }

    public void setStudent(Student student){
        lblFullName.setText(student.getStrFullName());
        lblStudNo.setText(student.getStrStudNo());
        lblEmail.setText(student.getStrEmail());
        lblBirthdate.setText(student.getStrEmail());
        lblGender.setText(student.getStrGender());
        lblState.setText(student.getStrState());
    }
}
