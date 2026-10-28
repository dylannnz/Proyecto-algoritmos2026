# Proyecto Final: Sistema de Gestión para Congreso Estudiantil

Aplicación de escritorio en **Java Swing** para administrar la logística de un Congreso Estudiantil Universitario: registrar expositores, programar conferencias, inscribir estudiantes, controlar la asistencia el día del evento y generar un reporte final. Los datos se guardan en archivos `.csv`, así que se conservan al cerrar y volver a abrir el programa.

**Autor:** Dylan Zuleta (`dygrz`) · Octubre 2026
**Curso:** Algoritmos · Universidad Mariano Gálvez
**Entorno:** Apache NetBeans · Maven · Java 21 · paquete `umg.proyecto2026`

---

## 📁 Estructura del proyecto

```
Proyecto-algoritmos2026/
├── README.md
└── Proyecto2026/                          ← proyecto Maven (abrir ESTA carpeta en NetBeans)
    ├── pom.xml
    ├── expositores.csv                    ← se crea al registrar el primer expositor
    ├── conferencias.csv                   ← se crea al registrar la primera conferencia
    ├── estudiantes.csv                    ← se crea al inscribir al primer estudiante
    └── src/main/java/umg/proyecto2026/
        ├── Menu.java                      (menú principal)
        ├── FrmExpositores.java            (+ .form)
        ├── FrmConferencias.java           (+ .form)
        ├── FrmEstudiantes.java            (+ .form)
        ├── FrmAsistencia.java             (+ .form)
        ├── FrmReporte.java                (+ .form)
        ├── expositor.java                 (modelo)
        ├── conferencia.java               (modelo)
        └── estudiante.java                (modelo)
```

---

## ▶️ Cómo ejecutar

1. Abrir **NetBeans** → **File → Open Project** → seleccionar la carpeta `Proyecto2026`.
2. Ejecutar el programa de cualquiera de estas dos formas:

| Forma | Cómo |
|---|---|
| **Run Project** | Clic derecho sobre el proyecto → **Run** (o `F6`). El `pom.xml` ya tiene `Menu` como clase principal (`exec.mainClass`) |
| **Run File** | En **Projects**, `Source Packages → umg.proyecto2026`, clic derecho sobre `Menu.java` → **Run File** (o `Shift + F6`) |

> Los archivos `.csv` se leen y escriben de forma relativa, así que se crean en la carpeta `Proyecto2026` (la raíz del proyecto Maven) la primera vez que se registra un dato. No vienen incluidos en el repositorio: el programa arranca vacío.

---

## 🗺️ Flujo de uso recomendado

| Paso | Pantalla | Qué se hace |
|---|---|---|
| 1 | **Expositores** | Registrar a los profesionales que darán las conferencias |
| 2 | **Conferencias** | Crear la agenda eligiendo un expositor ya registrado |
| 3 | **Estudiantes** | Inscribir a los alumnos que compraron su entrada |
| 4 | **Asistencia** | El día del evento, ingresar el carné de cada estudiante que llega |
| 5 | **Reporte** | Ver cuántos asistieron, cuántos faltaron y quiénes |

---

## 🧩 Clases del sistema (modelo)

Cada clase usa **encapsulamiento**: atributos `private`, constructor, *getters* y *setters*.

| Clase | Atributos | Notas |
|---|---|---|
| `expositor` | `int idExpositor`, `String nombre`, `String especialidad` | El ID se genera automáticamente |
| `conferencia` | `int idConferencia`, `String titulo`, `String expositorAsignado`, `String salon` | `expositorAsignado` guarda el **nombre** del expositor elegido |
| `estudiante` | `String carne`, `String nombre`, `String correo`, `boolean asistio` | `asistio` inicia en `false` |

Los objetos se manejan en memoria con `ArrayList` (`ArrayList<expositor>`, `ArrayList<conferencia>` y `ArrayList<estudiante>`).

---

## 🖥️ Módulos (ventanas)

### `Menu`

Ventana principal con un botón por módulo. Cada ventana se abre desde aquí y el botón **Regresar** de cada una la cierra (`dispose()`) para volver al menú.

### `FrmExpositores`

| Componente | Función |
|---|---|
| `txtnombreexpositor`, `txtespecialidad` | Datos del expositor |
| `btnexportarexpositor` (texto **Registrar**) | Valida, agrega al `ArrayList` y guarda en `expositores.csv` |
| `taExpositores` | Muestra todos los expositores registrados |
| `btnregresarexpositores` | Cierra la ventana |

### `FrmConferencias`

| Componente | Función |
|---|---|
| `txtTituloconf`, `txtsalonconf` | Título y salón de la conferencia |
| `cbExpositor` (`JComboBox`) | Lista desplegable con los expositores registrados; así solo se puede vincular un expositor que existe |
| `btnRegistarconf` | Valida, agrega y guarda en `conferencias.csv` |
| `taConferencias` | Muestra la agenda de conferencias |
| `btnRegresarconf` | Cierra la ventana |

Al abrirla desde el menú se vuelve a leer `expositores.csv`, por lo que el combo siempre incluye a los expositores recién registrados.

### `FrmEstudiantes`

| Componente | Función |
|---|---|
| `txtCarnetEst`, `txtNombreEst`, `txtCorreoEst` | Datos del estudiante |
| `btnRegistrarest` | Valida, agrega con `asistio = false` y guarda en `estudiantes.csv` |
| `btnregresare` | Cierra la ventana |

### `FrmAsistencia`

| Componente | Función |
|---|---|
| `txtAsistencia` | Carné del estudiante que llega al evento |
| `btnAsistencia` | Busca el carné en el `ArrayList<estudiante>`. Si existe, cambia `asistio` a `true`, guarda y muestra un mensaje de bienvenida |
| `btnRegresarasistencia` | Cierra la ventana |

La asistencia indica si el estudiante asistió **al congreso en general**, no a una conferencia en particular.

### `FrmReporte`

| Componente | Función |
|---|---|
| `btnGenerarreporte` | Lee `estudiantes.csv` y arma el resumen |
| `jTextArea1` | Muestra el reporte |
| `btnRegresarconf` | Cierra la ventana |

El reporte incluye: **total de inscritos**, **total que sí asistieron**, **total de ausentes** y el **listado de ausentes** (carné y nombre).

Ejemplo:

```
REPORTE FINAL DEL CONGRESO
---------------------------
Total de estudiantes inscritos: 3
Total de estudiantes que si asistieron: 1
Total de estudiantes ausentes: 2

Listado de ausentes:
3190-26-5678 - Luis Perez
3190-26-9012 - Maria Gomez
```

---

## 💾 Persistencia con archivos CSV

| Archivo | Lo usan | Formato de cada línea |
|---|---|---|
| `expositores.csv` | Expositores, Conferencias | `idExpositor,nombre,especialidad` |
| `conferencias.csv` | Conferencias | `idConferencia,titulo,expositorAsignado,salon` |
| `estudiantes.csv` | Estudiantes, Asistencia, Reporte | `carne,nombre,correo,asistio` |

Ejemplos:

```
1,Ana Lopez,Bases de datos
1,Introduccion a Java,Ana Lopez,Salon A
3190-26-1234,Ana Lopez,ana@correo.com,true
```

**Cómo funciona:**
- **Guardar:** `FileWriter` recorre el `ArrayList` y escribe los atributos separados por comas (el archivo se sobrescribe completo).
- **Cargar:** `Scanner` lee el archivo línea por línea, `split(",")` separa los valores y se crea un objeto por línea.
- Como varias ventanas comparten un mismo archivo (por ejemplo `estudiantes.csv`), **cada botón vuelve a leer el archivo antes de modificarlo**. Así nunca se trabaja con una lista desactualizada.

---

## ✅ Validaciones

| Pantalla | Se valida |
|---|---|
| Expositores | Campos vacíos y comas en los datos |
| Conferencias | Que exista al menos un expositor, campos vacíos y comas en los datos |
| Estudiantes | Campos vacíos, comas, que el correo tenga `@` y que el carné no esté repetido |
| Asistencia | Carné vacío, carné no inscrito y asistencia ya registrada |

> No se permiten comas en los datos porque la coma es el separador del CSV.

---

## 🧰 Conceptos aplicados

| Tema | Dónde |
|---|---|
| Clases, objetos y encapsulamiento (`private`, constructores, *getters* y *setters*) | `expositor`, `conferencia`, `estudiante` |
| Colecciones dinámicas (`ArrayList`) | Todas las ventanas |
| Lectura y escritura de archivos (`Scanner`, `FileWriter`, `File`) | Todas las ventanas |
| `split(",")` y conversión de texto (`Integer.parseInt`, `Boolean.parseBoolean`) | Métodos `cargar...()` |
| Ciclos y condicionales (`for`, `if / else if`) | Búsquedas, validaciones y reporte |
| Interfaces gráficas con Swing y eventos de botón | Todas las ventanas |
| `JComboBox` | `FrmConferencias` |
| Programación modular (varias ventanas independientes) | `Menu` y `Frm...` |

---

## ⚠️ Limitaciones conocidas

- No se pueden **editar ni eliminar** registros desde la aplicación; para corregir un dato hay que modificar el `.csv`.
- Los IDs se calculan como `cantidad de registros + 1`, así que dependen de que no se borren líneas del archivo.
- Los datos no pueden llevar comas.

---

## ✍️ Autor

**Dylan Zuleta (`dygrz`)** · Proyecto Final de Algoritmos · Octubre 2026
