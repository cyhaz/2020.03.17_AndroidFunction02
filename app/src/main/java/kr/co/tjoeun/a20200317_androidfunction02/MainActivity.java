package kr.co.tjoeun.a20200317_androidfunction02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import kr.co.tjoeun.a20200317_androidfunction02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                다른화면으로 이동 : Intent
//                => 우리가 만든게 아닌, 안드로이드가 제공하는 화면으로 이동
//                => 전화걸기 화면

//                어느 화면으로 갈지 => 안드로이드가 요구하는 양식으로 작성 : Uri

//                응용문제 : EditText에 입력한 번호로 전화걸도록
                String phoneNum = binding.phoneNumEdt.getText().toString();

                String phoneUriStr = String.format("tel:%s", phoneNum);
                Uri uri = Uri.parse(phoneUriStr);
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        binding.callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                현재까지 배운것만으로는 실행 불가 : 권한 획득 x

                Uri uri = Uri.parse("tel:01022612183");
                Intent intent = new Intent(Intent.ACTION_CALL, uri);
                startActivity(intent);
            }
        });

        binding.smsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("smsto:01022612183");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "공유 메세지 내용");
                startActivity(intent);

            }
        });

        binding.webLinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 네이버로 이동하기
                Uri uri = Uri.parse("http://www.naver.com");  // 방문할 사이트 주소
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        binding.playStoresBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 앱 광고 링크
//                Uri uri = Uri.parse();
//                Intent intent = new Intent(Intent.ACTION_, uri);
//                startActivity(intent);
            }
        });

        binding.googleMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 구글 지도 띄워보기
            }
        });
    }
}
