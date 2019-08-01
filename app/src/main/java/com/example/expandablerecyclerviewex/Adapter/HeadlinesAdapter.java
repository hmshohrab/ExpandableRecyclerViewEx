package com.example.expandablerecyclerviewex.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import com.example.expandablerecyclerviewex.Models.HeadlinesModel;
import com.example.expandablerecyclerviewex.R;

import java.util.List;

/**
 * @author SHOHRAB
 * @date 29-Jul-19
 */
public class HeadlinesAdapter  extends RecyclerView.Adapter<HeadlinesAdapter.CustomViewHolder> {

    Context mContext;
    List<HeadlinesModel> mHeadlinesModelList;

    View mView;
  CustomViewHolder mCustomViewHolder;
    LayoutInflater mLayoutInflater = null;

    public HeadlinesAdapter(Context context, List<HeadlinesModel> headlinesModelList) {
        mContext = context;
        mHeadlinesModelList = headlinesModelList;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }




    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.item_headlines,viewGroup,false);

        return new CustomViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {

        final int pos = i;
        HeadlinesModel headlinesModel = mHeadlinesModelList.get(pos);


        customViewHolder.title.setText(headlinesModel.getTitle());
        customViewHolder.description.setText(headlinesModel.getDescription());
        Toast.makeText(mContext,"Success",Toast.LENGTH_LONG).show();

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mHeadlinesModelList == null ? 0 : mHeadlinesModelList.size();
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView description ;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.titleId);
            description = itemView.findViewById(R.id.descriptionId);
        }
    }
}
