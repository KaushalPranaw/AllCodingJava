package CoreJava.CustomAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  // Annotation is available at runtime
@Target(ElementType.METHOD) // Can only be applied to methods
public @interface MyAnnotation {
    String value(); // Annotation element with no default
    int version() default 1; // Default value for version
}
