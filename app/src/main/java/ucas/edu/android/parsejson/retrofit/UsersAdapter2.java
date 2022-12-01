package ucas.edu.android.parsejson.retrofit;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ucas.edu.android.parsejson.ListenerInterface;
import ucas.edu.android.parsejson.R;
import ucas.edu.android.parsejson.model.User;


public class UsersAdapter2 extends RecyclerView.Adapter<UsersAdapter2.MyViewHolder> {

    private ListenerInterface listenerInterface;
    List<UsersResponse.UserData> users;
    Context context;

    public UsersAdapter2(Context context, List<UsersResponse.UserData> users, ListenerInterface listenerInterface) {
        this.context = context;
        this.users = users;
        this.listenerInterface=listenerInterface;
    }

    public UsersAdapter2(Activity activity) {
        this.context = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        UsersResponse.UserData user = users.get(position);
        if(user==null)
            return;
        holder.name.setText(user.getFirstName()+" "+user.getLastName());
        holder.email.setText(user.getEmail());
        Glide.with(context)
                .load(user.getAvatar())
                .optionalCircleCrop()
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerInterface.onclick(user.getId(),holder.getAdapterPosition());
            }
        });
    }


    @Override
    public int getItemCount() {
        return users != null ? users.size() : 0;
    }

    public void setUsers(List<UsersResponse.UserData> users) {
        this.users = users;
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
