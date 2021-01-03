package com.dsi31g4.activitr41;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private SharedPreferences nPref;
private SharedPreferences.Editor editorr;
private EditText Enom,Epass;
private Button btnlog;
private CheckBox nCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Enom = findViewById(R.id.EditTextNom);
        Epass= findViewById(R.id.EditTextPwd);
        btnlog = findViewById(R.id.btlog);
        nCheckbox =  findViewById(R.id.checkbox);
        nPref = PreferenceManager.getDefaultSharedPreferences(this);
        //nb les données sera stocker dans l"editor
        editorr = nPref.edit();
        checkedsharePref();
        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nCheckbox.isChecked()){
                    editorr.putString(getString(R.string.checkbox),"True");
                    editorr.commit();

                    String nm = Enom.getText().toString();
                    editorr.putString(getString(R.string.nom),nm);
                    editorr.commit();

                    String ps = Epass.getText().toString();
                    editorr.putString(getString(R.string.mdp),ps);
                    editorr.commit();

                }else{
                    editorr.putString(getString(R.string.checkbox),"False");
                    editorr.commit();


                    editorr.putString(getString(R.string.nom),"");
                    editorr.commit();


                    editorr.putString(getString(R.string.mdp),"");
                    editorr.commit();
                }
            }
        });
    }
    public void checkedsharePref(){
    String checkbx = nPref.getString(getString(R.string.checkbox),"False");
    String pnom = nPref.getString(getString(R.string.nom),"");
    String ppass = nPref.getString(getString(R.string.mdp),"");
        Enom.setText(pnom);
        Epass.setText(ppass);
        if(checkbx.equals("True")){
            nCheckbox.setChecked(true);
        }else{
            nCheckbox.setChecked(false);
        }

    }

}