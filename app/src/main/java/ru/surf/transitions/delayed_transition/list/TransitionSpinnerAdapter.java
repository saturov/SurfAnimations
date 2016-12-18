package ru.surf.transitions.delayed_transition.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import ru.surf.transitions.R;
import ru.surf.transitions.delayed_transition.data.TransitionType;

public class TransitionSpinnerAdapter extends BaseAdapter {

    Context context;
    TransitionType[] transitionTypes;
    LayoutInflater inflter;

    public TransitionSpinnerAdapter(Context applicationContext, TransitionType[] transitionTypes) {
        this.context = applicationContext;
        this.transitionTypes = transitionTypes;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return transitionTypes.length;
    }

    @Override
    public Object getItem(int i) {
        return transitionTypes[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.spinner_item_layout, null);
        TextView titleText = (TextView) view;
        titleText.setText(transitionTypes[i].getName());
        return view;
    }


}