package pokemonfactory;

public class PokemonFactory {
    public IPokemon choose(PokemonType type) {
        switch (type) {
            case WATER:
                return new Squirtle();
            case FIRE:
                return new Charmander();
            case GRASS:
                return new Bulbasaur();
            default:
                return new Squirtle();
        }
    }
}
