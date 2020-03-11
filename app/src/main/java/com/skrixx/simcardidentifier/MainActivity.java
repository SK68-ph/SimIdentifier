package com.skrixx.simcardidentifier;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getApplication().setTheme(R.style.AppTheme);
    }

    public ArrayList<String> list_GlobeTm = new ArrayList<>(Arrays.asList(
            "0904", "0905", "0906", "0915", "0916", "0917", "0925", "0926", "0927", "0935", "0936", "0937", "0945", "0955", "0956", "0965", "0966", "0967", "0973", "0975", "0976",
            "0977", "0978", "0979", "0994", "0995", "0997"

    ));

    public ArrayList<String> list_Smart = new ArrayList<>(Arrays.asList(
            "0813", "0908", "0911", "0913", "0914", "0918", "0919", "0920", "0921", "0928", "0929", "0939", "0947", "0949", "0961", "0970", "0981",
            "0989", "0998", "0999"

    ));

    public ArrayList<String> list_Tnt = new ArrayList<>(Arrays.asList(
            "0907", "0909", "0910", "0912", "0930", "0938", "0946", "0948", "0950"

    ));

    public ArrayList<String> list_Sun = new ArrayList<>(Arrays.asList(
            "0922", "0923", "0924", "0925", "0931", "0932", "0933", "0934", "0941", "0942", "0943","0944"

    ));

    public String searchSim(String num){
        String simType = "";

        if (list_GlobeTm.contains(num)){
            simType = "Globe/TM";

        }else if (list_Tnt.contains(num)){
            simType = "TnT";

        }else if (list_Smart.contains(num)){
            simType = "Smart";

        }else if (list_Sun.contains(num)){
            simType = "Sun";

        }
        else {
            simType = "Not Found";

        }

        return simType;
    }

    public void onClick_BTN(View v){
        TextView phonenumber = (TextView) findViewById(R.id.editText);
        TextView status = (TextView) findViewById(R.id.textStatus);
        String phonenumberInput = phonenumber.getText().toString();

        if(phonenumberInput.equals("")){
            Toast toast = Toast.makeText(getApplicationContext(), "Please type the phonenumber", Toast.LENGTH_LONG);
            toast.show();

        }else{
            if(phonenumberInput.contains("+63")) {
                String newphonenumberInput = phonenumberInput.replace("+63", "0");
                phonenumber.setText(newphonenumberInput);

            }else if(phonenumberInput.contains("63")){
                    String newphonenumberInput = phonenumberInput.replace("63", "0");
                phonenumber.setText(newphonenumberInput);

            }

                String phonenumprefix = "";
                phonenumprefix = phonenumber.getText().toString().substring(0, 4);
                System.out.println(phonenumprefix);
                phonenumprefix = searchSim(phonenumprefix);
                status.setText(phonenumprefix);
                Toast toast = Toast.makeText(getApplicationContext(), "Sim Type :" + status.getText(), Toast.LENGTH_LONG);
                toast.show();

        }



    }

}
