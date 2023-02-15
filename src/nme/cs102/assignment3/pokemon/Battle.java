package nme.cs102.assignment3.pokemon;

import java.util.HashSet;
import java.util.Set;

public class Battle {
    public static final int ROUND_LIMIT = 50;

    public static Player tatakai(Player p1, Player p2) {
        Set<Pokemon> p1DeadPokemons = new HashSet<>();
        Set<Pokemon> p2DeadPokemons = new HashSet<>();

        int round = 0;
        game:
        while (!p1.pokemons.isEmpty() && !p2.pokemons.isEmpty()) {
            Pokemon p1BattlingPokemon = p1.pokemons.remove(0);
            Pokemon p2BattlingPokemon = p2.pokemons.remove(0);

            int p1MaxHp = p1BattlingPokemon.getHp();
            int p2MaxHp = p2BattlingPokemon.getHp();

            Pokemon first, second;
            if (p1BattlingPokemon.getSpeed() >= p2BattlingPokemon.getSpeed()) {
                first = p1BattlingPokemon;
                second = p2BattlingPokemon;
            } else {
                first = p2BattlingPokemon;
                second = p1BattlingPokemon;
            }

            int cd1 = first.skill.getSkillCd();
            int cd2 = second.skill.getSkillCd();

            while (first.getHp() > 0 && second.getHp() > 0) {
                if (++round > ROUND_LIMIT) {
                    p1BattlingPokemon.setHp(p1MaxHp);
                    p1.addPokemon(p1BattlingPokemon);
                    p2BattlingPokemon.setHp(p2MaxHp);
                    p2.addPokemon(p2BattlingPokemon);
                    break game;
                }

                if (cd1-- <= 0) {
                    second.setHp(second.getHp() - first.skill.getSkillAtk());
                    cd1 = first.skill.getSkillCd();
                } else {
                    second.setHp(second.getHp() - first.getAtk());
                }

                if (second.getHp() <= 0) {
                    break;
                }

                if (cd2-- <= 0) {
                    first.setHp(first.getHp() - second.skill.getSkillAtk());
                    cd2 = second.skill.getSkillCd();
                } else {
                    first.setHp(first.getHp() - second.getAtk());
                }
            }

            if (p1BattlingPokemon.getHp() <= 0) {
                p1BattlingPokemon.setHp(p1MaxHp);
                p1DeadPokemons.add(p1BattlingPokemon);
                p2.pokemons.add(0, p2BattlingPokemon);
            }

            if (p2BattlingPokemon.getHp() <= 0) {
                p2BattlingPokemon.setHp(p2MaxHp);
                p2DeadPokemons.add(p2BattlingPokemon);
                p1.pokemons.add(0, p1BattlingPokemon);
            }
        }

        Player winner = null;

        if (p1.pokemons.isEmpty()) {
            winner = p2;
        }

        if (p2.pokemons.isEmpty()) {
            winner = p1;
        }

        p1.pokemons.addAll(p1DeadPokemons);
        p2.pokemons.addAll(p2DeadPokemons);

        return winner;
    }
}
