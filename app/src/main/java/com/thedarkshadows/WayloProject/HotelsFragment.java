package com.thedarkshadows.WayloProject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.TextInputLayout;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class HotelsFragment extends Fragment {

    Float hotelprice, discount, duration, rooms, totalhotelprice;
    Float hotelpricecal, afterdurationcal, taxcal, waylototalcal, discountcal;
    TextView textViewHotelPrice, textViewDiscount, textViewDuration, textViewTax, textViewTotalHotelPrice;
    Button buttonCalculate, buttonClearFields;

    private TextInputLayout editTextHotelPrice;
    private TextInputLayout editTextDiscount;
    private TextInputLayout editTextDuration;
    private TextInputLayout editTextRooms;
    private TextInputLayout editTextTotalHotelPrice;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotels, container, false);

        textViewHotelPrice = view.findViewById(R.id.tvHotelPrice);
        textViewDiscount = view.findViewById(R.id.tvDiscount);
        textViewDuration = view.findViewById(R.id.tvDuration);
        textViewTax = view.findViewById(R.id.tvTax);
        textViewTotalHotelPrice = view.findViewById(R.id.tvTotalHotelPrice);

        editTextHotelPrice = view.findViewById(R.id.etHotelPrice);
        editTextDiscount = view.findViewById(R.id.etDiscount);
        editTextDuration = view.findViewById(R.id.etDuration);
        editTextRooms = view.findViewById(R.id.etRooms);
        editTextTotalHotelPrice = view.findViewById(R.id.etTotalHotelPrice);

        buttonCalculate = view.findViewById(R.id.btnCalculate);
        buttonClearFields = view.findViewById(R.id.btnClearFields);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextHotelPrice.getEditText().getText().toString().length() == 0 || editTextDiscount.getEditText().getText().toString().length() == 0 || editTextDuration.getEditText().getText().toString().length() == 0 || editTextRooms.getEditText().getText().toString().length() == 0 || editTextTotalHotelPrice.getEditText().getText().toString().length() == 0) {

                    validateHotelPrice();
                    validateDiscount();
                    validateDuration();
                    validateRooms();
                    validateTotalHotelPrice();

                } else {

                    validateHotelPrice();
                    validateDiscount();
                    validateDuration();
                    validateRooms();
                    validateTotalHotelPrice();

                    hotelprice = Float.parseFloat(editTextHotelPrice.getEditText().getText().toString());
                    discount = Float.parseFloat(editTextDiscount.getEditText().getText().toString());
                    duration = Float.parseFloat(editTextDuration.getEditText().getText().toString());
                    rooms = Float.parseFloat(editTextRooms.getEditText().getText().toString());
                    totalhotelprice = Float.parseFloat(editTextTotalHotelPrice.getEditText().getText().toString());

                    waylototalcal = totalhotelprice - (1 - discount) * hotelprice * duration * rooms;
                    textViewTotalHotelPrice.setText(new DecimalFormat("##.##").format(waylototalcal));

                    hotelpricecal = hotelprice * discount;
                    textViewHotelPrice.setText(new DecimalFormat("##.##").format(hotelpricecal));

                    discountcal = totalhotelprice - waylototalcal;
                    textViewDiscount.setText(new DecimalFormat("##.##").format(discountcal));

                    afterdurationcal = hotelpricecal * duration;
                    textViewDuration.setText(new DecimalFormat("##.##").format(afterdurationcal));

                    taxcal = waylototalcal - afterdurationcal;
                    textViewTax.setText(new DecimalFormat("##.##").format(taxcal));

                }
            }
        });

        buttonClearFields.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextHotelPrice.getEditText().getText().toString().isEmpty() && editTextDiscount.getEditText().getText().toString().isEmpty() && editTextDuration.getEditText().getText().toString().isEmpty() && editTextRooms.getEditText().getText().toString().isEmpty() && editTextTotalHotelPrice.getEditText().getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Fields are already empty!", Toast.LENGTH_SHORT).show();
                } else {
                    editTextHotelPrice.getEditText().setText("");
                    editTextDiscount.getEditText().setText("");
                    editTextDuration.getEditText().setText("");
                    editTextRooms.getEditText().setText("");
                    editTextTotalHotelPrice.getEditText().setText("");
                }
            }
        });

        return view;
    }

    public boolean validateHotelPrice() {
        String stringHotelPrice = editTextHotelPrice.getEditText().getText().toString().trim();

        if (stringHotelPrice.isEmpty()) {
            editTextHotelPrice.setError("Field can't be empty!");
            return false;
        } else {
            editTextHotelPrice.setError(null);
            return true;
        }
    }

    public boolean validateDiscount() {
        String stringDiscount = editTextDiscount.getEditText().getText().toString().trim();

        if (stringDiscount.isEmpty()) {
            editTextDiscount.setError("Field can't be empty!");
            return false;
        } else {
            editTextDiscount.setError(null);
            return true;
        }
    }

    public boolean validateDuration() {
        String stringDuration = editTextDuration.getEditText().getText().toString().trim();

        if (stringDuration.isEmpty()) {
            editTextDuration.setError("Field can't be empty!");
            return false;
        } else {
            editTextDuration.setError(null);
            return true;
        }
    }

    public boolean validateRooms() {
        String stringTax = editTextRooms.getEditText().getText().toString().trim();

        if (stringTax.isEmpty()) {
            editTextRooms.setError("Field can't be empty!");
            return false;
        } else {
            editTextRooms.setError(null);
            return true;
        }
    }

    public boolean validateTotalHotelPrice() {
        String stringRooms = editTextTotalHotelPrice.getEditText().getText().toString().trim();

        if (stringRooms.isEmpty()) {
            editTextTotalHotelPrice.setError("Field can't be empty!");
            return false;
        } else {
            editTextTotalHotelPrice.setError(null);
            return true;
        }
    }

}
