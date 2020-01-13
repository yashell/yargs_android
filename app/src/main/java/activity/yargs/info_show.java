package activity.yargs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class info_show extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_show);
    }
    private void backPage(View view){
       this.finish();
    }
}
