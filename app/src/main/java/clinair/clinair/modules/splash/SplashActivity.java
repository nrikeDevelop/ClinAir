package clinair.clinair.modules.splash;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import nucleus.factory.RequiresPresenter;
import nucleus.view.NucleusActivity;
import clinair.clinair.R;
import clinair.clinair.common.Navigator;

@RequiresPresenter(SplashPresenter.class)
public class SplashActivity extends NucleusActivity<SplashPresenter> {

    Context context;
    @BindView(R.id.splash_icon)ImageView prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        context = this;
        setViews();
    }

    public void setViews(){
        setFonts();
        getPresenter().requestData(this);
    }

    public void setFonts(){

    }

    public void onSuccess(String msg){
        Navigator.startMainActivity(context);
    }

    public void onError(String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
