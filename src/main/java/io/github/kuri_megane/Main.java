package io.github.kuri_megane;

import io.github.kuri_megane.Layer.StartMenu;

public class Main {
    public static void main(String[] args) {

        StartMenu startMenu = new StartMenu();
        startMenu.display("");

        Game game = new Game();
        game.run();
    }
}
