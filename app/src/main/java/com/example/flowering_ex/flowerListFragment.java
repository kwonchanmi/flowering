package com.example.flowering_ex;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.HashMap;

public class flowerListFragment extends ListFragment {

    ListViewAdapter adapter ;

    public static flowerListFragment newInstance() { return new flowerListFragment(); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Adapter 생성 및 Adapter 지정.
        adapter = new ListViewAdapter() ;
        setListAdapter(adapter) ;

        // 첫 번째 아이템 추가.
        //colts foot
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.flower),
                "관동화", "") ;

        // 두 번째 아이템 추가.
        //daisy
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.flower),
                "데이지", "#빨간색 #보라색 #하얀색") ;

        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.flower),
                "미나리아재비", "#6월 #노란색") ;

        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.flower),
                "민들레", "#4월 #5월 #노란색") ;

        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.flower),
                "블루벨", "") ;

        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.flower),
                "설강화", "") ;

        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.flower),
                "수선화", "#12월 #1월 #하얀색") ;

        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.flower),
                "숲바람꽃", "#5월 #6월 #하얀색") ;

        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.flower),
                "아이리스", "") ;

        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.flower),
                "은방울꽃", "#4월 #5월 #하얀색") ;

        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.flower),
                "참나리", "#7월 #8월 #주황색") ;

        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.flower),
                "크로커스", "") ;

        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.flower),
                "튤립", "") ;

        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.flower),
                "팬지", "#4월 #5월 #보라색 #흰색 #노란색") ;

        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.flower),
                "프리틸라리아", "") ;

        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.flower),
                "해바라기", "#8월 #9월 #노란색") ;

        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.flower),
                "황화구륜초", "") ;

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick (ListView l, View v, int position, long id) {
        // get TextView's Text.
        ListViewItem item = (ListViewItem) l.getItemAtPosition(position) ;

        String titleStr = item.getTitle() ;
        String descStr = item.getDesc() ;
        Drawable iconDrawable = item.getIcon() ;

        // TODO : use item data.
    }


}
