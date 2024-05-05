package pokemonfactory;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PokemonFactoryTest {
    PokemonFactory factory = new PokemonFactory();

    @Test
    public void GivenFactoryWhenWaterChosenThenSelectedOutputsExpectedMessage() {
        IPokemon pokemon = factory.choose(PokemonType.WATER);

        assertEquals("Selected Squirtle a water type Pokemon that is sure to make a splash", pokemon.selected());
    }

    @Test
    public void GivenFactoryWhenFireChosenThenSelectedOutputsExpectedMessage() {
        IPokemon pokemon = factory.choose(PokemonType.FIRE);

        assertEquals("Selected Charmander a fire type Pokemon with a sparky personality", pokemon.selected());
    }

    @Test
    public void GivenFactoryWhenGrassChosenThenSelectedOutputsExpectedMessage() {
        IPokemon pokemon = factory.choose(PokemonType.GRASS);

        assertEquals("Selected Bulbasaur a grass type Pokemeon that is cool as a breeze", pokemon.selected());
    }
}