package com.example.abbadon.moblieappsfinal2;

/**
 * Created by Abbadon on 12/12/2016.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abbadon on 12/12/2016.
 */

public class ListMedAdapter extends ArrayAdapter{
    List list = new ArrayList();
    public ListMedAdapter(Context context, int resource) {
        super(context, resource);
    }
    static class MedicalHandler{
        TextView TITLE, DATE, TIME, PROFESSION, REASON;
    }

    @Override
    public void add(Object object)
    {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View medRow = convertView;
        MedicalHandler medicalHandler;
        if(medRow == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            medRow = layoutInflater.inflate(R.layout.medical_layout,parent,false);
            medicalHandler = new MedicalHandler();
            medicalHandler.TITLE = (TextView) medRow.findViewById(R.id.medTitle);
            medicalHandler.DATE = (TextView) medRow.findViewById(R.id.dateTitle);
            medicalHandler.TIME = (TextView) medRow.findViewById(R.id.timeTitle);
            medicalHandler.PROFESSION = (TextView) medRow.findViewById(R.id.professionTitle);
            medicalHandler.REASON = (TextView) medRow.findViewById(R.id.reasonTitle);
            medRow.setTag(medicalHandler);
        }
        else{
            medicalHandler = (MedicalHandler) medRow.getTag();

        }
        MedicalSorter medicalSorter = (MedicalSorter) this.getItem(position);
        medicalHandler.TITLE.setText(medicalSorter.getTitle());
        medicalHandler.DATE.setText(medicalSorter.getDate());
        medicalHandler.TIME.setText(medicalSorter.getTime());
        medicalHandler.PROFESSION.setText(medicalSorter.getProfession());
        medicalHandler.REASON.setText(medicalSorter.getReason());
        return medRow;
    }
}
