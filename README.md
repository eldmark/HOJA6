# Proyecto de Algoritmos y Estructuras de Datos

## Descripción
Este proyecto es parte del curso de Algoritmos y Estructuras de Datos. Consiste en la implementación y análisis de diferentes HASH en el lenguaje de java.

## Estructura del Proyecto
- `src/`: Contiene el código fuente del proyecto.
- `docs/`: Documentación del proyecto.
- `tests/`: Pruebas unitarias y de integración.
- `README.md`: Este archivo.

## Requisitos
- Lenguaje de programación: [Java 22]
- Herramientas: [Maven]

## Instalación
1. Clonar el repositorio:
    ```bash
    git clone https://github.com/eldmark/HOJA6.git
    ```
2. Navegar al directorio del proyecto:
    ```bash
    cd collection
    ```
3. Instalar dependencias:
    ```bash
    mvn clean install
    ``` 

## Uso
[Instrucciones sobre cómo ejecutar el proyecto]

## Contribución
1. Hacer un fork del repositorio.
2. Crear una nueva rama:
    ```bash
    git checkout -b feature/nueva-funcionalidad
    ```
3. Realizar los cambios y hacer commit:
    ```bash
    git commit -m "Descripción de los cambios"
    ```
4. Hacer push a la rama:
    ```bash
    git push origin feature/nueva-funcionalidad
    ```
5. Crear un pull request.


## Respuestas de analisis:
Caso 4:
1. En el caso me 4 me voy a basar en la implementación con hasmap, dado que hashmap tiene una complejidad teórica de O(n), lo que significa
    que la complejidad en tiempo irá aumentando respecto a la cantidad de datos utilizados en la operación. Agregado a eso se utiliza el metodo Sort() que utiliza implicitamente el algoritmo TimSort que tiene una complejidad promedio de O(n log n) en promedio, dando como consecuencia que este ordenamiento tenga O(n log n) de complejidad

2. Utilicé linkedHashSet para la coleccion de pokemones del usuario porque tenia una validación automatica de que no permite utilizar repetidos, además de que este conserva un orden lo cual puede ser util al momento de tratar con la poca cantidad de datos que un usuario puede tener en la vida real, asimismo asumiendo que esta tiene complejidad O(n) esta tiene un limite de los 905 pokemones en el csv por lo que su valor no crecera en desmedida
## Licencia
[Especificar licencia]

## Contacto
[Información de contacto]
