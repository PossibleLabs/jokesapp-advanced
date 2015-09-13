package com.example.tivesoft.jokes;

import android.app.Activity;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;

/**
 * Created by tivesoft on 9/12/15.
 */
public class ChuckNorrisActivity extends Activity {

    private TextView jokeText;
    private String joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_activity);
        jokeText = (TextView) findViewById(R.id.txtJokeCotainer);
        new httpGetJoke().execute();
    }

    private class httpGetJoke extends AsyncTask<Void, Void ,String>{
        private  static  final String URL = "http://api.icndb.com/jokes/random";
        AndroidHttpClient client = AndroidHttpClient.newInstance("");

        @Override
        protected String doInBackground(Void... voids) {
            HttpGet request = new HttpGet(URL);
            JSONResponseHandler responseHandler = new JSONResponseHandler();
            try {
                return client.execute(request, responseHandler);
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            if (null != client) {
                client.close();
            }

            jokeText.setText(result);
            joke=result;
        }
    }
    public void speechJoke(View view){
        MyAplicacion.speakOut(joke);
    }
}
