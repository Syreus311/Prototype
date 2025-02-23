# Implementación del Patrón Prototype

## Descripción del Patrón

El patrón Prototype es utilizado para crear (clonar) objetos duplicados de una instancia existente sin que el código dependa de sus clases específicas y delegar el proceso de clonación a
los propios objetos que están siendo clonados. Este proyecto demuestra su implementación mediante un ejemplo práctico en **Java** utilizando **Maven** como gestor de dependencias.

---

## Estructura del Proyecto
La estructura del proyecto sigue el estándar de **Maven**:

```
Prototype
│
├── pom.xml                # Archivo de configuración de Maven
├── README.md              # Documentación del proyecto
|
├── uml                    
|   |── uml1.png           # Imagen con el diagrama UML estándar
|   └── uml2.png           # Imagen con el diagrama UML implementado
|
└── src/main/java          # Carpeta con los códigos
    |
    ├── Main.java          # Para ejecutar el programa
    │
    └── prototype
        |── Vehicle.java                 # Clase de Java
        |── VehiclePrototype.java        # Clase de Java
        └── VehicleRegistry.java         # Clase de Java
```

---

## Dependencias Utilizadas
Este proyecto no utiliza dependencias adicionales que deban ser definidas en el archivo **pom.xml**.

---

## Instrucciones de Instalación

1. **Clonar el repositorio:**
```bash
git clone https://github.com/Syreus311/Prototype.git
cd Prototype
```

2. **Compilar el proyecto:**
```bash
mvn clean install
mvn clean compile         # Opcional
```

3. **Ejecutar el proyecto:**
```bash
mvn exec:java
```

---

## Ejemplo de Ejecución
Al ejecutar el programa, deberías ver la siguiente salida:

```
¡Bienvenido al sistema de clonación de vehículos
=============================================
              MENÚ PRINCIPAL
=============================================
1. Clonar un nuevo vehículo
2. Ver cuántos vehículos se han clonado y sus características
3. Comparar memoria entre dos vehículos clonados
4. Salir
Seleccione una opción (1-4):
```
---

## Diagrama UML

El siguiente diagrama muestra la estructura estándar del patrón Prototype:
![Diagrama UML](uml/uml1.png)

El siguiente diagrama muestra la estructura del patrón implementado:
![Diagrama UML](uml/uml2.png)

---

## Explicación de la Implementación
El patrón Prototype ha sido implementado utilizando las siguientes clases principales:
- **Vehicle**: Vehicle es una implementación concreta que puede ser clonada. Contiene la lógica de negocio para modificar las propiedades del vehículo, pero también está definida para ser clonada mediante el método clone.
- **VehiclePrototype**: Funciona como una interfaz o clase base para los objetos que se van a clonar. Contiene el método clone(), que es implementado por la clase concreta para proporcionar la lógica de clonación.
- **VehicleRegistry**: Se encarga de almacenar y gestionar los prototipos de los vehículos. Contiene un mecanismo para recuperar una copia de un prototipo registrado mediante su identificador.
- **Main**: Main actúa como el cliente en este patrón, ya que es la clase encargada de solicitar la clonación de los objetos mediante la interacción con el VehicleRegistry para obtener las instancias clonadas.

---

## Contribuciones
Este proyecto fue desarrollado por:
- Katherin Juliana Moreno Carvajal
- Santiago Navarro Cuy
- Mariana Salas Gutiérrez
