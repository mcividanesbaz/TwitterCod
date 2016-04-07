Crear aplicación de twitter.

Antes de empezar a programar en netbeans lo primeero que tenemos que hacer es hacer un par de pasos en otras paginas.
Primero vamos a twitter4j.org y nos descargamos las librerias de twitter (twitter4j-4.0.4.zip) .
Despues vamos a la pagina para desarrolladores de twitter(dev.twitter.com), vamos a la parte de abajo de todo de la aplicación y pinchamos en “Manage your Apps” donde a continuaciion tendremos que introducir nuestra cuenta de twitter para poder crear una aplicación de twitter y asi generar las keys y acces tokens que despues nos haran falta en netbeans.

Una vez hecho esto en netbeans creamos una nueva clase donde crearemos los metodos.
Primero vamos a libreries y añadimos el jar que venia en el zip que descargamos antes(twitter4j-core-4.0.4)

En la clase método crearemos la variable "Twitter twitter", que es con la que vamos a trabajar durante todo el programa

Ahora tenemos que ir a la pagina de twitter 4j y coger la Configuracion Builder y pegarla en nuestro proyecto de netbeans dentro del constructor por defecto de la clase Metodos Twitter.


ConfigurationBuilder cb = new ConfigurationBuilder();
cb.setDebugEnabled(true)
.setOAuthConsumerKey("*********************")
.setOAuthConsumerSecret("******************************************")
.setOAuthAccessToken("**************************************************")
.setOAuthAccessTokenSecret("******************************************");

TwitterFactory tf = new TwitterFactory(cb.build());
Twitter twitter = tf.getInstance();

Una vez pegado esto en nuestra clase Metodos Twitter tenemos que ir al proyecto que creamos antes en apps.twitter.com
y generamos”Consumer key and Secret” y “Acces token and secret” esto nos hace falta para conseguir  la “Consumer Key”,”ConsumerSecret”,” AccesToken “y la “Acces Token Secret”
que sera lo que tenemos que reemplazar por los asteriscos del codigo pegado.

Pero como pides que estos datos no esten en el codigo fuente de la aplicación basta con substituirlos por una simple linea de codigo:

twitter = new TwitterFactory("twitter4j.properties").getInstance();
Esto habria que ponerlo dentro del constructor por defecto.

Ahora vamos a hacer un metodo para mostrar la linea del tiempo( TimeLine), para eso vamos a la pagina de twitter4j y vamos al apartado “getting timeline” y copiamos el siguiente codigo:

List<Status> statuses = twitter.getHomeTimeline();
System.out.println("Showing home timeline.");
for (Status status : statuses) {
System.out.println(status.getUser().getName() + ":" +
status.getText()); 

Ahora vamos a hacer otro metodo llamado buscar para los tweets que tengan una string introducida. Para ello vamos a “search for tweets” en twitter4j.org y pegamos el siguiente codigo:


Query query = new Query("source:twitter4j yusukey");
QueryResult result = twitter.search(query);
for (Status status : result.getTweets()) {
System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());


Pero para nuestro ejercicio solo nos hace falta que busque los que tienen una string por lo tanto tendremos que hacer un par de modificaciones en el codigo para que nos funcione.


Ahora vamos con  el ultmo apartado, twittear, para esto tenemos que coger el codigo de  “post a Tweet” y pegamos las siguientes lineas:

Status status = twitter.updateStatus(latestStatus);
System.out.println("Successfully updated the status to [" + status.getText() + "].");

 Ahora tendremos que modificar tamnien varias lineas del codigo para adaptarlo a nuestro ejercicio,le tendremos que mandar al método un String de nombre "tweet".

Por último solo tendremos que crear las variables y el objeto en el Main, necesarios para poder llamar a los métodos que hemos echo y para que funcione el programa y hacer un menu para poder elegir la accion que deseemos hacer. 
Y asi ya tenemos nuestra aplicación.
Ahora tenemos que comentar nuestro codigo para despues hacer el javadoc, para ello pulsamos boton derecho sobre la tacita y le damos a generate javadoc y ya nos lo hace automaticamente.
