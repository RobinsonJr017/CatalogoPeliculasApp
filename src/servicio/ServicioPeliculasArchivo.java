package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPeliculas{

    private final String NOMBRE_ARCHIVO = "peliculas.txt";
    public ServicioPeliculasArchivo(){
        var archivo = new File(NOMBRE_ARCHIVO);
        try{ //Si ya existe el archivo, No se vuelva a crear
            if (archivo.exists()){
                System.out.println("El archivo ya existe! ");
            } else { //si no existe, se crea vacio
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error al abrir el archivo" + e.getMessage());
        }

    }
    @Override
    public void listarPeliculas() {
        // vovlemos a abrir el archivo
        var archivo = new File(NOMBRE_ARCHIVO);
        try{ //Si ya existe el archivo, No se vuelva a crear
            System.out.println("Listado de Peliculas");
            // Abrimos el archivo para lecuta
            var entrada = new BufferedReader(new FileReader(archivo)); //Para leer linea a linea nuestro archivo
            // Leemos linea a linea el archivo
            String linea;
            linea = entrada.readLine();
            while (linea != null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                // Antes de terminar el cliclo volvemos a leer la sgt linea
                linea = entrada.readLine();
            }
            // Cerramnos el archivo
            entrada.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error al leer el archivo" + e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {

    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {

    }
}
