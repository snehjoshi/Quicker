package com.example.quicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MenuItemDetails extends AppCompatActivity {
    TextView title, menuPrice,menuCategory, menuDescription;
    ImageView imageView;
    Button order, backToList;
    int price;
    String name;
    String url;
    String category;
    String description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item_details);
        title=findViewById(R.id.txtTitle);
        menuPrice=findViewById(R.id.txtPrice);
        menuCategory=findViewById(R.id.txtCategory);
        menuDescription=findViewById(R.id.txtDescription);
        imageView=findViewById(R.id.imgView);
        order=findViewById(R.id.btnOrder);
        backToList=findViewById(R.id.btnBack);

        Intent i = getIntent();
        name = i.getStringExtra("itemName");
        category = i.getStringExtra("itemCategory");
        url = i.getStringExtra("itemUrl");
        description = i.getStringExtra("description");
        price = i.getIntExtra("itemPrice",0);

        title.setText(name);
        menuPrice.setText("CAD "+String.valueOf(price));
        menuCategory.setText(category);
        menuDescription.setText(description);
        Picasso.get().load(url).into(imageView);

        backToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),MenuItemsActivity.class);
                startActivity(intent);
            }
        });
    }
}
