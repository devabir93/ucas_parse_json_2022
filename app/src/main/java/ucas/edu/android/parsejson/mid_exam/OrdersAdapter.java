package ucas.edu.android.parsejson.mid_exam;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ucas.edu.android.parsejson.R;


public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.MyViewHolder> {

    List<OrdersData> ordersDataList;
    Context context;

    public OrdersAdapter(Context context, List<OrdersData> ordersDataList) {
        this.context = context;
        this.ordersDataList = ordersDataList;
    }

    public OrdersAdapter(Activity activity) {
        this.context = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflate the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        OrdersData ordersData = ordersDataList.get(position);
        if (ordersData == null)
            return;

        holder.name.setText(ordersData.getDetails());
        holder.email.setText(ordersData.getPhone());
        ArrayList<OrderPhoto> photesArrayList = ordersData.getOrderPhotoArrayList();
        if (photesArrayList != null && photesArrayList.size() > 0) {
            if(ordersData.getOrderPhotoArrayList().get(0)!=null)
                Glide.with(context).load(ordersData.getOrderPhotoArrayList().get(0).getPhoto()).into(holder.imageView);
        }
    }


    @Override
    public int getItemCount() {
        return ordersDataList != null ? ordersDataList.size() : 0;
    }

    public void setProducts(List<OrdersData> ordersDataList) {
        this.ordersDataList = ordersDataList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, email;// init the item view's
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
            email = (TextView) itemView.findViewById(R.id.email);
            imageView = (ImageView) itemView.findViewById(R.id.imageview);
        }
    }
}
