package uso;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final ArmaAutomatica automatica= new ArmaAutomatica(30);
        final Operador operador= new Operador();
        operador.operar(automatica);
	}

}
