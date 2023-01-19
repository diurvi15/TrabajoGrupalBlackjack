# TrabajoGrupalBlackjack
#Partes del proyecto

    #Estructura de datos
        Clase Cartas para crear el Objeto con sus parámetros: 
    (ArrayList<int> valorCartas,ArrayList<String> palos)


    #Estructura de código
        Nuestra aplicación contará con un Icono propio y nombre personalizado
        Tendremos tres actividades y una clase.
        

    #actividades

        Splash (Main Activity):
            Una pantalla principal con un estilo propio para esa actividad que usaremos como Splash con una duración de 2500ms.
                Contiene una imagen del Titulo de nuestra Aplicación
                    -Imagen / (ImageView)

        Menú:
            Pantalla que se mostrará después del splash donde podremos elegir entre varios botones,
            los cuales nos darán la opción de jugar una partida, ver las estadísticas de las últimas diez partidas
            y los créditos de los creadores del juego. 

            -Botón de jugar / Button : 
                Al hacer click en el botón aparecerá una ventana emergente para introducir los nombres de los jugadores
                esta ventana te dará la opción de jugar la partida o de volver al menú. 
            -Botón de estadísticas /Button (*2)
            -Botón de créditos / button(*3)


        Activity_Jugar: 
        Una pantalla donde dos jugadores jugaran encima de un tapete y 
        cada uno tendrá su turno para pedir cartas o plantarse. 
            -Botón Pedir Carta / Button
            -Dos botones de Plantarse (uno para cada uno) / Button

            -TerminaroVolverPartida(AlertDialog): Al acabar la partida se 
            mostrará para elegir que hacer. 
                - Una opción para volver a jugar y otra para volver 
                a la pantalla de inicio.



        (*2)Estadisticas(AlertDialog):
            Dialog en el que mostraremos los diez últimos ganadores con su puntuación obtenida y la fecha de la partida.
            -Diez Labels para los datos del ganador de cada partida (estos se irán rellenando con el paso de las partidas)
            -Archivo CSV - para guardar los datos en el.


        (*3)Créditos(AlertDialog):
            Dialog en el que mostraremos los nombres de los creadores del juego y el nombre de la aplicación.

        
        # lógica de negocio (toda la programación que organiza el funcionamiento de la aplicación) (interface)

        # Descripción del proyecto (que efecto va a tener cada error o cada acierto dentro de la aplicacion)
            La aplicación comienza con una ventana a pantalla completa que contiene el nombre de nuestra aplicación,
            después de esperar 2500ms pasará automáticamente a la siguiente ventana, la cuál tendrá tres botones en los que
            se podrá acceder a jugar, podrá ver las estadísticas y los créditos.
            En la ventana de jugar habrá hueco para dos jugadores, los cuáles jugarán entre ellos por ver quien se acerca más a 21, con sus respectivos botones
            para pedir cartas o para plantarse. 
            Al terminar la partida estos podrán volver a jugar o salirse al menú. 
            De vuelta en el menú podrá pinchar en el botón de estadísticas para ver las últimas diez partidas y los ganadores de ellas, junto con más datos.
            Estos datos los guardaremos dentro de un CSV.
            Y en el botón de los créditos podrá ver a aquellos que hayan participado en la creación de la aplicación. 