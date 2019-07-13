package bwie.com.basemvp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

public class Main2Activity extends AppCompatActivity {
    private SimpleDraweeView sldv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        sldv = findViewById(R.id.sldv);
        sldv.setImageURI(Uri.parse("https://uploadbeta.com/api/pictures/random/?key=%E7%90%83"));
    }
}
