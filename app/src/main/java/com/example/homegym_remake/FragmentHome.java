package com.example.homegym_remake;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentHome extends Fragment {

    public FragmentHome() { }

    /*프래그먼트에서 메인엑티비티가 필요한 경우*/
    MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity = null;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //아래 코드가 기존에 있었음. 아래 코드 부분을 ViewGrop 객체로 생성
//inflater.inflate(R.layout.fragment_search, container, false);

        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_home,container,false);
        Button button1 = (Button)rootview.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "버튼 클릭!!!!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), UpperActivity.class);
                startActivity(intent);
            }
        });
        Button button2 = (Button)rootview.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "버튼 클릭!!!!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), LowerActivity.class);
                startActivity(intent);
            }
        });
        Button button3 = (Button)rootview.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "버튼 클릭!!!!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), WholeBodyActivity.class);
                startActivity(intent);
            }
        });
        return rootview;
    }

}
