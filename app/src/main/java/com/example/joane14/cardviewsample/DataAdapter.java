package com.example.joane14.cardviewsample;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Joane14 on 03/02/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<String> name, age, bDate;

    public DataAdapter(ArrayList<String> name, ArrayList<String> age, ArrayList<String> bdate){

        this.name=name;
        this.age=age;
        this.bDate=bdate;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        holder.mName.setText(name.get(position));
        holder.mAge.setText(age.get(position));
        holder.mBDate.setText(bDate.get(position));

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                PopupMenu pop = new PopupMenu(view.getContext(), view);
                MenuInflater inflater = pop.getMenuInflater();
                inflater.inflate(R.menu.card_popup_menu, pop.getMenu());
                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(view.getContext(), "You clicked: "+ menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public void showPopUpMenu(final View view){
        PopupMenu popupMenumenu = new PopupMenu(view.getContext(), view);
        MenuInflater inflater = popupMenumenu.getMenuInflater();
        inflater.inflate(R.menu.card_popup_menu, popupMenumenu.getMenu());


        popupMenumenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toast.makeText(view.getContext(), "You clicked: "+ menuItem.getTitle(), Toast.LENGTH_SHORT).show();

                return true;
            }
        });
        popupMenumenu.show();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mName, mAge, mBDate;
        ImageButton btn;
        public ViewHolder(View view){
            super(view);

            mName = (TextView) view.findViewById(R.id.tvName);
            mAge= (TextView) view.findViewById(R.id.tvAge);
            mBDate = (TextView) view.findViewById(R.id.tvBirthDate);
            btn = (ImageButton) view.findViewById(R.id.option);
        }

    }

}
