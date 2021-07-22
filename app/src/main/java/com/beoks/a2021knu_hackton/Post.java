package com.beoks.a2021knu_hackton;

import java.io.Serializable;
public class Post implements Serializable {
    public String title;
    public String content;
    public String writer;
    public String date;
    public String link;
    public int max_count;
    public String timeplace;
    public boolean isRecruit;
    public Post(){

    }
    public Post(String title, String content, String date, String link, int max_count, String timeplace, String writer) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.link = link;
        this.max_count = max_count;
        this.timeplace = timeplace;
        this.writer=writer;
        this.isRecruit=true;
    }

    public static Post getSample() {
        return new Post("대구팀원 모집합니다",
                "플로팅 작업 버튼(FAB)은 앱 UI의 기본 작업을 트리거하는 원형 버튼입니다. 이 페이지에서는 FAB를 레이아웃에 추가하고, 모양을 맞춤설정하며, 버튼 탭에 응답하는 방법을 보여줍니다.",
                "2021.07.19",
                "https://open.kakao.com/ffff",
                5,
                "일주일에 2번 팀원들과 협의 후 결정, 쪽문 카페 등",
                "ljs");
    }
}
