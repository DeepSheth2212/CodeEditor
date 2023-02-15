package com.example.codeeditor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.amrdeveloper.codeview.CodeView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    CodeView codeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        codeView = findViewById(R.id.codeView);
        JavaSyntaxManager.applyMonokaiTheme(this,codeView);
        configLanguageAutoComplete();


    }

    private void configLanguageAutoComplete() {
        //Load current Programming Language
        final String[] languageKeywords = getResources().getStringArray(R.array.java_keywords);

        //Custom list item xml layout
        final int layoutId = R.layout.suggestion_list_item;

        //TextView id to put suggestion on it
        final int viewId = R.id.suggestItemTextView;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, layoutId, viewId,
                languageKeywords);

        //Add Custom Adapter to the CodeView
        codeView.setAdapter(adapter);
   }
}