import java.util.ArrayList;
import java.util.List;



public class Grafo<T> {
	class Enlace{
		T nodoA;
		T nodoB;
		public T getA(){
			return nodoA;
		}
		public T getB(){
			return nodoB;
		}
		public Enlace (T a,T b){
			this.nodoA=a;
			this.nodoB=b;
		}
		private T getOther(T nodo){
			if (nodoA==nodo){
				return nodoB;
			}
			else{
				return nodoA;
			}
		}
	}
	
	private List<T> nodos;
	private List<Enlace> enlaces=new ArrayList<Enlace>();
	
	public Grafo(T nodo){
		nodos=new ArrayList<T>();
		nodos.add(nodo);
	}

	//devuelve lista de vecinos.
	public List<T> vecinos (T nodo){
		List<T> vecinos=new ArrayList<T>();
		for(Enlace enlace : enlaces){
			if(nodo==enlace.getA()||nodo==enlace.getB()){
				vecinos.add(enlace.getOther(nodo));
			}			
		}
		return vecinos;
	}
	//agrega un nodo al grafo y lo conecta, la conexion es simple solo agrega (a,b).
	public void agregarNodo (T nodo,T conexion){
		if(!nodos.contains(nodo)&& nodos.contains(conexion)){
			nodos.add(nodo);
			enlaces.add(new Enlace(nodo,conexion));
			
		}
	}
	//agrega un enlace entre nodos que ya existen
	public void agregarEnlace(T salida, T llegada){
		if(nodos.contains(salida)&&nodos.contains(llegada)){
			Enlace AB=new Enlace(salida,llegada);
			Enlace BA=new Enlace(llegada,salida);
			if(!enlaces.contains(AB)&&!enlaces.contains(BA)){
				enlaces.add(AB);
			}
		}
	}
	
	//devuelve una lista de caminos.
	public List<List<T>> caminos (T salida,T llegada){
		List<List<T>> caminos=new ArrayList<List<T>>();
		List<T> caminoact = new ArrayList<T>();
		camino(salida,llegada,caminoact,caminos);
		return caminos;
	}
	private void camino(T actual, T llegada, List<T> caminoact, List<List<T>> caminos) {
		if(!caminoact.contains(actual)){
			caminoact.add(actual);
			if(actual==llegada){
				caminos.add(caminoact);
			}
			else{
				List<T> aux;
				aux=continuarLista(caminoact);
				for(T nodo:vecinos(actual)){
					camino(nodo,llegada,aux,caminos);
				}
			}
		}
	}
	private List<T> continuarLista(List<T> lista){
		List<T> aux=new ArrayList<T>();
		for (T elemento: lista) {
			aux.add(elemento);

		}
		return aux;
	}
}