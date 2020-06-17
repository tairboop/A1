package operacionespol;
import java.util.*;
public class OperacionesPol {
    public int con;
    Polinomio P1,P2,P3;
    int tam;
    Scanner lec = new Scanner(System.in);
    void leer(){
        System.out.println("TAMAÑO: # de terminos Polinomio 1: ");
        tam = lec.nextInt();
        P1 = new Polinomio(tam);
        P1.leerPol();
        System.out.println("TAMAÑO: # de terminos Polinomio 2: ");
        tam = lec.nextInt();
        P2 = new Polinomio(tam);
        P2.leerPol();
    }
    void sumar(){
        P3 = new Polinomio(P1.tam + P2.tam);
        int i=0; int j=0; int k=0;
        while((i < P1.tam) && (j < P2.tam)){
            Termino Tpol= new Termino();
            if((P1.Pol[i].getExpo()) == (P2.Pol[j].getExpo())){
                Tpol.coef = P1.Pol[i].getCoef()+P2.Pol[j].getCoef();
                Tpol.expo=P1.Pol[i].getExpo();
                P3.Pol[k] = Tpol;
                i++;
                j++;
                k++;
                con++;
            }else{
                if(P1.Pol[i].getExpo() < P2.Pol[j].getExpo()){
                    Tpol.coef = P1.Pol[i].getCoef();
                    Tpol.expo= P1.Pol[i].getExpo();
                    P3.Pol[k] = Tpol;
                    i++;
                    k++;
                }else{
                    Tpol.coef = P2.Pol[j].getCoef();
                    Tpol.expo = P2.Pol[j].getExpo();
                    P3.Pol[k] = Tpol;
                    j++;
                    k++;
                }
            }
        }
        while (i < P1.tam){
            Termino Tpo2 = new Termino();
            Tpo2.coef = P1.Pol[i].getCoef();
            Tpo2.expo = P1.Pol[i].getExpo();
            P3.Pol[k] = Tpo2;
            i++;
            k++;
        }
        while ( j < P2.tam){
            Termino Tpo3 = new Termino();
            Tpo3.coef = P2.Pol[j].getCoef();
            Tpo3.expo = P2.Pol[j].getExpo();
            P3.Pol[k] = Tpo3;
            j++;
            k++;
        }
    }
    void MenuPrin(){
        String s;
        int op;
        do{ System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
            System.out.println("[1] llenar: ");
            System.out.println("[2] sumar: ");
            System.out.println("[3] mostrar: ");
            System.out.println("[4] ordenar: ");
            System.out.println("[5] simplicar: ");
            System.out.println("[6] salir: ");
            System.out.print("Elejir opcion:-> ");
            
            op = lec.nextInt();
            System.out.print("\n____________________________________\n");
            switch (op){
                case 1: leer();
                        s = P1.mostrar();
                        System.out.println("Polinomio 1=> "+s+"\n");
                        s="";
                        s = P2.mostrar();
                        System.out.println("Polinomio 2=> "+s+"\n");
                        break;
    /*SUMA*/    case 2: P1.ordenar();
                        P2.ordenar();
                        con = 0;
                        sumar();
                        s="";
                        s = P3.mostrar(con);
                        System.out.println("res. P3=>"+ s);
                        
                        break;
                case 3: s = P1.mostrar();
                        System.out.println("P1: "+s);
                        s = P2.mostrar();
                        System.out.println("P2: "+s);
                        if(null != P3){
                            if(con == 0){
                                s = P3.mostrar();
                                System.out.println("P3: "+s);
                            }else{
                                s = P3.mostrar(con);
                                System.out.println("P3: "+s);
                            }
                                
                        }else{
                            System.out.println("vacio");
                        }
                        break;
                case 4: if(null != P1)
                            P1.ordenar();
                        if(null != P2)
                            P2.ordenar();
                        if(null != P3){
                            if(con == 0){
                                P3.ordenar();
                            }else{
                                P3.simplicar(con);
                            }
                        }
                        break;
                case 5: if(null != P1)
                            P1.simplicar();
                        if(null != P2)
                            P2.simplicar();
                        if(null != P3){
                            if(con == 0){
                                P3.simplicar();
                            }else{
                                P3.simplicar(con);
                            }
                        }
                        break;
                case 6: System.exit(0);
                        break;
        }
        }while ( op != 6);
    }
        
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        OperacionesPol oppol = new OperacionesPol();
        oppol.MenuPrin();
    }
    
}
