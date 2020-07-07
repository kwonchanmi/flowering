package com.example.flowering_ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Fragment mFragment;
    private String predict_str;
    private Bitmap bitmapfinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setContentView(R.layout.content_main);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //퍼미션 상태 확인
            if (!hasPermissions(PERMISSIONS)) {

                //퍼미션 허가 안되어있다면 사용자에게 요청
                requestPermissions(PERMISSIONS, PERMISSIONS_REQUEST_CODE);
            }else{

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.framelayout_main, Camera2BasicFragment.newInstance())
                        .commit();
            }
        }


    }

    @Override
    protected void onStart() {
        super.onStart();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getActivity().onBackPressed();
            }
        });*/


        BottomNavigationView mbottom=(BottomNavigationView)findViewById(R.id.bottom_navigation);
        mbottom.setSelectedItemId(R.id.page_2);
        mbottom.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                        // page 1 : list
                        // page 2 : camera
                        // page 3 : settings
                        switch(item.getItemId()){
                            case R.id.page_1:
                                replaceFragment(flowerListFragment.newInstance(),3);
                                return true;
                            case R.id.page_2:
                                replaceFragment(Camera2BasicFragment.newInstance(),1);
                                return true;
                            case R.id.page_3:
                                replaceFragment(SettingFragment.newInstance(),2);
                                return true;
                        }


                        return false;
                    }
                }
        );


    }

    // 여기서부터는 퍼미션 관련 코드입니다.
    static final int PERMISSIONS_REQUEST_CODE = 1000;
    String[] PERMISSIONS  = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};

    private boolean hasPermissions(String[] permissions) {
        int result;

        //스트링 배열에 있는 퍼미션들의 허가 상태 여부 확인
        for (String perms : permissions){

            result = ContextCompat.checkSelfPermission(this, perms);

            if (result == PackageManager.PERMISSION_DENIED){
                //허가 안된 퍼미션 발견
                return false;
            }
        }

        //모든 퍼미션이 허가되었음
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch(requestCode){

            case PERMISSIONS_REQUEST_CODE:

                if (grantResults.length > 0) {
                    boolean cameraPermissionAccepted = grantResults[0]
                            == PackageManager.PERMISSION_GRANTED;
                    boolean diskPermissionAccepted = grantResults[1]
                            == PackageManager.PERMISSION_GRANTED;

                    if (!cameraPermissionAccepted || !diskPermissionAccepted)
                        showDialogForPermission("앱을 실행하려면 퍼미션을 허가하셔야합니다.");
                    else
                    {
                        Intent intent=new Intent(this,MainActivity.class);
                        startActivity(intent);

                        finish();
                    }
                }
                break;
        }
    }



    private void showDialogForPermission(String msg) {

        AlertDialog.Builder builder = new AlertDialog.Builder( MainActivity.this);
        builder.setTitle("알림");
        builder.setMessage(msg);
        builder.setCancelable(false);
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id){
                requestPermissions(PERMISSIONS, PERMISSIONS_REQUEST_CODE);
            }
        });
        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        });
        builder.create().show();
    }



    //fragment 전환
    public void replaceFragment(Fragment fragment,int check) {

        //check==0 Camera->Predict
        if(check==0){

            Bundle bundle=new Bundle();
            bundle.putString("data",predict_str);

            fragment.setArguments(bundle);
        }
        // check==1 - > Camera
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.framelayout_main, fragment)
                .commit();

    }

    public void getPredict(String answer){predict_str=answer;}

    public void getBitmap(Bitmap bitmap){bitmapfinal=bitmap;}

    public Bitmap setBitmap(){return bitmapfinal;}

    @Override
    protected void onDestroy() {
        if(bitmapfinal==null){
            bitmapfinal.recycle();
            bitmapfinal=null;
        }


        super.onDestroy();
    }
}