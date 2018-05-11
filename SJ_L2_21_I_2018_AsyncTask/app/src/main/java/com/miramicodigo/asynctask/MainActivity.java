package com.miramicodigo.asynctask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog dialog;
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tvResultado);
        dialog = new ProgressDialog(this);
    }

    public void onClick(View view) {
        DownloadWebPageTask task = new DownloadWebPageTask();
        task.execute(new String[]
                {"http://www.instagram.com",
                "http://www.google.com",
                "http://www.bolivia.com"});
    }

    public void toast(View v) {
        Toast.makeText(
                getApplicationContext(),
                "Muestra Toast",
                Toast.LENGTH_SHORT).show();
    }

    private class DownloadWebPageTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.setMessage("Descargando codigo fuente");
            dialog.setCancelable(true);
            dialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            String response = "";
            for(String url : strings) {
                DefaultHttpClient client = new DefaultHttpClient();
                HttpGet httpGet = new HttpGet(url);
                try{
                    HttpResponse execute = client.execute(httpGet);
                    InputStream content = execute.getEntity().getContent();
                    BufferedReader buffer = new BufferedReader(
                            new InputStreamReader(content)
                    );
                    String res = "";
                    while ((res = buffer.readLine()) != null){
                        response += res;
                    }
                }catch(Exception e) {

                }
            }
            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(dialog.isShowing()) {
                dialog.dismiss();
            }
            textView.setText(s);

        }
    }

}
