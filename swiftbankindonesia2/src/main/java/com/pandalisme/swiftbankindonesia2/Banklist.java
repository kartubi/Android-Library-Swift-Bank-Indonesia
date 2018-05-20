package com.pandalisme.swiftbankindonesia2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Banklist extends AppCompatActivity {

    public Button button;
    public RecyclerView mRecyclerView;
    public Adapter mAdapter;
    public List<Bank> banks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banklist);

        mRecyclerView = findViewById(R.id.recyclerView);
        mAdapter = new Adapter(banks, getApplicationContext(), this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        loadData();

    }

    public void setDataReturn(String mName, String mCode){
        Intent data = new Intent();
        data.putExtra("name",mName);
        data.putExtra("code", mCode);
        setResult(RESULT_OK, data);
        finish();
    }

    private void loadData() {
        Bank bank;

        String myJson=inputStreamToString(getApplicationContext().getResources().openRawResource(R.raw.bank));

        Log.d("TAG", myJson);

        try {
            JSONArray array = new JSONArray(myJson);
            for (int i = 0; i<array.length();i++){
                JSONObject object = array.getJSONObject(i);
                Log.d("TAG", object.getString("name"));
                bank = new Bank(object.getString("id"), object.getString("name"), object.getString("code"));
                banks.add(bank);
            }
            mAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String inputStreamToString(InputStream inputStream) {
        try {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, bytes.length);
            String json = new String(bytes);
            return json;
        } catch (IOException e) {
            return null;
        }
    }



}
