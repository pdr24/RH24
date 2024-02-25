package edu.utsa.cs.acm.rh24.View;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.utsa.cs.acm.rh24.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pet = findViewById(R.id.pet);
        pet.setOnClickListener(this);
        //Button runner = findViewById(R.id.runner);
        //runner.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        Intent intent;

        int idOfButtonPressed = view.getId();
        if (idOfButtonPressed == R.id.pet) {
            intent = new Intent(this, FeedActivity.class);
            this.startActivity(intent);
        }


    }


}