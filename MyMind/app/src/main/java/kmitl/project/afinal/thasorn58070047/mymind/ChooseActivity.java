package kmitl.project.afinal.thasorn58070047.mymind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;

public class ChooseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        //Show toast welcome
        Toast.makeText(ChooseActivity.this,
                "ยินดีต้อนรับสู่ MyMind!", Toast.LENGTH_SHORT).show();
    }

    public void quiz1(View v){
        //Show toast quiz 1
        Toast.makeText(ChooseActivity.this,
                "แบบประเมินภาวะสุขภาพจิต General Health Questionnaire (GHQ)", Toast.LENGTH_SHORT).show();

        //go to page quiz 1
        Intent i = new Intent(getBaseContext(), MainActivity.class);
        i.putExtra("whatQuiz","1");
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    public void quiz2(View v){
        //Show toast quiz 2
        Toast.makeText(ChooseActivity.this,
                "แบบคัดกรองปัญหาอาการวิตกกังวลและซึมเศร้า Hospital Anxiety and Depression Scale questionnaire (HADS)", Toast.LENGTH_SHORT).show();

        //go to page quiz 2
        Intent i = new Intent(getBaseContext(), MainActivity.class);
        i.putExtra("whatQuiz","2");
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    public void quiz3(View v){
        //Show toast quiz 3
        Toast.makeText(ChooseActivity.this,
                "แบบประเมินภาวะซึมเศร้า Thai Depression Inventory questionnaire", Toast.LENGTH_SHORT).show();

        //go to page quiz 3
        Intent i = new Intent(getBaseContext(), MainActivity.class);
        i.putExtra("whatQuiz","3");
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    public void logout(View v){
        //Show toast logout
        Toast.makeText(ChooseActivity.this,
                "ออกจากระบบ! ขอให้วันนี้เป็นวันที่ดี!", Toast.LENGTH_SHORT).show();

        //end session and go to login page
        Intent i = new Intent(getBaseContext(), LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        if(AccessToken.getCurrentAccessToken() != null) {
            LoginManager.getInstance().logOut();
        }
        startActivity(i);
    }

}
