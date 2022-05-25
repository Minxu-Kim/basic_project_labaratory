package com.example.basic_project_labaratory;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Mission1Adapter extends RecyclerView.Adapter<Mission1Adapter.ItemViewHolder> {
    private ArrayList<Mission1Data> listData = new ArrayList<>();
    private Context mContext;

    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mission1_recyclerview, parent, false);
        return new ItemViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.onBind(listData.get(position));
    }

    public int getItemCount() {
        return listData.size();
    }

    void additem(Mission1Data data) {
        listData.add(data);
    }

    public Mission1Adapter(Context context, ArrayList<Mission1Data> listData) {
        this.listData = listData;
        this.mContext = context;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView missiontext;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            missiontext = itemView.findViewById(R.id.missiontext);
            itemView.setClickable(true);
            itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        Intent intent = new Intent(mContext, Mission1Item.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        //intent.putExtra("Text", listData.get(pos));
                        mContext.startActivity(intent);

                    }
                }
            });
        }

        void onBind(Mission1Data data) {
            missiontext.setText(data.getContent());
        }
    }
}


