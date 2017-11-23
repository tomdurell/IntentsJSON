package tomdurel.intentstest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
// add below
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.AsyncTask;
import java.util.ArrayList;
import android.widget.*;
import java.util.Date;
import android.util.Log;
public class Tweets extends AppCompatActivity
{
    // array list to store tweet items from web service
    ArrayList<String> items = new ArrayList<String>();
    // json test string
    String jsonTest;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweets);
        // start the  AsyncTask for calling the REST service using httpConnect class
        new AsyncTaskParseJson().execute();
    }
    // added asynctask class methods below -  you can make this class as a separate class file
    public class AsyncTaskParseJson extends AsyncTask<String, String, String>
    {

        // set the url of the web service to call
        String yourServiceUrl = "http://35.198.83.47/tweet/tweetledee/userjson.php?user=shaunlawson&c=10";

        @Override
        // this method is used for......................
        protected void onPreExecute() {}

        @Override
        // this method is used for...................
        protected String doInBackground(String... arg0)  {

            try {
                // create new instance of the httpConnect class
                httpConnect jParser = new httpConnect();

                // get json string from service url
                String json = jParser.getJSONFromUrl(yourServiceUrl);

                // save returned json to your test string
                jsonTest = json.toString();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        // below method will run when service HTTP request is complete, will then bind tweet text in arrayList to ListView
        protected void onPostExecute(String strFromDoInBg) {
            TextView tv1 = (TextView)findViewById(R.id.jsonText);
            tv1.setText(jsonTest);
        }
    }

}
