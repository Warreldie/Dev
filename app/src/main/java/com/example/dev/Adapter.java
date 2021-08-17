package com.example.dev;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
//Is build for the first screen
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Item> mList;
    private OnItemClickListener mListener;

    //If there is been clicked on an item it wil say what item it is wich number of the whole array
    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    //Makes a list
    public Adapter(Context context, ArrayList<Item> list){
        mContext = context;
        mList = list;
    }

    //Inflator
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
       return new ViewHolder(v);
    }

    //Adds the title to the item from the position
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item currentItem = mList.get(position);

        String title = currentItem.getTitle();

        holder.mTitle.setText(title);
    }
    //Makes the RecyclerView work with ViewHolder
    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.text_view_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener != null){
                        int position = getBindingAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
