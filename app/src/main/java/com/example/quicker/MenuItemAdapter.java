package com.example.quicker;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MenuItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context cContext;
    private List<MenuItemsData> cUploads;
    public MenuItemAdapter(Context context, List<MenuItemsData> uploads){
        cContext=context;
        cUploads=uploads;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.menuitem_record,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MenuItemsData menuItemsData=cUploads.get(position);
        ((ViewHolder) holder).title.setText(menuItemsData.getTitle());
        ((ViewHolder) holder).price.setText(String.valueOf(menuItemsData.getPrice()));
        ((ViewHolder)holder).category.setText(String.valueOf(menuItemsData.getCategory()));
        Picasso.get().load(menuItemsData.getImage()).into(((ViewHolder)holder).img);

    }

    @Override
    public int getItemCount() {
        return cUploads.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView img;
        public TextView title, price, category;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.imgView);
            title=(TextView)itemView.findViewById(R.id.txtTitle);
            price=(TextView)itemView.findViewById(R.id.txtPrice);
            category=(TextView)itemView.findViewById(R.id.txtCategory);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    MenuItemsData menuItemsData = cUploads.get(position);
                    String title = menuItemsData.getTitle();
                    int price = menuItemsData.getPrice();
                    String category = menuItemsData.getCategory();
                    String url = menuItemsData.getImage();
                    String description = menuItemsData.getDescription();
//                    Toast.makeText(cContext.getApplicationContext(),title,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(v.getContext(), MenuItemDetails.class);
                    intent.putExtra("itemName",title);
                    intent.putExtra("itemPrice",price);
                    intent.putExtra("itemCategory",category);
                    intent.putExtra("itemUrl",url);
                    intent.putExtra("description",description);
                    cContext.startActivity(intent);
                }
            });
        }
    }


}



