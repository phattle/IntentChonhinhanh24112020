package com.example.intentchonhinhanh24112020;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    List<User> mArrUsers;

    public UserAdapter(List<User> mArrUsers) {
        this.mArrUsers = mArrUsers;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater  = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_item_user_score,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mArrUsers.get(position);
        holder.tvScore.setText(user.getScore() + " point");
        holder.tvDots.setText("............................................................................................");
        holder.tvName.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return mArrUsers.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{

        TextView tvName,tvScore,tvDots;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.textViewUserName);
            tvScore = itemView.findViewById(R.id.textViewUserScore);
            tvDots = itemView.findViewById(R.id.textViewDots);
        }
    }
}
