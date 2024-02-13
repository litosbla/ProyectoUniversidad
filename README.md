Se requiere el desarrollo de un sistema monousuario en Java con interfaz de consola. Este proyecto se estructura en varias fases esenciales: análisis del problema, diseño de diagramas de clases y relacional, construcción del software y pruebas.

La primera etapa, el análisis del problema, implica una comprensión profunda de los requisitos y desafíos que el sistema debe abordar. Aquí, se examinarán detalladamente las necesidades del usuario, los flujos de trabajo y cualquier restricción relevante.

Posteriormente, se procederá al diseño, que incluirá la creación de diagramas de clases y entidad-relación. Estos diagramas servirán como mapas visuales que representarán las relaciones entre los distintos componentes del sistema y ayudarán a establecer una estructura clara y eficiente.

La fase de construcción del software se llevará a cabo utilizando el lenguaje de programación Java. Durante este proceso, se implementarán las funcionalidades identificadas en las fases anteriores, asegurando una codificación limpia y modular para facilitar el mantenimiento y futuras expansiones.

Finalmente, se llevarán a cabo pruebas exhaustivas para verificar la robustez y confiabilidad del sistema. Este enfoque estructurado garantizará un desarrollo eficiente y efectivo del sistema monousuario, cumpliendo con los estándares de calidad y proporcionando una solución sólida y fácil de usar en el entorno de consola.

La Universidad de los Sabios está necesitando con urgencia un sistema de gestión que permita almacenar la información sobre los departamentos, profesores, alumnos, cursos, asignaturas, programas, salones, tarifas y matrículas.

Los Departamentos se caracterizan por poseer un identificador único y un nombre específico. Cada departamento puede estar asociado con uno o varios profesores, mientras que un profesor está vinculado exclusivamente a un solo departamento.

La información relativa a las personas incluye un identificador único, el tipo de documento (Cédula, Cédula de Extranjería, Número de Pasaporte, Tarjeta de Identidad), número, nombres, apellidos, ciudad de residencia, dirección, número de teléfono, fecha de nacimiento y sexo. Esta información es compartida por profesores y alumnos.

La asignatura constituye la fuente principal de información para llevar a cabo procesos de matrícula. Cada asignatura se caracteriza por contar con un identificador único y un nombre que resulta de la combinación de varios códigos, tales como el código del programa, el código del curso y el período (ejemplo: PR01-C01-PER-01-MATEMATICAS). Además, se especifica la cantidad de créditos asignados, indicando el peso del curso, que puede variar incluso para la misma materia, según el programa académico. También se registra el profesor encargado de impartir la asignatura, así como el cupo disponible para estudiantes, el programa.

El periodo se define mediante un identificador autoincremental, un código específico, el año y el semestre correspondiente. Por ejemplo, un periodo puede tener el nombre P24-01, indicando que corresponde al año 2024 y al semestre 01. Este dato reviste gran importancia, ya que la programación académica se estructura por periodos, proporcionando así la base para relacionar la información de manera semestral.

El programa almacena información asociada a programas académicos, incluyendo un identificador autoincremental, nombre y nivel (pregrado o postgrado). Por ejemplo, un programa podría tener la siguiente información: ID: 1, Nombre: Ingeniería de Sistemas, Nivel: Pregrado.

Por otro lado, el curso contiene detalles específicos sobre el curso en cuestión. Este registro incluye un identificador autoincremental, el nombre del curso y la guía cátedra. La guía cátedra es un extenso documento que abarca toda la información académica del curso, detallando los temas tratados y las competencias que se buscan desarrollar.

Las tarifas poseen una importancia crucial, ya que desempeñan un papel fundamental en el cálculo del costo total de la matrícula por asignatura. Esto se debe a que cada asignatura tiene asignado un número específico de créditos. En el registro de tarifas se consigna el costo asociado a los créditos por periodo, programa y valor del crédito. Es bastante común que estudiantes de diversos programas, al inscribir la misma asignatura, curso, horario y docente, experimenten variaciones en el costo total debido al valor asignado por crédito. Este fenómeno es inherente a la diversidad de tarifas aplicadas, permitiendo así que cada estudiante abone un monto diferenciado basado en el valor atribuido a cada crédito.

Se mantiene un registro detallado de los salones, siendo estos de especial relevancia en la vinculación entre asignaturas y salones, dado que deben cumplir con el cupo y la capacidad establecida para el salón en particular. Cada salón se caracteriza por contar con un identificador autoincremental, información sobre su capacidad de alumnos, el edificio en el que se encuentra ubicado, el piso correspondiente y su número de identificación específico.

La matrícula constituye el paso central y final en el proceso una vez que se ha recopilado toda la información previamente detallada. Una matrícula se encuentra asociada a un estudiante y a una asignatura específica. De este modo, podemos afirmar que un estudiante puede tener una o varias matrículas, ya que cada matrícula se vincula al curso planificado con su respectivo horario y salón asignado.

Resulta de gran importancia establecer de manera precisa el horario de clases, el cual registra la programación detallada de cada asignatura, especificando el día, la hora de inicio y fin, así como el salón correspondiente. Es fundamental garantizar que no se produzcan solapamientos, es decir, que para un día específico, como el lunes de 8:00 a 10:00, la asignatura PR01-C01-PER-01-MATEMATICAS se imparte en el salón S001 sin que existan conflictos en la programación. Nuestro sistema debe hacer todo este tipo de validaciones.





