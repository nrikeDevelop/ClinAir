package project.baseproject.modules.splash;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

import com.koushikdutta.ion.Ion;

import butterknife.BindView;
import nucleus.factory.RequiresPresenter;
import nucleus.view.NucleusActivity;
import project.baseproject.R;
import project.baseproject.common.Navigator;

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
