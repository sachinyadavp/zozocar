package com.app.zozocar.view.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.app.zozocar.R;
import com.app.zozocar.view.adapter.LoginSignUpPAgeAdapter;
import com.app.zozocar.view.adapter.UserPageAdapter;
import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class UserActivity extends AppCompatActivity implements View.OnClickListener {
    int c_pe=0;
    final  static  int MY_PERMISSIONS_REQUEST=10;
    int s_pe=0;
    File destination;
    Uri outputFileUri;
    Bitmap bitmap;
    int tag;
    String imgPath;
    ImageView iv_profile;
  RelativeLayout rl_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        init();
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
    public void init()
    {
        iv_profile=findViewById(R.id.iv_profile);

        rl_profile=findViewById(R.id.rl_profile);
        rl_profile.setOnClickListener(this);
        TabLayout tabLayout =  findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Details"));
        tabLayout.addTab(tabLayout.newTab().setText("Account"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final UserPageAdapter adapter = new UserPageAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //  tab.setTabTextColors(getResources().getColor(R.color.blue_200), getResources().getColor(R.color.white));
                //tab.setCustomView(LayoutInflater.from(SigninSignUpActivity.this).inflate(R.layout.tab_background,null));
                //   tab.setIcon(R.drawable.back_icon);
                tab.getPosition();
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
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
                            ActivityCompat.requestPermissions(UserActivity.this,new String[]{
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
                            Uri uri = Uri.fromParts("package",UserActivity.this.getPackageName(), null);
                            intent.setData(uri);
                            ActivityCompat.requestPermissions(UserActivity.this,new String[]{
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
                            ActivityCompat.requestPermissions(UserActivity.this,new String[]{
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
                            Uri uri = Uri.fromParts("package",UserActivity.this.getPackageName(), null);
                            intent.setData(uri);
                            ActivityCompat.requestPermissions(UserActivity.this,new String[]{
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1) {

            if (resultCode== Activity.RESULT_OK) {
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), outputFileUri);
                    if (bitmap!=null)
                        Glide.with(this)
                                .load(bitmap)
                                .placeholder(R.drawable.userimg) // can also be a drawable
                                .into(iv_profile);
                    iv_profile.setImageBitmap(bitmap);
                    Log.e("the bitmp", bitmap.toString() + " da" + imgPath);
                } catch (Exception e) {
                    Log.e("exception e", e.getLocalizedMessage() + " mes");

                }
            }
            else {
                Log.e("path not found","p");
                imgPath=null;
                bitmap=null;

            }
        }
        if (requestCode ==100) {
            try {
                Uri selectedImage = data.getData();
                Log.e("nskldnv", selectedImage + "");
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                Glide.with(this)
                        .load(bitmap)
                        .placeholder(R.drawable.userimg)
                        .into(iv_profile);
                iv_profile.setImageBitmap(bitmap);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                Log.e("Activity", "Pick from Gallery::>>> ");
                destination = new File(getRealPathFromURI(selectedImage).toString());
                imgPath= createDirectoryAndSaveFile(bitmap, destination.getName()).getAbsolutePath();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.rl_profile)
        {
            if (checkPermission()&&check_permision2())
            {
                selectImage();
            }
        }
    }
    public String getRealPathFromURI(Uri contentUri) {
        String[] proj = {MediaStore.Audio.Media.DATA};
        Cursor cursor = managedQuery(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
    private File createDirectoryAndSaveFile(Bitmap imgSave, String fileName) {

        File direct = new File(Environment.getExternalStorageDirectory() + "/" + getString(R.string.app_name));

        if (!direct.exists()) {
            File imageDirectory = new File(Environment.getExternalStorageDirectory() + "/" + getString(R.string.app_name) + "/");
            imageDirectory.mkdirs();
        }
        destination = new File(new File(Environment.getExternalStorageDirectory() + "/" + getString(R.string.app_name) + "/"), fileName);
        if (destination.exists()) {
            destination.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(destination);
            imgSave.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return destination;
    }
}
