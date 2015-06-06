package com.paul.debashis.recyclerviewexample;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Admin on 04/03/2015.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    String[] mTitle;
    String[] mDetail;
    int[] mImage;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTitleView;
        TextView mDetailView;
        ImageView mImageView;
        public ViewHolder(View view) {
            super(view);
            Log.d("DEB"," ViewHolder constructor is called");
            mTitleView = (TextView) view.findViewById(R.id.titleView);
            mDetailView = (TextView) view.findViewById(R.id.detailView);
            mImageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(String[] mTitle,String[] mDetail, int[] mImage) {
        Log.d("DEB"," MyAdapter constructor is called");
        this.mTitle = mTitle;
        this.mDetail = mDetail;
        this.mImage = mImage;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("DEB","onCreateViewHolder is called");
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view_item,parent,false);
        ViewHolder mViewHolder = new ViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d("DEB","onBindViewHolder is called");
        holder.mTitleView.setText(mTitle[position]);
        holder.mDetailView.setText(mDetail[position]);
        holder.mImageView.setImageResource(mImage[position]);
    }

    @Override
    public int getItemCount() {
        // Return the size of your dataset (invoked by the layout manager)
        Log.d("DEB","getItemCount is called");
        return mTitle.length;
    }
}
