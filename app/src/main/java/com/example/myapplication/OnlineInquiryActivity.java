package com.example.myapplication;

import static com.example.myapplication.tool.JsonTools.loadDiseasesFromJson;
import static com.example.myapplication.tool.JsonTools.loadSymptomsFromJson;
import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.adapter.ChatMessageAdapter;
import com.example.myapplication.entity.ChatMessage;
import com.example.myapplication.entity.Disease;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class OnlineInquiryActivity extends AppCompatActivity {
    private ListView chatListView;
    private EditText messageEditText;
    private Button sendButton;
    private Button exitButton;
    private ChatMessageAdapter chatAdapter;
    private ArrayList<ChatMessage> chatMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_online_inquiry);

        chatListView = findViewById(R.id.chat_list_view);
        messageEditText = findViewById(R.id.et_message_input);
        sendButton = findViewById(R.id.btn_send);
        exitButton = findViewById(R.id.btn_exit);

        chatMessages = new ArrayList<>();
        chatAdapter = new ChatMessageAdapter(this, chatMessages);
        chatListView.setAdapter(chatAdapter);

        exitButton.setOnClickListener(v -> {
            // 关闭当前 Activity
            finish();
        });

        sendButton.setOnClickListener(view -> {
            String message = messageEditText.getText().toString();
            if (!message.isEmpty()) {
                // 添加用户消息
                chatMessages.add(new ChatMessage(message, false));
                // 机器人回复
                String reply = getBotReply(message); // 获取机器人回复
                chatMessages.add(new ChatMessage(reply, true));
                messageEditText.setText("");
                chatAdapter.notifyDataSetChanged();
                chatListView.setSelection(chatAdapter.getCount() - 1);
            }else {
                Toast.makeText(OnlineInquiryActivity.this, "Message cannot be empty", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getBotReply(String userMessage) {
        Set<String> userSymptoms = extractSymptoms(this,userMessage);
        Disease bestMatch = findBestMatch(this,userSymptoms);
        String reply = bestMatch != null ?
                "推荐您去" + bestMatch.getName() + "门诊。" :
                "请提供更多病情信息。";

        return reply;
    }

    public Set<String> extractSymptoms(Context context, String userInput) {
        Set<String> extractedSymptoms = new HashSet<>();
        Set<String> knownSymptoms = loadSymptomsFromJson(context);
        for (String symptom : knownSymptoms) {
            if (userInput.toLowerCase().contains(symptom.toLowerCase())) {
                extractedSymptoms.add(symptom);
            }
        }
        return extractedSymptoms;
    }

    public Disease findBestMatch(Context context, Set<String> userSymptoms) {
        List<Disease> diseases = loadDiseasesFromJson(context); // 从JSON加载疾病列表

        Disease bestMatch = null;
        int maxMatchCount = 0;
        for (Disease disease : diseases) {
            int matchCount = disease.matchSymptoms(userSymptoms);
            if (matchCount > maxMatchCount) {
                bestMatch = disease;
                maxMatchCount = matchCount;
            }
        }
        return bestMatch;
    }




}
