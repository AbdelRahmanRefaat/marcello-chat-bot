package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatMessagesListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<ChatMessageModel> chatMessages = new ArrayList<ChatMessageModel>();
    private final int VIEW_TYPE_USER_MESSAGE = 1;
    private final int VIEW_TYPE_BOT_MESSAGE = 2;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_USER_MESSAGE){
            return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.message_user_side,parent,false));
        }else if(viewType == VIEW_TYPE_BOT_MESSAGE){
            return new BotViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.message_bot_side,parent,false));
        }else{
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(chatMessages.get(position).getId() == VIEW_TYPE_USER_MESSAGE){
            UserViewHolder userViewHolder = (UserViewHolder) holder;
            userViewHolder.nameTv.setText(chatMessages.get(position).getName());
        }else if(chatMessages.get(position).getId() == VIEW_TYPE_BOT_MESSAGE){
            BotViewHolder botViewHolder = (BotViewHolder) holder;
            botViewHolder.nameTv.setText(chatMessages.get(position).getName());
        }

    }

    @Override
    public int getItemViewType(int position) {
        return chatMessages.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    public void setList(ArrayList<ChatMessageModel> chatMessages){
        this.chatMessages = chatMessages;
        notifyDataSetChanged();
    }
    public class BotViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv;
        public BotViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.text_view_chat_message);
        }
    }
    public class UserViewHolder extends RecyclerView.ViewHolder{
        TextView nameTv;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.text_view_chat_message);
        }
    }
}