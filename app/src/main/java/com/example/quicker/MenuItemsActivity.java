package com.example.quicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MenuItemsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<MenuItemsData> menuItems;
    private MenuItemAdapter menuItemAdapter;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_items);
        recyclerView = findViewById(R.id.rcView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        menuItems = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("users/restaurant").child("menuitems");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    MenuItemsData upload = postSnapshot.getValue(MenuItemsData.class);
                    menuItems.add(upload);
                }
                menuItemAdapter = new MenuItemAdapter(MenuItemsActivity.this, menuItems);
                recyclerView.setAdapter(menuItemAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MenuItemsActivity.this, databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
