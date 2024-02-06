package com.example.lab_2a_tip_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.lab_2a_tip_calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView output = binding.splitOutputLbl;
                double total = 0;
                double percent = 0;
                double people = 0;

                try {
                    if (!binding.totalInputLbl.getText().toString().isEmpty()) {
                        total = Double.parseDouble(binding.totalInputLbl.getText().toString());
                    }
                    if (!binding.percentInputLbl.getText().toString().isEmpty()) {
                        percent = Double.parseDouble(binding.percentInputLbl.getText().toString());
                    }
                    if (!binding.peopleInputLbl.getText().toString().isEmpty()) {
                        people = Double.parseDouble(binding.peopleInputLbl.getText().toString());
                    }
                } catch (NumberFormatException e) {
                    output.setText(R.string.InputError);
                }
                if ((total <= 0) || (percent <= 0) || (people <= 0)) {
                    output.setText(R.string.InputMissing);
                } else if ((total > 0) && (percent > 0) && (people > 0)) {
                    output.setText(
                            String.format("%.2f", (total + (total * (percent/100))) / people));
                } else {
                    output.setText(R.string.OutputError);
                }
            }
        });
    }
}