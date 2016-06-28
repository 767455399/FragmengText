package cn.pocketwallet.pocketwallet.ui.activity.common;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import cn.pocketwallet.pocketwallet.R;
import cn.pocketwallet.pocketwallet.base.BaseActivity;
import cn.pocketwallet.pocketwallet.model.AlbumModel;
import cn.pocketwallet.pocketwallet.util.album.AlbumCallback;
import cn.pocketwallet.pocketwallet.util.album.AlbumGridAdapter;
import cn.pocketwallet.pocketwallet.util.album.AlbumIntentUtil;
import cn.pocketwallet.pocketwallet.util.album.AlbumListAdapter;
import cn.pocketwallet.pocketwallet.util.album.AlbumMediaScanner;
import cn.pocketwallet.pocketwallet.util.album.AlbumSpacesItemDecoration;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AlbumActivity extends BaseActivity {


    private static final int SPAN_COUNT = 3;
    private static final String DIRECTORY_TYPE = Environment.DIRECTORY_PICTURES;
    private static final String CAMERA_FILE_NAME = "camera_pic.jpg";
    private static final String CROP_FILE_NAME = "crop_pic.jpg";

    private RecyclerView albumGridRecyclerView;
    private RecyclerView albumListRecyclerView;
    private Button albumListButton;


    private boolean enableCamera = false;
    private boolean enableCrop = false;
    private boolean enablePreview = false;
    private int maxChoice = 1;

    private String currentAlbumId = AlbumMediaScanner.ALBUM_ID_ALL_PHOTOS;

    private Uri cameraOutPutUri = null;
    private Uri cropOutPutUri = null;
    private Uri currentPreviewUri = null;
    private ArrayList<AlbumModel> albums = new ArrayList<>();
    private ArrayList<Uri> photos = new ArrayList<>();
    private ArrayList<String> selectedPhotos = new ArrayList<>();
    private AlbumGridAdapter albumGridAdapter;
    private AlbumListAdapter albumListAdapter;


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_album);
        Intent intent = getIntent();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(intent.getStringExtra("title"));
        }
        enableCamera = intent.getBooleanExtra("enableCamera", false);
        enablePreview = intent.getBooleanExtra("enablePreview", false);
        enableCrop = intent.getBooleanExtra("enableCrop", false);
        maxChoice = intent.getIntExtra("maxLimit", 1);
        albumGridRecyclerView = (RecyclerView) findViewById(R.id.albumGridRecyclerView);
        albumListRecyclerView = (RecyclerView) findViewById(R.id.albumListRecyclerView);
        albumListButton = (Button) findViewById(R.id.albumListButton);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        albumListRecyclerView.setLayoutManager(linearLayoutManager);
        albumGridRecyclerView.setLayoutManager(new GridLayoutManager(this, SPAN_COUNT));
        albumGridRecyclerView.addItemDecoration(new AlbumSpacesItemDecoration(2));
    }


    @Override
    protected void loadData() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int mScreenWidth = dm.widthPixels;
        int itemWith = mScreenWidth / 3;
        albumGridAdapter = new AlbumGridAdapter(cn.pocketwallet.pocketwallet.ui.activity.common.AlbumActivity.this, photos, gridClickListener, itemWith, enableCamera);
        albumListAdapter = new AlbumListAdapter(cn.pocketwallet.pocketwallet.ui.activity.common.AlbumActivity.this, albums, listClickListener);
        albumGridRecyclerView.setAdapter(albumGridAdapter);
        albumListRecyclerView.setAdapter(albumListAdapter);
        loadAlbumPhotos(AlbumMediaScanner.ALBUM_ID_ALL_PHOTOS);
        loadAlbumList();
    }

    @Override
    protected void setListeners() {
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (albumListRecyclerView.getVisibility() == View.VISIBLE) {
                    albumListRecyclerView.setVisibility(View.GONE);
                } else {
                    setResult(AlbumIntentUtil.RESULT_CANCEL);
                    cn.pocketwallet.pocketwallet.ui.activity.common.AlbumActivity.this.finish();
                }
            }
        });
        albumListButton.setOnClickListener(listener);
    }


    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.albumListButton) {
                if (albums.size() > 0) {
                    if (albumListRecyclerView.getVisibility() == View.VISIBLE) {
                        albumListRecyclerView.setVisibility(View.GONE);
                    } else {
                        albumListRecyclerView.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    };


    private void loadAlbumPhotos(final String albumId) {
        final ProgressDialog progressDialog = new ProgressDialog(cn.pocketwallet.pocketwallet.ui.activity.common.AlbumActivity.this);
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.setCancelable(false);
        progressDialog.show();
        Observable.create(new Observable.OnSubscribe<Void>() {
            @Override
            public void call(Subscriber<? super Void> subscriber) {
                photos.clear();
                if (albumId.equals(AlbumMediaScanner.ALBUM_ID_ALL_PHOTOS)) {
                    photos.addAll(AlbumMediaScanner.getAllPhotos(cn.pocketwallet.pocketwallet.ui.activity.common.AlbumActivity.this));
                } else {
                    photos.addAll(AlbumMediaScanner.getPhotosByAlbumId(cn.pocketwallet.pocketwallet.ui.activity.common.AlbumActivity.this, albumId));
                }
                subscriber.onNext(null);
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Void>() {
                    @Override
                    public void onCompleted() {
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onNext(Void v) {
                        albumGridAdapter.notifyDataSetChanged();
                    }
                });
    }


    private void loadAlbumList() {
        Observable.create(new Observable.OnSubscribe<Void>() {
            @Override
            public void call(Subscriber<? super Void> subscriber) {
                albums.clear();
                albums.addAll(AlbumMediaScanner.getAllAlbums(cn.pocketwallet.pocketwallet.ui.activity.common.AlbumActivity.this));
                subscriber.onNext(null);
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Void>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Void v) {
                        albumListAdapter.notifyDataSetChanged();
                    }
                });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == AlbumIntentUtil.REQUEST_CODE_CAMERA) {
                scanFile(cameraOutPutUri);
                if (enableCrop) {
                    cropOutPutUri = Uri
                            .fromFile(Environment.getExternalStoragePublicDirectory(DIRECTORY_TYPE))
                            .buildUpon()
                            .appendPath(System.currentTimeMillis() + "_" + CROP_FILE_NAME)
                            .build();
                    AlbumIntentUtil.startCropActivityForResult(cn.pocketwallet.pocketwallet.ui.activity.common.AlbumActivity.this, cameraOutPutUri, cropOutPutUri);
                }
            }
            if (requestCode == AlbumIntentUtil.REQUEST_CODE_PREVIEW) {
                if (currentPreviewUri != null) {
                    if (enableCrop) {
                        cropOutPutUri = Uri
                                .fromFile(Environment.getExternalStoragePublicDirectory(DIRECTORY_TYPE))
                                .buildUpon()
                                .appendPath(System.currentTimeMillis() + "_" + CROP_FILE_NAME)
                                .build();
                        AlbumIntentUtil.startCropActivityForResult(cn.pocketwallet.pocketwallet.ui.activity.common.AlbumActivity.this, currentPreviewUri, cropOutPutUri);
                    }
                }
            }
            if (requestCode == AlbumIntentUtil.REQUEST_CODE_CROP) {
                if (maxChoice == 1) {
                    selectedPhotos.clear();
                    selectedPhotos.add(cropOutPutUri.getPath());
                    Intent intent = new Intent();
                    intent.putStringArrayListExtra("selectedPhotos", selectedPhotos);
                    setResult(AlbumIntentUtil.RESULT_OK, intent);
                    finish();
                }
            }
        }
    }


    private void scanFile(Uri scanUri) {
        AlbumMediaScanner.scanFile(cn.pocketwallet.pocketwallet.ui.activity.common.AlbumActivity.this, scanUri, new AlbumCallback<String>() {
            @Override
            public void onCompleted(String object) {
                loadAlbumPhotos(AlbumMediaScanner.ALBUM_ID_ALL_PHOTOS);
            }

            @Override
            public void onFailed(String str) {

            }
        });
    }


    private AlbumGridAdapter.OnItemClickListener gridClickListener = new AlbumGridAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(Uri uri, int position) {
            if (enableCamera && position == 0) {
                cameraOutPutUri = Uri
                        .fromFile(Environment.getExternalStoragePublicDirectory(DIRECTORY_TYPE))
                        .buildUpon()
                        .appendPath(System.currentTimeMillis() + "_" + CAMERA_FILE_NAME)
                        .build();
                AlbumIntentUtil.startCameraActivityForResult(cn.pocketwallet.pocketwallet.ui.activity.common.AlbumActivity.this, cameraOutPutUri);
            } else {
                if (maxChoice == 1) {
                    if (enableCrop) {
                        cropOutPutUri = Uri
                                .fromFile(Environment.getExternalStoragePublicDirectory(DIRECTORY_TYPE))
                                .buildUpon()
                                .appendPath(System.currentTimeMillis() + "_" + CROP_FILE_NAME)
                                .build();
                        AlbumIntentUtil.startCropActivityForResult(cn.pocketwallet.pocketwallet.ui.activity.common.AlbumActivity.this, uri, cropOutPutUri);
                    } else {
                        selectedPhotos.clear();
                        selectedPhotos.add(uri.getPath());
                        Intent intent = new Intent();
                        intent.putStringArrayListExtra("selectedPhotos", selectedPhotos);
                        setResult(AlbumIntentUtil.RESULT_OK, intent);
                        finish();
                    }

                }
            }
        }
    };

    private AlbumListAdapter.OnItemClickListener listClickListener = new AlbumListAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(String albumId, String albumName, int position) {
            if (!albumId.equals(currentAlbumId)) {
                currentAlbumId = albumId;
                albumListButton.setText(albumName);
                loadAlbumPhotos(albumId);
            }
            albumListRecyclerView.setVisibility(View.GONE);
        }
    };

    @Override
    public void onBackPressed() {
        if (albumListRecyclerView.getVisibility() == View.VISIBLE) {
            albumListRecyclerView.setVisibility(View.GONE);
        } else {
            setResult(AlbumIntentUtil.RESULT_CANCEL);
            super.onBackPressed();
        }
    }
}
