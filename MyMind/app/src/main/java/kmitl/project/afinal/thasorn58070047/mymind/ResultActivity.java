package kmitl.project.afinal.thasorn58070047.mymind;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import java.io.ByteArrayOutputStream;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle extras = getIntent().getExtras();
        String value = extras.getString("result");
        Toast.makeText(ResultActivity.this,
                value, Toast.LENGTH_SHORT).show();
        result(value);
    }

    public void result(String value){
        if (value.equals("sick")){
            TextView head_result = (TextView)findViewById(R.id.head_result);
            head_result.setText(getResources().getString(R.string.head_result_sick));
            head_result.setTextColor(Color.parseColor("#FF1919"));

            TextView des_result = (TextView)findViewById(R.id.des_result);
            des_result.setText(getResources().getString(R.string.des_result_sick));

            ImageView img= (ImageView) findViewById(R.id.image);
            img.setImageResource(R.drawable.stress);
        }
        if (value.equals("fine")){
            TextView head_result = (TextView)findViewById(R.id.head_result);
            head_result.setText(getResources().getString(R.string.head_result_fine));
            head_result.setTextColor(Color.parseColor("#198CFF"));

            TextView des_result = (TextView)findViewById(R.id.des_result);
            des_result.setText(getResources().getString(R.string.des_result_fine));

            ImageView img= (ImageView) findViewById(R.id.image);
            img.setImageResource(R.drawable.happy);
        }
    }

    public void shareFacebook(View v){
        Toast.makeText(ResultActivity.this,
                "YES SHARE" , Toast.LENGTH_SHORT).show();

        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        else
            connected = false;
        if(connected == false){
            Toast.makeText(ResultActivity.this,
                    "Require internet connection" , Toast.LENGTH_SHORT).show();
        } else{
            Bundle extras = getIntent().getExtras();
            String value = extras.getString("result");
            if (value.equals("sick")){
                ShareLinkContent shareLinkContent = new ShareLinkContent.Builder()
                        .setContentUrl(Uri.parse("https://www.dmh.go.th/"))
                        .setQuote(getString(R.string.des_result_sick))
                        .build();

                ShareDialog.show(ResultActivity.this,shareLinkContent);
            }
            if (value.equals("fine")){
                ShareLinkContent shareLinkContent = new ShareLinkContent.Builder()
                        .setContentUrl(Uri.parse("https://www.dmh.go.th/"))
                        .setQuote(getString(R.string.des_result_fine))
                        .build();

                ShareDialog.show(ResultActivity.this,shareLinkContent);
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), ChooseActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        super.onBackPressed();
    }
}
