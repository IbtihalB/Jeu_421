

<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Chat</title>
 <script language="javascript" type="text/javascript">
 </script>
 </head>
 <body>
 <h1>Chat en WebSocket</h1>
 <div id="zonePseudo">
 <p>Entre ton pseudo :
 <input id="entreePseudo" value="" type="text">
 <input id="boutonPseudo" value="Envoyer" type="button" onclick="initialisation()">
 </p>
 </div>
 <div id="zoneMessage" style="display:none;">
 <p>Entre ton message <span id="pseudo"> </span> :
 <input id="message" name="message" value="" type="text" size=70>
 <input onclick="envoyerMessage()" value="Envoyer" type="button"><br />
 <input onclick="fermerSocket()" value="Fermer Communication" type="button">
 </p>
 <h2>La liste des messages :</h2>
 <p id="listeMessages"></p>
 </div>
 </body>
</html>
<script type="text/javascript">
var websocket;

 function ouvrirConnexion() {
 websocket = new WebSocket("ws://localhost:8084/Test/chat");
 websocket.onopen = function(evt) {
 onOpen(evt)
 };
 websocket.onmessage = function(evt) {
 onMessage(evt)
 };
 websocket.onerror = function(evt) {
 onError(evt)
 };
 }
 function onOpen(evt) {
 alert("Connexion établie");
}

// appelée quand le serveur envoie un message : rajoute la donnée de
// l'événement à la fin du paragraphe qui contient la liste des messages
function onMessage(evt) {
 liste = document.getElementById("listeMessages");
 liste.innerHTML = liste.innerHTML + "<br />" + evt.data;
 }
// appelée quand il y a une erreur
function onError(evt) {
 alert("Erreur : " + evt.data);
}

function envoyerMessage() {
 // récupère le contenu de la zone de texte
 message = document.getElementById("message").value;
 // envoie le message au serveur avec le pseudo
 websocket.send(pseudo + " : " + message);
 // efface le contenu de la zone de texte
 document.getElementById("message").value = "";
}
function initialisation() {
 // récupère le pseudo de l'utilisateur
 pseudo = document.getElementById("entreePseudo").value;
 // remplit le <span> d'id pseudo avec le pseudo de l'utilisateur
 document.getElementById("pseudo").innerHTML = pseudo;
 // cache la zone d'entrée du pseudo et affiche celle des messages
 document.getElementById("zonePseudo").style.display = "none";
 document.getElementById("zoneMessage").style.display = "block";
 // ouvre la connexion avec la partie serveur
 ouvrirConnexion();
} 
</script>