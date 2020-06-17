package operacionespol;
import java.util.Scanner;
public class Polinomio {
    Scanner lec = new Scanner(System.in);
    public Termino Pol[];
    protected int tam;
    public Polinomio(int nt){
        tam = nt;
        Pol = new Termino[tam];
    }
    void leerPol(){
        int i;int coef; int expo;
        for(i=0 ; i< Pol.length;i++){
            Termino poli = new Termino();
            System.out.print("Coeficiente=> ");
            coef = lec.nextInt();
            System.out.print("Exponente=> ");
            expo = lec.nextInt();
            poli.setCoef(coef);
            poli.setExpo(expo);
            Pol[i] = poli;
        }
    }
    String mostrar(){
        int e=0;
        String s = "";
        for(e=0 ; e < Pol.length;e++){
            //System.out.println(Pol.length+" contador "+e);
            if(e < Pol.length-1 ){
                s= s + Pol[e].getCoef()+"x^"+ Pol[e].getExpo()+ " + ";
            }else{
                s= s + Pol[e].getCoef()+"x^"+ Pol[e].getExpo();
            }
        }
        return s;
    }
    String mostrar(int x){
        int e=0;
        String s = "";
        for(e=0 ; e < Pol.length-x;e++){
            //System.out.println(Pol.length+" contador "+e);
            if(e < Pol.length-x-1 ){
                s= s + Pol[e].getCoef()+"x^"+ Pol[e].getExpo()+ " + ";
            }else{
                s= s + Pol[e].getCoef()+"x^"+ Pol[e].getExpo();
            }
        }
        return s;
    }
    public void ordenar(){
        int i; int j;
        Termino polaux = new Termino();
        //MANEJAMOS EXCEPCIONES CON TRY
        try{
            for(i=0; i < Pol.length-1;i++){
                for(j=i+1; j < Pol.length;j++){
                    if(Pol[i].getExpo()> Pol[j].getExpo()){
                        polaux = Pol[i];
                        Pol[i]= Pol[j];
                        Pol[j]= polaux;
                    }
                }
            }
        }
        catch(NullPointerException e){
            System.out.println("Error"+e/*.getMessaje()*/);
        }
    }
    void simplicar(){
        int i,j,k;
        for(i=0 ; i< tam-1;i++){
            for(j=i+1;j<tam;j++){
                if(Pol[i].getExpo() == Pol[j].getExpo()){
                    Pol[i].coef = Pol[i].coef+Pol[j].coef;
                    /*for(k=j; k< tam-1;k++){
                        Pol[k]=Pol[k+1];
                    }*/
                    Pol[j].coef = 0;
                    Pol[j].expo = 0;
                    tam--;
                }
            }
        }
    }
    void simplicar(int x){
        int i,j,k;
        for(i=0 ; i< tam-1-x;i++){
            for(j=i+1;j<tam-x;j++){
                if(Pol[i].getExpo() == Pol[j].getExpo()){
                    Pol[i].coef = Pol[i].coef+Pol[j].coef;
                    /*for(k=j; k< tam-1-x;k++){
                        Pol[k]=Pol[k+1];
                    }*/
                    Pol[j].coef = 0;
                    Pol[j].expo = 0;
                    tam--;
                }
            }
        }
    }
}