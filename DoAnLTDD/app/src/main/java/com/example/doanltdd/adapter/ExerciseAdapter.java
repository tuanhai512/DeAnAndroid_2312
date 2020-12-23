package com.example.doanltdd.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanltdd.ListDayOnWeek;
import com.example.doanltdd.R;
import com.example.doanltdd.model.Exercise;

import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHoder> {
    private Context context;
    private List<Exercise> exerciseList;
    private AdapterView.OnItemClickListener listener;
    public void setData(List<Exercise> list)
    {
        this.exerciseList = list;
        notifyDataSetChanged();
    }
    public void setData(List<Exercise> list,Context context)
    {
        this.context = context;
        this.exerciseList = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ExerciseViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_excercise,parent,false);
        return new ExerciseViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHoder holder, int position) {
        Exercise exercise = exerciseList.get(position);
        if(exercise == null) {
            return;
        }
        holder.tvName.setImageResource(exercise.getResourceID());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0) {
                    Intent intent = new Intent(holder.itemView.getContext(), ListDayOnWeek.class);
                    holder.itemView.getContext().startActivity(intent);
                }
                if(position==1)
                {
                    Intent intent = new Intent(holder.itemView.getContext(), ListDayOnWeek.class);
                    holder.itemView.getContext().startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        if(exerciseList != null)
        {
            return exerciseList.size();
        }
        return 0;
    }


   class ExerciseViewHoder extends RecyclerView.ViewHolder {
        //Khởi tạo biến
        private ImageView tvName;
        LinearLayout linearLayout;

        public ExerciseViewHoder(View itemView) {
            super(itemView);
            //Gán biến
            tvName= (ImageView) itemView.findViewById(R.id.tv_name);

            itemView.setOnClickListener(v -> Toast.makeText(context.getApplicationContext(),""+getAdapterPosition(),Toast.LENGTH_LONG).show());
        }


    }

}
