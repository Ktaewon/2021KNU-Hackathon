package com.beoks.a2021knu_hackton;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * 공모전 클래스
 */
public class Contest implements Serializable {
    public String contest_title;
    public String poster;
    public String end_date;
    public String content;
    public int viewCount;
    public List<Post> post;
    public String start_date;
    public Contest(){

    }
    public Contest(String contest_title, String poster, int viewCount, String end_date, String content) {
        this.contest_title = contest_title;
        this.poster = poster;
        this.viewCount = viewCount;
        this.end_date=end_date;
        this.content=content;
        this.post=new ArrayList<Post>();
    }
    public interface Listener{
        void onDataGetListener(ArrayList<Contest> contests);
    }
    public static ArrayList<Contest> getContestsFromFB(final Listener listener){

        ArrayList<Contest> arrayList=new ArrayList<Contest>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("contest_list");
        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<DataSnapshot> task) {
                if(task.isSuccessful()){
                    for(DataSnapshot dataSnapshot:task.getResult().getChildren()){
                        arrayList.add(dataSnapshot.getValue(Contest.class));
                    }
                    listener.onDataGetListener(arrayList);
                    Log.d("firebase_contest","Success");
                }
                else{
                    Log.d("firebase_contest","fail");
                }
            }
        });

        try {
            Thread.sleep(100);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
    public static Contest getSample(){
        Contest contest= new Contest("2021 오픈소스 컨트리뷰톤 아카데미",
                "https://cf.festa.io/img/2021-7-14/bd641835-97ae-4bbd-89c3-35bee0d97216.jpg",
                64,"2021.07.23",
                "2021 오픈소스 컨트리뷰션 아카데미에 참가하실 멘티를 찾습니다!\n" +
                        "\n" +
                        "\uD83D\uDCA1 오픈소스 컨트리뷰톤의 새로운 타이틀 '오픈소스 컨트리뷰션 아카데미(Contribution Academy)'\n" +
                        "\uD83D\uDCCC 선배 개발자와 함께 협업하여 4개월 간 원하는 오픈소스 프로젝트에 직접 컨트리뷰션 해보며 컨트리뷰터로 성장할 수 있는 멋진 기회!\n" +
                        "\uD83C\uDFB6 오픈소스 진입장벽이 높게만 느껴지는 개발자들을 위한 컨트리뷰션 멘토링 프로그램\n" +
                        "✨ 멘토도 한때는 멘티였다!\n" +
                        " \n" +
                        "　- '오픈소스 프로젝트에 기여한다는 것'이 무엇인지 제대로 알려드립니다.\n" +
                        "\n" +
                        "　- 즐겁고 파이팅 넘치는 컨트리뷰션 활동을 통해 다양한 방법으로 오픈소스 문화에 기여할 수 있는 기회를 제공합니다.\n" +
                        "\n" +
                        "　- 홈페이지를 통해 오픈소스 컨트리뷰션 아카데미와 컨트리뷰션 활동에 대해 더욱 자세히 확인하실 수 있으며\n" +
                        "\n" +
                        "　- 올해 기여해 볼 수 있는 25개의 프로젝트와 멘토에 대해서도 더욱 자세히 알아볼 수 있습니다.\n" +
                        "\n" +
                        "　- 오픈소스 개발문화에 직접 참여해 보고 싶은 누구나 참여 가능합니다!\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "· \u200B주최: 과학기술정보통신부\n" +
                        "\n" +
                        "· 주관: 정보통신산업진흥원\n" +
                        "\n" +
                        "· 후원: Microsoft, SK telecom, LG, LINE, kakao, Lablup, GitHub Korea\n" +
                        "\n" +
                        "· with: SK DevOcean, OpenStack Korea Group, 우분투한국커뮤니티\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "· 모집대상: 오픈소스 프로젝트 기여에 관심있는 누구나\n" +
                        "\n" +
                        "· 모집기간: 2021. 07. 05(월) ~ 2021. 07. 26(월) \n" +
                        "\n" +
                        "\u200B· 선정결과 발표: 2021. 7. 30.(금)\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "· 상세안내: https://www.oss.kr/contribution_academy\n" +
                        "\n" +
                        "· 프로젝트 소개: https://www.oss.kr/contribution_academy_project\n" +
                        "\n" +
                        "· 신청접수: https://contributionacademy.oopy.io/\n" +
                        "\n" +
                        "· 참가신청 접수 form 바로가기 url: https://qbc6zgjasnp.typeform.com/to/xXS1Znrf");
        contest.post.add(Post.getSample());
        contest.post.add(Post.getSample());
        return contest;

    }
    class DownloadImageFromURI extends AsyncTask<String, Void, Bitmap>{
        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            } catch (IOException e) {
                // Log exception
                Log.e("Contest class",e.toString());
                return null;
            }
        }
    }
    public Bitmap getImage(){
        DownloadImageFromURI downloadImageFromURI=new DownloadImageFromURI();
        try {
            return downloadImageFromURI.execute(poster).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public long getDDay(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy.MM.dd");
        Date end= null;
        try {
            end = simpleDateFormat.parse(end_date);
            Date now=new Date();
            now.setTime(now.getTime()-now.getTime()%(24*60*60*1000));
            long leftDate=(end.getTime()-now.getTime())/(24*60*60*1000)+1;
            return leftDate;
        } catch (ParseException e) {
            e.printStackTrace();
            return -100;
        }
    }

}
class User {

    public String username;
    public String email;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

}