import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Eventos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println("Menu de Opciones: ");
            System.out.println("1. Realizar una Busqueda");
            System.out.println("2. Salir del programa");
           
            int opcion = scanner.nextInt();

          switch (opcion) {
            case 1:
              System.out.println("Elija un criterio para tu Busqueda: ");

              System.out.println("1. Localidad");
              System.out.println("2. Tipo de Evento");
              System.out.println("3. Nombre del contacto");

              int criterio = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Escribi la palabra clave para Buscar");
                String palabraClave = scanner.nextLine();

             try (BufferedReader br = new BufferedReader(new FileReader("eventos.csv"))){
                String linea = br.readLine();
                String[] encabezados = linea.split(";");
                System.out.println("Encabezados: "+ String.join("; ",encabezados));
                System.out.println("-------------------------------"); 

                boolean encontrado =false;

                while((linea = br.readLine()) !=null){
                    String[] datos = linea.split(";");
                    

                    String localidad = datos[0];
                    String tipoEvento = datos[1];
                    String contacto = datos [3];

                if(criterio == 1 && localidad.equalsIgnoreCase(palabraClave)){
                    System.out.println("Evento Encontrado ");
                    for(int i = 0; i < datos.length; i++){
                    
                    System.out.println(encabezados[i]+":  "+ datos[i]);
                    
                    }
                    encontrado = true;
                }
                else if(criterio ==2 && tipoEvento.equalsIgnoreCase(palabraClave)){
                    System.out.println("Evento Encontrado.");
                    for(int i = 0; i <datos.length; i++){
                    
                    System.out.println(encabezados[i] +":  "+ datos[i]);
                    
                    }
                    encontrado = true;

                } 
                else if(criterio ==3 &&  contacto.equalsIgnoreCase(palabraClave)){
                     System.out.println("Evento Encontrado.");
                    for(int i = 0; i <datos.length; i++){
                    
                    System.out.println(encabezados[i] +":  "+ datos[i]);
                    
                    }
                    encontrado = true;


                }
                    

                }
                if(!encontrado){
                    System.out.println("Lo siento, No pudimos encontrar un resultado para tu Busqueda.");
                }
                

                }
                catch(IOException e){
                    System.out.println("Error al leer el archivo: "+ e.getMessage());
                }
                break;
            
            case 2:
              System.out.println("Saliendo del programa");
              scanner.close();
              System.exit(0);
          
              default:
              System.out.println("Opcion no valida. Por favor elija una opcion valida");
            }  
        }

        
    }
}

