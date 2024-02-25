package edu.utsa.cs.acm.rh24.Controller;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import edu.utsa.cs.acm.rh24.View.FeedActivity;
import edu.utsa.cs.acm.rh24.View.PetActivity;

public class PetController implements View.OnClickListener {
    public PetActivity activity;
    public Button walk;
    public Button feed;
    public Button game;

    public PetController (PetActivity petActivity, Button walkButton, Button feedButton, Button gameButton) {
        // contructor for pet controller
        this.activity = petActivity;
        this.walk = walkButton;
        this.feed = feedButton;
        this.game = gameButton;

        this.walk.setOnClickListener(this);
        this.feed.setOnClickListener(this);
        this.game.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int idOfButtonPressed = v.getId();

        Intent intent;
        if (idOfButtonPressed == this.walk.getId()) {
            System.out.println("\n\n WALK button pressed\n");
            //intent = new Intent(this, WalkActivity.class);

        } else if (idOfButtonPressed == this.feed.getId()) {
            System.out.println("\n\n FEED button pressed\n");
            intent = new Intent(this.activity, FeedActivity.class);
            this.activity.startActivity( intent );
        }
        else if (idOfButtonPressed == this.game.getId()) {
            System.out.println("\n\n GAME button pressed\n");
        }
        else {
            System.out.println("\n\n not feed, walk, or game pressed \n\n");
        }
    }
}
