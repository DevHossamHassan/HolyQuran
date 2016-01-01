package me.branded.hossamhassan.holyquran;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.avast.android.dialogs.fragment.SimpleDialogFragment;

/**
 * Created by HossamHassan on 12/27/2015.
 */
public class Dialog_chooseChapter extends SimpleDialogFragment {
    public static String TAG = "Hoss";

    public  void show(FragmentActivity activity) {
        new Dialog_chooseChapter().show(activity.getSupportFragmentManager(),TAG);}

        public Builder build(final Builder builder) {
            builder.setTitle("الذهاب الي جزء معين");
            builder.setView(LayoutInflater.from(getActivity()).inflate(R.layout.dialog_choose_chapter, null));
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
                    final int chapterNumber;
                    try {
                        chapterNumber = Integer.parseInt(edt.getText().toString());
                    } catch (Exception e) {
                        edt.setError(getString(R.string.emptyFieldErrorMsg));
                        return;
                    }
                    if (chapterNumber >= 1 && chapterNumber <= 30) {
                        int chapterPageNumber=((chapterNumber-1)*20)+2;
                        ViewPager mViewPager =(ViewPager)getActivity().findViewById(R.id.container);
                        mViewPager.setCurrentItem(chapterPageNumber-1);
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
