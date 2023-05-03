package com.amrdroid.dummycontact;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {
    Context context;
    ArrayList<ContactModel> arrayContacts;
    private int lastPosition=-1;
    public RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrayContacts) {
        this.context = context;
        this.arrayContacts = arrayContacts;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_card,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       // ContactModel contactModel = (ContactModel) arrayContacts.get(position);
        holder.personImg.setImageResource(arrayContacts.get(position).personImg);
        holder.personName.setText(arrayContacts.get(position).personName);
        holder.contactNo.setText(arrayContacts.get(position).contactNo);

        holder.row_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_lay);

                EditText name_edt = dialog.findViewById(R.id.name_edt);
                EditText number_edt = dialog.findViewById(R.id.number_edt);
                Button action_btn = dialog.findViewById(R.id.action_btn);
                TextView title_txt = dialog.findViewById(R.id.title_txt);
                action_btn.setText("Update");
                title_txt.setText("Update Contact");

                name_edt.setText(arrayContacts.get(holder.getAdapterPosition()).personName);
                number_edt.setText(arrayContacts.get(holder.getAdapterPosition()).contactNo);

                action_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name="";
                        String number="";
                        if(!name_edt.getText().toString().equals("") && !number_edt.getText().toString().equals("")) {
                            name = name_edt.getText().toString();
                            number = number_edt.getText().toString();


                            arrayContacts.set(holder.getAdapterPosition(),new ContactModel(arrayContacts.get(holder.getAdapterPosition()).personImg,name,number));
                            notifyItemChanged(holder.getAdapterPosition());
                            dialog.dismiss();
                        }else {
                            Toast.makeText(context, "Please enter details", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                dialog.show();
            }
        });

        holder.row_ll.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                        .setMessage("Are you sure want to delete?")
                        .setIcon(R.drawable.ic_baseline_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                arrayContacts.remove(holder.getAdapterPosition());
                                notifyItemRemoved(holder.getAdapterPosition());
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.show();

                return true;
            }
        });

        setAnimation(holder.itemView,position);

    }

    @Override
    public int getItemCount() {
        return arrayContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView personImg;
        TextView personName;
        TextView contactNo;
        LinearLayout row_ll;
        public ViewHolder(View itemView) {
            super(itemView);
            personImg = itemView.findViewById(R.id.person_img);
            personName = itemView.findViewById(R.id.personName_txt);
            contactNo = itemView.findViewById(R.id.contact_txt);
            row_ll = itemView.findViewById(R.id.row_ll);
        }
    }

    private void setAnimation(View viewToAnimate,int position) {
        if(position>lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}
