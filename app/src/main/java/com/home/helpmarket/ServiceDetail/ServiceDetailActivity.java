package com.home.helpmarket.ServiceDetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.home.helpmarket.Enroll.EnrollActivity;
import com.home.helpmarket.R;

public class ServiceDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_detail);
    }

    public void onClickChon(View view) {
        startActivity(new Intent(ServiceDetailActivity.this, EnrollActivity.class));
    }
}
