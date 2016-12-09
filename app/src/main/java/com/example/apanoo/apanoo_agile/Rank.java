package com.example.apanoo.apanoo_agile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Peter on 9/12/2016.
 */

public class Rank extends AppCompatActivity {
    private DatabaseHelper helper = new DatabaseHelper(this);
    private TextView Mathlist;
    private TextView Englist;
    private Users user;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rank);
        user = (Users) getIntent().getParcelableExtra("Users");
        Mathlist=(TextView)findViewById(R.id.Mathlist);
        Englist=(TextView)findViewById(R.id.Englist);
        helper.GetEngRank(Englist,user.getUname());
        helper.GetMathRank(Mathlist,user.getUname());
    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent it = new Intent(Rank.this, welcome.class);
        it.putExtra("Users", user);
        finish();
        startActivity(it);
    }
}
