package uso;

import invocaciones.InvocarMultiple;

public class ArmaAutomatica {

	private static final int RAFAGA = 3;
	 
    private static final int AUTOMATICA = 5;
    
    
    private int bala;
    
    public ArmaAutomatica(int bala) {
        this.bala = bala;
    }
 
    @InvocarMultiple
    public void disparoSimple() {
        bala--;
        System.out.println("disparo simple ! bala left: " + bala);
    }
 
    @InvocarMultiple(numerodInvocaciones = RAFAGA)
    public void disparoRafaga() {
        bala--;
        System.out.println("disparo de rafaga! bala left: " + bala);
    }
 
    @InvocarMultiple(numerodInvocaciones = AUTOMATICA)
    public void disparoAutomatico() {
        bala--;
        System.out.println("disparo automatico ! bala left: " + bala);
    }
}
