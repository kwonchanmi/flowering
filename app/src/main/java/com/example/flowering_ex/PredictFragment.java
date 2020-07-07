package com.example.flowering_ex;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.flowering_ex.databinding.FragmentPredictBinding;

import org.w3c.dom.Text;

public class PredictFragment extends Fragment {

    private TextView predictResult;
    private String predictString="";
    private FragmentPredictBinding binding;

    public static PredictFragment newInstance() { return new PredictFragment(); }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = DataBindingUtil.inflate(inflater, R.layout.fragment_predict, container, false).getRoot();
        binding = DataBindingUtil.getBinding(view);



        if(getArguments()!=null){
            predictString=getArguments().getString("data");
            Log.e("TAG",predictString);
        }


        int idx=predictString.indexOf(" ");
        Log.e("TAG_z",String.valueOf(idx));
        String first=predictString.substring(idx+1);

        idx=first.indexOf(" ");
        Log.e("TAG_z1",String.valueOf(idx));
        String third=first.substring(0,idx);
        String second=first.substring(idx+1);


        Log.e("TAG_z2",third);
        Log.e("TAG_z3",second);

        binding.preview.setImageBitmap(((MainActivity)getActivity()).setBitmap());

        //둥글게
        binding.preview.setBackground(new ShapeDrawable((new OvalShape())));
        binding.preview.setClipToOutline(true);

        binding.label.setText(third);
        binding.accuracy.setText(Float.toString(Float.parseFloat(second)*100)+"%");


        //binding.predictPrint.setText(predictString);



        return view;
    }

    /** Layout the preview and buttons. */
    /*@Override
    public View onCreateView(


            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_predict, container, false);
    }*/



   /* @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(getArguments()!=null){
            predictString=getArguments().getString("data");
            Log.e("TAG",predictString);
        }



        Toolbar toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);


        predictResult=(TextView)view.findViewById(R.id.predictPrint);
        predictResult.setText(predictString);


    }*/

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
