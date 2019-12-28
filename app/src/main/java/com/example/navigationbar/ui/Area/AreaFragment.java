package com.example.navigationbar.ui.Area;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.navigationbar.R;

public class AreaFragment extends Fragment {

    private AreaViewModel areaViewModel;
    EditText etRadius;
    Button btnCalculate;
    TextView tvResult;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        areaViewModel =
                ViewModelProviders.of(this).get(AreaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_area, container, false);
        etRadius=root.findViewById(R.id.etRadius);
        tvResult= root.findViewById(R.id.tvResult);
        btnCalculate=root.findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(etRadius.getText())){
                   etRadius.setError("Enter Radius");
                }
                else{
                Double radius=Double.parseDouble(etRadius.getText().toString());
                Double result=3.14*radius*radius;
                tvResult.setText(result.toString());
                }
            }
        });

        return root;
    }
}