package com.logangoodwin.aactaptalk;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.view.Gravity;
import android.view.HapticFeedbackConstants;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener {

    private TextToSpeech textToSpeech;
    private boolean speechReady = false;
    private TextView selectedText;
    private TextView helperText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        window.setStatusBarColor(Color.WHITE);
        window.setNavigationBarColor(Color.WHITE);

        textToSpeech = new TextToSpeech(this, this);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER_HORIZONTAL);
        root.setBackgroundColor(Color.rgb(248, 250, 252));
        root.setPadding(dp(18), dp(18), dp(18), dp(18));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            root.setOnApplyWindowInsetsListener((view, insets) -> {
                int top = insets.getSystemWindowInsetTop();
                int bottom = insets.getSystemWindowInsetBottom();
                view.setPadding(dp(18), top + dp(14), dp(18), bottom + dp(14));
                return insets;
            });
        }

        TextView title = new TextView(this);
        title.setText("AAC Tap Talk");
        title.setTextSize(28);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setTextColor(Color.rgb(15, 23, 42));
        title.setGravity(Gravity.CENTER);
        root.addView(title, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        TextView subtitle = new TextView(this);
        subtitle.setText("Tap a picture to speak");
        subtitle.setTextSize(18);
        subtitle.setTextColor(Color.rgb(71, 85, 105));
        subtitle.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams subtitleParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        subtitleParams.setMargins(0, dp(4), 0, dp(16));
        root.addView(subtitle, subtitleParams);

        LinearLayout resultPanel = new LinearLayout(this);
        resultPanel.setOrientation(LinearLayout.VERTICAL);
        resultPanel.setGravity(Gravity.CENTER);
        resultPanel.setBackgroundResource(R.drawable.result_panel);
        resultPanel.setPadding(dp(14), dp(12), dp(14), dp(12));

        selectedText = new TextView(this);
        selectedText.setText("READY");
        selectedText.setTextSize(42);
        selectedText.setTypeface(Typeface.DEFAULT_BOLD);
        selectedText.setTextColor(Color.rgb(15, 23, 42));
        selectedText.setGravity(Gravity.CENTER);
        resultPanel.addView(selectedText, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        helperText = new TextView(this);
        helperText.setText("Waiting for a choice");
        helperText.setTextSize(18);
        helperText.setTextColor(Color.rgb(71, 85, 105));
        helperText.setGravity(Gravity.CENTER);
        resultPanel.addView(helperText, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        LinearLayout.LayoutParams resultParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dp(132)
        );
        resultParams.setMargins(0, 0, 0, dp(16));
        root.addView(resultPanel, resultParams);

        LinearLayout buttonArea = new LinearLayout(this);
        buttonArea.setOrientation(LinearLayout.VERTICAL);
        buttonArea.setGravity(Gravity.CENTER);

        buttonArea.addView(makeChoiceButton(
                "YES",
                "Yes",
                R.drawable.ic_yes,
                R.drawable.card_yes,
                "Yes button. Tap to say yes."
        ));

        buttonArea.addView(makeChoiceButton(
                "NO",
                "No",
                R.drawable.ic_no,
                R.drawable.card_no,
                "No button. Tap to say no."
        ));

        buttonArea.addView(makeChoiceButton(
                "BATHROOM",
                "I need the bathroom",
                R.drawable.ic_bathroom,
                R.drawable.card_bathroom,
                "Bathroom button. Tap to say I need the bathroom."
        ));

        root.addView(buttonArea, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
        ));

        setContentView(root);
    }

    private View makeChoiceButton(String displayWord, String spokenPhrase, int imageRes, int backgroundRes, String description) {
        LinearLayout button = new LinearLayout(this);
        button.setOrientation(LinearLayout.HORIZONTAL);
        button.setGravity(Gravity.CENTER_VERTICAL);
        button.setPadding(dp(22), dp(14), dp(22), dp(14));
        button.setBackgroundResource(backgroundRes);
        button.setClickable(true);
        button.setFocusable(true);
        button.setContentDescription(description);

        ImageView image = new ImageView(this);
        image.setImageResource(imageRes);
        image.setContentDescription(displayWord + " picture");
        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(dp(96), dp(96));
        imageParams.setMargins(0, 0, dp(22), 0);
        button.addView(image, imageParams);

        TextView label = new TextView(this);
        label.setText(displayWord);
        label.setTextSize(40);
        label.setTypeface(Typeface.DEFAULT_BOLD);
        label.setTextColor(Color.rgb(15, 23, 42));
        label.setGravity(Gravity.CENTER_VERTICAL);
        button.addView(label, new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1f
        ));

        button.setOnClickListener(v -> {
            v.playSoundEffect(SoundEffectConstants.CLICK);
            v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
            say(displayWord, spokenPhrase);
        });

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
        );
        params.setMargins(0, 0, 0, dp(14));
        button.setLayoutParams(params);

        return button;
    }

    private void say(String displayWord, String spokenPhrase) {
        selectedText.setText(displayWord);
        helperText.setText("Speaking: " + spokenPhrase);

        if (!speechReady || textToSpeech == null) {
            Toast.makeText(this, "Speech is still loading. Tap again in a moment.", Toast.LENGTH_SHORT).show();
            return;
        }

        textToSpeech.speak(spokenPhrase, TextToSpeech.QUEUE_FLUSH, null, displayWord);
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int languageResult = textToSpeech.setLanguage(Locale.US);
            textToSpeech.setSpeechRate(0.85f);
            textToSpeech.setPitch(1.0f);
            speechReady = languageResult != TextToSpeech.LANG_MISSING_DATA
                    && languageResult != TextToSpeech.LANG_NOT_SUPPORTED;
        } else {
            speechReady = false;
        }
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }

    private int dp(int value) {
        return Math.round(value * getResources().getDisplayMetrics().density);
    }
}
