package it.unibo.sensor.dsl.generator;

import org.eclipse.xtext.generator.AbstractGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class AbstractSensorGenerator extends AbstractGenerator {
    private static Map<String, String> templates = new HashMap<>();
    private static String templateExtension = ".template";

    private static String templateFile(final String name) throws IOException {
        if (!templates.containsKey(name)) {
            final InputStream in = AbstractSensorGenerator.class.getResourceAsStream("/templates/" + name + templateExtension);
            try (final BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
                final var content = reader.lines().collect(Collectors.joining("\n"));
                templates.put(name, content);
            }
        }
        return templates.get(name);
    }

    protected static String pythonTemplateFile(final String name) throws IOException {
        return templateFile(name + ".py");
    }

    protected static String pythonTemplateFile(final String name, final Map<String, String> replacements) throws IOException {
        return AbstractSensorGenerator.replace(AbstractSensorGenerator.pythonTemplateFile(name), replacements);
    }

    protected static String replace(String template, final Map<String, String> replacements) {
        final Pattern pattern = Pattern.compile("\\{\\{\\s*(\\w+)\\s*}}");
        final Matcher matcher = pattern.matcher(template);
        final StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            String key = matcher.group(1);
            String replacement = replacements.getOrDefault(key, matcher.group(0));
            matcher.appendReplacement(result, Matcher.quoteReplacement(replacement));
        }

        matcher.appendTail(result);
        return result.toString();
    }
}
