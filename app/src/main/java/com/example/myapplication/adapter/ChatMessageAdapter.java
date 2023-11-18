package com.example.myapplication.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.entity.ChatMessage;

import java.util.ArrayList;

public class ChatMessageAdapter extends ArrayAdapter<ChatMessage> {
    public ChatMessageAdapter(Context context, ArrayList<ChatMessage> messages) {
        super(context, 0, messages);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChatMessage message = getItem(position);
        if (convertView == null) {
            if (message.isBot()) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.bot_message, parent, false);
            } else {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_message, parent, false);
            }
        }

        TextView textView = message.isBot() ?
                convertView.findViewById(R.id.tv_bot_message) :
                convertView.findViewById(R.id.tv_user_message);
        textView.setText(message.getContent());

        return convertView;

    }

}
