package com.izv.Sadarik.reproductordevideo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import com.example.izv.reproductordevideo.R;

public class Principal extends Activity {

    private final int Video = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode==RESULT_OK) {
            Uri videoSeleccionado = data.getData();
            Intent i=new Intent(this, Reproductor.class);
            i.putExtra("uri",videoSeleccionado);
            startActivity(i);
            this.finish();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent i = new Intent (Intent.ACTION_PICK, MediaStore.Video.Media.INTERNAL_CONTENT_URI);
            startActivityForResult(i, Video);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
