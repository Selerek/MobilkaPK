package com.example.ddzppm.ui.zad2;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ddzppm.R;

public class Zad2Fragment extends Fragment {

    private Zad2ViewModel mViewModel;

    public static Zad2Fragment newInstance() {
        return new Zad2Fragment();
    }

    private ImageView zdjecie;
    private Button wroc;
    private Button nastepny;
    private TextView textView;
    int twojstary = 0;
    int images[] = {
            R.drawable.batman,
            R.drawable.dawidj,
            R.drawable.boba,
            R.drawable.borys,
            R.drawable.malpiszon,
            R.drawable.zietas
    };
    private String opisy[] = {
            "jederecgceoxmhepjmjowmojmxmoimfewomfwfxfhewoifewmfn",
            "dwawhfhcwhfnxhewgyfnxwiunfxiuewhfiuewhfnxhiewhfixhewiuxfnhnfuhfwn",
            "trzifewoofcjwenfxoewnxfoeywbeyfewmfxhoewvonncfnoewnhcfowey",
            "czteqhndozhqdhowqhdmoqdhqhndzohwqmonhdxry",
            "pie3147xn7017xn44x097307403140317408c",
            "sze4174301x0n3710mx37n5x-9m15cm10n5c73150m09n5c315m01n7x039m5csc",
    };


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zad2, container, false);
        wroc = view.findViewById(R.id.button);
        nastepny = view.findViewById(R.id.button2);
        zdjecie = view.findViewById(R.id.imageView2);
        textView = view.findViewById(R.id.textView2);
        wroc.setEnabled(false);

        zdjecie.setImageResource(images[twojstary]);


        nastepny.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                twojstary++;
                zdjecie.setImageResource(images[twojstary]);
                textView.setText(opisy[twojstary]);
                updateButtons();

            }
        });
        wroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twojstary--;
                zdjecie.setImageResource(images[twojstary]);
                textView.setText(opisy[twojstary]);
                updateButtons();
                if (twojstary == 6){
                    nastepny.setClickable(false);
                }
                else{
                    nastepny.setClickable(true);
                }
            }
        });











        return view;
    }

    private void updateButtons() {
        wroc.setEnabled(twojstary > 0);
        nastepny.setEnabled(twojstary < images.length - 1);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Zad2ViewModel.class);
        // TODO: Use the ViewModel
    }

}