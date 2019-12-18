package com.aloogn.demo.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.aloogn.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性动画可以看作是增强版的补间动画，与补间动画的不同之处体现在：

 补间动画只能定义两个关键帧在透明、旋转、位移和倾斜这四个属性的变换，但是属性动画可以定义任何属性的变化。
 补间动画只能对 UI 组件执行动画，但属性动画可以对任何对象执行动画。
 与补间动画类似的是，属性动画也需要定义几个方面的属性：

 动画持续时间。默认为 300ms，可以通过 android:duration 属性指定。
 动画插值方式。通过 android:interploator 指定。
 动画重复次数。通过 android:repeatCount 指定。
 重复行为。通过 android:repeatMode 指定。
 动画集。在属性资源文件中通过 <set .../> 来组合。
 帧刷新率。指定多长时间播放一帧。默认为 10 ms。
 属性动画 API
 Animator: 提供创建属性动画的基类，基本不会直接使用这个类。
 ValueAnimator:属性动画用到的主要的时间引擎，负责计算各个帧的属性值。
 ObjectAnimator： ValueAnimator 的子类，对指定对象的属性执行动画。
 AnimatorSet：Animator 的子类，用于组合多个 Animator。
 除了这些 API,属性动画还提供了一个 Evaluator ，用来控制属性动画如何计算属性值。

 IntEvaluator:计算 int 类型属性值的计算器。
 FloatEvaluator: 用于计算 float 类型属性值的计算器。
 ArgbEvaluator: 用于计算十六进制形式表示的颜色值的计算器。
 TypeEvaluator: 可以自定义计算器。
 使用 ValueAnimator 创建动画的步骤：
 调用 ValueAnimator 的 ofInt()、ofFloat() 或者 ofObject() 静态方法创建 ValueAnimator 实例。
 调用 ValueAnimator 的 setXxx() 等方法设置持续时间，插值方式、重复次数等。
 调用 ValueAnimator 的 start() 方法启动动画。
 为 ValueAnimator 注册 AnimatorUpdateListener 监听器，在该监听器中可以监听 ValueAnimator 计算出来的值改变，并将这些值应用到指定对象上。
 属性动画的一般使用：
 定义属性动画和补间动画等类似，有两种方式：

 使用 ValueAnimator 或者 ObjectAnimator 的静态工厂方法创建动画。
 使用资源文件来定义动画。
 属性动画的使用：

 创建 ValueAnimator 或 ObjectAnimator 对象 —— 即可以从 XML 资源文件加载该动画也可以直接调用 ValueAnimator 或者 ObjectAnimator 的静态工厂方法创建动画。
 根据需要为 Animator 对象设置属性。
 如果需要监听 Animator 的动画开始事件，动画结束事件、动画重复事件、动画值改变事件，并根据事件提供响应处理代码，需要为Animator 对象设置监听器。
 如果有多个动画需要同时播放，需要使用 AnimatorSet 组合这些动画。
 调用 Animator 对象的 start 启动动画。
 */
public class PropertyActivity extends AppCompatActivity implements View.OnClickListener{

    private int[] mRes = {
            R.id.imageView_a, R.id.imageView_b, R.id.imageView_c,
            R.id.imageView_d, R.id.imageView_e
    };
    private List<ImageView> mImageViews = new ArrayList<>();
    private boolean mFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);

        int sum = mRes.length;
        for (int i = 0; i < sum; i++) {
            ImageView imageView = (ImageView) findViewById(mRes[i]);
            imageView.setOnClickListener(this);
            mImageViews.add(imageView);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView_a:
                if (mFlag) {
                    startAnim();
                } else {
                    closeAnim();
                }
                break;
            case R.id.imageView_b:
                Toast.makeText(this, "b", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView_c:
                Toast.makeText(this, "c", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView_d:
                Toast.makeText(this, "d", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView_e:
                Toast.makeText(this, "e", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void closeAnim() {
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(mImageViews.get(0),
                "alpha", 0.5F, 1F);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mImageViews.get(1),
                "translationY", 200F, 0);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImageViews.get(2),
                "translationX", 200F, 0);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mImageViews.get(3),
                "translationY", -200F, 0);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(mImageViews.get(4),
                "translationX", -200F, 0);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(animator0, animator1, animator2, animator3, animator4);
        set.start();
        mFlag = true;
    }

    private void startAnim() {
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(
                mImageViews.get(0),
                "alpha",
                1F,
                0.5F);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                mImageViews.get(1),
                "translationY",
                200F);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                mImageViews.get(2),
                "translationX",
                200F);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(
                mImageViews.get(3),
                "translationY",
                -200F);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(
                mImageViews.get(4),
                "translationX",
                -200F);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(
                animator0,
                animator1,
                animator2,
                animator3,
                animator4);
        set.start();
        mFlag = false;
    }
}
