package me.branded.hossamhassan.holyquran;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

//this is a new test branch to test new features
/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    final String TAG = "Hoss";
    String x = "";
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private static Integer[] mThumbIds = {R.drawable.img_1, R.drawable.img_2, R.drawable.img_3,
            R.drawable.img_4, R.drawable.img_5, R.drawable.img_6, R.drawable.img_7, R.drawable.img_8,
            R.drawable.img_9, R.drawable.img_10, R.drawable.img_11, R.drawable.img_12, R.drawable.img_13,
            R.drawable.img_14, R.drawable.img_15, R.drawable.img_16, R.drawable.img_17, R.drawable.img_18,
            R.drawable.img_19, R.drawable.img_20, R.drawable.img_21, R.drawable.img_22, R.drawable.img_23,
            R.drawable.img_24, R.drawable.img_25, R.drawable.img_26, R.drawable.img_27, R.drawable.img_28,
            R.drawable.img_29, R.drawable.img_30, R.drawable.img_31, R.drawable.img_32, R.drawable.img_33,
            R.drawable.img_34, R.drawable.img_35, R.drawable.img_36, R.drawable.img_37, R.drawable.img_38,
            R.drawable.img_39, R.drawable.img_40, R.drawable.img_41, R.drawable.img_42, R.drawable.img_43,
            R.drawable.img_44, R.drawable.img_45, R.drawable.img_46, R.drawable.img_47, R.drawable.img_48,
            R.drawable.img_49, R.drawable.img_50, R.drawable.img_51, R.drawable.img_52, R.drawable.img_53,
            R.drawable.img_54, R.drawable.img_55, R.drawable.img_56, R.drawable.img_57, R.drawable.img_58,
            R.drawable.img_59, R.drawable.img_60, R.drawable.img_61, R.drawable.img_62, R.drawable.img_63,
            R.drawable.img_64, R.drawable.img_65, R.drawable.img_66, R.drawable.img_67, R.drawable.img_68,
            R.drawable.img_69, R.drawable.img_70, R.drawable.img_71, R.drawable.img_72, R.drawable.img_73,
            R.drawable.img_74, R.drawable.img_75, R.drawable.img_76, R.drawable.img_77, R.drawable.img_78,
            R.drawable.img_79, R.drawable.img_80, R.drawable.img_81, R.drawable.img_82, R.drawable.img_83,
            R.drawable.img_84, R.drawable.img_85, R.drawable.img_86, R.drawable.img_87, R.drawable.img_88,
            R.drawable.img_89, R.drawable.img_90, R.drawable.img_91, R.drawable.img_92, R.drawable.img_93,
            R.drawable.img_94, R.drawable.img_95, R.drawable.img_96, R.drawable.img_97, R.drawable.img_98,
            R.drawable.img_99, R.drawable.img_100, R.drawable.img_101, R.drawable.img_102, R.drawable.img_103,
            R.drawable.img_104, R.drawable.img_105, R.drawable.img_106, R.drawable.img_107, R.drawable.img_108,
            R.drawable.img_109, R.drawable.img_110, R.drawable.img_111, R.drawable.img_112, R.drawable.img_113,
            R.drawable.img_114, R.drawable.img_115, R.drawable.img_116, R.drawable.img_117, R.drawable.img_118,
            R.drawable.img_119, R.drawable.img_120, R.drawable.img_121, R.drawable.img_122, R.drawable.img_123,
            R.drawable.img_124, R.drawable.img_125, R.drawable.img_126, R.drawable.img_127, R.drawable.img_128,
            R.drawable.img_129, R.drawable.img_130, R.drawable.img_131, R.drawable.img_132, R.drawable.img_133,
            R.drawable.img_134, R.drawable.img_135, R.drawable.img_136, R.drawable.img_137, R.drawable.img_138,
            R.drawable.img_139, R.drawable.img_140, R.drawable.img_141, R.drawable.img_142, R.drawable.img_143,
            R.drawable.img_144, R.drawable.img_145, R.drawable.img_146, R.drawable.img_147, R.drawable.img_148,
            R.drawable.img_149, R.drawable.img_150, R.drawable.img_151, R.drawable.img_152, R.drawable.img_153,
            R.drawable.img_154, R.drawable.img_155, R.drawable.img_156, R.drawable.img_157, R.drawable.img_158,
            R.drawable.img_159, R.drawable.img_160, R.drawable.img_161, R.drawable.img_162, R.drawable.img_163,
            R.drawable.img_164, R.drawable.img_165, R.drawable.img_166, R.drawable.img_167, R.drawable.img_168,
            R.drawable.img_169, R.drawable.img_170, R.drawable.img_171, R.drawable.img_172, R.drawable.img_173,
            R.drawable.img_174, R.drawable.img_175, R.drawable.img_176, R.drawable.img_177, R.drawable.img_178,
            R.drawable.img_179, R.drawable.img_180, R.drawable.img_181, R.drawable.img_182, R.drawable.img_183,
            R.drawable.img_184, R.drawable.img_185, R.drawable.img_186, R.drawable.img_187, R.drawable.img_188,
            R.drawable.img_189, R.drawable.img_190, R.drawable.img_191, R.drawable.img_192, R.drawable.img_193,
            R.drawable.img_194, R.drawable.img_195, R.drawable.img_196, R.drawable.img_197, R.drawable.img_198,
            R.drawable.img_199, R.drawable.img_200, R.drawable.img_201, R.drawable.img_202, R.drawable.img_203,
            R.drawable.img_204, R.drawable.img_205, R.drawable.img_206, R.drawable.img_207, R.drawable.img_208,
            R.drawable.img_209, R.drawable.img_210, R.drawable.img_211, R.drawable.img_212, R.drawable.img_213,
            R.drawable.img_214, R.drawable.img_215, R.drawable.img_216, R.drawable.img_217, R.drawable.img_218,
            R.drawable.img_219, R.drawable.img_220, R.drawable.img_221, R.drawable.img_222, R.drawable.img_223,
            R.drawable.img_224, R.drawable.img_225, R.drawable.img_226, R.drawable.img_227, R.drawable.img_228,
            R.drawable.img_229, R.drawable.img_230, R.drawable.img_231, R.drawable.img_232, R.drawable.img_233,
            R.drawable.img_234, R.drawable.img_235, R.drawable.img_236, R.drawable.img_237, R.drawable.img_238,
            R.drawable.img_239, R.drawable.img_240, R.drawable.img_241, R.drawable.img_242, R.drawable.img_243,
            R.drawable.img_244, R.drawable.img_245, R.drawable.img_246, R.drawable.img_247, R.drawable.img_248,
            R.drawable.img_249, R.drawable.img_250, R.drawable.img_251, R.drawable.img_252, R.drawable.img_253,
            R.drawable.img_254, R.drawable.img_255, R.drawable.img_256, R.drawable.img_257, R.drawable.img_258,
            R.drawable.img_259, R.drawable.img_260, R.drawable.img_261, R.drawable.img_262, R.drawable.img_263,
            R.drawable.img_264, R.drawable.img_265, R.drawable.img_266, R.drawable.img_267, R.drawable.img_268,
            R.drawable.img_269, R.drawable.img_270, R.drawable.img_271, R.drawable.img_272, R.drawable.img_273,
            R.drawable.img_274, R.drawable.img_275, R.drawable.img_276, R.drawable.img_277, R.drawable.img_278,
            R.drawable.img_279, R.drawable.img_280, R.drawable.img_281, R.drawable.img_282, R.drawable.img_283,
            R.drawable.img_284, R.drawable.img_285, R.drawable.img_286, R.drawable.img_287, R.drawable.img_288,
            R.drawable.img_289, R.drawable.img_290, R.drawable.img_291, R.drawable.img_292, R.drawable.img_293,
            R.drawable.img_294, R.drawable.img_295, R.drawable.img_296, R.drawable.img_297, R.drawable.img_298,
            R.drawable.img_299, R.drawable.img_300, R.drawable.img_301, R.drawable.img_302, R.drawable.img_303,
            R.drawable.img_304, R.drawable.img_305, R.drawable.img_306, R.drawable.img_307, R.drawable.img_308,
            R.drawable.img_309, R.drawable.img_310, R.drawable.img_311, R.drawable.img_312, R.drawable.img_313,
            R.drawable.img_314, R.drawable.img_315, R.drawable.img_316, R.drawable.img_317, R.drawable.img_318,
            R.drawable.img_319, R.drawable.img_320, R.drawable.img_321, R.drawable.img_322, R.drawable.img_323,
            R.drawable.img_324, R.drawable.img_325, R.drawable.img_326, R.drawable.img_327, R.drawable.img_328,
            R.drawable.img_329, R.drawable.img_330, R.drawable.img_331, R.drawable.img_332, R.drawable.img_333,
            R.drawable.img_334, R.drawable.img_335, R.drawable.img_336, R.drawable.img_337, R.drawable.img_338,
            R.drawable.img_339, R.drawable.img_340, R.drawable.img_341, R.drawable.img_342, R.drawable.img_343,
            R.drawable.img_344, R.drawable.img_345, R.drawable.img_346, R.drawable.img_347, R.drawable.img_348,
            R.drawable.img_349, R.drawable.img_350, R.drawable.img_351, R.drawable.img_352, R.drawable.img_353,
            R.drawable.img_354, R.drawable.img_355, R.drawable.img_356, R.drawable.img_357, R.drawable.img_358,
            R.drawable.img_359, R.drawable.img_360, R.drawable.img_361, R.drawable.img_362, R.drawable.img_363,
            R.drawable.img_364, R.drawable.img_365, R.drawable.img_366, R.drawable.img_367, R.drawable.img_368,
            R.drawable.img_369, R.drawable.img_370, R.drawable.img_371, R.drawable.img_372, R.drawable.img_373,
            R.drawable.img_374, R.drawable.img_375, R.drawable.img_376, R.drawable.img_377, R.drawable.img_378,
            R.drawable.img_379, R.drawable.img_380, R.drawable.img_381, R.drawable.img_382, R.drawable.img_383,
            R.drawable.img_384, R.drawable.img_385, R.drawable.img_386, R.drawable.img_387, R.drawable.img_388,
            R.drawable.img_389, R.drawable.img_390, R.drawable.img_391, R.drawable.img_392, R.drawable.img_393,
            R.drawable.img_394, R.drawable.img_395, R.drawable.img_396, R.drawable.img_397, R.drawable.img_398,
            R.drawable.img_399, R.drawable.img_400, R.drawable.img_401, R.drawable.img_402, R.drawable.img_403,
            R.drawable.img_404, R.drawable.img_405, R.drawable.img_406, R.drawable.img_407, R.drawable.img_408,
            R.drawable.img_409, R.drawable.img_410, R.drawable.img_411, R.drawable.img_412, R.drawable.img_413,
            R.drawable.img_414, R.drawable.img_415, R.drawable.img_416, R.drawable.img_417, R.drawable.img_418,
            R.drawable.img_419, R.drawable.img_420, R.drawable.img_421, R.drawable.img_422, R.drawable.img_423,
            R.drawable.img_424, R.drawable.img_425, R.drawable.img_426, R.drawable.img_427, R.drawable.img_428,
            R.drawable.img_429, R.drawable.img_430, R.drawable.img_431, R.drawable.img_432, R.drawable.img_433,
            R.drawable.img_434, R.drawable.img_435, R.drawable.img_436, R.drawable.img_437, R.drawable.img_438,
            R.drawable.img_439, R.drawable.img_440, R.drawable.img_441, R.drawable.img_442, R.drawable.img_443,
            R.drawable.img_444, R.drawable.img_445, R.drawable.img_446, R.drawable.img_447, R.drawable.img_448,
            R.drawable.img_449, R.drawable.img_450, R.drawable.img_451, R.drawable.img_452, R.drawable.img_453,
            R.drawable.img_454, R.drawable.img_455, R.drawable.img_456, R.drawable.img_457, R.drawable.img_458,
            R.drawable.img_459, R.drawable.img_460, R.drawable.img_461, R.drawable.img_462, R.drawable.img_463,
            R.drawable.img_464, R.drawable.img_465, R.drawable.img_466, R.drawable.img_467, R.drawable.img_468,
            R.drawable.img_469, R.drawable.img_470, R.drawable.img_471, R.drawable.img_472, R.drawable.img_473,
            R.drawable.img_474, R.drawable.img_475, R.drawable.img_476, R.drawable.img_477, R.drawable.img_478,
            R.drawable.img_479, R.drawable.img_480, R.drawable.img_481, R.drawable.img_482, R.drawable.img_483,
            R.drawable.img_484, R.drawable.img_485, R.drawable.img_486, R.drawable.img_487, R.drawable.img_488,
            R.drawable.img_489, R.drawable.img_490, R.drawable.img_491, R.drawable.img_492, R.drawable.img_493,
            R.drawable.img_494, R.drawable.img_495, R.drawable.img_496, R.drawable.img_497, R.drawable.img_498,
            R.drawable.img_499, R.drawable.img_500, R.drawable.img_501, R.drawable.img_502, R.drawable.img_503,
            R.drawable.img_504, R.drawable.img_505, R.drawable.img_506, R.drawable.img_507, R.drawable.img_508,
            R.drawable.img_509, R.drawable.img_510, R.drawable.img_511, R.drawable.img_512, R.drawable.img_513,
            R.drawable.img_514, R.drawable.img_515, R.drawable.img_516, R.drawable.img_517, R.drawable.img_518,
            R.drawable.img_519, R.drawable.img_520, R.drawable.img_521, R.drawable.img_522, R.drawable.img_523,
            R.drawable.img_524, R.drawable.img_525, R.drawable.img_526, R.drawable.img_527, R.drawable.img_528,
            R.drawable.img_529, R.drawable.img_530, R.drawable.img_531, R.drawable.img_532, R.drawable.img_533,
            R.drawable.img_534, R.drawable.img_535, R.drawable.img_536, R.drawable.img_537, R.drawable.img_538,
            R.drawable.img_539, R.drawable.img_540, R.drawable.img_541, R.drawable.img_542, R.drawable.img_543,
            R.drawable.img_544, R.drawable.img_545, R.drawable.img_546, R.drawable.img_547, R.drawable.img_548,
            R.drawable.img_549, R.drawable.img_550, R.drawable.img_551, R.drawable.img_552, R.drawable.img_553,
            R.drawable.img_554, R.drawable.img_555, R.drawable.img_556, R.drawable.img_557, R.drawable.img_558,
            R.drawable.img_559, R.drawable.img_560, R.drawable.img_561, R.drawable.img_562, R.drawable.img_563,
            R.drawable.img_564, R.drawable.img_565, R.drawable.img_566, R.drawable.img_567, R.drawable.img_568,
            R.drawable.img_569, R.drawable.img_570, R.drawable.img_571, R.drawable.img_572, R.drawable.img_573,
            R.drawable.img_574, R.drawable.img_575, R.drawable.img_576, R.drawable.img_577, R.drawable.img_578,
            R.drawable.img_579, R.drawable.img_580, R.drawable.img_581, R.drawable.img_582, R.drawable.img_583,
            R.drawable.img_584, R.drawable.img_585, R.drawable.img_586, R.drawable.img_587, R.drawable.img_588,
            R.drawable.img_589, R.drawable.img_590, R.drawable.img_591, R.drawable.img_592, R.drawable.img_593,
            R.drawable.img_594, R.drawable.img_595, R.drawable.img_596, R.drawable.img_597, R.drawable.img_598,
            R.drawable.img_599, R.drawable.img_600, R.drawable.img_601, R.drawable.img_602, R.drawable.img_603,
            R.drawable.img_604};


    /**
     * The {@link ViewPager} that will host the section contents.
     */
    public static ViewPager mViewPager;
    private int currentItemForReload;

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };
    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //initials shared preferences
        HolyQuranUtils.initSharedPreferences(getApplicationContext());
        /////////////////////////////////////////////
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        //get the current page from shared preferences
        int currentPage = HolyQuranUtils.getInt(getString(R.string.currentPagekey), HolyQuranConstants.currentPageNumberDefault);
        if (currentPage != HolyQuranConstants.currentPageNumberDefault) {
            mViewPager.setCurrentItem(currentPage);
        }


        mDetector = new GestureDetectorCompat(this, this);
        // Set the gesture detector as the double tap
        // listener.
        mDetector.setOnDoubleTapListener(this);
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent me) {
                return mDetector.onTouchEvent(me);
            }
        });


        /////////////////////////////////////////////

        mVisible = true;
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);


        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // toggle();
            }
        });

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        //findViewById(R.id.btn_page).setOnTouchListener(mDelayHideTouchListener);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }

   /* @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        this.mDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }*/

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        toggle();
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        //toggle();
        return true;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String IMG_ID = "img_id";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(IMG_ID, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ImageView imgView = (ImageView) rootView.findViewById(R.id.imgViewMain);
            imgView.setBackgroundResource(mThumbIds[getArguments().getInt(IMG_ID)]);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position);

        }

        @Override
        public int getCount() {
            // Show 604 total pages.
            return 604;
        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return null;
        }
    }

    @Override
    protected void onDestroy() {
        //saveIntToPref(mViewPager.getCurrentItem());
        HolyQuranUtils.setInt(getString(R.string.currentPagekey), mViewPager.getCurrentItem());
        super.onDestroy();
    }

    /*private   void saveIntToPref(int intger)
    {
        sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(getString(R.string.saved_curren_img), intger);
        editor.commit();
    }
    private int getIntFromPref()
    {
        sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
        int defaultValue =-1;
        return sharedPref.getInt(getString(R.string.saved_curren_img), defaultValue);
    }*/
    @Override
    protected void onSaveInstanceState(final Bundle outState) {

        //super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        //super.onRestoreInstanceState(savedInstanceState);

    }

    public void buttonPressed(View view) {
        int viewId = view.getId();
        switch (viewId) {
            case R.id.btn_page:
                choosePageNumDialog();
                break;
            case R.id.btn_sora:
                chooseSoraDialog();
                break;
            case R.id.btn_chapter:
                chooseChapterNumDialog();
                break;
            case R.id.btn_favorite:
                break;
            case R.id.btn_note:
                break;
            case R.id.btn_share:
                break;
            default:


        }

    }

    private void choosePageNumDialog() {
        Dialog_choosePage choosePage = new Dialog_choosePage();
        choosePage.show(this);
    }
    private void chooseChapterNumDialog() {
        Dialog_chooseChapter chooseChapter = new Dialog_chooseChapter();
        chooseChapter.show(this);
    }
    private void chooseSoraDialog(){
        Intent i = new Intent(MainActivity.this, Dialog_chooseSora.class);
        startActivity(i);
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////
}
