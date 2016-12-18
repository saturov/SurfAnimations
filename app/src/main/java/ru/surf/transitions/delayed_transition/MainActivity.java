package ru.surf.transitions.delayed_transition;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import ru.surf.transitions.R;
import ru.surf.transitions.delayed_transition.data.TransitionType;
import ru.surf.transitions.delayed_transition.list.TransitionSpinnerAdapter;

import static android.transition.TransitionManager.beginDelayedTransition;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout container;
    private Spinner transitionSpinner;
    private View redView;
    private View greenView;
    private View blueView;
    private View blackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (RelativeLayout) findViewById(R.id.activity_main);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    beginDelayedTransition(container, new Explode());
                }
                toggleVisibility(redView, greenView, blueView, blackView);
            }
        });

        transitionSpinner = (Spinner) findViewById(R.id.delayed_transition_animator_spinner);
        transitionSpinner.setAdapter(new TransitionSpinnerAdapter(this, TransitionType.values()));

        redView = findViewById(R.id.red_view);
        greenView = findViewById(R.id.green_view);
        blueView = findViewById(R.id.blue_view);
        blackView = findViewById(R.id.black_view);
    }

    private void toggleVisibility(View... views) {
        for (View view : views) {
            boolean isVisible = view.getVisibility() == View.VISIBLE;
            view.setVisibility(isVisible ? View.INVISIBLE : View.VISIBLE);
        }
    }
}