package com.example.basic_project_labaratory;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<Dictionary> mList;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView textView;


        public CustomViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.text);
        }
    }


    public CustomAdapter(ArrayList<Dictionary> list) {
        this.mList = list;
    }



    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.mission2_item, viewGroup, false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }




    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {
        viewholder.textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        viewholder.textView.setGravity(Gravity.CENTER);
        viewholder.textView.setText(mList.get(position).getContext());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}