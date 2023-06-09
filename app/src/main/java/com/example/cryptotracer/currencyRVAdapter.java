package com.example.cryptotracer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

// on below line we are creating our adapter class
// in this class we are passing our array list
// and our View Holder class which we have created.
public class currencyRVAdapter extends RecyclerView.Adapter<currencyRVAdapter.CurrencyViewholder> {
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    private ArrayList<currencyRVModal> currencyRVModelArrayList;
    private Context context;

    public currencyRVAdapter(ArrayList<currencyRVModal> currencyRVModelArrayList, Context context) {
        this.currencyRVModelArrayList = currencyRVModelArrayList;
        this.context = context;
    }

    // below is the method to filter our list.
    public void filterList(ArrayList<currencyRVModal> filterlist) {
        // adding filtered list to our array list and notifying data set changed
        currencyRVModelArrayList = filterlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public currencyRVAdapter.CurrencyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // this method is use to inflate the layout file which we have created for our recycler view.

        View view = LayoutInflater.from(context).inflate(R.layout.currency_rv_item, parent, false);
        return new currencyRVAdapter.CurrencyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull currencyRVAdapter.CurrencyViewholder holder, int position) {
        // on below line we are setting data to our item of recycler view and all its views.
        currencyRVModal modal = currencyRVModelArrayList.get(position);
        holder.nameTV.setText(modal.getName());
        holder.rateTV.setText("$ " + df2.format(modal.getPrice()));
        holder.symbolTV.setText(modal.getSymbol());
    }

    @Override
    public int getItemCount() {
        // on below line we are returning the size of our array list.
        return currencyRVModelArrayList.size();
    }

    // on below line we are creating our view holder class which will be used to initialize each view of our layout file.
    public class CurrencyViewholder extends RecyclerView.ViewHolder {
        private TextView symbolTV, rateTV, nameTV;

        public CurrencyViewholder(@NonNull View itemView) {
            super(itemView);
            // on below line we are initializing all our text views along with  its ids.
            symbolTV = itemView.findViewById(R.id.idTVSymbol);
            rateTV = itemView.findViewById(R.id.idTVRate);
            nameTV = itemView.findViewById(R.id.idTVName);
        }
    }
}