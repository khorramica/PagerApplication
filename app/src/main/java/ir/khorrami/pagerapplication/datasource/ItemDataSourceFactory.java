package ir.khorrami.pagerapplication.datasource;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import ir.khorrami.pagerapplication.model.Items;

public class ItemDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, Items>> itemLiveDataSource = new MutableLiveData<>();


    @Override
    public DataSource<Integer, Items> create() {
        ItemDataSource itemDataSource = new ItemDataSource();
        itemLiveDataSource.postValue(itemDataSource);

        return itemDataSource;
    }

    //getter for itemlivedatasource
    public MutableLiveData<PageKeyedDataSource<Integer, Items>> getItemLiveDataSource() {
        return itemLiveDataSource;
    }
}
