package com.tengfeizhao.schemeapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String toastInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        System.out.println("scheme:" + intent.getScheme());
        Uri uri = intent.getData();
        if (uri != null) {
            System.out.println("uri.scheme: " + uri.getScheme());
            System.out.println("uri.host: " + uri.getHost());
            System.out.println("uri.port: " + uri.getPort());
            System.out.println("uri.path: " + uri.getPath());
            System.out.println("uri.queryString: " + uri.getQuery());
            System.out.println("uri.queryParameter: " + uri.getQueryParameter("key"));
            toastInfo = "get info  scheme:" + uri.getScheme() + "  host:" + uri.getHost() + "  port:" + uri.getPort() + "  path:" + uri.getPath() + "  queryString:" + uri.getQuery();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!TextUtils.isEmpty(toastInfo)) {
            Toast.makeText(this, toastInfo, Toast.LENGTH_SHORT).show();
            toastInfo = null;
        }
    }
}
