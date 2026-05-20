package ec.edu.poo;

public class Main {

    public static void main(String[] args) {
        System.out.println("Inicio Pruebas");

    
        GestorActivos gestor = new GestorActivos();

       
        Servidor s1 = new Servidor("prueb1", "Servidor 1", 9, false, "Ubuntu Server");
        Firewall f1 = new Firewall("prueb2", "Firewall P1", 7, false, 25);
        Servidor s2 = new Servidor("prueb3", "Servidor 2", 5, false, "Windows Server");

       
        System.out.println("Registro Servidor 1 (Riesgo 9): " + gestor.registrarActivo(s1));
        System.out.println("Registro Firewall 1 (Riesgo 7): " + gestor.registrarActivo(f1));
        System.out.println("Registro Servidor 2 (Riesgo 5): " + gestor.registrarActivo(s2));

       
        System.out.println("Registrando duplicado de Servidor 1: " + gestor.registrarActivo(s1));
      //no es necesario la linea 22 pero lo pongo como ejemplo de un duplicado de servidor (pruebas de clase)

        
        System.out.println("Metricas");
        System.out.println("Total activos : " + gestor.obtenerCantidadActivos());
        System.out.println("Activos Criticos (min riesgo >= 8): " + gestor.contarActivosCriticos());
        System.out.println("Promedio de riesgo total: " + gestor.calcularPromedioRiesgo());

     
      

        System.out.println("Linea que me dice que todo esta bien y las pruebas estan bien hechas =)");
    }
}
