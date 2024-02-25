package edu.utsa.cs.acm.rh24.Controller;

import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import edu.utsa.cs.acm.rh24.Model.Pet;
import edu.utsa.cs.acm.rh24.R;
import edu.utsa.cs.acm.rh24.View.FeedActivity;

public class FeedController {
    public FeedActivity activity;
    public Pet dinosaur;

    public FeedController(FeedActivity feedActivity) {
        this.activity = feedActivity;
        this.dinosaur = new Pet();
    }

    public void playFeedingGame() {

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                // Update the variable here
                dinosaur.setEnergy(dinosaur.getEnergy() - 1);
                TextView hungerTextView = activity.findViewById(R.id.contraintLayout);

                // Update UI in the UI thread
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Update TextView with the updated variable value
                        hungerTextView.setText("Hunger: " + dinosaur.getEnergy());
                    }
                });


            }

        };

        // Schedule the TimerTask to run every 2 seconds (2000 milliseconds)
        timer.schedule(timerTask, 0, 2000);
    }

}


