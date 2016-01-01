package me.branded.hossamhassan.holyquran;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.avast.android.dialogs.core.BaseDialogFragment;
import com.avast.android.dialogs.fragment.SimpleDialogFragment;

/**
 * Created by HossamHassan on 12/27/2015.
 */
public class Dialog_choosePage extends SimpleDialogFragment {
    public static String TAG = "Hoss";

    public  void show(FragmentActivity activity) {
        new Dialog_choosePage().show(activity.getSupportFragmentManager(),TAG);}

        public BaseDialogFragment.Builder build(final BaseDialogFragment.Builder builder) {
            builder.setTitle("الذهاب الي صفحة معينة");
            builder.setView(LayoutInflater.from(getActivity()).inflate(R.layout.dialog_choose_page, null));
            builder.setPositiveButton(getString(R.string.cancel), new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
            builder.setNegativeButton(getString(R.string.ok), new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                /*for (IPositiveButtonDialogListener listener : getPositiveButtonDialogListeners()) {
                    listener.onPositiveButtonClicked(mRequestCode);*/
                    EditText edt = (EditText) getDialog().findViewById(R.id.edt_page);
                    final int pageNumber;
                    try {
                        pageNumber = Integer.parseInt(edt.getText().toString());
                    } catch (Exception e) {
                        edt.setError(getString(R.string.emptyFieldErrorMsg));
                        return;
                    }
                    if (pageNumber >= 1 && pageNumber < 605) {
                        ViewPager mViewPager =(ViewPager)getActivity().findViewById(R.id.container);
                        mViewPager.setCurrentItem(pageNumber-1);
                        dismiss();
                    } else {
                        edt.setError(getString(R.string.notValidValueErrorMsg));
                        return;
                    }
                    //////////////////////////////////////////////////////

                }

                // }
            });
            return builder;
        }
    }
