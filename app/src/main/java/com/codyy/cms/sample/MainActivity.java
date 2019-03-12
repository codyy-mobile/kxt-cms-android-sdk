package com.codyy.cms.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.codyy.cms.core.CmsEngine;
import com.codyy.cms.core.CmsEngineOpts;
import com.codyy.cms.core.LoginOptions;
import com.codyy.cms.core.definition.ClassUserRole;
import com.codyy.cms.core.definition.UserRole;
import com.orhanobut.logger.Logger;

import org.jdeferred2.Deferred;
import org.jdeferred2.Promise;
import org.jdeferred2.android.AndroidDeferredManager;
import org.jdeferred2.impl.DeferredObject;

public class MainActivity extends AppCompatActivity {
    final AndroidDeferredManager dm = new AndroidDeferredManager();
    final Deferred<String, Throwable, Void> deferred = new DeferredObject<>();
    Promise<String, Throwable, Void> promise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        promise = deferred.promise();
        promise.done(result -> {

        }).fail(throwable -> {

        });
        new TestThread().start();
        CmsEngine.getInstance().init(this, new CmsEngineOpts("6ddb8bc251564e95af743486e76dc40e", "", (newState, reason) -> {
            runOnUiThread(() -> Logger.d("newState:" + newState + "reason:" + reason));
        }), 1);
        CmsEngine.getInstance().login2(new LoginOptions(108, "lijian", UserRole.STUDENT, ClassUserRole.STUDENT, BuildConfig.DEBUG))
                .done(result -> {
                    runOnUiThread(() -> {
                        Logger.d("Login Success!");
                        CmsEngine.getInstance().getMsgEngine().joinChannel2()
                                .done(result1 -> {
                                    runOnUiThread(() -> {
                                        Logger.d("Join channel success!");
                                        Toast.makeText(this, "Join channel success!", Toast.LENGTH_SHORT).show();
                                    });
                                })
                                .fail(result1 -> {
                                    runOnUiThread(() -> {
                                        Logger.e(result1, "Join channel failed! ");
                                    });
                                });
                    });

                }).fail(result -> {
            runOnUiThread(() -> {
                Logger.e(result, "Login Error");
            });

        });
    }

    private class TestThread extends Thread {
        @Override
        public void run() {
            super.run();
//            ConnectionState.CONNECTION_STATE_ABORTED;
            deferred.resolve("HelloWorld");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CmsEngine.getInstance().logout();
    }
}
