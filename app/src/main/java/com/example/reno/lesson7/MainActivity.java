package com.example.reno.lesson7;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends Activity implements View.OnClickListener

{

    LinearLayout titleLayout;
    LinearLayout choice1Layout;
    LinearLayout choice2Layout;
    LinearLayout choice3Layout;
    LinearLayout choice4Layout;

    @Override
    public void onCreate(Bundle savedData)
    {
        super.onCreate(savedData);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        LinearLayout outerLayout = new LinearLayout(this);
        outerLayout.setOrientation(LinearLayout.VERTICAL);
        outerLayout.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);
        LinearLayout.LayoutParams outerLayout1Params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        outerLayout.setLayoutParams(outerLayout1Params);

        LinearLayout.LayoutParams choiceParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        titleLayout = new LinearLayout(this);
        titleLayout.setOrientation(LinearLayout.VERTICAL);
        titleLayout.setGravity(Gravity.CENTER);
        titleLayout.setLayoutParams(choiceParams);
        titleLayout.setBackgroundColor(Color.WHITE);

        TextView titleTV = new TextView(this);
        titleTV.setGravity(Gravity.CENTER);
        titleTV.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
        titleTV.setTextColor(Color.BLACK);
        titleTV.setText("Dani");
        titleTV.setPadding(50, 25, 25, 90);

        choice1Layout = new LinearLayout(this);
        choice1Layout.setOrientation(LinearLayout.VERTICAL);
        choice1Layout.setGravity(Gravity.CENTER);
        choice1Layout.setLayoutParams(choiceParams);
        choice1Layout.setBackgroundColor(Color.BLUE);
        choice1Layout.setOnClickListener(this);

        TextView choice1TV = new TextView(this);
        choice1TV.setGravity(Gravity.CENTER);
        choice1TV.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
        choice1TV.setTextColor(Color.WHITE);
        //choice1TV.setText("Choice 1");
        choice1TV.setText("link to develpoer android ");
        choice1TV.setPadding(10, 25, 25, 50);

        choice2Layout = new LinearLayout(this);
        choice2Layout.setOrientation(LinearLayout.VERTICAL);
        choice2Layout.setGravity(Gravity.CENTER);
        choice2Layout.setLayoutParams(choiceParams);
        choice2Layout.setBackgroundColor(Color.GREEN);
        choice2Layout.setOnClickListener(this);

        TextView choice2TV = new TextView(this);
        choice2TV.setGravity(Gravity.CENTER);
        choice2TV.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
        choice2TV.setTextColor(Color.WHITE);
        choice2TV.setText("takes you to my lesson5");
        choice2TV.setPadding(10, 25, 25, 50);

        choice3Layout = new LinearLayout(this);
        choice3Layout.setOrientation(LinearLayout.VERTICAL);
        choice3Layout.setGravity(Gravity.CENTER);
        choice3Layout.setLayoutParams(choiceParams);
        choice3Layout.setBackgroundColor(Color.MAGENTA);
        choice3Layout.setOnClickListener(this);

        TextView choice3TV = new TextView(this);
        choice3TV.setGravity(Gravity.CENTER);
        choice3TV.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
        choice3TV.setTextColor(Color.WHITE);
        choice3TV.setText("check my linkid in profile");
        choice3TV.setPadding(10, 25, 25, 50);

        choice4Layout = new LinearLayout(this);
        choice4Layout.setOrientation(LinearLayout.VERTICAL);
        choice4Layout.setGravity(Gravity.CENTER);
        choice4Layout.setLayoutParams(choiceParams);
        choice4Layout.setBackgroundColor(Color.BLUE);
        choice4Layout.setOnClickListener(this);

        TextView choice4TV = new TextView(this);
        choice4TV.setGravity(Gravity.CENTER);
        choice4TV.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
        choice4TV.setTextColor(Color.WHITE);
        choice4TV.setText("Set Alarm");
        choice4TV.setPadding(10, 25, 25, 50);

        titleLayout.addView(titleTV);
        choice1Layout.addView(choice1TV);
        choice2Layout.addView(choice2TV);
        choice3Layout.addView(choice3TV);
        choice4Layout.addView(choice4TV);
       choice4Layout.setOnClickListener(this);

        outerLayout.addView(titleLayout);
        outerLayout.addView(choice1Layout);
        outerLayout.addView(choice2Layout);
        outerLayout.addView(choice3Layout);
        outerLayout.addView(choice4Layout);

        setContentView(outerLayout);
    }

    @Override
    public void onClick(View touchedObject)
    {
        if(touchedObject == choice1Layout)
        {
            Uri myUri = Uri.parse("http://developer.android.com/about/dashboards/index.html");
            Intent LaunchTheBrowser = new Intent(Intent.ACTION_VIEW, myUri);
            startActivity(LaunchTheBrowser);
        }
        else if(touchedObject == choice2Layout)
        {
            Intent secondIntent = new Intent("android.intent.action.MAIN");
            secondIntent.setComponent(ComponentName.unflattenFromString(
                    "com.example.reno.lesson5/com.example.reno.lesson5.MainActivity"));//u can put what ever u like to link a project
            secondIntent.addCategory("android.intent.category.LAUNCHER");
            startActivity(secondIntent);
        }
        else if(touchedObject == choice3Layout)
        {
            Uri myUri = Uri.parse("https://www.linkedin.com/in/danielabrham10");
            Intent LaunchTheBrowser = new Intent(Intent.ACTION_VIEW, myUri);
            startActivity(LaunchTheBrowser);

        }
        else if(touchedObject == choice4Layout)
        {
            long millis=System.currentTimeMillis();
            Calendar c=Calendar.getInstance();
            c.setTimeInMillis(millis);
            int hours=c.get(Calendar.HOUR);
            int minutes=c.get(Calendar.MINUTE);
            int am_pm=c.get(Calendar.AM_PM);

            minutes = minutes + 2;
            if (minutes > 59)
            {
                minutes = 0;
                hours++;
            }
            if (hours > 12) hours = 0;
            if (am_pm > 0) hours += 12;

            Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, "Time to do some awesome coding! :)")
                    .putExtra(AlarmClock.EXTRA_HOUR, hours)
                    .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
            if (intent.resolveActivity(getPackageManager()) != null)
            {
                startActivity(intent);
            }
        }
    }

}
