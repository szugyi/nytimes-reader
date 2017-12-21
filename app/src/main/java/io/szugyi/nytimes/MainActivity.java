package io.szugyi.nytimes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @Inject
    DataPresenter presenter;

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

        NytimesApplication.getInstance().getApplicationComponent().inject(this);
        testDi();
    }

    @AfterViews
    void setupListeners() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void testDi() {
        presenter.search("test")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(string -> {
                    Timber.d(string);
                });
    }
}
