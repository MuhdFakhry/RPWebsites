package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class website_activity extends AppCompatActivity {

    WebView wvPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.website_page);

        wvPage = findViewById(R.id.webViewDisplay);
        wvPage.setWebViewClient(new WebViewClient());

        Intent intentReceived = getIntent();

        String website = intentReceived.getStringExtra("webpage");
        wvPage.getSettings().setBuiltInZoomControls(true);
        wvPage.loadUrl(website);
    }
}
