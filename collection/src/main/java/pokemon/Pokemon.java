package pokemon;

public class Pokemon {
    private String name;
    private String pokedexNumber;
    private String type1;
    private String type2;
    private String classification;
    private String height;
    private String weight;
    private String ability1;
    private String ability2;
    private String generation;
    private String legendaryStatus;

    public Pokemon( String pokedexNumber, String type1, String type2, String classification, String height, String weight, String abilities,String ability2, String generation, String legendaryStatus) {
        this.pokedexNumber = pokedexNumber;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.ability1 = abilities;
        this.ability2 = ability2;
        this.generation = generation;
        this.legendaryStatus = legendaryStatus;
    }

    
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getPokedexNumber() {
        return pokedexNumber;
    }


    public String getAbility1() {
        return ability1;
    }


    public void setAbility1(String ability1) {
        this.ability1 = ability1;
    }


    public String getAbility2() {
        return ability2;
    }


    public void setAbility2(String ability2) {
        this.ability2 = ability2;
    }


    public void setPokedexNumber(String pokedexNumber) {
        this.pokedexNumber = pokedexNumber;
    }


    public String getType1() {
        return type1;
    }


    public void setType1(String type1) {
        this.type1 = type1;
    }


    public String getType2() {
        return type2;
    }


    public void setType2(String type2) {
        this.type2 = type2;
    }


    public String getClassification() {
        return classification;
    }


    public void setClassification(String classification) {
        this.classification = classification;
    }


    public String getHeight() {
        return height;
    }


    public void setHeight(String height) {
        this.height = height;
    }


    public String getWeight() {
        return weight;
    }


    public void setWeight(String weight) {
        this.weight = weight;
    }


    public String getAbilities() {
        return ability1;
    }


    public void setAbilities(String abilities) {
        this.ability1 = abilities;
    }


    public String getGeneration() {
        return generation;
    }


    public void setGeneration(String generation) {
        this.generation = generation;
    }


    public String getLegendaryStatus() {
        return legendaryStatus;
    }


    public void setLegendaryStatus(String legendaryStatus) {
        this.legendaryStatus = legendaryStatus;
    }



}
