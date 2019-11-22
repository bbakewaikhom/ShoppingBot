package com.crown.shoppingbot.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.crown.shoppingbot.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ControlPanelActivity extends AppCompatActivity {

    @BindView(R.id.btn_acp_stop)
    Button mBtnAcpStop;
    @BindView(R.id.btn_acp_resume)
    Button mBtnAcpResume;
    @BindView(R.id.btn_acp_next)
    Button mBtnAcpNext;
    @BindView(R.id.btn_acp_add_item)
    Button mBtnAcpAddItem;
    @BindView(R.id.btn_acp_billing)
    Button mBtnAcpBilling;
    @BindView(R.id.btn_acp_abort)
    Button mBtnAcpAbort;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_panel);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @butterknife.OnClick({R.id.btn_acp_stop, R.id.btn_acp_resume, R.id.btn_acp_next, R.id.btn_acp_add_item, R.id.btn_acp_billing, R.id.btn_acp_abort})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_acp_stop: {
                // TODO: button click on stop button
                Toast.makeText(getApplicationContext(), "stop", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_acp_resume: {
                // TODO: button click on resume button
                Toast.makeText(getApplicationContext(), "resume", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_acp_next: {
                // TODO: button click on next button
                Toast.makeText(getApplicationContext(), "next", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_acp_add_item: {
                // TODO: button click on add item button
                Toast.makeText(getApplicationContext(), "add item", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_acp_billing: {
                // TODO: button click on billing button
                Toast.makeText(getApplicationContext(), "billing", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_acp_abort: {
                // TODO: button click on abort button
                Toast.makeText(getApplicationContext(), "abort", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
