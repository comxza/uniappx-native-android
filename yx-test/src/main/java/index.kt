@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME")
package uts.sdk.modules.yxTest;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.uts.*;
import io.dcloud.uts.Map;
import io.dcloud.uts.Set;
import io.dcloud.uts.UTSAndroid;
import kotlin.Any;
import kotlin.Int;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
import uts.sdk.modules.yxTest.R;
open class LoginListener : Activity, IUiListener {
    open var mTencent: Tencent? = null;
    constructor() : super() {
        Tencent.setIsPermissionGranted(true, Build.MODEL);
        this.mTencent = Tencent.createInstance("1106089718", UTSAndroid.getUniActivity()!!, "uts.sdk.modules.yxTest.fileprovider");
    }
    override fun onComplete(response: Any): Unit {
        console.log(response, " at uni_modules/yx-test/utssdk/app-android/src/QQ.uts:22");
    }
    override fun onCancel(): Unit {
        console.log("onCancel", " at uni_modules/yx-test/utssdk/app-android/src/QQ.uts:25");
    }
    override fun onError(_param0: UiError): Unit {
        console.log(_param0, " at uni_modules/yx-test/utssdk/app-android/src/QQ.uts:28");
        console.log("onError", " at uni_modules/yx-test/utssdk/app-android/src/QQ.uts:29");
    }
    override fun onWarning(_param0: Int): Unit {
        console.log(_param0, " at uni_modules/yx-test/utssdk/app-android/src/QQ.uts:32");
        console.log("onWarning", " at uni_modules/yx-test/utssdk/app-android/src/QQ.uts:33");
    }
}
open class QQ : Activity {
    open var mTencent: Tencent? = null;
    constructor() : super() {
        Tencent.setIsPermissionGranted(true, Build.MODEL);
        this.mTencent = Tencent.createInstance("1106089718", UTSAndroid.getUniActivity()!!, "uts.sdk.modules.yxTest.fileprovider");
    }
    open fun register() {
        UTSAndroid.onAppActivityResult(fun(requestCode: Int, resultCode: Int, data: Intent?){
            Tencent.onActivityResultData(requestCode, resultCode, data, LoginListener());
            console.log("onAppActivityResult", " at uni_modules/yx-test/utssdk/app-android/src/QQ.uts:55");
        }
        );
        console.log("this.mTencent", this.mTencent, " at uni_modules/yx-test/utssdk/app-android/src/QQ.uts:57");
        if (!this.mTencent!!.isSessionValid()) {
            this.mTencent!!.login(UTSAndroid.getUniActivity()!!, "get_simple_userinfo", LoginListener());
        }
    }
}
var qq = QQ();
val register = fun() {
    console.log(qq, " at uni_modules/yx-test/utssdk/app-android/index.uts:11");
    qq.register();
}
;
fun test(): Unit {
    console.log("test111", " at uni_modules/yx-test/utssdk/app-android/index.uts:17");
}
