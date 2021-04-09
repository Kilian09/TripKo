package dda.es.ulpgc.kilian.garcia106.tripko;

import android.os.Bundle;

import androidx.test.runner.MonitoringInstrumentation;

import cucumber.api.CucumberOptions;
import cucumber.api.android.CucumberInstrumentationCore;
import dda.es.ulpgc.kilian.garcia106.tripko.BuildConfig;

@SuppressWarnings("unused")
@CucumberOptions(
        features = "features",
        glue = "dda.es.ulpgc.kilian.garcia106.tripko"
)
public class Instrumentation extends MonitoringInstrumentation {

    private final CucumberInstrumentationCore instrumentation =
            new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(Bundle arguments) {
        super.onCreate(arguments);

        String tags = BuildConfig.TEST_TAGS;
        if (!tags.isEmpty()) {
            arguments.putString(
                    "tags",
                    tags
                            .replaceAll(",", "--")
                            .replaceAll("\\s", "")
            );
        }

        instrumentation.create(arguments);
        start();
    }

    @Override
    public void onStart() {
        super.onStart();

        waitForIdleSync();
        instrumentation.start();
    }
}

