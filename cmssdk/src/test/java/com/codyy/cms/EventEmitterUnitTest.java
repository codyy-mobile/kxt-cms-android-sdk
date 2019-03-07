package com.codyy.cms;

import com.codyy.cms.core.MessageHandler;
import com.codyy.cms.core.definition.Message;
import com.codyy.cms.core.event.EventEmitter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class EventEmitterUnitTest {
    @Test
    public void addition_isCorrect() {
        EventEmitter eventEmitter = new EventEmitter();
        eventEmitter.on("click", new EventHandler());
        eventEmitter.addListener("click", new EventHandler());
        eventEmitter.emit("click", new Message());
    }

    public class EventHandler implements MessageHandler {

        @Override
        public void handle(String msgName, Message message) {
            System.out.println("处理事件" + msgName + message.getClass().getSimpleName());
        }
    }
}