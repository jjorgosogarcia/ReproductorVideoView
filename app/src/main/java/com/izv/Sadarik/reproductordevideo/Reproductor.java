package com.izv.Sadarik.reproductordevideo;

import android.app.Activity;;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.izv.reproductordevideo.R;


public class Reproductor extends Activity {

    private VideoView reproductor;
    private Uri u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_reproductor);
        reproductor=(VideoView)findViewById(R.id.video);
        Bundle bundle = getIntent().getExtras();
        if(bundle !=null ) {
            u=bundle.getParcelable("uri");
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(reproductor);
            reproductor.setMediaController(mediaController);
            reproductor.setVideoURI(u);
            reproductor.start();
        } else{}

    }

    public void play(View view){
        reproductor.start();
    }

    public void pause(View view){
        reproductor.pause();
    }


}
