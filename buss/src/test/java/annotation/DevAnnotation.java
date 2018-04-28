package annotation;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lee
 * @Date:22/02/2018
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

@ActiveProfiles("dev")
@Transactional
public @interface DevAnnotation {

}
