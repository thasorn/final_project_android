package kmitl.project.afinal.thasorn58070047.mymind;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioButton radio4;
    private Button btnDisplay;
    private TextView question;
    private String[] quiz;
    private String[][] ans;
    private int num = 0;
    private int i = 0;
    private int size;
    private String check = "1";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = 0;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("whatQuiz");
            if(value.equals("1")){
                Context context = getApplicationContext();
                quiz = context.getResources().getStringArray(R.array.array_quiz1);
                size = context.getResources().getStringArray(R.array.array_quiz1).length;
                ans = new String[][]{{"ดีกว่าปกติ", "เหมือนปกติ", "น้อยกว่าปกติ", "น้อยกว่าปกติมาก"},
                        {"ไม่เลย", "ไม่มากกว่าปกติ", "ค่อนข้างมากกว่าปกติ", "มากกว่าปกติมาก"},
                        {"ดีกว่าปกติ", "เหมือนปกติ", "น้อยกว่าปกติ", "น้อยกว่าปกติมาก"},
                        {"ดีกว่าปกติ", "เหมือนปกติ", "น้อยกว่าปกติ", "น้อยกว่าปกติมาก"},
                        {"ไม่เลย", "ไม่มากกว่าปกติ", "ค่อนข้างมากกว่าปกติ", "มากกว่าปกติมาก"},
                        {"ไม่เลย", "ไม่มากกว่าปกติ", "ค่อนข้างมากกว่าปกติ", "มากกว่าปกติมาก"},
                        {"ดีกว่าปกติ", "เหมือนปกติ", "น้อยกว่าปกติ", "น้อยกว่าปกติมาก"},
                        {"ดีกว่าปกติ", "เหมือนปกติ", "น้อยกว่าปกติ", "น้อยกว่าปกติมาก"},
                        {"ไม่เลย", "ไม่มากกว่าปกติ", "ค่อนข้างมากกว่าปกติ", "มากกว่าปกติมาก"},
                        {"ไม่เลย", "ไม่มากกว่าปกติ", "ค่อนข้างมากกว่าปกติ", "มากกว่าปกติมาก"},
                        {"ไม่เลย", "ไม่มากกว่าปกติ", "ค่อนข้างมากกว่าปกติ", "มากกว่าปกติมาก"},
                        {"ดีกว่าปกติ", "เหมือนปกติ", "น้อยกว่าปกติ", "น้อยกว่าปกติมาก"}};
            }
            if(value.equals("2")){
                Context context = getApplicationContext();
                quiz = context.getResources().getStringArray(R.array.array_quiz2);
                size = context.getResources().getStringArray(R.array.array_quiz2).length;
                ans = new String[][]{{"เป็นบ่อยมาก", "ค่อนข้างบ่อย", "ไม่บ่อยนัก", "ไม่มีเลย"},
                        {"เหมือนเดิม", "ไม่เท่าแต่ก่อน", "มีน้อยมาก", "ไม่มีเลย"},
                        {"เป็นบ่อยมาก", "ค่อนข้างบ่อย", "ไม่บ่อยนัก", "ไม่มีเลย"},
                        {"เหมือนเดิม", "ไม่เท่าแต่ก่อน", "มีน้อยมาก", "ไม่มีเลย"},
                        {"เป็นบ่อยมาก", "ค่อนข้างบ่อย", "ไม่บ่อยนัก", "ไม่มีเลย"},
                        {"เหมือนเดิม", "ไม่เท่าแต่ก่อน", "มีน้อยมาก", "ไม่มีเลย"},
                        {"เป็นบ่อยมาก", "ค่อนข้างบ่อย", "ไม่บ่อยนัก", "ไม่มีเลย"},
                        {"เหมือนเดิม", "ไม่เท่าแต่ก่อน", "มีน้อยมาก", "ไม่มีเลย"},
                        {"เป็นบ่อยมาก", "ค่อนข้างบ่อย", "ไม่บ่อยนัก", "ไม่มีเลย"},
                        {"เหมือนเดิม", "ไม่เท่าแต่ก่อน", "มีน้อยมาก", "ไม่มีเลย"},
                        {"เป็นบ่อยมาก", "ค่อนข้างบ่อย", "ไม่บ่อยนัก", "ไม่มีเลย"},
                        {"เหมือนเดิม", "ไม่เท่าแต่ก่อน", "มีน้อยมาก", "ไม่มีเลย"},
                        {"เป็นบ่อยมาก", "ค่อนข้างบ่อย", "ไม่บ่อยนัก", "ไม่มีเลย"},
                        {"เหมือนเดิม", "ไม่เท่าแต่ก่อน", "มีน้อยมาก", "ไม่มีเลย"}};
            }
            if(value.equals("3")){
                Context context = getApplicationContext();
                quiz = context.getResources().getStringArray(R.array.array_quiz3);
                size = context.getResources().getStringArray(R.array.array_quiz3).length;
                ans = new String[][]{{"ท้อแท้ใจมาก หมดหวัง", "้ท้อแท้ใจ", "มองโลกแง่ร้าย", "ท้อแท้บ้างในบางครั้ง", "ไม่หมดหวัง"},
                                {"คิดวางแผนฆ่าตัวตาย", "คิดอยากตาย", "ชีวิตนี้ไม่น่าอยู่ คิดถึงเรื่องตายบ้าง", "ไม่ได้คิดถึงเรื่องความตาย"},
                                {"รู้สึกว่าตนเองเป็นคนไม่ดี ไม่มีค่า", "รู้สึกผิด คิดแต่เรื่องความผิดในอดีต", "รู้สึกตนเองเป็นคนไม่ดีบ่อยๆ", "ไม่รู้สึกผิดหรือคิดว่าตนเปป็นคนไม่ดี"},
                                {"อยู่เฉยๆ ไม่อยากทำอะไร", "คิดทำอะไรเชื่องช้าลงมาก", "คิดทำอะไรช้าลงเล็กน้อย", "คิดทำอะไรได้เหมือเดิม"},
                                {"งุ่นง่าน เดินไปมา อยู๋ไม่ติดที่บ่อยๆ", "กระสับกระส่าย อยู๋นิ่งไม่ค่อยได้", "ร้อนใจ กระวนกระวาย", "ไม่ร้อนใจหรือกระสับกระส่ายใดๆ"},
                                {"ซึมเศร้ามาก ร้องไห้บ่อย", "หดหู่ ทำให้สบายใจไม่ได้", "ซึมเซา ไม่แจ่มใสเหมือนเคย", "จิตใจสบายดี"},
                                {"คิดมาก กังวลกับทุกเรื่อง", "คิดมาก กังวลใจบ่อย", "คิดมาก กังวลใจง่ายกว่าแต่ก่อน", "ไม่วิตกกังวล"},
                                {"เบื่อไปหมดทุกอย่าง ไม่อยากทำอะไร", "รู้สึกเบื่อ ไม่มีความเพลินใจ", "เบื่อง่าย พอมีความเพลินใจบ้าง", "มีความสนใจเหมือนเดิม"},
                                {"หงุดหงินมาก ทะเลาะกัน ทำลายข้าวของ", "หงุดหงิด ฉุนเฉียว", "หงุดหงิดง่ายกว่าเดิม พอควบคุมได้", "ไม่มีอารมณ์หงุดหงิด"},
                                {"หลับยากทุกคืน ต้องใช้ยานอนหลับ", "หลับยากค่อนข้างบ่อย", "หลับยากบางครั้ง", "นอนหลับปกติดี"},
                                {"ตื่นกลางดึกแทบทุกคืน หลับไม่ได้เลย", "ตื่นค่อนข้างบ่อย หลับต่อยาก", "นอนหลับไม่สนิท กระสับกระส่าย", "หลับปกติดี"},
                                {"เบื่ออาหารมาก กินแทบไม่ได้", "เบื่ออาหาร แต่พอฝืนได้", "ไม่เจริญอาหารเหมือนเดิม", "กินอาหารได้ตามปกติ"},
                                {"เหนื่อหรืออ่อนเพลียมากจนทำอะไรไม่ได้", "เหนื่อหรืออ่อนเพลีย ทำอะไรก็เหนื่อยไปหมด", "เหนื่อย อ่อนเพลียง่าย", "ไม่มีอาการอ่อนเพลีย"},
                                {"ไม่สนใจทางเพศอีกเลย", "สานใจทางเพศลดลงมาก", "สนใจทางเพศลดลงบ้าง", "ความสนใจทางเพศเหมือนเดิม"},
                                {"ตัดสินใจอะไรไม่ได้เลย", "ลังเลใจ ตัดสินใจเรื่องเล็กๆน้อยๆไม่ได้", "ลังเลใจบ้าง ไม่อยากตัดสินใจ", "ไม่มีลังเลใจ"},
                                {"เชื่อว่าตัวเองมีโรคใทาง่างกาย", "กังวลใจ คิดว่าตนเองมีโรค", "ห่วงสุขภาพของตัวเองกว่าแต่ก่อน", "ไม่ค่อยกังวลโรคทางร่างกาย"},
                                {"ใจลอย ไม่มีสมาธิเลย", "ใจลอย สมาธิไม่ดี ต้องตั้งใจมาก หากจะทำอะไร", "ใจลอย สมาธิไม่ดีเท่าแต่ก่อน", "สมาธิปกติ"},
                                {"ทำงานไม่ได้เลย", "ทำงานแย่ลงมาก ต้องบังคับตัวเองเวลาทำงาน", "ต้องฝืนใจเวลาทำงานหรือเริ่มทำอะไรสักอย่าง", "ทำงานได้ตามปกติ"},
                                {"มีอาการใจสั่น ปวดศีรษะ มือชาบ่อยมาก", "มีอาการใจสั่น ปวดศีรษะ มือชาค่อนข้างบ่อย", "มีอาการใจสั่น ปวดศีรษะ มือชาบ้าง", "ไม่มีอาการใจสั่น ปวดศีรษะ มือชาเลย"},
                                {"ไม่สนใจอะไรเลย ใครจะเป็นอย่างไรก็ช่าง", "ไม่ค่อยสนใจใคร ไม่อยากพูดคุย", "สนใจคนรอบข้างน้อยลง", "สนใจต่อคนอื่นๆเหมือนเดิม"}};
            }
        }

        addListenerOnButton();

        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);

        question.setText(quiz[i]);
        radio1.setText(ans[i][0]);
        radio2.setText(ans[i][1]);
        radio3.setText(ans[i][2]);
        radio4.setText(ans[i][3]);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radio1:
                        check = "1";
                        break;
                    case R.id.radio2:
                        check = "2";
                        break;
                    case R.id.radio3:
                        check = "3";
                        break;
                    case R.id.radio4:
                        check = "4";
                        break;
                }
            }
        });
    }



    public void addListenerOnButton() {

        radio1 = (RadioButton) findViewById(R.id.radio1);
        radio2 = (RadioButton) findViewById(R.id.radio2);
        radio3 = (RadioButton) findViewById(R.id.radio3);
        radio4 = (RadioButton) findViewById(R.id.radio4);

        btnDisplay = (Button) findViewById(R.id.btnDisplay);

        question = (TextView) findViewById(R.id.question);

        question.setText(quiz[i]);

        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                if (check.equals("1")){
                    checkAns(check);
                    changeTextQuestion(question);
                }

                if (check.equals("2")){
                    checkAns(check);
                    changeTextQuestion(question);
                }

                if (check.equals("3")){
                    checkAns(check);
                    changeTextQuestion(question);
                }

                if (check.equals("4")){
                    checkAns(check);
                    changeTextQuestion(question);
                }

                Toast.makeText(MainActivity.this,
                       Integer.toString(num) , Toast.LENGTH_SHORT).show();

            }

        });

    }

    public void changeTextQuestion(View v){

        if (i>=size-1){
            btnDisplay.setVisibility(View.GONE);

            Intent s = new Intent(getBaseContext(), ResultActivity.class);
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                String value = extras.getString("whatQuiz");
                if (value.equals("1")) {
                    if(num > 2){
                        s.putExtra("result", "sick");
                    } else{
                        s.putExtra("result", "fine");
                    }
                }
                if (value.equals("2")) {
                    if(num > 22){
                        s.putExtra("result", "sick");
                    } else{
                        s.putExtra("result", "fine");
                    }
                }
                if (value.equals("3")) {
                    if(num > 35){
                        s.putExtra("result", "sick");
                    } else{
                        s.putExtra("result", "fine");
                    }
                }
            }
            s.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(s);
        } else {
            i++;
            question.setText(quiz[i]);
            radio1.setText(ans[i][0]);
            radio2.setText(ans[i][1]);
            radio3.setText(ans[i][2]);
            radio4.setText(ans[i][3]);

            Random rand = new Random();
            int  n = rand.nextInt(10) + 1;
            ImageView img= (ImageView) findViewById(R.id.happyPic);
            switch(n) {
                case 1:
                    img.setImageResource(R.drawable.nice1);
                    break;
                case 2:
                    img.setImageResource(R.drawable.nice2);
                    break;
                case 3:
                    img.setImageResource(R.drawable.nice3);
                    break;
                case 4:
                    img.setImageResource(R.drawable.nice4);
                    break;
                case 5:
                    img.setImageResource(R.drawable.nice5);
                    break;
                case 6:
                    img.setImageResource(R.drawable.nice6);
                    break;
                case 7:
                    img.setImageResource(R.drawable.nice7);
                    break;
                case 8:
                    img.setImageResource(R.drawable.nice8);
                    break;
                case 9:
                    img.setImageResource(R.drawable.nice9);
                    break;
                case 10:
                    img.setImageResource(R.drawable.nice10);
                    break;
            }
        }

    }

    public void checkAns(String check) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("whatQuiz");
            if (value.equals("1")) {
                switch(check){
                case "1": num += 0;
                    break;
                case "2": num += 0;
                    break;
                case "3": num += 1;
                    break;
                case "4": num += 1;
                    break;
                }
            }
            if (value.equals("2")) {
                if(i%2 != 0){
                    switch(check){
                        case "1": num += 0;
                            break;
                        case "2": num += 1;
                            break;
                        case "3": num += 2;
                            break;
                        case "4": num += 3;
                            break;
                    }
                }
                else if(i%2 == 0){
                    switch(check){
                        case "1": num += 3;
                            break;
                        case "2": num += 2;
                            break;
                        case "3": num += 1;
                            break;
                        case "4": num += 0;
                            break;
                    }
                }
            }
            if (value.equals("3")) {
                switch(check){
                    case "1": num += 3;
                        break;
                    case "2": num += 2;
                        break;
                    case "3": num += 1;
                        break;
                    case "4": num += 0;
                        break;
                }
            }
        }

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("ออกจากการทำแบบสอบถาม");
        builder.setMessage("คุณแน่ใจหรือไม่ว่าต้องการหยุดการทำแบบสอบถามและกลับไปยังหน้าเลือกแบบสอบถาม? คุณอาจสูญเสียกระบวนการที่ได้ทำมาทั้งหมดไป");

        builder.setPositiveButton("ใช่ (Y)", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(getApplicationContext(), ChooseActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);

                dialog.dismiss();
            }
        });

        builder.setNegativeButton("ไม่ (N)", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

}