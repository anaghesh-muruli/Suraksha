package anaghesh.suraksha;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.View;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import agency.tango.materialintroscreen.animations.IViewTranslation;

public class IntroActivity extends MaterialIntroActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableLastSlideAlphaExitTransition(true);

        getBackButtonTranslationWrapper()
                .setEnterTranslation(new IViewTranslation() {
                    @Override
                    public void translate(View view, @FloatRange(from = 0, to = 1.0) float percentage) {
                        view.setAlpha(percentage);
                    }
                });


        addSlide(new SlideFragmentBuilder()
                        .backgroundColor(R.color.orange)
                        .buttonsColor(R.color.colorPrimary)
                        .image(R.drawable.user_friendly)
                        .title("User friendly")
                        .description("Quick and Easy")
                        .build());

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.orange)
                .buttonsColor(R.color.colorPrimary)
                .image(R.drawable.track)
                .title("Safe and secure")
                .description("Your safety is our first priority")
                .build());

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.orange)
                .buttonsColor(R.color.colorPrimary)
                .image(R.drawable.track)
                .title("Track your rides on the go")
                .description("Anywhere. Anytime.")
                .build());
    }

    @Override
    public void onFinish() {
        super.onFinish();
      startActivity(new Intent(IntroActivity.this,Login.class));
    }
}