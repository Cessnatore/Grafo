import java.util.List;

public class Areee {

	public static void main(String[] args) {
		Grafo<String> putos=new Grafo<String>("oh wa ah ah");
        putos.agregarNodo("iz0","oh wa ah ah");
        putos.agregarNodo("iz1","iz0");
        putos.agregarNodo("iz2","iz1");
        putos.agregarNodo("dr0","oh wa ah ah");
        putos.agregarNodo("dr1","dr0");
        putos.agregarNodo("dr2","dr1");
        putos.agregarNodo("fin","iz2");
        putos.agregarEnlace("dr2","fin");
        putos.agregarEnlace("fin","oh wa ah ah");
		for(List<String> as : putos.caminos("oh wa ah ah","fin")){
            for(String a:as) {
                System.out.println(a);
            }
            System.out.println("--------------------------------------");
		}
	}

}
