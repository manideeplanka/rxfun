package com.rapidbizapps.rxsample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rapidbizapps.rxsample.models.GitHubUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mlanka on 16-05-2016.
 */
public class GitHubUsersAdapter extends RecyclerView.Adapter<GitHubUsersAdapter.CustomViewHolder> {
    Context context;

    private static final String LOG_TAG = "GitHubUsersAdapter";

    GitHubUsersAdapter(Context context) {
        this.context = context;
    }

    List<GitHubUser> users = new ArrayList<>();

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.github_user_list_item, parent, false);
        return new CustomViewHolder(itemView);
    }


    void addUser(GitHubUser user) {
        users.add(user);
        notifyItemInserted(users.size() - 1);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.login_tv.setText(users.get(position).getLogin());
        holder.name_tv.setText(users.get(position).getName());
    }


    @Override
    public int getItemCount() {
        return users.size();
    }


    static class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView login_tv, name_tv;

        public CustomViewHolder(View itemView) {
            super(itemView);

            login_tv = (TextView) itemView.findViewById(R.id.loginID);
            name_tv = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
