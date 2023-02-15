package com.example.codeeditor;

import android.content.Context;

import com.amrdeveloper.codeview.CodeView;

import java.util.regex.Pattern;

public class JavaSyntaxManager {
    //language keywords
    private static final Pattern PATTERN_KEYWORDS =
            Pattern.compile("\\b(abstract|continue|for|new|switch|assert|default|package|synchronized|boolean|do|if|private|this|break|double|implements|protected|throwbyte|else|import|public|throws|case|enum|instanceof|return|transient|catch|extends|int|short|try|char|final|interface|static|void|class|finally|long|strictfp|volatile|float|native|super|while)\\b");

    //Brackets and Colons
    private static final Pattern PATTERN_BUILTINS = Pattern.compile("[,:;[->]{}()]");

    //Data
    private static final Pattern PATTERN_NUMBERS = Pattern.compile("\\b(\\d*[.]?\\d+)\\b");
    private static final Pattern PATTERN_CHAR = Pattern.compile("'[a-zA-Z]'");
    private static final Pattern PATTERN_STRING = Pattern.compile("\".*\"");
    private static final Pattern PATTERN_HEX = Pattern.compile("0x[0-9a-fA-F]+");
    private static final Pattern PATTERN_TODO_COMMENT = Pattern.compile("//TODO[^\n]*");
    private static final Pattern PATTERN_COMMENT =
            Pattern.compile("//(?!TODO )[^\\n]*" + "|" + "/\\*(.|\\R)*?\\*/");
    private static final Pattern PATTERN_ATTRIBUTE = Pattern.compile("\\.[a-zA-Z0-9_]+");
    private static final Pattern PATTERN_OPERATION = Pattern.compile(":|==|>|<|!=|>=|<=|->|=|>|<|%|-|-=|%=|\\+|\\-|\\-=|\\+=|\\^|\\&|\\|::|\\?|\\*");


    public static void applyMonokaiTheme(Context context, CodeView codeView) {
        codeView.resetSyntaxPatternList();
        //View Background
        codeView.setBackgroundColor(codeView.getResources().getColor(R.color.syntax_background));

        //Syntax Colors
        codeView.addSyntaxPattern(PATTERN_HEX, context.getResources().getColor(R.color.syntax_purple));
        codeView.addSyntaxPattern(PATTERN_CHAR, context.getResources().getColor(R.color.syntax_green));
        codeView.addSyntaxPattern
                (PATTERN_STRING, context.getResources().getColor(R.color.syntax_orange));
        codeView.addSyntaxPattern
                (PATTERN_NUMBERS, context.getResources().getColor(R.color.syntax_purple));
        codeView.addSyntaxPattern
                (PATTERN_KEYWORDS, context.getResources().getColor(R.color.syntax_red));
        codeView.addSyntaxPattern
                (PATTERN_BUILTINS, context.getResources().getColor(R.color.white));
        codeView.addSyntaxPattern
                (PATTERN_COMMENT, context.getResources().getColor(R.color.syntax_comment));
        codeView.addSyntaxPattern
                (PATTERN_ATTRIBUTE, context.getResources().getColor(R.color.syntax_blue));
        codeView.addSyntaxPattern
                (PATTERN_OPERATION, context.getResources().getColor(R.color.syntax_red));
        //Default Color
        codeView.setTextColor( context.getResources().getColor(R.color.white));

        codeView.setTextColor( context.getResources().getColor(R.color.white));

        codeView.addSyntaxPattern
                (PATTERN_TODO_COMMENT, context.getResources().getColor(R.color.gold));

        codeView.reHighlightSyntax();


    }
}
