package com.tobeproductive.madhav.savingdataintointernalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity
{
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
    }
    //OnClick -->to save data into internal storage
    public  void saveIntoInternalStorage(View view)
    {
        String fileName=et1.getText().toString().trim();
        String data=et2.getText().toString().trim();
        //Activity super class ContextThemeWrapper its superclass ContextWrapper so we can call the method openFileOutput directly from activity class
        //Two params FILENAME and operating mode
        //Returns fileOutputStream
        try
        {
            FileOutputStream fop=openFileOutput(fileName,MODE_PRIVATE);
            //data written into internal storage is in form of bytes
            //so converting string into byte array (Data Stroed in 0 1 format)
            byte[] b=data.getBytes();
            fop.write(b);
            fop.close();
            et1.setText("");
            et2.setText("");
            et1.requestFocus();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
