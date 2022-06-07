package ir.khorrami.pagerapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import ir.khorrami.pagerapplication.adapter.ItemAdapter;
import ir.khorrami.pagerapplication.model.Items;
import ir.khorrami.pagerapplication.viewmodel.ItemViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ItemViewModel itemViewModel =new ViewModelProvider(this).get(ItemViewModel.class    );
        //ItemViewModel itemViewModel=ViewModelProviders.of(this).get(ItemViewModel.class);


        final ItemAdapter adapter = new ItemAdapter(this);


        //observing the itemPagedList from view model
        itemViewModel.itemPagedList.observe(this, new Observer<PagedList<Items>>() {
            @Override
            public void onChanged(@Nullable PagedList<Items> items) {

                //in case of any changes
                //submitting the items to adapter
                adapter.submitList(items);
            }
        });

        //setting the adapter
        recyclerView.setAdapter(adapter);

    }
}