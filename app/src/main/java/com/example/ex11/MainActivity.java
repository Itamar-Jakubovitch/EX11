package com.example.ex11;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Itamar Jakubovitch ItamarJakubovitch@gmail.com
 * @version 1.0
 * @since 14/3/2026
 * A browser app
 */
public class MainActivity extends AppCompatActivity {
    WebView wV;
    Button btn;
    EditText eT;
    String stringUrl;

    /**
     * Runs when the app starts.
     * <p>
     *
     * @param savedInstanceState saved app data from before
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wV = (WebView) findViewById(R.id.wV);
        eT = (EditText) findViewById(R.id.eT);
        btn = (Button) findViewById(R.id.btn);

        wV.getSettings().setJavaScriptEnabled(true);
        wV.setWebViewClient(new MyWebViewClient());
    }

    /**
     * Opens the website the user typed.
     * <p>
     *
     * @param view the go button
     */
    public void clicked(View view) {
        stringUrl = eT.getText().toString();
        wV.loadUrl(stringUrl);
    }

    /**
     * Makes links open inside the app and not in Chrome.
     * <p>
     *
     */
    private class MyWebViewClient extends WebViewClient {

        /**
         * Opens the link inside the app.
         * <p>
         *
         * @param view the web browser inside the app
         * @param url the link to open
         * @return true so the app handles the link
         */
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}