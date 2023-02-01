package hajarshaufi.ftmk.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private ArrayList fullName, studNo, email, birth, gender, state;

    public MyAdapter(Context context, ArrayList fullName, ArrayList studNo, ArrayList email, ArrayList birth, ArrayList gender, ArrayList state) {
        this.context = context;
        this.fullName = fullName;
        this.studNo = studNo;
        this.email = email;
        this.birth = birth;
        this.gender = gender;
        this.state = state;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.student_entry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.fullName.setText(String.valueOf(fullName.get(position)));
        holder.studNo.setText(String.valueOf(studNo.get(position)));
        holder.email.setText(String.valueOf(email.get(position)));
        holder.birth.setText(String.valueOf(birth.get(position)));
        holder.gender.setText(String.valueOf(gender.get(position)));
        holder.state.setText(String.valueOf(state.get(position)));
    }

    @Override
    public int getItemCount() {
        return fullName.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView fullName, studNo, email, birth, gender, state;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fullName = itemView.findViewById(R.id.txtName);
            studNo = itemView.findViewById(R.id.txtStudNo);
            email = itemView.findViewById(R.id.txtEmail);
            birth = itemView.findViewById(R.id.txtBirth);
            gender = itemView.findViewById(R.id.txtGender);
            state = itemView.findViewById(R.id.txtState);
        }
    }
}
