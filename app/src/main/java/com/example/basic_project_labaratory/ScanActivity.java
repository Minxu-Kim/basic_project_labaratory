package com.example.basic_project_labaratory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.graphics.Bitmap;

import android.content.Intent;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScanActivity extends AppCompatActivity {

    final private static String TAG = "태그명";
    final static int TAKE_PICTURE = 1;
    // 경로 변수와 요청변수 생성
    String mCurrentPhotoPath;
    final static int REQUEST_TAKE_PHOTO = 1;

    private Button btnCapture;
    private ImageView imgCapture;
    //private static final int Image_Capture_Code = 1;
    //변수 선언, 카메라 실행
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prforscan);
        btnCapture =(Button)findViewById(R.id.btnTakePicture);
        imgCapture = (ImageView) findViewById(R.id.capturedImage);
        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cInt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cInt,Image_Capture_Code); //결과값 전달? 사진 전달 메소드? 실행이 잘 안되는 건지?
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Image_Capture_Code) {
            if (resultCode == RESULT_OK) {
                Bitmap bp = (Bitmap) data.getExtras().get("data");
                bp = RotateBitmap(bp, 90);
                int cx = 128, cy = 128;
                bp = Bitmap.createScaledBitmap(bp, cx, cy, false);
                int[] pixels = new int[cx * cy];
                bp.getPixels(pixels, 0, cx, 0, 0, cx, cy);

                ByteBuffer input_img = getInputImage_2(pixels, cx, cy);
                Interpreter tf_lite = getTfliteInterpreter("cats_and_dogs.tflite");

                float[][] pred = new float[1][2];
                tf_lite.run(input_img, pred);

                final String predText = String.format("%f", pred[0][0]) + String.format("%f", pred[0][1]);
                if (pred[0][0] > pred[0][1]) {
                    Toast toast = Toast.makeText(getApplicationContext(), String.format("고양이 확률 : %f", pred[0][0]), Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), String.format("강아지 확률 : %f", pred[0][1]), Toast.LENGTH_LONG);
                    toast.show();
                }

                Log.d("prediction", predText);

                imgCapture.setImageBitmap(bp);


            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            }
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        imgCapture = findViewById(R.id.capturedImage);
        btnCapture = findViewById(R.id.btnTakePicture);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(checkSelfPermission(Manifest.permission.CAMERA)
                    == PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "권한 설정 완료");
            } else {
                Log.d(TAG, "권한 설정 요청");
                ActivityCompat.requestPermissions(ScanActivity.this, new String[]
                        {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnTakePicture:
                        dispatchTakePictureIntent();
                        break;
                }
            }
        });
    }

    // 권한 요청
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG, "onRequestPermissionsResult");
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED ) {
            Log.d(TAG, "Permission: " + permissions[0] + "was " + grantResults[0]);
        }
    }

    // 카메라로 촬영한 영상을 가져오는 부분
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        try {
            switch (requestCode) {
                case REQUEST_TAKE_PHOTO: {
                    if (resultCode == RESULT_OK) {
                        File file = new File(mCurrentPhotoPath);
                        Bitmap bitmap;
                        if (Build.VERSION.SDK_INT >= 29) {
                            ImageDecoder.Source source = ImageDecoder.createSource(getContentResolver(), Uri.fromFile(file));
                            try {
                                bitmap = ImageDecoder.decodeBitmap(source);
                                if (bitmap != null) { imgCapture.setImageBitmap(bitmap); }
                            } catch (IOException e) { e.printStackTrace(); }
                        } else {
                            try { bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(file));
                                if (bitmap != null) { imgCapture.setImageBitmap(bitmap); }
                            } catch (IOException e) { e.printStackTrace(); }
                        }
                    }
                    break;
                }
            }
        } catch (Exception error) { error.printStackTrace(); }
    }

    // 사진 촬영 후 이미지를 파일로 저장
    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile( imageFileName, ".jpg", storageDir );
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    // 카메라 인텐트 실행하는 부분
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
        if(takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try { photoFile = createImageFile();
            } catch (IOException ex) { }
            if(photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this, "com.example.basic_project_labaratory.fileprovider", photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
            }
        }
    }


    //출처: https://ebbnflow.tistory.com/177 [삶은 확률의 구름]


    /*
    public static Bitmap RotateBitmap(Bitmap source, float angle)
    {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        Bitmap temp = Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
        temp = ThumbnailUtils.extractThumbnail(temp, 1080, 1080);

        return temp;
    }
    // 다루기 편한 1차원 배열 사용
    private ByteBuffer getInputImage_2(int[] pixels, int cx, int cy) {
        ByteBuffer input_img = ByteBuffer.allocateDirect(cx * cy * 3 * 4);
        input_img.order(ByteOrder.nativeOrder());

        for (int i = 0; i < cx * cy; i++) {
            int pixel = pixels[i];        // ARGB : ff4e2a2a

            input_img.putFloat(((pixel >> 16) & 0xff) / (float) 255);
            input_img.putFloat(((pixel >> 8) & 0xff) / (float) 255);
            input_img.putFloat(((pixel >> 0) & 0xff) / (float) 255);
        }

        return input_img;
    }


    // 모델 파일 인터프리터를 생성하는 공통 함수
    // loadModelFile 함수에 예외가 포함되어 있기 때문에 반드시 try, catch 블록이 필요하다.
    private Interpreter getTfliteInterpreter(String modelPath) {
        try {
            return new Interpreter(loadModelFile(PrepareScanActivity.this, modelPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 모델을 읽어오는 함수로, 텐서플로 라이트 홈페이지에 있다.
    // MappedByteBuffer 바이트 버퍼를 Interpreter 객체에 전달하면 모델 해석을 할 수 있다.
    private MappedByteBuffer loadModelFile(Activity activity, String modelPath) throws IOException {
        AssetFileDescriptor fileDescriptor = activity.getAssets().openFd(modelPath);
        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }*/


}