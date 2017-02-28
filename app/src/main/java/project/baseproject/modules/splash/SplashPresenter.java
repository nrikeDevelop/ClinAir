package project.baseproject.modules.splash;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;

import nucleus.presenter.Presenter;
import project.baseproject.common.Navigator;
import project.baseproject.common.Preferences;
import project.baseproject.model.Estautomaticas.A1;
import project.baseproject.model.Estautomaticas.A4;
import project.baseproject.model.Operations.A1Operations;
import project.baseproject.model.Operations.A3Operations;
import project.baseproject.model.Operations.A4Operations;
import project.baseproject.model.Operations.A5Operations;
import project.baseproject.model.Operations.A6Operations;
import project.baseproject.model.Estautomaticas.A7;
import project.baseproject.model.Operations.A7Operations;

/**
 * Created by susy on 20/12/16.
 */

public class SplashPresenter extends Presenter<SplashActivity> {

    private String TAG="SplashPresenter";
    private int TIME_TO_START;


    public void requestData(final Context context){
        if(!Preferences.getDataRequest(context)) {
            TIME_TO_START = 5000;
            requestAllData(context);
        }else TIME_TO_START = 2000;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (isRequestDataOk(context)){
                    getView().onSuccess("onSucces true");
                }else{
                    getView().onError("onSucces false");
                }

            }
        }, TIME_TO_START);
    }

    private boolean isRequestDataOk(Context contex){
        boolean isDataRequestOk = true;

        ArrayList<Boolean> requestData = new ArrayList<>();

        if(Preferences.getA1List(contex) != null) requestData.add(true); else requestData.add(false);
        if(Preferences.getA3List(contex) != null) requestData.add(true); else requestData.add(false);
        if(Preferences.getA4List(contex) != null) requestData.add(true); else requestData.add(false);
        if(Preferences.getA5List(contex) != null) requestData.add(true); else requestData.add(false);
        if(Preferences.getA6List(contex) != null) requestData.add(true); else requestData.add(false);
        if(Preferences.getA7List(contex) != null) requestData.add(true); else requestData.add(false);

        for (int i = 0 ; i < requestData.size(); i++){
            if(!requestData.get(i)){
                System.out.println(">>"+requestData.get(i));
                isDataRequestOk=false;
                break;
            }
        }

        return isDataRequestOk;

    }

    private void requestAllData(Context context){
        A7Operations.getData(context);
        A6Operations.getData(context);
        A5Operations.getData(context);
        A1Operations.getData(context);
        A4Operations.getData(context);
        A3Operations.getData(context);
        Preferences.setDataRequest(context,true);
    }
}
