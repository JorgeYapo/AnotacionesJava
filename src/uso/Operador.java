package uso;

import invocaciones.InvocarMultiple;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Nota
//La lectura de la anotación en tiempo de ejecución se realiza mediante reflexión,
//pero sólo si ésta tiene un nivel de retención RUNTIME.
public class Operador {

	public void operar(ArmaAutomatica automatica) {
        final String className = automatica.getClass().getName();
        try {
            final Method[] methods = Class.forName(className).getMethods();
            for (final Method method : methods) {
            	invocarMetodo(method, automatica);
            }
        } catch (final Exception e) {
            System.err.println("Hubo un error:" + e.getMessage());
        }
    }
 
    private void invocarMetodo(Method method, ArmaAutomatica automatica)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
 
        final InvocarMultiple multipleInvocacion = method.getAnnotation(InvocarMultiple.class);
 
        if (multipleInvocacion != null) {
            final int nunmerodInvocaiones = multipleInvocacion.numerodInvocaciones();
 
            for (int i = 0; i < nunmerodInvocaiones; i++) {
                method.invoke(automatica, (Object[])null);
            }
        }
 
    }
}
