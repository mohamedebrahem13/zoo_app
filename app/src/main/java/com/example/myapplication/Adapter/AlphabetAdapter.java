package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class AlphabetAdapter extends BaseAdapter {

    Context c;
    List<String> alphabet;

    public AlphabetAdapter(Context c) {
        this.c = c;
    }

    public void setlist (List<String> alphabet) {
        this.alphabet = alphabet;
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        if (alphabet!=null){

            return alphabet.size();
        }
        return -1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.alphabeta_adapter_layout, null);
        }
        TextView textView = convertView.findViewById(R.id.gridtext);
        textView.setText(alphabet.get(position));
        return convertView;

    }
}
