package com.word.word;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.word.word.R;

public class WebViewFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        WebView webView = (WebView) root.findViewById(R.id.web_view);
        webView.loadDataWithBaseURL(null, "<html><head><title> WebView </title></head>" +
                    "<body><h2>HELLO！！！WEBVIEW！</h2></body></html>", "text/html", "utf-8", null);
        return root;
    }
}
