package tomdurel.intentstest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;
public class userPermissions extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_permissions);
    }
    public void cameraPermissions(View view)
    {
        ActivityCompat.requestPermissions(userPermissions.this,
                new String[]{Manifest.permission.CAMERA},
                1);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the work!
                    // display short notification stating permission granted
                    Toast.makeText(userPermissions.this, "Permission granted to access to the Camera!", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(userPermissions.this, "Permission denied to access to the Camera!", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}
