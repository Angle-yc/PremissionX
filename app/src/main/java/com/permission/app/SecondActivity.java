package com.permission.app;

import android.Manifest;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.permission.angle.PermissionX;

import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/**
 * 作者    angle
 * 时间    2020/11/12 3:50 PM
 * 文件    PermissionX
 * 描述
 */
public class SecondActivity extends AppCompatActivity {
    private final String[] permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA,Manifest.permission.READ_CONTACTS};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.permissionBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermision();
            }
        });

    }

    private void requestPermision(){
        PermissionX.INSTANCE.request(this, permissions, new Function2<Boolean, List<String>, Unit>() {
            @Override
            public Unit invoke(Boolean aBoolean, List<String> deniedList) {
                if (aBoolean){
                    Toast.makeText(SecondActivity.this,"All permissions are granted",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(SecondActivity.this,"You denied"+deniedList,Toast.LENGTH_SHORT).show();
                }
                return null;
            }
        });
    }
}
