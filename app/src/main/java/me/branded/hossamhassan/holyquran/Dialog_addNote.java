package me.branded.hossamhassan.holyquran;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.avast.android.dialogs.fragment.SimpleDialogFragment;

import me.branded.hossamhassan.holyquran.Utils.HossDBManager;
import me.branded.hossamhassan.holyquran.Utils.Notes;

/**
 * Created by HossamHassan on 12/27/2015.
 */
public class Dialog_addNote extends SimpleDialogFragment {
    public static String TAG = "Hoss";
    HossDBManager dbManager;
    int currentPN;
    Notes note;
    public  void show(FragmentActivity activity,int currentPN) {
        this.currentPN=currentPN;
        new Dialog_addNote().show(activity.getSupportFragmentManager(),TAG);}

        public Builder build(final Builder builder) {
            builder.setTitle("اضافة ملاحظة جديدة");
            builder.setView(LayoutInflater.from(getActivity()).inflate(R.layout.dialog_add_note, null));
            dbManager =new HossDBManager(getActivity(),null,null,1);
            note=new Notes();
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
                    EditText edt = (EditText) getDialog().findViewById(R.id.edt_add);
                    final String not;
                    not = edt.getText().toString();
                    if (not.isEmpty() || not.length() < 17) {
                        if (not.isEmpty()) {
                            edt.setError(getString(R.string.emptyFieldErrorMsg));
                        } else {
                            edt.setError("نص الملاحظة قصير جداً!");
                        }

                    } else {
                        note.setTitle(not.substring(0, 15) + "...");
                        note.setDescription(not);
                        note.setPageNum(currentPN);
                        dbManager.addNote(note);
                        dismiss();


                    }
                    //////////////////////////////////////////////////////

                }

                // }
            });
            return builder;
        }
    }
