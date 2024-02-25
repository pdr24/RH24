package edu.utsa.cs.acm.rh24.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs.acm.rh24.Controller.PetController;
import edu.utsa.cs.acm.rh24.R;

public class PetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_activity);
        Button feed = this.findViewById(R.id.feed);
        Button walk = this.findViewById(R.id.walk);
        Button game = this.findViewById(R.id.game);

        PetController controller = new PetController(this, walk, feed, game);

    }



}
