package project.baseproject.modules.main;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nucleus.factory.RequiresPresenter;
import nucleus.view.NucleusActivity;
import project.baseproject.R;
import project.baseproject.common.Preferences;
import project.baseproject.model.Estautomaticas.A1;
import project.baseproject.model.Estautomaticas.A5;
import project.baseproject.modules.FragmentData;
import project.baseproject.modules.FragmentBase;

@RequiresPresenter(MainPresenter.class)
public class MainActivity extends NucleusActivity<MainPresenter>{

    Place ubication;
    String DATE_SEARCH = "01/01/2016";
    int TYPE_SERCH = 2;

    FragmentManager manager;
    FragmentTransaction transaction;

    PlaceAutocompleteFragment autocompleteFragment;
    Context context;

    String nearSensor;

    @BindView(R.id.main_loading)
    RelativeLayout mainLoading;

    @BindView(R.id.main_splash)
    LinearLayout mainSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = this;
        setViews();
    }

    @OnClick(R.id.main_button_day)
    public void onClickButtonDay(){
        if (ubication != null){
            TYPE_SERCH = 0;
            mainLoading.setVisibility(View.VISIBLE);
            actionSearch();
        }else{
            Toast.makeText(context, getResources().getString(R.string.toast_empty_ubication), Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.main_button_month)
    public void onClickButtonMonth(){
        if (ubication != null){
            TYPE_SERCH = 1;
            mainLoading.setVisibility(View.VISIBLE);
            actionSearch();
        }else{
            Toast.makeText(context, getResources().getString(R.string.toast_empty_ubication), Toast.LENGTH_SHORT).show();
        }
    }


    @OnClick(R.id.main_button_year)
    public void onClickButtonYear(){
        if (ubication != null){
            TYPE_SERCH = 2;
            mainLoading.setVisibility(View.VISIBLE);
            actionSearch();
        }else{
            Toast.makeText(context, getResources().getString(R.string.toast_empty_ubication), Toast.LENGTH_SHORT).show();
        }
    }


    @BindView(R.id.dd)TextView searchText;

    @OnClick(R.id.main_search_button)
    public void onCLickSearchButton(){

        if (ubication != null){
            TYPE_SERCH = 2;
            LayoutInflater inflater = this.getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.alert_dialog_search, null);

            final DatePicker datePicker = (DatePicker) dialogView.findViewById(R.id.aler_dialog_date_picker);
            datePicker.updateDate(2015,1,1);
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setView(dialogView);
            alertDialogBuilder
                    .setNegativeButton("Cancelar",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            dialog.cancel();
                        }
                    });
            alertDialogBuilder.setPositiveButton("Buscar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    String year = String.valueOf(datePicker.getYear());
                    String month;
                    if(datePicker.getMonth() < 10){
                        month = "0"+ String.valueOf(datePicker.getMonth());
                    }else {
                        month = String.valueOf(datePicker.getMonth());
                    }
                    String day;
                    if(datePicker.getDayOfMonth() < 10){
                        day = "0"+datePicker.getDayOfMonth();
                    }else {
                        day = String.valueOf(datePicker.getDayOfMonth());
                    }

                    String date = day+"/"+month+"/"+year;
                    DATE_SEARCH = date;
                    searchText.setText(date);
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }else{
            Toast.makeText(context, getResources().getString(R.string.toast_empty_ubication), Toast.LENGTH_SHORT).show();
        }

    }

    public void setError(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        finish();
    }

    public void setViews(){
        setFonts();
        //Views
        autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
                .setTypeFilter(AutocompleteFilter.TYPE_FILTER_ADDRESS)
                .build();
        autocompleteFragment.setFilter(typeFilter);
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                System.out.println("place guardado");
                Preferences.setLastQuery(context,place.getName().toString());
                ubication = place;
            }

            @Override
            public void onError(Status status) {
                Log.i("error","MAIN_ACTIVITY > error connection API filure :"+status.getStatusMessage());

            }
        });
    }

    public void actionSearch(){
        mainSplash.setVisibility(View.GONE);
        //Todo calculate
        nearSensor = getPresenter().getNearSensor(context,ubication);
        getPresenter().requestData(nearSensor,context, DATE_SEARCH);
    }

    public void onSuccess(ArrayList<?> nearSensorList){
        manager = getFragmentManager();
        transaction = manager.beginTransaction();

        Fragment fragment=null;

        fragment = new FragmentData(nearSensorList, TYPE_SERCH, nearSensor);

        transaction.replace(R.id.fragment, fragment);
        transaction.commit();
        mainLoading.setVisibility(View.GONE);
    }


    public void setFonts(){
        Typeface mavenpro_bold = Typeface.createFromAsset(getAssets(),"MavenPro-Bold.ttf");

    }




}
