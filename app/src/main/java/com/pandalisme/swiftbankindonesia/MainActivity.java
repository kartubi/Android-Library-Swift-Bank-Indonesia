package com.pandalisme.swiftbankindonesia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pandalisme.swiftbankindonesia2.Banklist;

public class MainActivity extends AppCompatActivity {

    private static int REQUEST_CODE_BANK = 145;
    Button btSubmit;
    TextView tvName, tvCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSubmit = findViewById(R.id.btSubmit);
        tvName = findViewById(R.id.tvName);
        tvCode = findViewById(R.id.tvCode);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bankList();
            }
        });
    }

    private void bankList() {
        Intent i = new Intent(getApplicationContext(), Banklist.class);
        startActivityForResult(i, REQUEST_CODE_BANK);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_BANK) {
            if (resultCode == RESULT_OK) {
                Log.d("TAG", data.getStringExtra("name"));
                Log.d("TAG", data.getStringExtra("code"));

                setData(data.getStringExtra("name"), data.getStringExtra("code"));
            }
        }
    }

    private void setData(String mName,String mCode) {
        mName = "Bank Name : " + mName;
        mCode = "Bank Code : " + mCode;
        tvName.setText(mName);
        tvCode.setText(mCode);
    }


}
