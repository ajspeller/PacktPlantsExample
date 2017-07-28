package com.ajspeller.packtplantsexample.dao;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ny2va on 7/27/2017.
 */

public class NetworkDAO {
    public String fetch(String uri) throws IOException {

        // a string builder will accumulate a collection of strings.
        StringBuilder sb = new StringBuilder();

        // open the connection to this URL
        URL url = new URL(uri);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            // reading in data
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));

            // current line
            String inputLine;

            while ((inputLine = bin.readLine()) != null) {
                sb.append(inputLine);
            }
        } finally {
            urlConnection.disconnect();
        }

        return sb.toString();
    }
}
