package uso;

import invocaciones.InvocarMultiple;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Nota
//La lectura de la anotaci�n en tiempo de ejecuci�n se realiza mediante reflexi�n,
//pero s�lo si �sta tiene un nivel de retenci�n RUNTIME.
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
