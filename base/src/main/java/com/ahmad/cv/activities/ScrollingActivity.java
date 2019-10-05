package com.ahmad.cv.activities;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.rhexgomez.typer.roboto.TyperRoboto;
import com.ahmad.cv.adapters.ViewPagerAdapter;
import com.ahmad.cv.base.R;
import com.ahmad.cv.fragments.AboutFragment;
import com.ahmad.cv.fragments.EducationFragment;
import com.ahmad.cv.fragments.ProfessionFragment;
import com.squareup.picasso.Picasso;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import java.util.Objects;
public class ScrollingActivity extends AppCompatActivity {
    TabLayout tabLayout;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        tabLayout = findViewById(R.id.tabs);
        Toolbar toolbar = findViewById(R.id.toolbar);
        ViewPager mViewPager = findViewById(R.id.viewpager);
        ImageView profileImage = findViewById(R.id.profile);
        ViewPagerAdapter mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setExpandedTitleColor(Color.parseColor("#00FFFFFF"));
        collapsingToolbarLayout.setCollapsedTitleTypeface(TyperRoboto.ROBOTO_REGULAR());
        collapsingToolbarLayout.setExpandedTitleTypeface(TyperRoboto.ROBOTO_REGULAR());
        Picasso.get().load(R.drawable.profile).into(profileImage);
        mViewPagerAdapter.addFragment(AboutFragment.newInstance(), "About");
        mViewPagerAdapter.addFragment(EducationFragment.newInstance(), "Education");
        mViewPagerAdapter.addFragment(ProfessionFragment.newInstance(), "Experience");
        mViewPager.setAdapter(mViewPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
        setupTabIcons();

        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }

    private void setupTabIcons() {
       final int[] tabIcons = {
                R.drawable.ic_person_black_24dp,
                R.drawable.education,
                R.drawable.tool
        };
        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(tabIcons[0]);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(tabIcons[1]);
        Objects.requireNonNull(tabLayout.getTabAt(2)).setIcon(tabIcons[2]);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0) {
                    Objects.requireNonNull(tab.getIcon()).setColorFilter(Color.parseColor("#2B2B2B"), PorterDuff.Mode.SRC_IN); }
                if(tab.getPosition() == 1){
                    Objects.requireNonNull(tab.getIcon()).setColorFilter(Color.parseColor("#2B2B2B"), PorterDuff.Mode.SRC_IN); }
                if(tab.getPosition() == 2){
                    Objects.requireNonNull(tab.getIcon()).setColorFilter(Color.parseColor("#2B2B2B"), PorterDuff.Mode.SRC_IN); }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                    Objects.requireNonNull(tab.getIcon()).setColorFilter(Color.parseColor("#0A6CEB"), PorterDuff.Mode.SRC_IN);
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i=new Intent(android.content.Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(android.content.Intent.EXTRA_SUBJECT,"Click the following link");
            i.putExtra(android.content.Intent.EXTRA_TEXT, "https://shahwaiz90.github.io/resume/");
            startActivity(Intent.createChooser(i,"Share via"));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}