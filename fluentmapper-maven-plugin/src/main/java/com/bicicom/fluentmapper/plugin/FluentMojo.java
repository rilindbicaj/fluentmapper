package com.bicicom.fluentmapper.plugin;

import com.bicicom.fluentmapper.provider.core.FluentFactory;
import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(name = "generate-mappings", defaultPhase = LifecyclePhase.COMPILE)
public class FluentMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}", readonly = true, required = true)
    private MavenProject project;

    @Parameter(property = "generate-mappings.exportPath")
    private String exportPath;

    @Parameter(property = "generate-mappings.mappingsPackage")
    private String mappingsPackage;

    @Override
    public void execute() throws MojoFailureException {

        getLog().info("Initializing FluentMapper...");

        final String classpath;
        try {
            classpath = project.getCompileClasspathElements()
                    .stream()
                    .reduce("", String::concat);
            getLog().info("Final classpath - " + classpath);
        } catch (DependencyResolutionRequiredException e) {
            throw new MojoFailureException("Could not access classpath - ", e);
        }

        if (exportPath == null) {
            getLog().info("No export path specified - will only output to classpath.");
        } else {
            getLog().info("Exporting to classpath and to " + exportPath);
        }

        FluentFactory.createConfigured(config -> {
            config.exportsTo(classpath + "/META-INF/orm.xml", exportPath)
                    .withMappingsPackage(mappingsPackage)
                    .withMappingsPath(classpath);
        }).execute();

        getLog().info("FluentMojo finished.");

    }

}
