package com.Jeu_421.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")

public class WsChat {
 // la liste des websockets : en static pour être partagée
 private static ArrayList<Basic> listeWS = new ArrayList<>();
 @OnMessage
 public void message(String message) {
 // on parcourt toutes les WS pour leur envoyer une à une le message
 for(Basic ws : WsChat.listeWS) {
 try { ws.sendText(message); }
 catch (IOException ex) { System.err.println("Erreur de communication"); }
 }
 }
 @OnOpen
 public void open(Session session) {
 // à l'ouverture d'une connexion, on rajoute la WS dans la liste
 WsChat.listeWS.add(session.getBasicRemote());
 }
 @OnClose
 public void onClose(CloseReason reason) {
 System.out.println("Fermeture de la WS");
 }
 @OnError
 public void error(Throwable t) {
 System.err.println("Erreur WS : "+t);
 }

}