package edu.utsa.cs.acm.rh24.Controller;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import edu.utsa.cs.acm.rh24.Model.Pet;
import edu.utsa.cs.acm.rh24.R;
import edu.utsa.cs.acm.rh24.View.FeedActivity;

public class FeedController implements View.OnClickListener {
    public FeedActivity activity;
    public Pet dinosaur;

    public ImageView plant1;
    public ImageView plant2;
    public ImageView plant3;


    public FeedController(FeedActivity feedActivity) {
        this.activity = feedActivity;
        this.dinosaur = new Pet();

        this.plant1 = feedActivity.findViewById(R.id.plant1);
        this.plant2 = feedActivity.findViewById(R.id.plant2);
        this.plant3 = feedActivity.findViewById(R.id.plant3);

        this.plant1.setOnClickListener(this);
        this.plant2.setOnClickListener(this);
        this.plant3.setOnClickListener(this);
    }

    public void playFeedingGame() {

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                // Update the variable here

                dinosaur.setHealth(dinosaur.getHealth() - 1);
                TextView hungerTextView = activity.findViewById(R.id.health);

                // Update UI in the UI thread
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Update TextView with the updated variable value
                        showPlant();
                        hungerTextView.setText("Hunger: " + dinosaur.getHealth());
                        updateHealthBar(dinosaur.getHealth());
                        if (dinosaur.getHealth() <= 0) {
                            extinction();
                            timer.cancel();

                        }

                    }
                });




            }

        };



            // Schedule the TimerTask to run every 2 seconds (2000 milliseconds)
            timer.schedule(timerTask, 0, 150);


    }

    public void extinction() {
        ImageView dinosaurImage = activity.findViewById(R.id.dinosaurView);
        dinosaurImage.setImageResource(R.drawable.skeleton2);
    }

    public void updateHealthBar(int health) {
        ImageView healthBar = activity.findViewById(R.id.healthBar);

        if (dinosaur.getHealth() >= 100) {
            healthBar.setImageResource(R.drawable.eight);
        } else if (dinosaur.getHealth() >= 90) {
            healthBar.setImageResource(R.drawable.seven);
        } else if (dinosaur.getHealth() >= 80) {
            healthBar.setImageResource(R.drawable.six);
        } else if (dinosaur.getHealth() >= 70) {
            healthBar.setImageResource(R.drawable.five);
        } else if (dinosaur.getHealth() >= 60) {
            healthBar.setImageResource(R.drawable.four);
        } else if (dinosaur.getHealth() >= 40) {
            healthBar.setImageResource(R.drawable.three);
        } else if (dinosaur.getHealth() >= 15) {
            healthBar.setImageResource(R.drawable.two);
        } else if (dinosaur.getHealth() <= 0) {
            healthBar.setImageResource(R.drawable.zero);
        }
    }


    @Override
    public void onClick(View v) {
        int idOfButtonPressed = v.getId();
        ImageView button = activity.findViewById(idOfButtonPressed);
        button.setClickable(false);

        dinosaur.setHealth(dinosaur.getHealth() + 5);
        TextView hungerTextView = activity.findViewById(R.id.health);
        hungerTextView.setText("Hunger: " + dinosaur.getHealth());


    }

    public void showPlant() {
        ImageView plant1 = activity.findViewById(R.id.plant1);
        ImageView plant2 = activity.findViewById(R.id.plant2);
        ImageView plant3 = activity.findViewById(R.id.plant3);

        plant1.setVisibility(View.INVISIBLE);
        plant2.setVisibility(View.INVISIBLE);
        plant3.setVisibility(View.INVISIBLE);

        plant1.setClickable(false);
        plant2.setClickable(false);
        plant3.setClickable(false);

        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int = rand.nextInt(3);

        if (rand_int == 0) {
            plant1.setVisibility(View.VISIBLE);
            plant1.setClickable(true);

        }else if (rand_int == 1) {
            plant2.setVisibility(View.VISIBLE);
            plant2.setClickable(true);
        }
        else {
            plant3.setVisibility(View.VISIBLE);
            plant3.setClickable(true);
        }
        // Print random integers
        //System.out.println("Random Integers: "+rand_int1);
    }
}


