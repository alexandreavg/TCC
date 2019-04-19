package com.example.alexa.projetotcc.DAO;

import com.fasterxml.jackson.databind.JsonNode;
import com.scaledrone.lib.Listener;
import com.scaledrone.lib.Member;
import com.scaledrone.lib.Room;
import com.scaledrone.lib.RoomListener;
import com.scaledrone.lib.Scaledrone;

public class ConexaoChat {

    final Scaledrone drone = new Scaledrone("CHANNEL_ID");

    public void conectarListener (){
        drone.connect(new Listener() {
            @Override
            public void onOpen() {
                drone.subscribe("grupo", new RoomListener() {
                    @Override
                    public void onOpen(Room room) {
                        room.publish("Hello World!!");
                    }

                    @Override
                    public void onOpenFailure(Room room, Exception ex) {
                        System.out.println("Erro ao entrar no grupo " + ex.getMessage());
                    }

                    @Override
                    public void onMessage(Room room, JsonNode message, Member member) {
                        System.out.println("Message: " + message.asText());
                    }
                });
            }

            @Override
            public void onOpenFailure(Exception ex) {
                System.out.println("Falha ao abrir conexão: " + ex.getMessage());
            }

            @Override
            public void onFailure(Exception ex) {
                System.out.println("Erro inesperado: " + ex.getMessage());
            }

            @Override
            public void onClosed(String reason) {
                System.out.println("Conexão fechada: " + reason);
            }
        });
    }

    public void conectarGrupo(){
        drone.subscribe("grupo", new RoomListener() {
            @Override
            public void onOpen(Room room) {

            }

            @Override
            public void onOpenFailure(Room room, Exception ex) {

            }

            @Override
            public void onMessage(Room room, JsonNode message, Member member) {
                System.out.println("Mensagem:" + message);

            }
        });
    }

    public void enviarMensagem(String mensagem){
        drone.publish("grupo",mensagem);
    }



}
