package com.bicicom.fluentmapper.plugin;

import com.bicicom.fluentmapper.core.FluentMapper;
import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

@Mojo(name = "FluentMapper", defaultPhase = LifecyclePhase.COMPILE)
public class FluentMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}", readonly = true, required = true)
    private MavenProject project;

    @Parameter(property = "FluentMapper.exportPath")
    private String exportPath;

    @Parameter(property = "FluentMapper.mappingsPackage")
    private String mappingsPackage;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        getLog().info("Initializing FluentMapper...");

        final String classpath;
        try {
            classpath = project.getCompileClasspathElements().get(0);
        } catch (DependencyResolutionRequiredException e) {
            throw new MojoFailureException("Could not access classpath - ", e);
        }

        if (exportPath == null) {
            getLog().info("No export path specified - will only output to classpath.");
        } else {
            getLog().info("Exporting to classpath and to " + exportPath);
        }

        FluentMapper.createConfigured(config -> {
            config.exportsTo(classpath + "/META-INF/orm.xml", exportPath)
                    .withMappingsPackage(mappingsPackage)
                    .withMappingsPath(classpath);
        }).execute();

        getLog().info("FluentMapper done!");

    }

    private ClassLoader getProjectClassloader(String classPath) throws MalformedURLException {
        URL[] urls = new URL[]{new URL("file:///" + classPath + "/")};
        return URLClassLoader.newInstance(urls, Thread.currentThread().getContextClassLoader());
    }

}
