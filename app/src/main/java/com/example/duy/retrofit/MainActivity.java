package com.example.duy.retrofit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duy.retrofit.RESTAPI.Gitservice;
import com.example.duy.retrofit.RESTAPI.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.ArrayList;

import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final String BASE_URL = "https://api.github.com/";
    private TextView textView;
    private ProgressDialog dialog;
    Data data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new ProgressDialog(this);
        findViewById(R.id.id_bt).setOnClickListener(this);
        textView = (TextView)findViewById(R.id.id_text);
    }

    @Override
    public void onClick(View v) {


        dialog.show();
        // khoi tao service
        Gitservice gitservice = ServiceGenerator.createService(Gitservice.class);
        //gan ten cho user interface goi tu getdata
        Log.e(null, "savedInstanceState is null");
        gitservice.getDataCall("2").enqueue(new Callback<data2>()
        {
            @Override
            public void onResponse(Call<data2> call, Response<data2> response) {
                if(response!=null)
                {
                    data = response.body().getData();
                    textView.setText(data.getFirstName());
                }
                dialog.dismiss();
            }
            @Override
            public void onFailure(Call<data2> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

    }
}
