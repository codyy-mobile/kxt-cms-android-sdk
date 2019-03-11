package com.codyy.cms;

import com.codyy.cms.core.definition.Message;
import com.codyy.cms.core.definition.MessageHeader;
import com.codyy.cms.utils.CombineUtils;
import com.codyy.cms.utils.GsonUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CombineUtilsUnitTest {
    @Test
    public void addition_isCorrect() {
        Student sourceModel = new Student(); // 第一个对象
        Student targetModel = new Student(); // 第二个model对象

        sourceModel.setSex("1");
        sourceModel.setcName("张三");

        targetModel.setSex("2");
        targetModel.setcName("李四");
        targetModel.setCardName("身份证");
        targetModel.setCardNumber("222222222222222222222");

        Student student = (Student) CombineUtils.combineSydwCore(sourceModel, targetModel);
        System.out.println(student.sex + student.cName + student.cardName + student.cardNumber);
        Message message = new Message();
        message.header = new MessageHeader();
        Message<Student> message1 = new Message<>();
        message1.header = new MessageHeader();
        message1.body = targetModel;
        System.out.println(new Gson().toJson(message1));
        Message<Student> message2 = GsonUtils.json2Bean(new Gson().toJson(message1), new TypeToken<Message<Student>>() {
        }.getType());
        System.out.println(new Gson().toJson(message2));
    }

    public class Student {
        private String sex;
        private String cName;
        private String cardName;
        private String cardNumber;

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getcName() {
            return cName;
        }

        public void setcName(String cName) {
            this.cName = cName;
        }

        public String getCardName() {
            return cardName;
        }

        public void setCardName(String cardName) {
            this.cardName = cardName;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

    }
}