package eu.dotteex.jecnak.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import eu.dotteex.jecnak.R;
import eu.dotteex.jecnak.models.Grade;

public class GradeAdapter extends RecyclerView.Adapter<GradeAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Grade> data;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView subtitle;
        private final TextView value;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            subtitle = (TextView) view.findViewById(R.id.subtitle);
            value = (TextView) view.findViewById(R.id.value);
        }

    }

    public GradeAdapter(Context context, ArrayList<Grade> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.grade_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        if(data.get(position).getTitle().equals("")) {
            viewHolder.title.setText("(bez popisu)");
        }else {
            viewHolder.title.setText(data.get(position).getTitle());
        }
        viewHolder.subtitle.setText(data.get(position).getDate()+", "+data.get(position).getTeacher());
        if(data.get(position).isUncountable()) {
            viewHolder.value.setText("N");
        }else {
            viewHolder.value.setText(String.valueOf(data.get(position).getValue()));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}