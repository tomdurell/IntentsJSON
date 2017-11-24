package tomdurel.intentstest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
// add below
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.AsyncTask;
import android.widget.*;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Music extends AppCompatActivity {
    // global variable to store returned xml data from service
    static String xml = "";

    // global variable to bitmap for current number 1 single (we aren't returning the other 39 songs!)
    static Bitmap bitmap;

    // array list to store song names from  service
    ArrayList<String> songs = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        // start the  AsyncTask for calling the REST service using httpConnect class
        new AsyncTaskParseXml().execute();
    }
    // added asynctask class methods below -  you can make this class as a separate class file
    public class AsyncTaskParseXml extends AsyncTask<String, String, String> {

        // set the url of the web service to call
        String yourXmlServiceUrl = "http://35.198.83.47/teaching/CMP3034M-1718/music.xml";

        @Override
        // this method is used for......................
        protected void onPreExecute() {}

        @Override
        // this method is used for...................
        protected String doInBackground(String... arg0)  {

            try {
                // create new instance of the httpConnect class
                httpConnect xmlParser = new httpConnect();

                // get xml string from service url
                xml = xmlParser.getJSONFromUrl(yourXmlServiceUrl);

            }
            catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        // below method will run when service HTTP request is complete
        protected void onPostExecute(String strFromDoInBg) {
            // bind the xml from service to the textview
            TextView tv1 = (TextView)findViewById(R.id.xmlText);
            tv1.setText(xml);
        }
    }
}
