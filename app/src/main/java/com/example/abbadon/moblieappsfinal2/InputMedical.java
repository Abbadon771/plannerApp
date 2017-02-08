package com.example.abbadon.moblieappsfinal2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Abbadon on 12/12/2016.
 */

public class InputMedical extends AppCompatActivity {
    EditText Day;
    EditText Month;
    EditText Time;
    EditText Title;
    EditText Profession;
    EditText Reason;
    Button Finish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medical);

        Day = (EditText) findViewById(R.id.mday);
        Month = (EditText) findViewById(R.id.mMonth);
        Time = (EditText) findViewById(R.id.mtime);
        Title = (EditText) findViewById(R.id.mtitle);
        Profession = (EditText) findViewById(R.id.mprofession);
        Reason = (EditText) findViewById(R.id.mdescription);
        Finish = (Button) findViewById(R.id.finishButton);

        Finish.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String mday = Day.getText().toString();
                String mmonth = Month.getText().toString();
                String mtime = Time.getText().toString();
                String mtitle = Title.getText().toString();
                String mprofession = Profession.getText().toString();
                String mreason = Reason.getText().toString();
                Intent mdata = new Intent();
                mdata.putExtra("Mtitle", mtitle);
                mdata.putExtra("Mday", mday);
                mdata.putExtra("Mmonth", mmonth);
                mdata.putExtra("Mtime", mtime);
                mdata.putExtra("Mprofession", mprofession);
                mdata.putExtra("Mreason", mreason);

                setResult(Activity.RESULT_OK, mdata);

                finish();

            }
        });
    }
}