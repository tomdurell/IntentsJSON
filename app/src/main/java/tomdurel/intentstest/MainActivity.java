package tomdurel.intentstest;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void userPermissionsIntent(View view)
    {

        // create an intent to start the activity called userPermissions
        Intent intent = new Intent(this, userPermissions.class);
        // run Permissions activity
        startActivity(intent);
    }

    public void cameraIntent(View view)
    {

        int REQUEST_IMAGE_CAPTURE = 1;
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    public void browserIntent(View view)
    {
        String url = "http://www.imdb.com/title/";
        String movieID = "tt0816692";
        Uri webpage = Uri.parse(url + movieID);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    public void eventIntent(View view)
    {
        Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
        Calendar beginTime = Calendar.getInstance();
        beginTime.set(2015, 12, 25, 00, 00);
        Calendar endTime = Calendar.getInstance();
        endTime.set(2015, 12, 25, 00, 01);
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
        calendarIntent.putExtra(CalendarContract.Events.TITLE, "Xmas!");
        calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "North Pole");
        startActivity(calendarIntent);
    }

    public void timerIntent(View view)
    {
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "timer started!")
                .putExtra(AlarmClock.EXTRA_LENGTH, 60)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, false);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    /** Called when the user selects the Tweets button */
    public void loadTweets(View view)
    {

        // create to intent to start Tweets activity
        Intent intent = new Intent(this, Tweets.class);
        startActivity(intent);
    }
    public void getMusicData(View view)
    {

        // create an intent to start the activity called userPermissions
        Intent intent = new Intent(this, Music.class);
        // run Permissions activity
        startActivity(intent);
    }

}
