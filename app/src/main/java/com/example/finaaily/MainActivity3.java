package com.example.finaaily;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends Activity {

    Button submitButton;
    EditText Code,Password, address, mobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Code =(EditText) findViewById(R.id.storeid);
        Password = (EditText) findViewById(R.id.passwordid);
        address = (EditText) findViewById(R.id.address);
        mobileNumber = (EditText) findViewById(R.id.mobileNumber);
        submitButton = (Button) findViewById(R.id.submitt);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                GlobalVariable.storre=Code.getText().toString();
                GlobalVariable.pass=Password.getText().toString();
                GlobalVariable.add=address.getText().toString();
                GlobalVariable.phone=mobileNumber.getText().toString();

                if (validate(Code)&&validate(address)
                        &&validate(Password)&&validate(mobileNumber)&&checkk(Code)&& checkk(Password)&&check_phone(mobileNumber))

                {
                    Toast.makeText(getApplicationContext(),"SuccessFully Register",Toast.LENGTH_LONG).show();
                    if(v.getId()==R.id.submitt){
                        Intent intent= new Intent(MainActivity3.this,MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private boolean validate(EditText editText) {
        if (editText.getText().toString().trim().length() < 1) {
            editText.setError("Please Fill This.!!!");
            editText.requestFocus();
            return false;
        }
        return true;
    }

    private boolean checkk(EditText editText) {
        if (editText.getText().toString().trim().length() < 6) {
            editText.setError(" less than 6!! ");
            editText.requestFocus();
            return false;
        }
        return true;
    }
    private boolean check_phone(EditText editText) {
        if (editText.getText().toString().trim().length() < 11) {
            editText.setError(" the phone Number incorrect ");
            editText.requestFocus();
            return false;
        }
        return true;
    }

}