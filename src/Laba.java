package src;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;


public class Laba {
    public void run() {
        Class<?> c = this.getClass();

        System.out.printf("🔥 %s\n\n",c.getName());

        for (Method m: c.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ParamsContainer.class)) {
                ParamsContainer paramsContainer = m.getAnnotation(ParamsContainer.class);
                for (Params params: paramsContainer.value()) {
                    this.callWithParams(m, params);
                }
            }
            if (m.isAnnotationPresent(Params.class)) {
                Params params = m.getAnnotation(Params.class);
                this.callWithParams(m, params);
            }

            if (m.isAnnotationPresent(ParamsContainer.class) || m.isAnnotationPresent(Params.class)) {
                System.out.print("\n");
            }
        }
    };

    private void callWithParams (Method m, Params params) {
        Parameter[] parameters = m.getParameters();
        

        if (parameters.length == 1 && parameters[0].getType().isArray()) {
            Parameter parameter = parameters[0];

            if (parameter.getType().isArray()) {
                Class<?> type = parameter.getType().getComponentType();

                System.out.printf("\t✅ \033[1m%s(%s)\033[0m : ", m.getName(), Arrays.toString(params.params()));

                if (type == int.class) {
                    int[] res = Arrays.stream(params.params()).mapToInt(Integer::parseInt).toArray();
                    try {
                        if (m.getReturnType().isArray()) {
                            Object r = m.invoke(null, res);
                            System.out.println(Arrays.toString((int[]) r));
                        } else {
                            System.out.println(m.invoke(null, res));
                        }
                    } catch (Exception e) {
                        System.out.println("bad");
                    }
                } else {
                    try {
                        System.out.println(m.invoke(null, Object.class.cast(params.params())));
                    } catch (Exception e) {
                        System.out.println("bad");
                    }
                }
            } else {
                System.out.println("F");
            }
        } else {
            Object[] res = new Object[m.getParameterCount()];
            int i = 0;
            for (Parameter parameter: parameters) {
                Class<?> type = parameter.getType();
                if (type == int.class) {
                    res[i] = Integer.parseInt(params.params()[i]);
                } else if (type == char.class) {
                    res[i] = params.params()[i].charAt(0);
                } else {
                    res[i] = params.params()[i];
                }
                i++;
            }
            
            System.out.printf("\t✅ \033[1m%s(%s)\033[0m : ", m.getName(), String.join(", ", params.params()));


            try {
                if (m.getReturnType().isArray()) {
                    Object r = m.invoke(null, res);
                    if (m.getReturnType().getComponentType() == String.class) {
                        System.out.println(Arrays.toString((String[]) r));
                    } else if (m.getReturnType().getComponentType() == int.class){
                        System.out.println(Arrays.toString((int[]) r));
                    }
                    
                } else {
                    System.out.println(m.invoke(null, res));
                }
            } catch (Exception e) {
                System.out.println("bad");
            }
        }
    }
}
