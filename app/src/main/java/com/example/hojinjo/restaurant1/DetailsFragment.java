package com.example.hojinjo.restaurant1;


import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {
    int index;
    MDBHelper menudbhelper;
    DBHelper restdbhelper;
    Cursor restc;
    public DetailsFragment() {
        // Required empty public constructor
    }

    public void setSelection(int i) {
        index = i;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_details, container, false);

        menudbhelper=new MDBHelper(getContext());
        restdbhelper = new DBHelper(getContext());



        Intent getmenu=getActivity().getIntent();
        String name=getmenu.getStringExtra("MENU");
        String price=getmenu.getStringExtra("PRICE");
       // menudbhelper.getOneMenuByName(name);


        Cursor c=restdbhelper.getAllRestaurants();
        Cursor cursor = menudbhelper.getAllMenusByID(c.getColumnIndex(name));
        Cursor menucursor = menudbhelper.getOneMenuByName(cursor.getColumnName(0));

        /*이 부분이 되지 않아 주석 처리 했습니다*/
    /*if(menucursor.getColumnName(0)==name) {*/
        /* ImageView menuImage = view.findViewById(R.id.imageView);
         menuImage.setImageURI(Uri.parse(uri*//*menucursor.getColumnName(1)*//*));

        TextView description = (TextView) view.findViewById(R.id.textView6);
        description.setText(menucursor.getColumnName(4));//맞는지모르겠음..*/
    //}

        //이미지랑 설명은 커서로


        TextView menuName= (TextView)view.findViewById(R.id.textView1);
        menuName.setText(name);

        TextView menuPrice = (TextView)view.findViewById(R.id.textView2);
        menuPrice.setText(price);

        return view;
    }

}
