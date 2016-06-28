package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import cn.pocketwallet.pocketwallet.R;
import uk.co.senab.photoview.PhotoViewAttacher;

public class AlbumPreviewActivity extends AppCompatActivity {


    private ImageView albumPreviewImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_preview);
        albumPreviewImageView = (ImageView) findViewById(R.id.albumPreviewImageView);
        Uri uri = Uri.parse(getIntent().getStringExtra("path"));
        Picasso.with(this).load(uri).into(albumPreviewImageView, new Callback() {
            @Override
            public void onSuccess() {
                new PhotoViewAttacher(albumPreviewImageView);
            }

            @Override
            public void onError() {

            }
        });
    }

}
