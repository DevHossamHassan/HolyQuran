package me.branded.hossamhassan.holyquran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import me.branded.hossamhassan.holyquran.dummy.HolyQuranSora;

public class Dialog_chooseSora extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener{
    String caller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_choose_sora);
        Log.d(HolyQuranConstants.TAG, "onCreate: Dialog_chooseSora Created");
         caller     = getIntent().getStringExtra("caller");
        Log.d(HolyQuranConstants.TAG, "onCreate: get Caller Activity   "+caller);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            ItemFragment firstFragment = new ItemFragment();
            firstFragment=firstFragment.newInstance(1);
            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            //firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }

    }

    @Override
    public void onListFragmentInteraction(HolyQuranSora.Sora item) {
        if (caller.equals("MainActivity")) {
            MainActivity.mViewPager.setCurrentItem(item.getPageNum() - 1);
        }else {
            MainActivity_land.mViewPager.setCurrentItem(item.getPageNum() - 1);

        }
        finish();
    }


}
