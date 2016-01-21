package me.branded.hossamhassan.holyquran;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.MultiAutoCompleteTextView;

import com.avast.android.dialogs.fragment.SimpleDialogFragment;

/**
 * Created by HossamHassan on 12/27/2015.
 */
public class Dialog_addTags extends SimpleDialogFragment {
    public static String TAG = "Hoss";
    String [] tags;
    public  void show(FragmentActivity activity,String [] tags) {
        this.tags=tags;
        new Dialog_addTags().show(activity.getSupportFragmentManager(),TAG);}

        public Builder build(final Builder builder) {
            builder.setTitle("اضافة كلمة مفتاحية");
            builder.setView(LayoutInflater.from(getActivity()).inflate(R.layout.dialog_add_tags, null));

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
                    MultiAutoCompleteTextView edt = (MultiAutoCompleteTextView) getDialog().findViewById(R.id.autoCompleteET);
                    edt.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
                    /*ArrayAdapter<String> adp=new ArrayAdapter<String>(this,
                            android.R.layout.simple_dropdown_item_1line,tags);

                    edt.setThreshold(1);
                    edt.setAdapter(adp);*/

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
                    }
                    //////////////////////////////////////////////////////

                }

                // }
            });
            return builder;
        }
    }
