package io.szugyi.nytimes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.szugyi.nytimes.data.Repository;
import timber.log.Timber;

@EActivity(R.layout.activity_main)
public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    Repository repository;

    @ViewById(R.id.message)
    TextView mTextMessage;
    @ViewById(R.id.navigation)
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            mTextMessage.setText(R.string.title_home);
                            return true;
                        case R.id.navigation_dashboard:
                            mTextMessage.setText(R.string.title_dashboard);
                            return true;
                        case R.id.navigation_notifications:
                            mTextMessage.setText(R.string.title_notifications);
                            return true;
                        default:
                            break;
                    }
                    return false;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        testDi();
    }

    @AfterViews
    void setupListeners() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void testDi() {
        repository.search("test")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(string -> {
                    Timber.d(string);
                });
    }
}
