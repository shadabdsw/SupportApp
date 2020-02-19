package com.thedarkshadows.WayloProject;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class PackageFragment extends Fragment {

    Float WayloTotalPrice;
    double waylototalpricecal;
    TextInputLayout editTextPackageTotalPrice;
    TextView textViewWayloTotalPrice;
    Button buttonCalculate, buttonClear;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_package, container, false);

        editTextPackageTotalPrice = view.findViewById(R.id.etPackageTotalPrice);
        textViewWayloTotalPrice = view.findViewById(R.id.tvWayloTotalPrice);
        buttonCalculate = view.findViewById(R.id.btnCalculate);
        buttonClear = view.findViewById(R.id.btnClear);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editTextPackageTotalPrice.getEditText().getText().toString().length() == 0) {
                    validateTotalPackagePrice();
                } else {
                    validateTotalPackagePrice();

                    WayloTotalPrice = Float.parseFloat(editTextPackageTotalPrice.getEditText().getText().toString());

                    if (WayloTotalPrice >= 3100) {
                        waylototalpricecal = WayloTotalPrice - 95;
                    } else {
                        waylototalpricecal = WayloTotalPrice * 0.97;
                    }
                    textViewWayloTotalPrice.setText(new DecimalFormat("##.##").format(waylototalpricecal));

                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextPackageTotalPrice.getEditText().setText("");
            }
        });

        return view;
    }


    public boolean validateTotalPackagePrice() {
        String stringTPP = editTextPackageTotalPrice.getEditText().getText().toString().trim();

        if (stringTPP.isEmpty()) {
            editTextPackageTotalPrice.setError("Field can't be empty!");
            return false;
        } else {
            editTextPackageTotalPrice.setError(null);
            return true;
        }
    }
}

