package com.example.navigationbar.ui.SimpleInterest;

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

public class SimpleInterest extends Fragment {

    private GalleryViewModel galleryViewModel;
    Button btnCalcus;
    EditText etPrincipal,etRate,etTime;
    TextView tvAnswer;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_simple, container, false);
        btnCalcus=root.findViewById(R.id.btnCalcus);
        etPrincipal=root.findViewById(R.id.etPrincipal);
        etRate=root.findViewById(R.id.etRate);
        etTime=root.findViewById(R.id.etTime);
        tvAnswer=root.findViewById(R.id.tvAnswer);
        btnCalcus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(etPrincipal.getText()))
                {
                    etPrincipal.setError("Enter Principal");
                }
                else if(TextUtils.isEmpty(etTime.getText()))
                {
                    etTime.setError("Enter Time");
                }
                else if(TextUtils.isEmpty(etRate.getText()))
                {
                    etRate.setError("Enter Rate");
                }
                else{
                    Double principal=Double.parseDouble(etPrincipal.getText().toString());
                    Double time=Double.parseDouble(etTime.getText().toString());
                    Double rate=Double.parseDouble(etRate.getText().toString());
                    Double result=(principal*time*rate)/100;
                    tvAnswer.setText(result.toString());
                }
            }
        });
        return root;
    }
}