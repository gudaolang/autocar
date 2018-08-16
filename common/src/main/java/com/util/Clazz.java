package com.util;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.List;

/**
 * projectName: base
 * Created by lee on 2018/7/18 18:42
 */
public class Clazz {

    public static void premain(String args, Instrumentation instrumentation) {
        instrumentation.addTransformer((loader, className, classBeingRedefined, protectionDomain, classfileBuffer) -> {
                    if (className != null && className.replaceAll("/", "\\.").equals("packageName")) {
                        ClassPool pool = ClassPool.getDefault();
                        pool.insertClassPath(new LoaderClassPath(loader));
                        try {
                            CtClass ctClass = pool.get(className.replaceAll("/", "\\."));
                            CtMethod ctMethod = ctClass.getDeclaredMethod("hello");
                            // 插入的是代码块
                            //{long startTime = System.currentTimeMillis();}
                            ctMethod.insertBefore("System.out.println(System.currentTimeMillis());");
                            //{long endTime = System.currentTimeMillis();}
                            CtMethod agentMethod = CtNewMethod.copy(ctMethod, "hello", ctClass, null);

                            agentMethod.setName("hello$agent");
                            ctClass.addMethod(agentMethod);
                            agentMethod.setBody("{long startTime = System.currentTimeMillis();"
                                    + "hello$agent($$);"
                                    + "long endTime = System.currentTimeMillis();"
                                    + "System.out.println(endTime-beginTime);"
                            );
                            return ctClass.toBytecode();
                        } catch (NotFoundException | CannotCompileException | IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return null;
                }

        );
    }

    public static void main(String[] args) {


        List<Object[]> aa = new ArrayList<>();

        Object[] ab = {1, "2", 3};
        aa.add(ab);

        System.out.println(aa);
    }
}
