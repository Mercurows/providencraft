package tech.lq0.providencraft.tools;

public enum Livers {
    MITSUKI("mitsuki","zero","#F9E7E8"),
    USA("usa","zero","#FFEDFE"),
    MADOKA("madoka","first","#F4F0FF"),
    MYANNA("myanna","first","#EAF6EE"),
    NIINA("niina","first","#FCDEE3"),
    UNIA("unia","first",""),
    AYELET("ayelet","first",""),
    MARI("mari","first",""),
    HAYA("haya","first",""),
    MUMU("mumu","second",""),
    LECIA("lecia","second","#E1EDFF"),
    SATOU("satou","second",""),
    LUCIA("lucia","second",""),
    LOUISE("louise","second",""),
    CHIRAM("chiram","magicros",""),
    HAINE("haine","magicros",""),
    KERORO("keroro","magicros",""),
    EKIRA("ekira","magicros",""),
    HIRU("hiru","third",""),
    BENI("beni","third",""),
    YUKI("yuki","third",""),
    LECIEL("leciel","third",""),
    SHIRAKO("shirako","poi","#F4ADB4"),
    SORAYO("sorayo","poi",""),
    MIYA("miya","poi",""),
    AOI("aoi","poi",""),
    AYU("ayu","poi",""),
    MARIA("maria","first",""),
    MOJUKO("mojuko","second","");

    private final String name;
    private final String gen;
    private final String color;

    Livers(String name, String gen, String color) {
        this.name = name;
        this.gen = gen;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getGen() {
        return gen;
    }

    public String getColor() {
        return color;
    }
}
