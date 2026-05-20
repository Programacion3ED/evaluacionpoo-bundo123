package ec.edu.poo;
public class GestorActivos {

    public final int MAX_ACTIVOS = 10;

    private ActivoDigital[] activos;
    private int contador;

    public GestorActivos() {
        this.activos = new ActivoDigital[MAX_ACTIVOS];
        this.contador = 0;
    }

    public void reiniciar() {
        this.activos = new ActivoDigital[MAX_ACTIVOS];
        this.contador = 0;
    }

    public boolean registrarActivo(ActivoDigital activo) {
        if (activo == null) {
            return false;
        }
      
        if (contador >= MAX_ACTIVOS) {
            return false;
        }
        
        if (buscarPorCodigo(activo.getCodigo()) != null) {
            return false;
        }

        activos[contador] = activo;
        contador++;
        return true;
    }

    public ActivoDigital buscarPorCodigo(String codigo) {
        if (codigo == null) {
            return null;
        }
        for (int i = 0; i < contador; i++) {
            if (activos[i].getCodigo().equals(codigo)) {
                return activos[i];
            }
        }
        return null;
    }

    public int contarActivosCriticos() {
        int criticos = 0;
        for (int i = 0; i < contador; i++) {
            // Regla: Nivel de riesgo mayor o igual a 8
            if (activos[i].getNivelRiesgo() >= 8) {
                criticos++;
            }
        }
        return criticos;
    }

    public double calcularPromedioRiesgo() {
        if (contador == 0) {
            return 0.0;
        }

        double sumaRiesgo = 0.0;
        for (int i = 0; i < contador; i++) {
            sumaRiesgo += activos[i].getNivelRiesgo();
        }
        return sumaRiesgo / contador;
    }

    public boolean aplicarParcheActivo(String codigo) {
        ActivoDigital activo = buscarPorCodigo(codigo);
        if (activo == null) {
            return false;
        }
        activo.setParcheAplicado(true);
        return true;
    }

    public int obtenerCantidadActivos() {
        return contador;
    }

    public ActivoDigital[] obtenerActivos() {
        return activos;
    }
}
