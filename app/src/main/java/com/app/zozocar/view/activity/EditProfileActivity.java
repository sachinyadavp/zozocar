package com.app.zozocar.view.activity;
import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.app.zozocar.R;
import com.app.zozocar.session.ZozoCar;
import java.io.File;
import java.util.Calendar;

import static maes.tech.intentanim.CustomIntent.customType;
public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_dob,tv_gender;
    EditText et_name,et_emal,et_password;
    LinearLayout ll_update;
    int s_pe=0;
    File destination;
    Uri outputFileUri;
    String imgPath;
    ZozoCar zozoCar;
    int tag;
    TextView tv_logout;
    int c_pe=0;
    final  static  int MY_PERMISSIONS_REQUEST=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        customType(this,"bottom-to-up");
        init();
    }
    public void init()
    {
        zozoCar=new ZozoCar(this);
        tv_logout=findViewById(R.id.tv_logout);
        tv_logout.setOnClickListener(this);
        et_emal=findViewById(R.id.et_gmail);
        et_password=findViewById(R.id.et_password);
        ll_update=findViewById(R.id.ll_update);
        ll_update.setOnClickListener(this);
        et_name=findViewById(R.id.et_name);
      et_name.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                //do your stuff here..
                et_name.setFocusableInTouchMode(true);
                return false;
            }
        });
        et_name.setOnClickListener(this);
        et_emal.setOnClickListener(this);
        et_emal.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Log.e("data",v.getText().toString()+" user");
                return false;
            }
        });
        et_password.setOnClickListener(this);
        tv_dob=findViewById(R.id.tv_dob);
        tv_gender=findViewById(R.id.tv_gender);
        tv_dob.setOnClickListener(this);
        tv_gender.setOnClickListener(this);
    }
    private void selectImage() {
        try {
            final CharSequence[] options = {"Take Photo", "Choose From Gallery", "Cancel"};
            android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
            builder.setTitle("Select Option");
            builder.setItems(options, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int item) {
                    if (options[item].equals("Take Photo")) {
                        dialog.dismiss();
                        tag=1;
                        try {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                         //   outputFileUri = Uri.fromFile(getFile());
                            imgPath = destination.getAbsolutePath();

                            intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
                            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                            StrictMode.setVmPolicy(builder.build());
                            startActivityForResult(intent, 1);
                        }
                        catch (Exception e)
                        {
                            Log.e("exception",e.getLocalizedMessage()+"mes");
                        }
                        // startActivityForResult(Intent.createChooser(intent, , 1);

                    } else if (options[item].equals("Choose From Gallery")) {
                        dialog.dismiss();
                        tag=2;
                        Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(pickPhoto, 100);
                    } else if (options[item].equals("Cancel")) {
                        dialog.dismiss();
                    }
                }
            });
            builder.show();

        } catch (Exception e) {
            Toast.makeText(this, "Camera Permission error", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.tv_gender)
        {
            final String[] items = new String[]{"Male", "Female"};
            AlertDialog.Builder ad = new AlertDialog.Builder(this);
            ad.setTitle("Select Gender");
            ad.setItems(items,new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                   tv_gender.setText(items[which]);
                }
            });
            ad.show();
        }
        if (v.getId()==R.id.ll_update)
        {
if(checkPermission()&&check_permision2())
{
    selectImage();
}
        }
        if (v.getId()==R.id.tv_dob)
        {
            final Calendar c = Calendar.getInstance();
            int  mYear = c.get(Calendar.YEAR);
            int  mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            tv_dob.setText(+dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v.getId()==R.id.et_name)
        {
            et_name.setEnabled(true);
        }
        if (v.getId()==R.id.tv_logout)
        {
            Intent in = new Intent(this,SplashActivity.class);
          zozoCar.deletSession();
            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(in);
            this.finish();
            try {
                this.finalize();
            } catch (Exception e) {
            } catch (Throwable throwable) {
                // throwable.printStackTrace();
            }
        }
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public boolean checkPermission()
    {
        int currentAPIVersion = Build.VERSION.SDK_INT;
        if(currentAPIVersion>=android.os.Build.VERSION_CODES.M)
        {
            if ( ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED&& ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale( this, Manifest.permission.READ_EXTERNAL_STORAGE)&&ActivityCompat.shouldShowRequestPermissionRationale( this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    Log.e("data 1","data");
                    android.app.AlertDialog.Builder alertBuilder = new android.app.AlertDialog.Builder(this);
                    alertBuilder.setCancelable(true);
                    alertBuilder.setTitle("Permission necessary");
                    alertBuilder.setMessage("Storage  permission is  necessary !!!");
                    alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(EditProfileActivity.this,new String[]{
                                    Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE,  Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST);
                            //requestPermissions((Activity)getContext(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                        }
                    });
                    android.app.AlertDialog alert = alertBuilder.create();
                    alert.show();
                } else {
                    Log.e("data 2","data");
                    android.app.AlertDialog.Builder alertBuilder = new android.app.AlertDialog.Builder(this);
                    alertBuilder.setCancelable(true);
                    alertBuilder.setTitle("Permission necessary");
                    alertBuilder.setMessage(" Storage  permission is necessary !!!");
                    alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                            Uri uri = Uri.fromParts("package",EditProfileActivity.this.getPackageName(), null);
                            intent.setData(uri);
                            ActivityCompat.requestPermissions(EditProfileActivity.this,new String[]{
                                    Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST);
                            if (s_pe==1)
                                startActivityForResult(intent,MY_PERMISSIONS_REQUEST);
                            else s_pe=1;
                            // requestPermissions((Activity)getContext(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                        }
                    });
                    android.app.AlertDialog alert = alertBuilder.create();
                    alert.show();
//                    requestPermissions(new String[]{
//                            Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST)
                    // ActivityCompat.requestPermissions((Activity)getContext(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                }
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
    public boolean check_permision2()
    {
        int currentAPIVersion = Build.VERSION.SDK_INT;
        if(currentAPIVersion>=android.os.Build.VERSION_CODES.M)
        {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) this, Manifest.permission.CAMERA)) {

                    android.app.AlertDialog.Builder alertBuilder = new android.app.AlertDialog.Builder(this);
                    alertBuilder.setCancelable(true);
                    alertBuilder.setTitle("Permission necessary");
                    alertBuilder.setMessage("Camera  permissions is necessary !!!");
                    alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(EditProfileActivity.this,new String[]{
                                    Manifest.permission.CAMERA}, 13);
                            //requestPermissions((Activity)getContext(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                        }
                    });
                    android.app.AlertDialog alert = alertBuilder.create();
                    alert.show();
                } else {
                    android.app.AlertDialog.Builder alertBuilder = new android.app.AlertDialog.Builder(this);
                    alertBuilder.setCancelable(true);
                    alertBuilder.setTitle("Permission necessary");
                    alertBuilder.setMessage("Camera   permission is necessary !!!");
                    alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                            Uri uri = Uri.fromParts("package",EditProfileActivity.this.getPackageName(), null);
                            intent.setData(uri);
                            ActivityCompat.requestPermissions(EditProfileActivity.this,new String[]{
                                    Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST);
                            if (c_pe==1) {
                                startActivityForResult(intent, 13);
                            }
                            else c_pe=1;
                            // requestPermissions((Activity)getContext(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                        }
                    });
                    android.app.AlertDialog alert = alertBuilder.create();
                    alert.show();
                    // ActivityCompat.requestPermissions((Activity)getContext(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                }
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

}
