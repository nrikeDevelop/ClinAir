package clinair.clinair.common;

import android.content.Context;
import android.content.Intent;

import clinair.clinair.modules.main.MainActivity;

/**
 * Created by susy on 20/12/16.
 */

public class Navigator {

    public static void startMainActivity(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
        context.startActivity(intent);
    }

}
