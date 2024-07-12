import modulos.ConverteMoeda;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConverteMoeda menu = new ConverteMoeda();
        menu.menuPrincipal();
    }
}
