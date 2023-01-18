import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.rafael.secondwearableapp.R;

/**
 * Created by rafael on 23/09/17.
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }
}
