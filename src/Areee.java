import java.util.List;

public class Areee {

	public static void main(String[] args) {
		Grafo<String> putos=new Grafo<String>("oh wa ah ah");
		putos.agregarNodo("los","oh wa ah ah");
		putos.agregarNodo("las","los");
        putos.agregarNodo("loma","las");
        putos.agregarNodo("lema","las");
        putos.agregarNodo("lemas","lema");
        putos.agregarNodo("lemur","lemas");
        putos.agregarNodo("disturbed","oh wa ah ah");
		for(List<String> as : putos.caminos("las","oh wa ah ah")){
            for(String a:as) {
                System.out.println(a);
            }
		}
	}

}
