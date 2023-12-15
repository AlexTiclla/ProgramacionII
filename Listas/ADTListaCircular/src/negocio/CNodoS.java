package negocio;


public class CNodoS {
    private Object Elemento;
    private CNodoS Enlace;
    
    //constructor sin parametros
    public CNodoS(){
        //Elemento=0;
        Enlace=null;
    }
    // Constructor parametrizado
    public CNodoS(int Elemento, CNodoS p) {
        this.Elemento = Elemento;
        this.Enlace = p;
    }

    public CNodoS(int Elemento) {
        this.Elemento = Elemento;
        this.Enlace = null;
    }
    
    public void setElem(Object Elemento) {
        this.Elemento = Elemento;
    }

    public void setEnlace(CNodoS p) {
        this.Enlace = p;
    }

    public Object getElem() {
        return Elemento;
    }

    public CNodoS getEnlace() {
        return Enlace;
    }

    @Override
    public String toString() {
        String s="[";
        s=s+getElem();
        return s+" | ]->";
    }
    public static void main(String[] args) {
        CNodoS p = new CNodoS();
        p.setElem(2);
        System.out.println(p.toString());
         System.out.println(p.toString()+"->"+p.getEnlace());
         CNodoS q=new CNodoS();
        q.setElem(1);
        System.out.println(q.toString());
         CNodoS r=new CNodoS();
        r.setElem(3);
        System.out.println(r.toString());
        //-------------------------------------------------
        //Enlazando nodos setEnlace
        q.setEnlace(p);// aqui enlazamos dos nodos q apunta a p
        System.out.println(q.toString()+"->"+q.getEnlace());
        p.setEnlace(r);// aqui enlazamos dos nodos p apunta a r
        System.out.println(q.toString()+"->"+q.getEnlace()+"->"+q.getEnlace().getEnlace());
        
                
    }
}
