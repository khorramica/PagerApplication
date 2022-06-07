package ir.khorrami.pagerapplication.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import ir.khorrami.pagerapplication.datasource.ItemDataSource;
import ir.khorrami.pagerapplication.datasource.ItemDataSourceFactory;
import ir.khorrami.pagerapplication.model.Items;

public class ItemViewModel {
    //creating livedata for PagedList  and PagedKeyedDataSource
    public LiveData<PagedList<Items>> itemPagedList;
    LiveData<PageKeyedDataSource<Integer, Items>> liveDataSource;

    //constructor
    public ItemViewModel() {
        //getting our data source factory
        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();

        //getting the live data source from data source factory
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource();

        //Getting PagedList config
        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(ItemDataSource.PAGE_SIZE).build();

        //Building the paged list
        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, pagedListConfig))
                .build();
    }
}
