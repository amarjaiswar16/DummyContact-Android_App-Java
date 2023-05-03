package com.amrdroid.dummycontact;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView contact_rv;
    ArrayList<ContactModel> arrayContacts = new ArrayList<>();
    FloatingActionButton openDialog_btn;
    RecyclerContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contact_rv = findViewById(R.id.contact_rv);
        openDialog_btn = findViewById(R.id.openDialog_btn);

        openDialog_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_lay);
                EditText name_edt = dialog.findViewById(R.id.name_edt);
                EditText number_edt = dialog.findViewById(R.id.number_edt);
                Button action_btn = dialog.findViewById(R.id.action_btn);

                action_btn.setOnClickListener(new View.OnClickListener() {
                    String name="";
                    String number="";
                    @Override
                    public void onClick(View v) {
//                        if(!name_edt.getText().toString().equals("")) {
//                            name = name_edt.getText().toString();
//                        }else {
//                            Toast.makeText(MainActivity.this, "Please enter contact name!", Toast.LENGTH_SHORT).show();
//                        }
//                        if(!number_edt.getText().toString().equals("")) {
//                            number = number_edt.getText().toString();
//                        }

                        if(!name_edt.getText().toString().equals("") && !number_edt.getText().toString().equals("")) {
                            name = name_edt.getText().toString();
                            number = number_edt.getText().toString();
                            
                            arrayContacts.add(new ContactModel(R.drawable.a,name,number));
                            adapter.notifyItemInserted(arrayContacts.size()-1);
                            contact_rv.scrollToPosition(arrayContacts.size()-1);
                            dialog.dismiss();
                            
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter details", Toast.LENGTH_SHORT).show();
                        }
                      

                    }
                });

                dialog.show();


            }
        });



        contact_rv.setLayoutManager(new LinearLayoutManager(this));


        arrayContacts.add(new ContactModel(R.drawable.a,"Amar","9967528585"));
        arrayContacts.add(new ContactModel(R.drawable.b,"Ashutosh","9876454654"));
        arrayContacts.add(new ContactModel(R.drawable.c,"Rahul","8749563120"));
        arrayContacts.add(new ContactModel(R.drawable.d,"Suyash","7987816421"));
        arrayContacts.add(new ContactModel(R.drawable.e,"Vinayak","8975435412"));
        arrayContacts.add(new ContactModel(R.drawable.f,"Sujay","9456782165"));
        arrayContacts.add(new ContactModel(R.drawable.g,"Ajay","8465798415"));
        arrayContacts.add(new ContactModel(R.drawable.h,"Siddesh","7698465452"));
        arrayContacts.add(new ContactModel(R.drawable.a,"Amar","9967528585"));
        arrayContacts.add(new ContactModel(R.drawable.b,"Ashutosh","9876454654"));
        arrayContacts.add(new ContactModel(R.drawable.c,"Rahul","8749563120"));
        arrayContacts.add(new ContactModel(R.drawable.d,"Suyash","7987816421"));
        arrayContacts.add(new ContactModel(R.drawable.e,"Vinayak","8975435412"));
        arrayContacts.add(new ContactModel(R.drawable.f,"Sujay","9456782165"));
        arrayContacts.add(new ContactModel(R.drawable.g,"Ajay","8465798415"));
        arrayContacts.add(new ContactModel(R.drawable.h,"Siddesh","7698465452"));
        arrayContacts.add(new ContactModel(R.drawable.d,"Suyash","7987816421"));
        arrayContacts.add(new ContactModel(R.drawable.e,"Vinayak","8975435412"));
        arrayContacts.add(new ContactModel(R.drawable.f,"Sujay","9456782165"));
        arrayContacts.add(new ContactModel(R.drawable.g,"Ajay","8465798415"));
        arrayContacts.add(new ContactModel(R.drawable.h,"Siddesh","7698465452"));
        arrayContacts.add(new ContactModel(R.drawable.a,"Amar","9967528585"));
        arrayContacts.add(new ContactModel(R.drawable.b,"Ashutosh","9876454654"));
        arrayContacts.add(new ContactModel(R.drawable.c,"Rahul","8749563120"));
        arrayContacts.add(new ContactModel(R.drawable.d,"Suyash","7987816421"));
        arrayContacts.add(new ContactModel(R.drawable.e,"Vinayak","8975435412"));
        arrayContacts.add(new ContactModel(R.drawable.f,"Sujay","9456782165"));
        arrayContacts.add(new ContactModel(R.drawable.g,"Ajay","8465798415"));
        arrayContacts.add(new ContactModel(R.drawable.h,"Siddesh","7698465452"));

         adapter = new RecyclerContactAdapter(this,arrayContacts);
        contact_rv.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Exit?");
        builder.setIcon(R.drawable.ic_baseline_exit_to_app_24);
        builder.setMessage("Are you sure want to exit?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.super.onBackPressed();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Welcome Back!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Operation Cancelled!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();

    }
}