package com.beoks.a2021knu_hackton.InfoBoard

import java.io.Serializable

class InfoData(var title: String, var date: String, var description: String, var kind: String,var openChat: String) : Serializable {
    companion object {
        val sample: InfoData
            get() = InfoData("프로젝트 협업 툴 모음",
                    "2021.07.23",
                    """예시 프로젝트나 스터디 할 때, 활용해보세요!

 1. Github
https://github.com/

 2. Slack
https://slack.com/intl/ko-kr/

 3. Trello
https://trello.com/

 4. 네이버 웍스
https://naver.worksmobile.com/""",
                    "스터디","https://open.kakao.com/ffff")
    }
}