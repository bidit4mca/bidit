package com.example.ksb.myapplication000;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
//import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class selling extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText editText2, editText3, editText4;
    private NestedScrollView rootlayout;
    private ImageView imageView3,imageView4;
    private TextView textView2,textView7,textView8,textView9,textView10,textView14,textView15,textView16;
    private Spinner spinner;
    private Button button12;
    private Bitmap bmp;
    private static final String TAG = selling.class.getSimpleName();

    private int PICK_IMAGE_REQUEST = 1;
    private int PICK_IMAGE_REQUEST2 = 2;
    String[] items = { "Select","item1", "item2", "item3", "item4", "item5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling);
        rootlayout=(NestedScrollView)  findViewById(R.id.rootlayout);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        imageView3 = (ImageView) findViewById(R.id.imageView3);

        imageView3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                openGallery(PICK_IMAGE_REQUEST);
            }
        });
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                openGallery(PICK_IMAGE_REQUEST2);
            }
        });

        button12 = (Button) findViewById(R.id.button16);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }
        });
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,items);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(aa);

    }
    private void openGallery(int Code)
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), Code);

    }
/*    private void openGalleryy()
    {
        Intent intentt = new Intent();
        intentt.setType("image/*");
        intentt.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intentt.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intentt, "Select Picture"), PICK_IMAGE_REQUEST);
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if ( resultCode == RESULT_OK && data != null && data.getData() != null) {
            if(requestCode==PICK_IMAGE_REQUEST){
                try{
                    Uri uri = data.getData();
                    Bitmap bitmap1 = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    imageView3.setImageBitmap(bitmap1);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(requestCode==PICK_IMAGE_REQUEST2){
                try{
                    Uri uri2 = data.getData();
                    Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(getContentResolver(), uri2);
                    imageView4.setImageBitmap(bitmap2);
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        }
    }

    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    private void checkDataEntered() {

        if(editText2.getText().toString().isEmpty()){
            editText2.setError("Please enter a valid product name!");
            // Snackbar snackbar1 = Snackbar.make(rootlayout, "Please enter a valid product name!", Snackbar.LENGTH_SHORT);
            // snackbar1.show();
        }
        if(editText3.getText().toString().isEmpty()){
            editText3.setError("Please enter a valid Rate!");
            //Snackbar snackbar1 = Snackbar.make(rootlayout, "Please enter a valid product rate!", Snackbar.LENGTH_SHORT);
            // snackbar1.show();
        }
        if(editText4.getText().toString().isEmpty()){
            editText4.setError("Please enter a valid input!");
            //Snackbar snackbar1 = Snackbar.make(rootlayout, "Provide product description!", Snackbar.LENGTH_SHORT);
            //snackbar1.show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}