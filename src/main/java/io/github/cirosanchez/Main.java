package io.github.cirosanchez;

import io.github.cirosanchez.token.TokenJSON;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;
import org.javacord.api.entity.server.Server;
import org.javacord.api.interaction.SlashCommand;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        DiscordApi api = null;

        try {
            api = new DiscordApiBuilder().setToken(TokenJSON.getToken()).login().join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        api.updateActivity(ActivityType.PLAYING, "Ticket System!");
        System.out.println("Bot connected: "+api.getYourself().getName());
        System.out.print("Servers: ");
        for (Server server : api.getServers()){
            System.out.print(server.getName());
        }
        System.out.println(" ");
        System.out.println(" Invite: " +api.createBotInvite());
        try {
            System.out.println(TokenJSON.getToken());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}