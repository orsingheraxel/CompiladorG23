#include <iostream>
#include <fstream>
#include <list>
#include <map>
using namespace std;

struct reg_libro
{
    string id;
    string titulo;
    string autor;
    string rubro;
    int paginas;
    int puntaje;
    int cant_ejemplares;
};
struct reg_alumno
{
    int puntaje_alumno;
    list<reg_libro> lista_libros;
    bool aprobado;
};





struct solucion
{
    int cant_estados; //indica el numero de estado, sera util para comparar la optimizacion de la poda y demás
    int cant_aprobados;
    int libros_disponibles;
    map<int,reg_alumno> asignaciones;//las claves del mapa son enteros que representan a los alumnos, las listas son los libros asignados a c/u
};

/////////PROCESAMIENTO DEL ARCHIVO/////////////
reg_libro * procesar_archivo_entrada(string origen,int & tamanio_arreglo);
void generar(int cantidad);
/////////ORDENAMIENTO DE LOS LIBROS SEGUN PUNTAJE/////////////
void quick_arreglo_segun_puntaje(reg_libro * arreglo_libros,int inicio,int fin);
int particion (reg_libro * arreglo_libros,int inicio, int fin);
////////////FUNCIONES BACKTRACKING///////////////////////////
void back_Asignacion_Alumnos(reg_libro * arreglo_libros,int cant_alumnos,int cant_libros,int puntaje,int libro_Actual, solucion solucionActual, solucion & solucionOptima);
bool libroAsignado(reg_libro * arreglo_libros,solucion solActual,int alumno,int libro);
void asignarLibro(reg_libro * arreglo_libros,solucion & solucionActual,int alumno,int libro,int puntaje);
bool PodaAlumno(solucion solucionActual,int alumno,int puntaje);
void avanzarLibro(reg_libro * arreglo_libros,int & libro,int cant_libros);
void quitarLibro(reg_libro * arreglo_libros,solucion & solucionActual,int alumno,int libro_Actual,int puntaje);


int main()
{
    string dataset;
    cout << "Ingrese nombre del dataset: ";
    cin >> dataset;
    int tamanio_arreglo;
    ////////////CARGAMOS EL ARCHIVO DE LIBROS EN UN ARREGLO////////////////////////////////
    reg_libro * arreglo_libros = procesar_archivo_entrada("./datasets/" + dataset,tamanio_arreglo);
    ////////////ORDENAMOS EL ARREGLO DE LIBROS DE MANERA DESCENDENTE SEGUN PUNTAJE/////////////////////////
    quick_arreglo_segun_puntaje(arreglo_libros,0,tamanio_arreglo-1);
    ///////////CALCULAMOS LA CANT TOTAL DE EJEMPLARES////////////////////////
    int cant_libros = 0;
    for (int i=0;i<tamanio_arreglo;i++) { //calculamos la cant de ejemplares total
        cant_libros+= arreglo_libros[i].cant_ejemplares;
    }
    cout << "CANT EJEMPLARES: " << cant_libros << endl;
    /////////////////////////////////////IMPRIMIMOS EL ARREGLO CON LOS LIBROS ORDENADOS///////////////////////////////
    for (int i=0; i<tamanio_arreglo;i++){//imprimimos el arreglo de libros ordenados
        cout << arreglo_libros[i].id << " | "<< arreglo_libros[i].titulo <<" | "<< arreglo_libros[i].autor<<" | "
        <<arreglo_libros[i].rubro<<" | "<<arreglo_libros[i].paginas<<" | "<<arreglo_libros[i].puntaje<<" | "<<arreglo_libros[i].cant_ejemplares<<"|" << endl;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    int alumnos, puntaje;
    cout << "Ingrese cantidad de alumnos y puntaje mínimo para aprobar: " << endl;
    cin >>alumnos >> puntaje;
    ///////////INICIALIZAMOS NUESTROS ESTADOS DE BACKTRACKING////////////////////
    solucion solActual,solOptima;
    solActual.cant_estados= 0;
    solActual.cant_aprobados = 0;
    solActual.libros_disponibles = cant_libros;
    solOptima.cant_aprobados = 0;
    list<reg_libro> lista;
    lista.clear();
    //////INICIALIZAMOS A CADA ALUMNO CON UNA LISTA VACIA PARA LUEGO PODER AGREGARLE LOS LIBROS
    for (int i=1; i<=alumnos; i++) {
        solActual.asignaciones[i].puntaje_alumno = 0;
        solActual.asignaciones[i].aprobado = false;
        solActual.asignaciones[i].lista_libros = lista;
    }
    back_Asignacion_Alumnos(arreglo_libros,alumnos,tamanio_arreglo,puntaje,0,solActual,solOptima);
    for (int i=1;i<=alumnos;i++)
    {
        list<reg_libro> listaa = solOptima.asignaciones[i].lista_libros;
        list<reg_libro>::iterator it;
        it = listaa.begin();
        cout << "LIBROS PARA EL ALUMNO NRO " << i << ": ";;
        while (it!= listaa.end()) {
            cout << it->id << ", ";
            it++;
        }
        cout << endl;
    }
    cout << "CANT ESTADOS: " << solOptima.cant_estados << endl;
    cout << "CANT APROBADOS: " << solOptima.cant_aprobados << endl;

    cout << "Desea volver a realizar una simulación (S/N)?: " << endl;
    //S: Se pide nuevamente cantidad de alumnos y puntaje mínimo con el mismo dataset.
    return 0;
}

reg_libro * procesar_archivo_entrada(string origen,int & tamanio_arreglo)
{
    ifstream archivo(origen);
    if (!archivo.is_open())
        cout << "No se pudo abrir el archivo: " << origen << endl;
    else {
        string linea;
        getline(archivo, linea);
        int cantidad_libros = atoi(linea.c_str());

        tamanio_arreglo = cantidad_libros;
        reg_libro * arreglo_libros = new reg_libro[cantidad_libros];

        cout << "Se cargarán " << cantidad_libros << " libros." << endl;

        int posicion = 0;
        //Leemos de una linea completa por vez (getline).
        while (getline(archivo, linea)) {
            //Primer posición del separador ;
            int pos_inicial = 0;
            int pos_final = linea.find(';');

            //Informacion entre pos_inicial y pos_final
            string id = linea.substr(pos_inicial, pos_final);

            //Segunda posición del separador ;
            pos_inicial = pos_final + 1;
            pos_final = linea.find(';', pos_inicial);
            string titulo = linea.substr(pos_inicial, pos_final - pos_inicial);

            //Tercera posición del separador ;
            pos_inicial = pos_final + 1;
            pos_final = linea.find(';', pos_inicial);
            string autor = linea.substr(pos_inicial, pos_final - pos_inicial);

            //Cuarta posición del separador ;
            pos_inicial = pos_final + 1;
            pos_final = linea.find(';', pos_inicial);
            string rubro = linea.substr(pos_inicial, pos_final - pos_inicial);

            //Quinta posición del separador ;
            pos_inicial = pos_final + 1;
            pos_final = linea.find(';', pos_inicial);
            int pags = atoi(linea.substr(pos_inicial, pos_final - pos_inicial).c_str());

            //Sexta posición del separador ;
            pos_inicial = pos_final + 1;
            pos_final = linea.find(';', pos_inicial);
            int puntaje = atoi(linea.substr(pos_inicial, pos_final - pos_inicial).c_str());

            //Septima posición del separador ;
            pos_inicial = pos_final + 1;
            pos_final = linea.find(';', pos_inicial);
            int cant = atoi(linea.substr(pos_inicial, pos_final - pos_inicial).c_str());

            reg_libro L;
            L.id = id;
            L.titulo = titulo;
            L.autor = autor;
            L.rubro = rubro;
            L.paginas = pags;
            L.puntaje = puntaje;
            L.cant_ejemplares = cant;
            arreglo_libros[posicion] = L;
            posicion++;

        }
        return arreglo_libros;
    }
}
/////////ORDENAMIENTO DE LOS LIBROS SEGUN PUNTAJE///////////////////////////////////////////////////////////////////
void quick_arreglo_segun_puntaje(reg_libro * arreglo,int inicio,int fin)//ordenamos el arreglo de los libros segun puntaje de mayor a menor por quicksort
{
  if (inicio < fin) //esto quiere decir que hay más de un elemento, ya que sino inicio=fin y en ese caso no hay que ordenar nada
  {
      int p = particion(arreglo,inicio,fin);
      quick_arreglo_segun_puntaje(arreglo,inicio,p-1);
      quick_arreglo_segun_puntaje(arreglo,p+1,fin);

  }

}
int particion (reg_libro * arreglo,int inicio, int fin)//devuelve el indice donde se encuentra el pivote ya posicionado
{
    reg_libro pivote = arreglo[inicio];
    int puntaje_pivote = pivote.puntaje;
    int posP = inicio;
    while (inicio < fin)
    {
        while (arreglo[inicio].puntaje >= puntaje_pivote) {inicio++;}
        while (arreglo [fin].puntaje < puntaje_pivote) {fin--;}
        if (inicio < fin)
        {
            reg_libro aux = arreglo[inicio];
            arreglo[inicio] = arreglo[fin];
            arreglo[fin] = aux;
            inicio++;
            fin--;
        }
    }
    arreglo[posP] = arreglo[fin];
    arreglo[fin] = pivote;
    return fin;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////
void back_Asignacion_Alumnos(reg_libro * arreglo_libros,int cant_alumnos,int cant_libros,int puntaje,int libro_Actual, solucion solucionActual, solucion & solucionOptima)
{
    solucionActual.cant_estados++;
    if (solucionActual.libros_disponibles == 0) {
        if (solucionActual.cant_aprobados > solucionOptima.cant_aprobados) {
            solucionOptima.asignaciones = solucionActual.asignaciones;
            solucionOptima.cant_aprobados = solucionActual.cant_aprobados;
            solucionOptima.cant_estados = solucionActual.cant_estados;
            solucionOptima.libros_disponibles = solucionActual.libros_disponibles;
        }
    }
    else {
        for(int alumno=1;alumno<=cant_alumnos;alumno++)
        {
            solucionActual.libros_disponibles--;
            arreglo_libros[libro_Actual].cant_ejemplares--;
            if (!libroAsignado(arreglo_libros,solucionActual,alumno,libro_Actual))
            {
                asignarLibro(arreglo_libros,solucionActual,alumno,libro_Actual,puntaje);
                if (!PodaAlumno(solucionActual,alumno,puntaje))
                {
                    avanzarLibro(arreglo_libros,libro_Actual,cant_libros);
                    back_Asignacion_Alumnos(arreglo_libros,cant_alumnos,cant_libros,puntaje,libro_Actual,solucionActual,solucionOptima);
                }
                quitarLibro(arreglo_libros,solucionActual,alumno,libro_Actual,puntaje);

            }
            solucionActual.libros_disponibles++;
            arreglo_libros[libro_Actual].cant_ejemplares++;
        }
    }

}


bool libroAsignado(reg_libro * arreglo_libros,solucion solActual,int alumno,int libro)
{
    list<reg_libro> lista_alumno;
    lista_alumno = solActual.asignaciones[alumno].lista_libros;
    list<reg_libro>::iterator it;
    it = lista_alumno.begin();
    bool encontrado = false;
    while ((!encontrado) && (it!=lista_alumno.end()))
    {
        if (it->id == arreglo_libros[libro].id) {encontrado = true;}
        it++;
    }
    return encontrado;
}

void asignarLibro(reg_libro * arreglo_libros,solucion & solucionActual,int alumno,int libro,int puntaje)//falta agregar cuando aprueba un alumno
{
    cout << "ASIGNAMOS AL ALUMNO " << alumno << " EL LIBRO " << arreglo_libros[libro].id;
    solucionActual.asignaciones[alumno].lista_libros.push_back(arreglo_libros[libro]);
    solucionActual.asignaciones[alumno].puntaje_alumno+=arreglo_libros[libro].puntaje;
    if ((solucionActual.asignaciones[alumno].puntaje_alumno >= puntaje) && (!solucionActual.asignaciones[alumno].aprobado))
    {
        solucionActual.cant_aprobados++;
        solucionActual.asignaciones[alumno].aprobado = true;
    }
    cout << ", ptje alumno: " << solucionActual.asignaciones[alumno].puntaje_alumno;
    cout << ", cant aprobados: " << solucionActual.cant_aprobados<< endl;

}

bool PodaAlumno(solucion solucionActual,int alumno,int puntaje) //falta ver el caso donde aprueban todos los alumnos
{
    bool poda = false;
    if (solucionActual.asignaciones[alumno].aprobado) {poda = true;}
    return poda;
}


void avanzarLibro(reg_libro * arreglo_libros,int & libro,int cant_libros)
{
    if ((arreglo_libros[libro].cant_ejemplares == 0) && (libro <(cant_libros-1))) {libro++;}
}

void quitarLibro(reg_libro * arreglo_libros,solucion & solucionActual,int alumno,int libro_Actual,int puntaje)
{
    cout << "QUITAMOS AL ALUMNO " << alumno << " EL LIBRO " << arreglo_libros[libro_Actual].id;
    int puntaje_anterior = solucionActual.asignaciones[alumno].puntaje_alumno;
    solucionActual.asignaciones[alumno].lista_libros.pop_back();
    solucionActual.asignaciones[alumno].puntaje_alumno-=arreglo_libros[libro_Actual].puntaje;

    if ((puntaje_anterior >= puntaje) && (solucionActual.asignaciones[alumno].puntaje_alumno < puntaje))
    {
        solucionActual.cant_aprobados--;
        solucionActual.asignaciones[alumno].aprobado = false;
    }
    cout << ", cant aprobados: " << solucionActual.cant_aprobados<< endl;
}
