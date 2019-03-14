# kxt-cms-android-sdk
[CMS SDK 设计文档](http://10.1.60.90:9000/index.php/%E5%A3%B0%E7%BD%91%E4%BF%A1%E4%BB%A4%E6%9B%BF%E6%8D%A2Coco%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3#.E8.AF.BE.E5.A0.82.E7.B1.BB.EF.BC.88CLASS.EF.BC.89)
# 学员发起
#### 课堂类(CLASS)
###### 签到
name：class_signin(学员端发起)

功能：学员点击签到按钮并通过信令消息通知教师和服务端匿名管理用户

发送类型：CP2M（Student to Teacher & Assistant & Anonymouse_Admin）

Request：No body

Response: N/A

---

###### 举手
name：class_hand_up（非老师发起)

功能：学员点击请求发言按钮并通过信令消息通知教师

发送类型：CP2M（No teacher to Teacher & Assistant & Anonymouse_Admin）

Request：
```
"body": {
   "classUserRole":"STUDENT" //用户课堂角色
}
```

---

###### 取消举手
消息名称：class_cancel_hand_up(非老师发起)

功能：通过信令消息通知教师

发送类型：CP2M（No teacher to Teacher & Assistant & Anonymouse_Admin）

Request：No body

Response: N/A

---

###### 结束发言
消息名称：class_end_speaking(教师端或学生自己发起)

功能：教师终止某个学生发言或发言学生自己终止

发送类型：CP2A（Teacher/Student to All）

Request：
```
"body": {
   "userId":123, //发言学生的id
}
```

---

#### 用户类
###### 发送个人基本信息
消息名称：user_basic_info(anyone发起)

功能：通过信令消息通知所有人

发送类型：CP2A（anyone to All）

Request：
```
"body":{
  "attributes":{
    "userId":"", //用户ID
    "userName":"", // 用户姓名
    "userRole":"", // 用户角色
    "classUserRole": "", //用户课堂内角色
    "loginTime":1, // 用户登录时间
    "handupTimes":1, // 用户举手次数
    "signinTimes":1 //用户签到次数
  },
  "environment": {
    "device": "pc"|"phone"|"pad",
    "os":"android"|"ios"|"windows"|"mac"|"linux",
    "osVersion":"1.0.0",
    "browser":"chrome71",浏览器类型和版本
    "appVersion":"1.0", //小阔应用版本
    "video": true|false, // true:有摄像头， false：没摄像头
    "audio": true|false, // true:有麦克风， false：没麦克风
  },
  "states":{
    "isSignedIn": true|false, //是否签过到
    "isOnline":true|false,
    "noChat":true|false, //禁言状态
    "isHandup":true|false, //是否在举手
    "speaking":"no"|"video"|"audio", // no：没有连麦发言，video：视频发言，audio：语言发言
  }
}
```

---
#### 文字交流（TEXTCHAT）
###### 发送文字消息
消息名称：textchat_send_msg(任何人发起)

功能：通过信令消息通知所有人

发送类型：CP2A（Anyone to All）

Request：
```
"body":{
  "classUserRole":"classRole",
  "userName":"user name",
  "msg":"msg"
}
```

---
#### 监管类
###### 截屏图片地址
消息名称：sys_capture_screen_url(学员发起)

功能：通过信令消息通知所有人

发送类型：CP2P（Student to 发送者）

Request：
```
"body":{
  "originalMsgId": "", // 发送截图指令的消息Id
  "imageUrl":"", //截图地址
  "classUserRole": "",
  "device": "",
  "os": ""
}
```
---
###### 认真度通知
消息名称：sys_switch_app(学员发起)

功能：当学员把小阔客户端或app切换到后台运行时或从后台切换到前台时，通过信令消息通知教师和管理员

发送类型：CP2M（Student to Teacher & Assistant & Anonymouse_Admin）

Request：
```
"body":{
  "action": "active"|"inactive", //切到前台或后台
  "activeTime": 100, //单位分钟
  "inactiveTime": 100, //单位分钟
  "classUserRole": "",
  "device": "",
  "os": ""
}
```
---