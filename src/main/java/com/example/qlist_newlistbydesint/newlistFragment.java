package com.example.qlist_newlistbydesint;

import android.app.DatePickerDialog;
import android.os.Bundle;
import java.util.Calendar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link newlistFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class newlistFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText eDate;
    DatePickerDialog.OnDateSetListener setListener;

    public newlistFragment()
    {

            }




    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment newlistFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static newlistFragment newInstance(String param1, String param2) {
        newlistFragment fragment = new newlistFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_newlist, container, false);




    }















     @Override
     public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstance)
   {
        eDate = view.findViewById(R.id.dte);
      Calendar calendar =Calendar.getInstance();
      final int year = calendar.get(Calendar.YEAR);
      final int month = calendar.get(Calendar.MONTH);
     final int day = calendar.get(Calendar.DAY_OF_MONTH);


       setListener =new DatePickerDialog.OnDateSetListener() {
         @Override
         public void onDateSet(DatePicker view, int year, int month, int dayOfmonth) {
          month =month+1;
         String date =dayOfmonth+"/"+month+"/"+year;
        }
  };


        eDate.setOnClickListener(new View.OnClickListener() {
         @Override
          public void  onClick (View view){
               DatePickerDialog datePickerDialog =new DatePickerDialog(
                    getActivity() , new DatePickerDialog.OnDateSetListener() {
               @Override
                 public void onDateSet(DatePicker view, int year, int month, int day) {
                     month = month+1;
                     String date =day+"/"+month+"/"+year;
                      eDate.setText(date);
                    }
          },year,month,day);
          datePickerDialog.show();


   }


});





 }

}








