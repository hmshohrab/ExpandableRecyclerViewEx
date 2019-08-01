package com.example.expandablerecyclerviewex.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.expandablerecyclerviewex.Models.NewsPaperModel;
import com.example.expandablerecyclerviewex.R;

import java.util.List;

/**
 * @author SHOHRAB
 * @date 30-Jul-19
 */
public class NewspaperAdapter extends RecyclerView.Adapter<NewspaperAdapter.CustomViewHolder> {


    Context mContext;
    List<NewsPaperModel> mNewsPaperModelsList;
    View mView;
    HeadlinesAdapter mHeadlinesAdapter;
    CustomViewHolder mCustomViewHolder;

    public NewspaperAdapter(Context context, List<NewsPaperModel> newsPaperModels) {
        mContext = context;
        mNewsPaperModelsList = newsPaperModels;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        mView = LayoutInflater.from(mContext).inflate(R.layout.item_newspapers, viewGroup,false);

        return new CustomViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
        final int pos = i;

        final NewsPaperModel newsPaperModel = mNewsPaperModelsList.get(pos);
        customViewHolder.paperName.setText(newsPaperModel.getName());
        this.mHeadlinesAdapter =new HeadlinesAdapter(this.mContext,newsPaperModel.getHeadlines());
        customViewHolder.rvHeadlines.setAdapter(this.mHeadlinesAdapter);
        customViewHolder.rvHeadlines.setLayoutManager(new LinearLayoutManager(this.mContext));

        customViewHolder.arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NewspaperAdapter.this.onItemClicked(newsPaperModel);

            }
        });

        boolean expanded = newsPaperModel.isIs_Expanded();
        if (expanded){
            customViewHolder.rvHeadlines.setVisibility(View.VISIBLE);
            customViewHolder.arrow.setImageResource(R.drawable.ic_arrow_drop_down);

        }else {
            customViewHolder.rvHeadlines.setVisibility(View.INVISIBLE);
            customViewHolder.arrow.setImageResource(R.drawable.ic_arrow_drop_up);
        }



    }

    public void onItemClicked(NewsPaperModel newsPaperModel){
      if (newsPaperModel != null){
          boolean is_expanded = newsPaperModel.isIs_Expanded();
      newsPaperModel.setIs_Expanded(!is_expanded);
      }


    }

    @Override
    public int getItemCount() {

        return mNewsPaperModelsList == null ? 0 : mNewsPaperModelsList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

        TextView paperName;
        ImageView arrow;
        RecyclerView rvHeadlines;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            paperName = itemView.findViewById(R.id.paperNameId);
            arrow = itemView.findViewById(R.id.arrowId);
            rvHeadlines = itemView.findViewById(R.id.rvHeadlinesId);
        }
    }
}
