package me.branded.hossamhassan.holyquran;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import me.branded.hossamhassan.holyquran.ItemFragment.OnListFragmentInteractionListener;
import me.branded.hossamhassan.holyquran.dummy.HolyQuranSora;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<HolyQuranSora.Sora> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<HolyQuranSora.Sora> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Log.d(HolyQuranConstants.TAG, "onBindViewHolder: "+position);
        holder.mItem = mValues.get(position);
        holder.soraId.setText(position+1+"");
        holder.soraName.setText(mValues.get(position).getName());
        holder.soraPageNum.setText(mValues.get(position).getPageNum()+"");
        holder.soraSize.setText(mValues.get(position).getSoraAyatNum()+"");

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d(HolyQuranConstants.TAG, "getItemCount: "+mValues.size());
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView soraId;
        public final TextView soraName;
        public final TextView soraPageNum;
        public final TextView  soraSize;
        public final CircleImageView soraImg;



        public HolyQuranSora.Sora mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            soraId = (TextView) view.findViewById(R.id.soraId);
            soraName = (TextView) view.findViewById(R.id.soraName);
            soraPageNum=(TextView) view.findViewById(R.id.soraPageNum);
            soraSize=(TextView) view.findViewById(R.id.soraSize);
            soraImg=(CircleImageView)view.findViewById(R.id.soraImg);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + soraName.getText() + "'";
        }
    }
}
