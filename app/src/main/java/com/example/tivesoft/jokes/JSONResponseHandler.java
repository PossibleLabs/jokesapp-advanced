package com.example.tivesoft.jokes;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.impl.client.BasicResponseHandler;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;

/**
 * Created by Griss Garcia on 16/07/2015.
 */
public class JSONResponseHandler implements ResponseHandler<String> {

    private static final String URL = "url";

    @Override
    public String handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
        String result = "";
        String JSONResponse = new BasicResponseHandler().handleResponse(httpResponse);
        try {
            JSONObject responseObject = (JSONObject) new JSONTokener(JSONResponse).nextValue();
            result = responseObject.getJSONObject("value").getString("joke");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}
