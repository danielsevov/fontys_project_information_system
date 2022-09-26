package utils;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This test condition disables all GUI tests if either of the following conditions is met:
 * <li><code>NO_GUI</code> is set to TRUE as system property</li>
 * <li><code>NO_GUI</code> is set to TRUE as environment variable</li>
 * <li><code>disableGuiTests</code> is set to TRUE in the project root folder</li>
 *
 * @author Nils Theres {@code n.theres@student.fontys.nl}
 */
public class GuiTestCondition implements ExecutionCondition {
    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {
        // Fast path.
        var envSet = System.getenv().get("NO_GUI");
        if ("true".equalsIgnoreCase(envSet) || "true".equalsIgnoreCase(System.getProperty("NO_GUI"))) {
            return ConditionEvaluationResult.disabled("GUI tests are disabled!");
        }
        // Manually load application properties file.
        var props = new Properties();
        // This is a tad hacky but it's the only way to get the application.properties file
        // since it's not on the default classloader path.
        var guiRoot = new File(System.getProperty("user.dir"));
        // ../impl/gui -> ../application.properties
        var appPath = guiRoot.getParentFile().getParentFile().toPath().resolve("application.properties");
        try {
            props.load(new FileInputStream(appPath.toFile()));
        } catch (IOException e) {
            return ConditionEvaluationResult.enabled(
                    "Could not find application properties file in project root!" +
                            " All GUI tests are going to run");
        }

        var disableGuiTests = props.getProperty("disableGuiTests");
        if ("true".equalsIgnoreCase(disableGuiTests)) {
            return ConditionEvaluationResult.disabled("GUI tests are disabled!");
        }

        return ConditionEvaluationResult.enabled("GUI tests are enabled!");
    }
}
