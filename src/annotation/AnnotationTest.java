package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author damien
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Field[] declaredFields = Fruit.class.getDeclaredFields();
        for (int i = 0;i<declaredFields.length;i++){
            Annotation[] annotations = declaredFields[i].getAnnotations();
            for (int j=0;j<annotations.length;j++){
                System.out.println(annotations[i]);
            }
        }
    }
}
