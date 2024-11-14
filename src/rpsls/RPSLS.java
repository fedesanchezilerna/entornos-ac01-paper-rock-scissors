/*
 * RPSLS 11/14/2024
 *
 *
 * ©Copyright 2024 Federico Sánchez Vidarte <fedesanchezvidarte@alumnes.ilerna.com>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package rpsls;

import java.util.Random;
import java.util.Scanner;

public class RPSLS {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        RPSLS game = new RPSLS();

        game.init();
        game.menu();

        byte player1 = game.selectOption();
        byte player2 = game.getRPSLS();

        String player1Choice = game.getText(player1);
        String player2Choice = game.getText(player2);

        System.out.println("You choice: " + player1Choice);
        System.out.println("Machine choice: " + player2Choice);

        String result = game.winner(player1, player2);

        if (result.equals("player1")) {
            System.out.println("You have won!");
        } else if (result.equals("player2")) {
            System.out.println("Sorry, you have lost.");
        } else {
            System.out.println("It is a draw.");
        }
    }

    private void init() {
        System.out.println("""
                **********************************************************************
                * ROCK PAPER SCISSORS LIZARD SPOCK       © Federico Sánchez Vidarte  *
                *                                                                    *
                * An extension of the children's game of rock paper scissors,        *
                * with two additional handshapes: lizard and Spock.                  *
                * Rules: Scissors cuts paper                                         *
                *        Paper covers rock                                           *
                *        Rock crushes lizard                                         *
                *        Lizard poisons Spock                                        *
                *        Spock smashes scissors                                      *
                *        Scissors decapitates lizard                                 *
                *        Lizard eats paper                                           *
                *        Paper disproves Spock                                       *
                *        Spock vaporizes rock                                        *
                *        and as it always has, rock crushes scissors.                *
                **********************************************************************
                """);
    }

    private void menu() {
        System.out.println("1: ROCK    2:PAPER    3:SCISSORS    4:LIZARD    5:SPOCK");
    }

    private byte selectOption() {
        System.out.println("CHOOSE YOUR OPTION:");
        return scanner.nextByte();
    }

    public byte getRPSLS() {
        return (byte) ((int) (Math.random() * 5) + 1);
    }

    public String getText(byte option) {
        return switch (option) {
            case 1 -> "ROCK";
            case 2 -> "PAPER";
            case 3 -> "SCISSORS";
            case 4 -> "LIZARD";
            case 5 -> "SPOCK";
            default -> "UNKNOWN";
        };
    }

    private String winner(byte player1, byte player2) {
        if (player1 == player2) return "draw";
        return switch (player1) {
            case 1 -> // ROCK
                    (player2 == 3 || player2 == 4) ? "player1" : "player2";
            case 2 -> // PAPER
                    (player2 == 1 || player2 == 5) ? "player1" : "player2";
            case 3 -> // SCISSORS
                    (player2 == 2 || player2 == 4) ? "player1" : "player2";
            case 4 -> // LIZARD
                    (player2 == 2 || player2 == 5) ? "player1" : "player2";
            case 5 -> // SPOCK
                    (player2 == 1 || player2 == 3) ? "player1" : "player2";
            default -> "draw";
        };
    }

}
