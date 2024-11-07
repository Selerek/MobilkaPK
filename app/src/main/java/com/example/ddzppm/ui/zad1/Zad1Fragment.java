package com.example.ddzppm.ui.zad1;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ddzppm.R;
import com.google.android.material.snackbar.Snackbar;

public class Zad1Fragment extends Fragment {

    private Zad1ViewModel mViewModel;
    private TextView textview;
    private EditText edittext;
    private CheckBox checkbox;
    private Button button;



    public static Zad1Fragment newInstance() {
        return new Zad1Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zad1, container, false);
        textview = view.findViewById(R.id.ID1);
        edittext = view.findViewById(R.id.ID2);
        checkbox = view.findViewById(R.id.ID3);
        button = view.findViewById(R.id.ID5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = edittext.getText().toString().trim();
                if (!text1.isEmpty()) {
                    if (checkbox.isChecked()) {
                        Toast.makeText(view.getContext(), edittext.getText(), Toast.LENGTH_SHORT).show();

                    } else {
                        Snackbar ID4 = Snackbar.make(view, edittext.getText(), Snackbar.LENGTH_LONG);
                        ID4.show();
                    }
                }
                else if (text1.isEmpty()){
                    if (checkbox.isChecked()) {
                        Toast.makeText(requireContext(), "fddsgfdsgds", Toast.LENGTH_SHORT).show();

                    } else {
                        Snackbar snackbar = Snackbar.make(view, "NIE WPISANO TEKSTU", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                }

            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Zad1ViewModel.class);
        // TODO: Use the ViewModel
    }

}